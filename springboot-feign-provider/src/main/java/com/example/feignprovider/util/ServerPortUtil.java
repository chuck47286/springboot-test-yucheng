package com.example.feignprovider.util;


import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author yucheng
 * @Date 2023/6/9 17:13
 * @Version 1.0
 */
public class ServerPortUtil {
    public static String getLocalURL() {
        return getIpAddress() + ":" + getLocalPort();
    }
    private static String getIpAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "Unknown";
    }
    private static String getLocalPort() {
        return System.getProperty("server.port");
    }
}
