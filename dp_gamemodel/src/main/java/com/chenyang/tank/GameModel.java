package com.chenyang.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    Tank myTank = new Tank(200, 400, Dir.UP, Group.GOOD, this);
//    List<Bullet> bullets = new ArrayList<>();
//    List<Tank> enemies = new ArrayList<>();
//    List<Explode> explodes = new ArrayList<>();
    List<GameObject> objects = new ArrayList<>();


    public GameModel() {
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("tank.initCount"));
        for (int i = 0; i < initTankCount; i++) {
            objects.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.setColor(c);

        myTank.paint(g);

        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }


        /*for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < enemies.size(); j++) {
                bullets.get(i).collideWith(enemies.get(j));
            }
        }*/
    }
}
