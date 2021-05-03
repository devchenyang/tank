package com.chenyang.tank.abstractfactory.factory;

import com.chenyang.tank.*;
import com.chenyang.tank.abstractfactory.interfaces.BaseBullet;
import com.chenyang.tank.abstractfactory.interfaces.BaseExplode;
import com.chenyang.tank.abstractfactory.interfaces.BaseTank;

public class DefaultFactory extends GameFactory {

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return null;
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return null;
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new Explode(x, y, tf);
    }
}
