package com.example.hackillinois2023;

import android.graphics.Bitmap;

public class Character {
    private int x;
    private int y;
    private int move_speed;
    private int jump_speed;
    private int life;
    private int score;

    Bitmap character;
    public Character(int x, int y, int life, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
        this.life = life;
    }

    /*
        jump method, only jump when on the ground
     */
    public void jump(int jumpSpeed) {

    }

    /*
        move method
     */
    public void move(int moveSpeed) {

    }

    /*
        when hit the monsters, reduce life based on the attack of different monsters
     */
    public void hit(Monsters[] monsters) {

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


    public int getMove_speed() {
        return move_speed;
    }

    public void setMove_speed(int move_speed) {
        this.move_speed = move_speed;
    }

    public int getJump_speed() {
        return jump_speed;
    }

    public void setJump_speed(int jump_speed) {
        this.jump_speed = jump_speed;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
