package org.westos.爬虫;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTest {
    public static void main(String[] args) throws IOException {
        HttpURLConnection connection = (HttpURLConnection)
                new URL("https://tieba.baidu.com/p/2256306796?red_tag=1781367364").openConnection();
        InputStream in = connection.getInputStream();
        StringBuilder sb = new StringBuilder();
        byte[] bytes = new byte[1024 * 8];
        int len = in.read(bytes);
        while ((len=in.read(bytes))!=-1){
            sb.append(new String(bytes,0,len,"utf-8"));
        }

        //System.out.println(sb.toString());

        Pattern p = Pattern.compile("<img.*src=(.*?)[^>]*?>");
        Matcher m = p.matcher(sb);
        List<String> list = new ArrayList<>();
        while (m.find()) {
            list.add(m.group());
        }
        System.out.println(list);
    }
}
