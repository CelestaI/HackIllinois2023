package com.example.hackillinois2023;

import android.graphics.Bitmap;

public class Monsters {
    private int x;
    private int y;

    private int attack;

    private int type;

    Bitmap monsters;

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

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
