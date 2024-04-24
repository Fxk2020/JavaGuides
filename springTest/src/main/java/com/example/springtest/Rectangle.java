package com.example.springtest;

public class Rectangle {
    private int width;
    private int length;

    public Rectangle() {
        System.out.println("Hello World!");
    }


    public void setWidth(int widTth) {
        this.width = widTth;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }
}


