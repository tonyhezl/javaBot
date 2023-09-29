package snkrz;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.sf.json.JSONArray;
import java.security.MessageDigest;
import java.util.*;

public class TheSnkrz {

    final static String API_CODE = "bHnBNUX2RJwqd8zscm3O";
    final static String email = "aabbccdd/";
    final static String createUrl = "https://youxiang.dev/api/email/";
    final static String getEmailUrl = "https://youxiang.dev/api/messages/";
    //TheSnkrz link
    final static String getCode= "https://mainnet.thesnkrz.app/api/users/get-verification/";
    final static String verifyEmail= "https://mainnet.thesnkrz.app/api/users/verify-email/";
    final static String getPhone= "https://mainnet.thesnkrz.app/api/users/get-phone-verification/";
    final static String verifyPhone= "https://mainnet.thesnkrz.app/api/users/verify-phone-number/";
    final static String messageFull= "https://mainnet.thesnkrz.app/api/users/me/";
    final static String claim= "https://mainnet.thesnkrz.app/api/users/referrals/claim/SMPXQ1/";
    final static String shoes= "https://mainnet.thesnkrz.app/api/open-shoes/select/";
    //Header message
    final static String AGENT= "SNKRZ/1.0.2(10010) u/133";
    final static String x_api_version= "2";
    final static String x_timezone= "Asia/Shanghai";
    final static String first= "ae55963b903b4d1786";
    final static String domionGetCode= "/api/users/get-verification/";
    final static String domionVerifyEmail= "/api/users/verify-email/";
    final static String domionGetPhone= "/api/users/get-phone-verification/";
    final static String domionVerifyPhone= "/api/users/verify-phone-number/";
    final static String domionMessageFull= "/api/users/me/";
    final static String domionShoes= "/api/open-shoes/select/";
    final static String domionClaim= "/api/users/referrals/claim/SMPXQ1/";
    final static String three= "ccc6f48b8637d2";
    final static String token= "01c07340e592e11906e38b43d9eb9a7254b07de8";
    final static String begin= "https://mainnet.thesnkrz.app/api/workouts/begin/";
    final static String end= "https://mainnet.thesnkrz.app/api/workouts/end/575284/";
    final static String beginSign= "/api/workouts/begin/";
    final static String endSign= "/api/workouts/end/575284/";




    public static void main(String[] args) throws Exception{

        //ID：
        /*TimerTask taskOne = new TimerTask() {
            @Override
            public void run() {
                long timestamp = currentTimeMillis();
                try {
                    TheSnkrz.register(timestamp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Timer timerOne = new Timer();
        // 从现在开始每间隔 1000 ms 计划执行一个任务（规律性重复执行调度 TimerTask）
        timerOne.schedule(taskOne, 1 ,3600);*/
        long timestamp = currentTimeMillis();
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("shoes_id", "4068");
        JSON.toJSONString(paramMap);
        begin(begin,timestamp,JSON.toJSONString(paramMap));


    }

    public static String begin(String url ,long timestamp,String paramMap){
        String signature = md5(first+beginSign+three+timestamp,false);
        System.out.println(url);
        System.out.println(signature);
        String result = HttpRequest.post(url)
                .header(Header.USER_AGENT, AGENT)//头信息，多个头信息多次调用此方法即可
                .header("x-api-version",x_api_version)
                .header("x-signature",signature)
                .header("x-timestamp",String.valueOf(timestamp))
                .header("x-timezone",x_timezone)
                .header("x-mobile-access-token",token)
                .header("x-record-version","2")
                .header(Header.CONTENT_TYPE,"application/json")
                .body(paramMap)
                .execute().body();
        if(result!=""||result!=null){
            return result;
        }else{
            return "结束";
        }
    }


    public static String end(String url ,long timestamp){
        String signature = md5(first+endSign+three+timestamp,false);
        String result = HttpRequest.post(url)
                .header(Header.USER_AGENT, AGENT)//头信息，多个头信息多次调用此方法即可
                .header("x-api-version",x_api_version)
                .header("x-signature",signature)
                .header("x-timestamp",String.valueOf(timestamp))
                .header("x-timezone",x_timezone)
                .header("x-mobile-access-token",token)
                .header(Header.CONTENT_TYPE,"application/json")
                .execute().body();
        if(result!=""||result!=null){
            return result;
        }else{
            return "开始";
        }
    }



    //创建邮箱
    public static String createMail(){
        String result = HttpRequest.get(createUrl+email+API_CODE).execute().body();
        if(result!=""||result!=null){
            return result;
        }else{
            return "无法创建邮箱";
        }

    }

