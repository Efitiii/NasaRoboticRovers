package com.nasa.roboticRovers.utility.direction;

import com.nasa.roboticRovers.exceptions.ExceptionMessages;
import com.nasa.roboticRovers.exceptions.IllegalNavigationAreaException;
import com.nasa.roboticRovers.model.Plateau;
import com.nasa.roboticRovers.model.Position;
import com.nasa.roboticRovers.utility.EmptySpaceValidator;

/**
 * @author Efrem
 */

public interface Direction {

    public Position triggerRobot (String in, Position position, Plateau plateau) throws IllegalNavigationAreaException;


    default public void checkForFreeSpaceAndAdd(Position currentPosition, Position nextPosition) throws IllegalNavigationAreaException {

        if (EmptySpaceValidator.checkFreeSpace(nextPosition)) {
            EmptySpaceValidator.removeOldPosition(currentPosition);
            EmptySpaceValidator.addNewPosition(nextPosition);
        }
        else{

            throw new IllegalNavigationAreaException(ExceptionMessages.ILLEGAL_NAVIGATION_INPUT_ANOTHERROVEREXIST.getMessage());
        }

    }

}
