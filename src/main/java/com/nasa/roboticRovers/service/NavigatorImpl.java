package com.nasa.roboticRovers.service;

import com.nasa.roboticRovers.exceptions.ExceptionMessages;
import com.nasa.roboticRovers.exceptions.IllegalInputParameterException;
import com.nasa.roboticRovers.exceptions.IllegalNavigationAreaException;
import com.nasa.roboticRovers.model.Plateau;
import com.nasa.roboticRovers.model.Position;
import com.nasa.roboticRovers.model.RoboticRover;
import com.nasa.roboticRovers.utility.EmptySpaceValidator;
import com.nasa.roboticRovers.utility.direction.Direction;
import com.nasa.roboticRovers.utility.direction.DirectionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Efrem
 */


public class NavigatorImpl implements Navigator {

    Plateau plateau;
    RoboticRover roboticRover;

    Map<String, RoboticRover> squadOfRovers;

    public NavigatorImpl() {
        squadOfRovers = new HashMap<>();
        plateau = null;
    }

    /*
     ** initializePlateau() initializes the boundaries of Plateau to be used for navigation
     */

    @Override
    public void initializePlateau(Integer x_coord_Size, Integer y_coord_Size) {
        this.plateau = new Plateau(x_coord_Size, y_coord_Size);

    }

    /*
     ** initializeRover() initializes the rovers position and adds the rover robot to the Map data-structure of squadRovers
     */

    @Override
    public void initializeRovers(Integer x_coord, Integer y_coord, String direction, String id) {

        try {
            Direction cardinal_direction = DirectionFactory.getDirection(direction);
            Position position = new Position(x_coord, y_coord, cardinal_direction);
            RoboticRover roboticRover = new RoboticRover(position, id);
            squadOfRovers.put(id, roboticRover);
            EmptySpaceValidator.addNewPosition(roboticRover.getCurrentPosition());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /*
     ** moveRobot() moves a robot based on the action provided
     *  ~ This function is also synchronized to assure each robot's motion to finish before another robot's motion is initiated
     */

    @Override
    public synchronized void  moveRobot(String action, RoboticRover roboticRover, Plateau plateau) throws IllegalInputParameterException, IllegalNavigationAreaException {

        if (plateau == null) {
            throw new IllegalInputParameterException(ExceptionMessages.PLATEAU_PARAMETERS_NOT_PROVIDED.getMessage());
        }


        Direction currentDirection = roboticRover.getCurrentPosition().getCardinal_point();
        Position currentPosition = roboticRover.getCurrentPosition();

        Position newPosition= currentDirection.triggerRobot(action.toLowerCase(), currentPosition, plateau);
        roboticRover.setCurrentPosition(newPosition);
    }

    public Map<String, RoboticRover> getSquadOfRovers() {
        return squadOfRovers;
    }

    public Plateau getPlateau() {
        return plateau;
    }
}
