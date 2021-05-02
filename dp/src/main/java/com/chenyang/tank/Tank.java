package com.chenyang.tank;

import java.awt.*;
import java.util.Random;

// 面向对象编程，把一些（经常重复用到的）属性封装到一个类里，
// 需要的时候new出来，这样可以大大简化代码
// 然后把画坦克的方法放到Tank类里面，
// 面向对象设计，哪些方法放到那些类里
public class Tank {
    private int x;
    private int y;
    public static int WIDTH = ResourceMgr.rGoodTankD.getWidth();
    public static int HEIGHT = ResourceMgr.rGoodTankD.getHeight();
    private Dir dir;
    private static final int SPEED = 2;
    private boolean living = true;
    private boolean moving = true;
    private Group group = Group.BAD;
    private Random random = new Random();
    Rectangle rect = new Rectangle();
    TankFrame tf;
    FireStrategy fs = new FourDirFireStrategy();

    public Tank() {
    }

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        this.tf = tf;
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

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {
        // 在固定位置画出tank
        // g.fillRect(200, 200, 50, 50);

        // 改变tank的位置
//        Color color = g.getColor();
//        g.setColor(Color.YELLOW);
//        g.fillRect(x, y, 50, 50);
//        g.setColor(color);
        // x += 10;
        // y += 10;

        // 验证切换窗口时会调用pain方法
        // System.out.println("paint");
        if (!living) tf.enemies.remove(this);
        switch (dir) {
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.rBadTankU : ResourceMgr.rGoodTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.rBadTankD : ResourceMgr.rGoodTankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.rBadTankL : ResourceMgr.rGoodTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.rBadTankR : ResourceMgr.rGoodTankR, x, y, null);
                break;
            default:
                break;
        }

        move();
    }

    private void move() {
        if (!moving) return;
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

        if (this.group == Group.BAD && random.nextInt(100) > 95)
            this.fire();

        if (this.group == Group.BAD && random.nextInt(100) > 95)
            randomDir();

        boundsCheck();

        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        //左边界
        if (this.x < 2) x = 2;
        //上边界
        if (this.y < 28) y = 28;
        //右边界
        if (this.x > TankFrame.GAME_WIDTH - Tank.HEIGHT - 2) x = TankFrame.GAME_WIDTH - Tank.HEIGHT - 2;
        //下边界
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        fs.fire(this);
    }
}
