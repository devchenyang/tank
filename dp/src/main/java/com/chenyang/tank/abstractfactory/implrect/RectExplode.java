package com.chenyang.tank.abstractfactory.implrect;

import com.chenyang.tank.ResourceMgr;
import com.chenyang.tank.TankFrame;
import com.chenyang.tank.abstractfactory.interfaces.BaseExplode;

import java.awt.Color;
import java.awt.Graphics;

public class RectExplode implements BaseExplode {
    private int x;
    private int y;
    private int step = 0;
    private TankFrame tf;

    public RectExplode() {
    }

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
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
