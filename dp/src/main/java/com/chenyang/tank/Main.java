package com.chenyang.tank;

public class Main {
    public static void main(String[] args) throws Exception {
        TankFrame tf = new TankFrame();
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("tank.initCount"));
        for (int i = 0; i < initTankCount; i++) {
            tf.enemies.add(tf.gf.createTank(50 + i * 80, 200, Dir.DOWN, Group.BAD, tf));
        }

        new Thread(()->new Audio("audio/war1.wav").play()).start();

        // 自动调用paint方法，实现tank在窗口中自动移动
        while (true) {
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
