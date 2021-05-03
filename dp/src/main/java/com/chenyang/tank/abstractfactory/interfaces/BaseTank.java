package com.chenyang.tank.abstractfactory.interfaces;

import com.chenyang.tank.Dir;
import com.chenyang.tank.Group;
import com.chenyang.tank.TankFrame;

import java.awt.*;

public interface BaseTank {

    void paint(Graphics g);

    int getX();

    int getY();

    Dir getDir();

    Group getGroup();

    void setLiving(boolean b);

    TankFrame getTf();

    Rectangle getRect();
}
