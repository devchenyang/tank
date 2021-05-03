package com.chenyang.cor;

import com.chenyang.tank.Bullet;
import com.chenyang.tank.Explode;
import com.chenyang.tank.GameObject;
import com.chenyang.tank.Tank;

public class BulletTankCollider implements Collider {
    @Override
    public void collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            if (b.getGroup() == t.getGroup()) return;

            int eX = t.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int eY = t.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;

            if (b.rect.intersects(t.rect)) {
                t.setLiving(false);
                b.setLiving(false);
                b.gm.add(new Explode(eX, eY, b.gm));
            }
        }
        if (o1 instanceof Tank && o2 instanceof Bullet) {
            collide(o2, o1);
        }
    }
}
