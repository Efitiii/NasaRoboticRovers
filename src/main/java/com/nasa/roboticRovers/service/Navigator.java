package com.nasa.roboticRovers.service;

import com.nasa.roboticRovers.exceptions.IllegalInputParameterException;
import com.nasa.roboticRovers.exceptions.IllegalNavigationAreaException;
import com.nasa.roboticRovers.model.Plateau;
import com.nasa.roboticRovers.model.RoboticRover;

/**
 * @author Efrem
 */


public interface Navigator {

    public void moveRobot(String action, RoboticRover roboticRover, Plateau plateau) throws IllegalInputParameterException,IllegalNavigationAreaException;

    public void initializePlateau(Integer x_coord_Size, Integer y_coord_Size);

    public void initializeRovers(Integer x_coord, Integer y_coord, String direction, String id);


}
