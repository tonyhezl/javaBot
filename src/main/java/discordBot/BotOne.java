package discordBot;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class BotOne {

    static int index = 0;
    static int index2 = 0;
    static String id2="";

    public static void main(String[] args) throws InterruptedException {

        //ID：yyds
        TimerTask taskOne = new TimerTask() {
            @Override
            public void run() {
                String url = "https://discord.com/api/v9/channels/984296390173786182/messages";
                String authorization = "OTEzNjY2NjY1MDI2MzA2MDg4.GrmtBQ.1sXbwGyhwsIBpxsH9JvAO8CZndWa1K7l-4-_ek";
                String agent =  "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.83 Safari/537.36";
                String[] langs = new String[]{"人人都搞碳中和！哈哈哈","感觉白这么难拿吗","不知道现在升级还来得及不哦！","哈哈哈","今天你们都要冲到8级嘛","感觉好慌啊","咋办咋办","兄弟们都吃早饭了嘛","我还没吃哦","哈哈哈","有没有比我等级低的","感觉人没得多少应该没有机器人吧","兄弟们这个项目怎么样呢","值得肝起来不","项目投资方牛皮不牛皮","希望这个项目牛逼起来","感觉我才来都被你们卷了","这项目必须火起来啊","哈哈","卷的没办法了","前面是有人说经验获取更少了嘛","你们666","保持活跃吧","两分钟才能发言一次","护肝片吃起来！！","药不能停","真的卷啊","还是蛮看好这个项目的","希望努力有回报","我快要肝不动了兄弟们","我实在是肝不动了","但是看到你们我只有接着肝了", "开始卷了啊", "不要停兄弟们", "卷起来了", "肝硬化了都", "不要停啊继续肝起来", "键盘都敲碎了", "为了白冲啊", "真的肝你们", "护肝片吃起来"};
                if(index<langs.length||index==langs.length){
                    HashMap<String, Object> paramMap = new HashMap<>();
                    paramMap.put("content", langs[index]);
                    Random random = new Random();
                    paramMap.put("nonce", "82329451212"+String.valueOf(random.nextInt( 1000)));
                    paramMap.put("tts", false);
                    id2 = BotOne.sendMsg(JSON.toJSONString(paramMap),url,agent,authorization);
                    index++;
                }
            }
        };
        Timer timerOne = new Timer();
        // 从现在开始每间隔 1000 ms 计划执行一个任务（规律性重复执行调度 TimerTask）
        timerOne.schedule(taskOne, 1 ,130000);

        //id-first
        TimerTask taskTwo= new TimerTask() {
            @Override
            public void run() {
                String url = "https://discord.com/api/v9/channels/984296390173786182/messages";
                String authorization = "OTUxMzQyNTgwNDcyMzgxNDUw.Gdwdo6.p9uFMIeuvtJZ80Dh8CEAbykN5bfbLkPFwlQAj0";
                String agent =  "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.83 Safari/537.36";
                String[] langs = new String[]{"现在还能得og不哦","我才进来算是早期嘛","不知道现在升级还来得及不哦！","这个阿里的项目咋样啊","人气太火爆了","感觉mod特别有耐心","为我们解答问题","兄弟们你们来的好早啊","我感觉我等级是你们最低的","哈哈哈","有没有比我等级低的","八级得肝到多久哦","是不是还要有邀请","这项目值得肝！","项目方这么牛皮","mint的费用a看到前面有人说0.3e","如果是的话还是有点贵啊","希望到时候上os百倍打底！","你们太卷了","真的是停不下来","管理好几个频道都见过，哈哈哈","6666666","保持活跃吧","两分钟才能发言一次太慢了"};
                if(index2<langs.length||index2==langs.length){
                    HashMap<String, Object> paramMap = new HashMap<>();
                    paramMap.put("content", langs[index2]);
                    Random random = new Random();
                    paramMap.put("nonce", "82329451212"+String.valueOf(random.nextInt( 1000)));
                    paramMap.put("tts", false);
                    id2 = BotOne.sendMsg(JSON.toJSONString(paramMap),url,agent,authorization);
                    index2++;
                }
                /*try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                BotOne.delete(id2,url,agent,authorization);*/
            }
        };
        Timer timerTwo= new Timer();
        // 从现在开始每间隔 1000 ms 计划执行一个任务（规律性重复执行调度 TimerTask）
        timerTwo.schedule(taskTwo, 1 ,140000);

        //id-btc
        TimerTask taskThree= new TimerTask() {
            @Override
            public void run() {
                String url = "https://discord.com/api/v9/channels/984296390173786182/messages";
                String authorization = "ODE3MjE5NDAxMzE2Njk2MDg0.G4zHn0.IO77J_jsZ1NlZgTZwExVX8oZhn4bVO7_UV2JYo";
                String agent =  "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.83 Safari/537.36";
                String[] langs = new String[]{"你们能不能停停稍等会在肝，哈哈哈！","来肝了","你们昨天肝了一夜哇","我感觉都来晚了","你们一个比一个卷","得加快进度了","今天一定肝一天！","肯定能肝到8j","哈哈哈","有没有比我等级低的","感觉我们频道很严格","应该没得多少机器人","现在两分钟发言一次太慢了","项目投资方牛皮不牛皮","希望这个项目牛逼起来","感觉我才来都被你们卷了","这项目必须火起来啊","哈哈","卷的没办法了","前面是有人说经验获取更少了嘛","你们666","保持活跃吧","十几秒发言一次就可以了","现在3级还有多少白哦","护肝片吃起来！！","药不能停","真的卷啊","还是蛮看好这个项目的","希望努力有回报","我快要肝不动了兄弟们","我实在是肝不动了","但是看到你们我只有接着肝了", "开始卷了啊", "不要停兄弟们", "卷起来了", "肝硬化了都", "不要停啊继续肝起来", "键盘都敲碎了", "为了白冲啊", "真的肝你们", "护肝片吃起来"};
                if(index2<langs.length||index2==langs.length){
                    HashMap<String, Object> paramMap = new HashMap<>();
                    paramMap.put("content", langs[index2]);
                    Random random = new Random();
                    paramMap.put("nonce", "82329451212"+String.valueOf(random.nextInt( 1000)));
                    paramMap.put("tts", false);
                    id2 = BotOne.sendMsg(JSON.toJSONString(paramMap),url,agent,authorization);
                    index2++;
                }
            }
        };
        Timer timerThree= new Timer();
        // 从现在开始每间隔 1000 ms 计划执行一个任务（规律性重复执行调度 TimerTask）
        timerThree.schedule(taskThree, 1 ,150000);

        //id-chen
        TimerTask taskf= new TimerTask() {
            @Override
            public void run() {
                String url = "https://discord.com/api/v9/channels/984296390173786182/messages";
                String authorization = "OTczNDgyNzUxMTc1MDQ1MTgx.GvxoEv.aIbZq6sK6gPVC9p0wcxEBJ6QjCeFe_iNAHwoIY";
                String agent =  "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.83 Safari/537.36";
                String[] langs = new String[]{"又来了","开始卷了啊","不要停兄弟们","卷起来了", "肝硬化了都", "不要停啊继续肝起来","键盘都敲碎了","为了白冲啊","真的肝你们","护肝片吃起来","不要停","真的难","卷就是了", "肝起来", "不要停继续肝起来","真的停不下来","肝的都饿了","停下来就凉了","大佬们真牛啊","不要停住","今天干到最后","真的难","一起肝","冲就是了","不要停啊","肝了肝了","真的不要停","手抖了都","都好肝啊","停下来就输了","胜利在前方","你们真的卷啊","真的厉害啊","咋那么猛","上岸上岸","加油兄弟","加油","真的活跃","加油兄弟们","我们可以的","肝的头晕眼花","停了就没了","要上岸 要加油","好累","你们是真的肝","停不下来","加油可以的","肝了一天","好难啊","加油加油","休息一下哇","真的好难啊","有啊","肝吧兄弟们","肝的太猛","停不下来了都","不想肝了","难啊","费肝真的","牛啊兄弟们","继续肝","不要停哦"};
                if(index2<langs.length||index2==langs.length){
                    HashMap<String, Object> paramMap = new HashMap<>();
                    paramMap.put("content", langs[index2]);
                    Random random = new Random();
                    paramMap.put("nonce", "82329451212"+String.valueOf(random.nextInt( 1000)));
                    paramMap.put("tts", false);
                    id2 = BotOne.sendMsg(JSON.toJSONString(paramMap),url,agent,authorization);
                    index2++;
                }
            }
        };
        Timer timerf= new Timer();
        // 从现在开始每间隔 1000 ms 计划执行一个任务（规律性重复执行调度 TimerTask）
        timerf.schedule(taskf, 1 ,160000);

    }




    public static String sendMsg(String params,String url,String agent,String authorization){
        String result = HttpRequest.post(url)
                .header(Header.USER_AGENT, agent)//头信息，多个头信息多次调用此方法即可
                .header(Header.AUTHORIZATION,authorization)
                .header(Header.CONTENT_TYPE,"application/json")
                .body(params)//表单内容
                .timeout(20000)//超时，毫秒
                .execute().body();
        System.out.println(Thread.currentThread().getName()+result);
        JsonParser jp = new JsonParser();
        //将json字符串转化成json对象
        String id = null;
        if (result!="") {
            JsonObject jo = jp.parse(result).getAsJsonObject();
            //获取message对应的值
            id = jo.get("id").getAsString();
            System.out.println("msgId：" + id);
        }
        return id;

    }

    public static void delete(String id,String url,String agent,String authorization){
        //删除拿到的是上面返回结果里的id值
        String msg = HttpRequest.delete("https://discord.com/api/v9/channels/984296390173786182/messages/"+id)
                .header(Header.USER_AGENT, agent)//头信息，多个头信息多次调用此方法即可
                .header(Header.AUTHORIZATION,authorization)
                .header(Header.CONTENT_TYPE,"application/json")
                .timeout(2000).execute().body();
    }

}
