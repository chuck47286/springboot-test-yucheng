package com.example.feignprovider.vo;

import lombok.Data;

/**
 * @Author yucheng
 * @Date 2023/6/9 11:21
 * @Version 1.0
 */
@Data
public class CommonResponseBody<T> {

    private T data;
    private String message;
    private int code;

    public CommonResponseBody() {
    }

    public CommonResponseBody(T data) {
        this.data = data;
    }
    public CommonResponseBody(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public CommonResponseBody<T> success(String message) {
        // 执行其他操作
        this.message = message;
        return this;
    }

    public CommonResponseBody<T> fail(String message) {
        // 执行其他操作
        this.message = message;
        return this;
    }

//    private static char[] getCharUrl() {
//        String url = "[IP]: " + getIpAddress() + ", [Port]: " + getServerPort();
//        return url.toCharArray();
//    }

//    private static String getUrl() {
//        return "[IP]: " + getIpAddress() + ", [Port]: " + getServerPort();
//    }
//
//    private static String getServerPort() {
//        return System.getProperty("server.port");
//    }
//
//    private static String getIpAddress() {
//        try {
//            return InetAddress.getLocalHost().getHostAddress();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        return "Unknown";
//    }
}
