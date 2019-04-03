package com.nasa.roboticRovers.utility.direction;

import com.nasa.roboticRovers.exceptions.ExceptionMessages;
import com.nasa.roboticRovers.exceptions.IllegalInputParameterException;

/**
 * @author Efrem
 */

/* Utility class that provides an instance of Direction
*/
public class DirectionFactory {

    public static Direction getDirection(String direction) throws IllegalInputParameterException{
        direction= direction.toLowerCase();
        Direction newDirection= null;

        switch (direction){

            case "n": newDirection= new North();
                      break;
            case "s": newDirection=  new South();
                      break;
            case "e": newDirection= new East();
                      break;
            case "w": newDirection= new West();
                      break;

        }

        if (newDirection==null){
            throw new IllegalInputParameterException(ExceptionMessages.ILLEGAL_DIRECTION_PARAMETER.getMessage());

        }

        return newDirection;

    }
}
