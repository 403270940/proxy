package com.liyongyue.scrumtool;

/**
 * Created by yli on 2015/7/23.
 */
public class ProxyItem {
    private String hostname;
    private int port;

    public ProxyItem(String hostname,int port){
        this.hostname = hostname;
        this.port = port;
    }
    public String getHostname() {
        return hostname;
    }
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
    public int getPort() {
        return port;
    }
    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "ProxyItem{" +
                "hostname='" + hostname + '\'' +
                ", port=" + port +
                '}';
    }
}
