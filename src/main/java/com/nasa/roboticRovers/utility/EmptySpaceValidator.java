package com.nasa.roboticRovers.utility;

import com.nasa.roboticRovers.model.Position;
import com.nasa.roboticRovers.utility.direction.Direction;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Efrem
 */

/* Utility class that checks if the robot's direction of motion is valid;
   ~ Checks if the location is already occupied by another robot.
*/

public class EmptySpaceValidator {

    public Set<Position> occupiedPositions= new HashSet<Position>();



    public boolean checkFreeSpace(Position newPosition){

        boolean freeSpace=false;

        if(!this.occupiedPositions.contains(newPosition)) {

            freeSpace=true;
        }

        return freeSpace;

    }

    public void removeOldPosition(Position currentPosition){


        this.occupiedPositions.remove(currentPosition);


    }

    public  void addNewPosition(Position newPosition){

        Integer x_coord= newPosition.getX_coord();
        Integer y_coord= newPosition.getY_coord();
        Direction direction= newPosition.getCardinal_point();

        this.occupiedPositions.add(new Position(x_coord,y_coord,direction));


    }



}
