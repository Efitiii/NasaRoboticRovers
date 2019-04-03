package com.nasa.roboticRovers.utility.direction;

import com.nasa.roboticRovers.exceptions.ExceptionMessages;
import com.nasa.roboticRovers.exceptions.IllegalNavigationAreaException;
import com.nasa.roboticRovers.model.Plateau;
import com.nasa.roboticRovers.model.Position;

/**
 * @author Efrem
 */

public class West implements Direction {

    @Override
    public Position triggerRobot(String in, Position position, Plateau plateau) throws IllegalNavigationAreaException {

        if (!in.toLowerCase().equals("l") && !in.toLowerCase().equals("r") && !in.toLowerCase().equals("m")) {
            throw new IllegalNavigationAreaException(ExceptionMessages.ILLEGAL_INPUT_PARAMETER.getMessage());
        }

        Integer x_coord = position.getX_coord();
        Integer y_coord = position.getY_coord();
        Direction direction = position.getCardinal_point();

        Position tempPosition = new Position(x_coord, y_coord, direction);

        if (in.equals("l")) {
            tempPosition.setCardinal_point(new South());
        }

        if (in.equals("r")) {
            tempPosition.setCardinal_point(new North());
        }

        if (in.equals("m")) {

            if (x_coord - 1 >= 0) {

                tempPosition.setX_coord(x_coord - 1);

                this.checkForFreeSpaceAndAdd(position, tempPosition);


            } else {
                throw new IllegalNavigationAreaException(ExceptionMessages.ILLEGAL_NAVIGATION_INPUT_OUTOFBORDER.getMessage());
            }
        }

        return tempPosition;

    }


}
