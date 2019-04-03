package com.nasa.roboticRovers.model;

import com.nasa.roboticRovers.utility.direction.Direction;

import java.util.Objects;

/**
 * @author Efrem
 */


/*
 * A model class Position that defines the x-coordinates, y-coordinates and the compass cardinal point
 * To help with HashSet implementation equals() and hashcode() methods are overridden
 */


public class Position {

    Integer x_coord;
    Integer y_coord;
    Direction cardinal_point;

    public Position(Integer x_coord, Integer y_coord, Direction cardinal_point){
        this.x_coord=x_coord;
        this.y_coord=y_coord;
        this.cardinal_point=cardinal_point;
    }


    public Integer getX_coord() {
        return x_coord;
    }

    public Integer getY_coord() {
        return y_coord;
    }

    public Direction getCardinal_point() {
        return cardinal_point;
    }

    public void setX_coord(Integer x_coord) {
        this.x_coord = x_coord;
    }

    public void setY_coord(Integer y_coord) {
        this.y_coord = y_coord;
    }

    public void setCardinal_point(Direction cardinal_point) {
        this.cardinal_point = cardinal_point;
    }


    @Override
    public int hashCode(){

        return Objects.hash(x_coord,y_coord);
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Position)){
            return false;
        }

        Position position= (Position) o;

        return this.x_coord==position.getX_coord() && this.y_coord==position.getY_coord();

    }


    @Override
    public String toString(){

        return  "x-Coordinates:" + this.getX_coord()+ "\n"+
                "y-Coordinates:" + this.getY_coord()+ "\n"+
                "cardinal-point:" + this.getCardinal_point().getClass().getName();
    }


}
