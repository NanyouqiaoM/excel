package com.xiyu.test;

import java.lang.reflect.Field;

public class Desc {
    private Double height;
    private Double weight;

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Desc() {
    }

    public Desc(Double height, Double weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Desc{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }




}
