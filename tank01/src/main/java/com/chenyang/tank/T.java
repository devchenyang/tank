package com.chenyang.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class T {
    public static void main(String[] args) {
        // 只执行这3行命令就可以在屏幕上显示一个窗口
        Frame f = new Frame();
        f.setSize(800, 600);
        f.setVisible(true);

        // 设置禁止窗口缩放，标题
        f.setResizable(false);
        f.setTitle("tank war");

        // 在窗口监听器的windowClosing方法中通过结束命令System.exit(0);
        // 实现点击关闭按钮时关闭窗口
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
