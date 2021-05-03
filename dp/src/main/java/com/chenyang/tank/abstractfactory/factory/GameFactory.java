package com.chenyang.tank.abstractfactory.factory;

import com.chenyang.tank.Dir;
import com.chenyang.tank.Group;
import com.chenyang.tank.TankFrame;
import com.chenyang.tank.abstractfactory.abstracts.BaseBullet;
import com.chenyang.tank.abstractfactory.abstracts.BaseExplode;
import com.chenyang.tank.abstractfactory.abstracts.BaseTank;

public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);
    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);
    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);
}
