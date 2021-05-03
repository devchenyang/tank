package com.chenyang.tank.abstractfactory.implrect;

import com.chenyang.tank.Dir;
import com.chenyang.tank.Group;
import com.chenyang.tank.PropertyMgr;
import com.chenyang.tank.Tank;
import com.chenyang.tank.TankFrame;
import com.chenyang.tank.abstractfactory.abstracts.BaseTank;
import com.chenyang.tank.firestrategy.DefaultFireStrategy;
import com.chenyang.tank.firestrategy.FireStrategy;

import java.awt.*;
import java.util.Random;

public class RectTank extends BaseTank {

    private int x;
    private int y;
    public static int WIDTH = 50;
    public static int HEIGHT = 50;
    private Dir dir;
    private static final int SPEED = 2;
    private boolean living = true;
    private boolean moving = true;
    private Group group = Group.BAD;
    private Random random = new Random();
    public Rectangle rect = new Rectangle();
    public TankFrame tf;
    public FireStrategy fs;

    public RectTank() {
    }

    public RectTank(int x, int y, Dir dir, Group group, TankFrame tf) {
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

    @Override
    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public TankFrame getTf() {
        return tf;
    }

    public void setTf(TankFrame tf) {
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!living) tf.enemies.remove(this);

        Color color = g.getColor();
        if (this.group == Group.GOOD) g.setColor(Color.RED);
        if (this.group == Group.BAD) g.setColor(Color.BLUE);
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(color);

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
        if (this.group == Group.GOOD) {
            String goodFS =(String) PropertyMgr.get("goodFS");
            try {
                fs  = (FireStrategy) Class.forName(goodFS).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            fs = new DefaultFireStrategy();
        }
        fs.fire(this);
    }
}
