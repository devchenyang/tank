package com.chenyang.cor;

import com.chenyang.tank.Bullet;
import com.chenyang.tank.Explode;
import com.chenyang.tank.GameObject;
import com.chenyang.tank.Tank;

public class TankTankCollider implements Collider {
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;

            if (t1.rect.intersects(t2.rect)) {
                t1.back();
                t2.back();
            }
        }
    }
}
