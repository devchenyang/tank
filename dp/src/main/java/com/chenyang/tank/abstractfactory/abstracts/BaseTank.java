package com.chenyang.tank.abstractfactory.abstracts;

import com.chenyang.tank.Dir;
import com.chenyang.tank.Group;
import com.chenyang.tank.TankFrame;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class BaseTank {
    public abstract void paint(Graphics g);

    public abstract int getX();

    public abstract int getY();

    public abstract Dir getDir();

    public abstract Group getGroup();

    public abstract void setLiving(boolean b);

    public abstract TankFrame getTf();

    public abstract Rectangle getRect();

    public abstract void fire();

    public abstract void setMoving(boolean b);

    public abstract void setDir(Dir up);
}
