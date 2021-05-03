package com.chenyang.tank.firestrategy;

import com.chenyang.tank.Audio;
import com.chenyang.tank.Bullet;
import com.chenyang.tank.Group;
import com.chenyang.tank.Tank;

public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        t.tf.gf.createBullet(bX, bY, t.getDir(), t.getGroup(), t.tf);

        if (t.getGroup() == Group.GOOD)
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
