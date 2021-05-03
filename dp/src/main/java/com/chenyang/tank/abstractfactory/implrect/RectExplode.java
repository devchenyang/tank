package com.chenyang.tank.abstractfactory.implrect;

import com.chenyang.tank.Audio;
import com.chenyang.tank.ResourceMgr;
import com.chenyang.tank.TankFrame;
import com.chenyang.tank.abstractfactory.abstracts.BaseExplode;

import java.awt.Color;
import java.awt.Graphics;

public class RectExplode extends BaseExplode {
    private int x;
    private int y;
    public static int WIDTH = 10;
    public static int HEIGHT = 10;
    private boolean living = true;
    private int step = 0;
    private TankFrame tf;

    public RectExplode() {
    }

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;

        new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public TankFrame getTf() {
        return tf;
    }

    public void setTf(TankFrame tf) {
        this.tf = tf;
    }

    @Override
    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.MAGENTA);
        g.fillRect(x, y, 10 * step, 10 * step);
        step++;
        g.setColor(c);
        if (step >= ResourceMgr.explodes.length) {
            tf.explodes.remove(this);
        }
    }
}
