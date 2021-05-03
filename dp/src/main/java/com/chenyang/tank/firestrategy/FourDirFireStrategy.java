package com.chenyang.tank.firestrategy;

import com.chenyang.tank.*;
import com.chenyang.tank.abstractfactory.abstracts.BaseTank;

public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(BaseTank t) {
        int bX = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        TankFrame tf = t.getTf();
        tf.gf.createBullet(bX, bY, Dir.UP, t.getGroup(), tf);
        tf.gf.createBullet(bX, bY, Dir.DOWN, t.getGroup(), tf);
        tf.gf.createBullet(bX, bY, Dir.LEFT, t.getGroup(), tf);
        tf.gf.createBullet(bX, bY, Dir.RIGHT, t.getGroup(), tf);

        if (t.getGroup() == Group.GOOD)
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
