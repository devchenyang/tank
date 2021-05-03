package com.chenyang.tank.firestrategy;

import com.chenyang.tank.*;

public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        t.tf.gf.createBullet(bX, bY, Dir.UP, t.getGroup(), t.tf);
        t.tf.gf.createBullet(bX, bY, Dir.DOWN, t.getGroup(), t.tf);
        t.tf.gf.createBullet(bX, bY, Dir.LEFT, t.getGroup(), t.tf);
        t.tf.gf.createBullet(bX, bY, Dir.RIGHT, t.getGroup(), t.tf);

        if (t.getGroup() == Group.GOOD)
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
