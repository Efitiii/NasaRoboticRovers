package com.nasa.roboticRovers.utility.direction;

import com.nasa.roboticRovers.exceptions.ExceptionMessages;
import com.nasa.roboticRovers.exceptions.IllegalNavigationAreaException;
import com.nasa.roboticRovers.model.Plateau;
import com.nasa.roboticRovers.model.Position;
import com.nasa.roboticRovers.utility.EmptySpaceValidator;

/**
 * @author Efrem
 */

public class North implements Direction {

    @Override
    public Position triggerRobot(String in, Position position, Plateau plateau, EmptySpaceValidator emptySpaceValidator) throws IllegalNavigationAreaException {

        if (!in.toLowerCase().equals("l") && !in.toLowerCase().equals("r") && !in.toLowerCase().equals("m")) {
            throw new IllegalNavigationAreaException(ExceptionMessages.ILLEGAL_INPUT_PARAMETER.getMessage());
        }

        Integer x_coord = position.getX_coord();
        Integer y_coord = position.getY_coord();
        Direction direction = position.getCardinal_point();

        Position tempPosition = new Position(x_coord, y_coord, direction);

        if (in.equals("l")) {
            tempPosition.setCardinal_point(new West());
        }

        if (in.equals("r")) {
            tempPosition.setCardinal_point(new East());
        }

        if (in.equals("m")) {

            if (y_coord + 1 <= plateau.getY_size()) {

                tempPosition.setY_coord(y_coord + 1);

                this.checkForFreeSpaceAndAdd(position, tempPosition, emptySpaceValidator);

            } else {
                throw new IllegalNavigationAreaException(ExceptionMessages.ILLEGAL_NAVIGATION_INPUT_OUTOFBORDER.getMessage());
            }
        }

        return  tempPosition;
    }


}
