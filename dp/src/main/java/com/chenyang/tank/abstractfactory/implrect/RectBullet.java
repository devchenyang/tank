package com.chenyang.tank.abstractfactory.implrect;

import com.chenyang.tank.Dir;
import com.chenyang.tank.Explode;
import com.chenyang.tank.Group;
import com.chenyang.tank.Tank;
import com.chenyang.tank.TankFrame;
import com.chenyang.tank.abstractfactory.interfaces.BaseBullet;
import com.chenyang.tank.abstractfactory.interfaces.BaseTank;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class RectBullet implements BaseBullet {

    private int x;
    private int y;
    public static int WIDTH = 10;
    public static int HEIGHT = 10;
    private Dir dir;
    private static final int SPEED = 6;
    private boolean living = true;
    private Group group = Group.BAD;
    Rectangle rect = new Rectangle();
    private TankFrame tf;

    public RectBullet() {
    }

    public RectBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        this.tf = tf;

        tf.bullets.add(this);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public void paint(Graphics g) {
        if (!living) tf.bullets.remove(this);

        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(c);

        move();
    }

    private void move() {
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT)
            living = false;

        rect.x = this.x;
        rect.y = this.y;
    }

    public void collideWith(BaseTank tank) {
        if (this.group == tank.getGroup()) return;

        int eX = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
        int eY = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;

        if (rect.intersects(tank.getRect())) {
            tank.setLiving(false);
            this.setLiving(false);
            tf.explodes.add(tf.gf.createExplode(eX, eY, tf));
        }
    }
}
