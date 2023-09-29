package ethScan;

import cn.hutool.http.HttpUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.HashMap;

class Reptile {
    public static void main(String[] args) throws Exception{
        Reptile.run();
    }

    public static void run() throws Exception {
        StringBuffer data = new StringBuffer();
        for (int i = 0; i < 1; i++) {
            // 因为要爬取分页信息，就通过循环重新加载网页来来实现，一般网页的分页URL都是有规律的，一般就是在后面的数字加1得到，所以利用这个规律来实现分页爬取数据的效果
            // 网页地址
            String url = "https://etherscan.io/tokentxns?a=0xe0e8cc0ae10f3f24343a630d6ead1a512ab73d8b&p=1"+ (i + 1) + "/";
            try {
                // 根据URL获取当前URL界面的doc对象，里面存储着界面的所有元素，类似于BOM
                Document doc = Jsoup.connect(url).get();
                /*这个select方法可以对Elements集合类型对象，或者Element单个类型元素对象来使用 select方法的其中一个作用就是找到在括号里传入要找标签的名字，他就会返回调用这个select方法的标签对象所有的和要查 找标签名字一样的标签对象的集合，注意这里返回的是Elements集合对象 后面那个last()方法和first()方法，是对集合操作的方法返回的是Element元素对象,first()就是返回元素集合的第一个元素last() 就是返回的最后一个*/
                // 获取第一个表格
                Element table = doc.select("table").last();
                Element tbody = table.select("tbody").first();
                Elements trs = tbody.select("tr");
                // 这个就是遍历元素集合的每一个元素，来查找想要的标签对象
                for (Element tr : trs) {
                    //data.append("==================================Txn Hash============================").append("   ====Date=====").append("      =======Age=======").append("   =======From=======").append("   ===Way==  ").append("=======To=======").append("   =======Value=======  ").append("  =======Token======="+"\n");
                    Elements tds = tr.select("td");
                    for (Element td : tds) {
                        // text()方法局势返回调用标签元素中的文本内容，返回的是String类型
                        data.append(td.text() + "\t");
                    }
                    data.append("\n");
                    //sendMsg(data.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //将结果写入到文件当中
        /*File f = new File( "/usr/local/zdld/address.txt");
        OutputStream out = null;
        out = new FileOutputStream(f);
        byte b[] = data.toString().getBytes();
        out.write(b);
        out.close();*/
        System.out.println(data);
    }

    public static void sendMsg(String data){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("text", data);
        String result= HttpUtil.post("http://114.132.237.91:5000/sendJK6", paramMap);
    }
}
