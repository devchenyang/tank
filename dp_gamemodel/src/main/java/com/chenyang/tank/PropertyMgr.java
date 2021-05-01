package com.chenyang.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    static Properties pros = new Properties();

    static {
        try {
            pros.load(PropertyMgr.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PropertyMgr() {
    }

    public static Object get(String key) {
        if (key == null) return null;
        return pros.get(key);
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr.get("tank.initCount"));
    }
}
