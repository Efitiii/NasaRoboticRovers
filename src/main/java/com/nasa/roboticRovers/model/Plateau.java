package com.nasa.roboticRovers.model;

/**
 * @author Efrem
 */

/*
 * A model class that defines the size of plateau under consideration
 */

public class Plateau {

    Integer x_size;
    Integer y_size;

   public Plateau (Integer x_size, Integer y_size){
        this.x_size=x_size;
        this.y_size=y_size;

    }

    public Integer getX_size() {
        return x_size;
    }

    public Integer getY_size() {
        return y_size;
    }
}