    //获取邮箱信息
    public static String getMail(String email){
        String result = HttpRequest.get(getEmailUrl+email+"/"+API_CODE).execute().body();
        if(result!=""||result!=null){
            return result;
        }else{
            return "无消息";
        }
    }
    /**
     * java生成随机字母6位数
     * @return
     */
    public static String getRandomNickname(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 字符串
            // 取得大写字母还是小写字母
            int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
            val += (char) (choice + random.nextInt(26));
        }
        return val;
    }

    //获取邮箱
    public static String getMailCode(String email){
        String url = "https://www.snapmail.cc/emailList/";
        String result = HttpRequest.get(url+email).execute().body();
        if(result!=""||result!=null){
            return result;
        }else{
            return "无消息";
        }
    }

    //注册通用远程调用
    public static String getEmailAll(String params,String url,String signature,long timestamp){
        System.out.println("加密后："+signature);
        System.out.println("参数："+params);
        System.out.println("url："+url);

        String result = HttpRequest.post(url)
                .header(Header.USER_AGENT, AGENT)//头信息，多个头信息多次调用此方法即可
                .header("x-api-version",x_api_version)
                .header("x-signature",signature)
                .header("x-timestamp",String.valueOf(timestamp))
                .header("x-timezone",x_timezone)
                .header("x-record-version","2")
                .header(Header.CONTENT_TYPE,"application/json; charset=UTF-8")
                .body(params)//表单内容
                .timeout(20000)//超时，毫秒
                .execute().body();
        System.out.println("结果输出"+Thread.currentThread().getName()+result);
        JsonParser jp = new JsonParser();
        //将json字符串转化成json对象
        if(jp!=null){
            String id = null;
            if (result!="") {
                JsonObject jo = jp.parse(result).getAsJsonObject();
                //获取message对应的值

                if(jo.get("email")!=null){
                    String email = jo.get("email").getAsString();
                    System.out.println("email：" + email);
                }
                if(jo.get("mobile_access_token")!=null){
                    String mobile_access_token = jo.get("mobile_access_token").getAsString();
                    System.out.println("mobile_access_token：" + mobile_access_token);
                    return mobile_access_token;
                }
                if(jo.get("error")!=null){
                    String error = jo.get("error").getAsString();
                    System.out.println("error：" + error);
                }
                if(jo.get("phone_number")!=null){
                    String phone_number = jo.get("phone_number").getAsString();
                    System.out.println("phone_number：" + phone_number);
                }
                if(jo.get("id")!=null){
                    id = jo.get("id").getAsString();
                    System.out.println("msgId：" + id);
                }
                if(jo.get("valid")!=null){
                    String valid = jo.get("valid").getAsString();
                    System.out.println("valid：" + valid);
                }
                if(jo.get("token_type")!=null){
                    String token_type = jo.get("token_type").getAsString();
                    System.out.println("token_type：" + token_type);
                }
            }
        }

        return "success";
    }

    //邀请码填写
    public static String getClaim(String url,String signature,String accessToken,long timestamp){
        String result = HttpRequest.post(url)
                .header(Header.USER_AGENT, AGENT)//头信息，多个头信息多次调用此方法即可
                .header("x-api-version",x_api_version)
                .header("x-signature",signature)
                .header("x-timestamp",String.valueOf(timestamp))
                .header("x-timezone",x_timezone)
                .header("x-mobile-access-token",accessToken)
                .header(Header.CONTENT_TYPE,"application/json")
                .execute().body();
        if(result!=""||result!=null){
            return result;
        }else{
            return "领取失败";
        }
    }

    //鞋子选择
    public static String shoes(String url,String signature,String accessToken,long timestamp){
        String result = HttpRequest.post(url)
                .header(Header.USER_AGENT, AGENT)//头信息，多个头信息多次调用此方法即可
                .header("x-api-version",x_api_version)
                .header("x-signature",signature)
                .header("x-timestamp",String.valueOf(timestamp))
                .header("x-timezone",x_timezone)
                .header("x-mobile-access-token",accessToken)
                .header(Header.CONTENT_TYPE,"application/json")
                .execute().body();
        if(result!=""||result!=null){
            return result;
        }else{
            return "选择失败";
        }
    }

    //获取当前时间的时间戳
    public static long currentTimeMillis() {
        return new Date().getTime();
    }

    //注册流程
    public static void register(long timestamp) throws Exception {
        String phone = TheSnkrz.getGetPhone();
        //获取邮件
       // String email=TheSnkrz.createMail();
        String email = getRandomNickname(6)+"@snapmail.cc";
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", email);
        //发送邮件
        String signature = md5(first+domionGetCode+three+timestamp,false);
        TheSnkrz.getEmailAll(JSON.toJSONString(paramMap),getCode,signature,timestamp);
        //Thread.sleep(30000);
        //获取邮箱验证码
        String code = getMailCode(email);
        JSONArray jsonArray = JSONArray.fromObject(code);
        String emailCode = (String) jsonArray.getJSONObject(0).get("text");
        System.out.println("验证码"+getCode(emailCode));
        HashMap<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("email", email);
        paramMap1.put("code", getCode(emailCode));
        //验证码校验
        String signature1 = md5(first+domionVerifyEmail+three+timestamp,false);
        String mobile_access_token = TheSnkrz.getEmailAll(JSON.toJSONString(paramMap1),verifyEmail,signature1,timestamp);
        //手机号填写
        HashMap<String, Object> paramMap2 = new HashMap<>();
        paramMap2.put("phone_number", phone);
        paramMap2.put("country", "86");
        String signature2 = md5(first+domionGetPhone+three+timestamp,false);
        TheSnkrz.verfifyPhone(JSON.toJSONString(paramMap2),getPhone,signature2,timestamp,mobile_access_token);
        //手机验证码校验
        HashMap<String, Object> paramMap3 = new HashMap<>();
        paramMap3.put("phone_number", phone);
        paramMap3.put("country", "86");
        paramMap3.put("verification_code", "000000");
        String signature3 = md5(first+domionVerifyPhone+three+timestamp,false);
        System.out.println(TheSnkrz.verfifyPhone(JSON.toJSONString(paramMap3),verifyPhone,signature3,timestamp,mobile_access_token));
        //基本信息填写
        HashMap<String, Object> paramMap4 = new HashMap<>();
        paramMap4.put("birthdate", "1998-07-22");
        paramMap4.put("username", "SNKRZ RUNNER");
        paramMap4.put("height", "170");
        paramMap4.put("weight", "70");
        paramMap4.put("timezone", "Asia/Shanghai");
        paramMap4.put("sex", "M");
        String signature4 = md5(first+domionMessageFull+three+timestamp,false);
        String shoesNumber = TheSnkrz.verfifyPhone(JSON.toJSONString(paramMap4),messageFull,signature4,timestamp,mobile_access_token);
        //鞋子选择
        String signature5 = md5(first+domionShoes+shoesNumber+"/"+three+timestamp,false);
        System.out.println(TheSnkrz.shoes(shoes+shoesNumber+"/",signature5,mobile_access_token,timestamp));
        shoesNumber = toStringLastNumAddOne(shoesNumber);
        //邀请码填写
        String signature6 = md5(first+domionClaim+three+timestamp,false);
        System.out.println(TheSnkrz.getClaim(claim,signature6,mobile_access_token,timestamp));
    }

    public static String getGetPhone(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int op = random.nextInt(3);//随机运营商标志位
        sb.append(createMobile(op));
        int i=1;
        if (i % 10 == 0) {
            sb.append("\n");
        } else {
            sb.append("\t");
        }
        System.out.println(sb.toString());
        return sb.toString();

    }

    //中国移动
    public static final String[] CHINA_MOBILE = {
            "134", "135", "136", "137", "138", "139", "150", "151", "152", "157", "158", "159",
            "182", "183", "184", "187", "188", "178", "147", "172", "198"
    };
    //中国联通
    public static final String[] CHINA_UNICOM = {
            "130", "131", "132", "145", "155", "156", "166", "171", "175", "176", "185", "186", "166"
    };
    //中国电信
    public static final String[] CHINA_TELECOME = {
            "133", "149", "153", "173", "177", "180", "181", "189", "199"
    };

    /**
     * 生成手机号
     *
     * @param op 0 移动 1 联通 2 电信
     */
    public static String createMobile(int op) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        String mobile01;//手机号前三位
        int temp;
        switch (op) {
            case 0:
                mobile01 = CHINA_MOBILE[random.nextInt(CHINA_MOBILE.length)];
                break;
            case 1:
                mobile01 = CHINA_UNICOM[random.nextInt(CHINA_UNICOM.length)];
                break;
            case 2:
                mobile01 = CHINA_TELECOME[random.nextInt(CHINA_TELECOME.length)];
                break;
            default:
                mobile01 = "op标志位有误！";
                break;
        }
        if (mobile01.length() > 3) {
            return mobile01;
        }
        sb.append(mobile01);
        //生成手机号后8位
        for (int i = 0; i < 8; i++) {
            temp = random.nextInt(10);
            sb.append(temp);
        }
        return sb.toString();
    }

    public static String toStringLastNumAddOne(String str) {
        StringBuilder sb = new StringBuilder(str + "0");
        // 默认添加一个0 分割数组
        String[] str2 = sb.toString().split("[^0-9]");
        // 取出最后一组的数字
        StringBuilder lastStr = new StringBuilder(str2[str2.length - 1]);
        // 删除字符串
        sb.delete(sb.length() - lastStr.length(), sb.length());
        // 判定如果最后一组数字的长度等于1，说明是原字符串末尾就没有数字，则拼接默认数字2
        return sb.append(lastStr.length() == 1 ? "2" :
                        Integer.parseInt(lastStr.deleteCharAt(lastStr.length() - 1).toString())+ 1)
                .toString();
    }

    /**
     * 生成32位的MD5签名串
     * @param source 待签名串
     * @param toUpperCase 是否转大写
     * @return
     */
    public static String md5(String source, boolean toUpperCase) {
        source = source;
        System.out.println("签名："+source);
        StringBuilder sb = new StringBuilder(32);

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(source.getBytes("utf-8"));

            for (int i = 0; i < array.length; i++) {
                if(toUpperCase) {
                    sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).toUpperCase().substring(1, 3));
                } else {
                    sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
                }
            }
        } catch (Exception e) {
            //log.error("Can not encode the string '" + source + "' to MD5!", e);
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

    public static String getCode(String str){
        String[] ss=str.split("\\D+");//以非数字分割ss数组中就是你要的
        String s="";
        for (int j = 0; j < 1; j++) {
            s = ss[1];
        }
        return s;
    }

    //手机号验证
    public static String verfifyPhone(String params,String url,String signature,long timestamp,String accessToken){
        System.out.println("加密后："+signature);
        System.out.println("参数："+params);
        System.out.println("url："+url);

        String result = HttpRequest.post(url)
                .header(Header.USER_AGENT, AGENT)//头信息，多个头信息多次调用此方法即可
                .header("x-api-version",x_api_version)
                .header("x-signature",signature)
                .header("x-timestamp",String.valueOf(timestamp))
                .header("x-timezone",x_timezone)
                .header("x-record-version","2")
                .header("x-mobile-access-token",accessToken)
                .header(Header.CONTENT_TYPE,"application/json; charset=UTF-8")
                .body(params)//表单内容
                .timeout(20000)//超时，毫秒
                .execute().body();
        System.out.println("结果输出"+Thread.currentThread().getName()+result);
        JsonParser jp = new JsonParser();
        //将json字符串转化成json对象
        if(jp!=null){
            String id = null;
            if (result!="") {
                JsonObject jo = jp.parse(result).getAsJsonObject();
                //获取message对应的值

                if(jo.get("email")!=null){
                    String email = jo.get("email").getAsString();
                    System.out.println("email：" + email);
                }
                if(jo.get("mobile_access_token")!=null){
                    String mobile_access_token = jo.get("mobile_access_token").getAsString();
                    System.out.println("mobile_access_token：" + mobile_access_token);
                    return mobile_access_token;
                }
                if(jo.get("error")!=null){
                    String error = jo.get("error").getAsString();
                    System.out.println("error：" + error);
                }
                if(jo.get("phone_number")!=null){
                    String phone_number = jo.get("phone_number").getAsString();
                    System.out.println("phone_number：" + phone_number);
                }
                if(jo.get("id")!=null){
                    id = jo.get("id").getAsString();
                    System.out.println("msgId：" + id);
                }
                if(jo.get("valid")!=null){
                    String valid = jo.get("valid").getAsString();
                    System.out.println("valid：" + valid);
                }
                if(jo.get("token_type")!=null){
                    String token_type = jo.get("token_type").getAsString();
                    System.out.println("token_type：" + token_type);
                }if(jo.get("openmode_shoes_list")!=null){
                    //获取message对应的值
                    JsonElement openmode_shoes_list =jo.get("openmode_shoes_list") ;
                    JSONArray jsonArray = JSONArray.fromObject(openmode_shoes_list.toString());
                    System.out.println(jsonArray.getJSONObject(0).get("id"));
                    Integer sss= (Integer) jsonArray.getJSONObject(0).get("id");
                    return String.valueOf(sss);
                }
            }
        }

        return "success";
    }

}
