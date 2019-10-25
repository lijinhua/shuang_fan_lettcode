package leetcode;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        System.out.println(decodeParamter("http%3A%2F%2Fcm15-c110-2.play.bokecc.com%2Fflvs%2Fca%2FQxEez%2FuHLsHEkrwg-20.mp4%3Ft%3D1561474798%26key%3DFE46929B48762434FD9BF87F5D0F167E%26tpl%3D10"));
    }

    public static String decodeParamter(String param) {
        try {
            return java.net.URLDecoder.decode(param, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "test";
    }
}