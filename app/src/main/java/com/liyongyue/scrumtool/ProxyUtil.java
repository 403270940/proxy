package com.liyongyue.scrumtool;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yli on 2015/7/23.
 */
public class ProxyUtil {

    public static List<ProxyItem> getProxyList(int count){
        List<ProxyItem> proxyList = new ArrayList<ProxyItem>();
        String proxyURL = "http://evxr.daili666.com/ip/?tid=555616995679100&operator=1&ports=3128,8080,55336,9797,8888&filter=on&num=" + count;
        String proxyResult = "";
        HttpGet httpGet = new HttpGet(proxyURL);

        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpResponse response = httpClient.execute(httpGet);
            proxyResult = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            return null;
        }
        String[] proxies = proxyResult.split("\n");
        for(String proxy :proxies){
            String hostname = proxy.trim().split(":")[0];
            int port = Integer.valueOf(proxy.trim().split(":")[1]);
            ProxyItem pItem = new ProxyItem(hostname,port);
            proxyList.add(pItem);
        }

        return proxyList;
    }

}
