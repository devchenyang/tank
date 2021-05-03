package com.chenyang.tank;

import com.chenyang.cor.ColliderChain;

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
    ColliderChain chain = new ColliderChain();

    public GameModel() {
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("tank.initCount"));
        for (int i = 0; i < initTankCount; i++) {
            add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    public void add(GameObject go) {
        this.objects.add(go);
    }

    public void remove(GameObject go) {
        this.objects.remove(go);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.setColor(c);

        myTank.paint(g);

        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                chain.collide(o1, o2);
            }
        }
    }
}
