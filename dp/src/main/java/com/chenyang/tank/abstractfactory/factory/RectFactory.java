package com.chenyang.tank.abstractfactory.factory;

import com.chenyang.tank.Dir;
import com.chenyang.tank.Group;
import com.chenyang.tank.TankFrame;
import com.chenyang.tank.abstractfactory.implrect.RectBullet;
import com.chenyang.tank.abstractfactory.implrect.RectExplode;
import com.chenyang.tank.abstractfactory.implrect.RectTank;
import com.chenyang.tank.abstractfactory.abstracts.BaseBullet;
import com.chenyang.tank.abstractfactory.abstracts.BaseExplode;
import com.chenyang.tank.abstractfactory.abstracts.BaseTank;

public class RectFactory extends GameFactory {

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectTank(x, y, dir, group, tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectBullet(x, y, dir, group, tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x, y, tf);
    }
}
