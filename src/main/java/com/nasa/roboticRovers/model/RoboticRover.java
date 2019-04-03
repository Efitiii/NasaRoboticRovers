package com.nasa.roboticRovers.model;

/**
 * @author Efrem
 */

/*
 * A model class RoboticRover that represents a robotic rover,
 * each robotic rover has a unique id and the current position it is situated
 */


public class RoboticRover {

    Position currentPosition;
    String id_rover;

   public RoboticRover(Position currentPosition, String id_rover){
        this.currentPosition=currentPosition;
        this.id_rover=id_rover;

    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }


}
