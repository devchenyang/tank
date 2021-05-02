package com.chenyang.tank;

public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bX = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        new Bullet(bX, bY, Dir.UP, t.getGroup(), t.tf);
        new Bullet(bX, bY, Dir.DOWN, t.getGroup(), t.tf);
        new Bullet(bX, bY, Dir.LEFT, t.getGroup(), t.tf);
        new Bullet(bX, bY, Dir.RIGHT, t.getGroup(), t.tf);

        if (t.getGroup() == Group.GOOD)
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
