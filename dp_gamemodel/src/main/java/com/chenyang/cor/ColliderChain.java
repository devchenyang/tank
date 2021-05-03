package com.chenyang.cor;

import com.chenyang.tank.GameObject;

import java.util.LinkedList;

public class ColliderChain {
    LinkedList<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        add(new TankTankCollider());
        add(new BulletTankCollider());
    }

    private void add(Collider collider) {
        colliders.add(collider);
    }

    public void collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            colliders.get(i).collide(o1, o2);
        }
    }
}
