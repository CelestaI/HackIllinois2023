package com.example.hackillinois2023;

public class Ground {
    private int groundX;
    private int groundY;

    private int speed;



    public Ground() {
        groundX = 0;
        groundY = 0;
    }

    public void move() {

    }


    public int getGroundY() {
        return groundY;
    }

    public void setGroundY(int groundY) {
        this.groundY = groundY;
    }

    public int getGroundX() {
        return groundX;
    }

    public void setGroundX(int groundX) {
        this.groundX = groundX;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //screen moving
    public void move(int speed) {

    }
}
