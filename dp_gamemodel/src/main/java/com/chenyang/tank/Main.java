package com.chenyang.tank;

public class Main {
    public static void main(String[] args) throws Exception {
        TankFrame tf = new TankFrame();

        new Thread(()->new Audio("audio/war1.wav").play()).start();

        // 自动调用paint方法，实现tank在窗口中自动移动
        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
