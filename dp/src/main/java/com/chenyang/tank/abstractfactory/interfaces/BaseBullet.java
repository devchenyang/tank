package com.chenyang.tank.abstractfactory.interfaces;

import com.chenyang.tank.Tank;

import java.awt.*;

public interface BaseBullet {
    void paint(Graphics g);
    void collideWith(BaseTank tank);
}
