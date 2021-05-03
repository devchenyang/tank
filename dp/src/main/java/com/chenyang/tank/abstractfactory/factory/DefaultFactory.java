package com.chenyang.tank.abstractfactory.factory;

import com.chenyang.tank.Bullet;
import com.chenyang.tank.Dir;
import com.chenyang.tank.Explode;
import com.chenyang.tank.Group;
import com.chenyang.tank.Tank;
import com.chenyang.tank.TankFrame;
import com.chenyang.tank.abstractfactory.abstracts.BaseBullet;
import com.chenyang.tank.abstractfactory.abstracts.BaseExplode;
import com.chenyang.tank.abstractfactory.abstracts.BaseTank;

public class DefaultFactory extends GameFactory {

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Tank(x, y, dir, group, tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Bullet(x, y, dir, group, tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new Explode(x, y, tf);
    }
}
