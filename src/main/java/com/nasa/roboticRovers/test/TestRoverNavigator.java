package com.nasa.roboticRovers.test;

import com.nasa.roboticRovers.exceptions.ExceptionMessages;
import com.nasa.roboticRovers.exceptions.IllegalInputParameterException;
import com.nasa.roboticRovers.exceptions.IllegalNavigationAreaException;
import com.nasa.roboticRovers.model.Plateau;
import com.nasa.roboticRovers.model.Position;
import com.nasa.roboticRovers.model.RoboticRover;
import com.nasa.roboticRovers.service.Navigator;
import com.nasa.roboticRovers.service.NavigatorImpl;
import com.nasa.roboticRovers.utility.direction.DirectionFactory;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Efrem
 */


@RunWith(JUnit4.class)
public class TestRoverNavigator extends TestCase {

    /*
     ** Test's robot motion for input;
     *  initial position: 1 2 N
         motion pattern: LMLMLMLMM
         expected output: 1 3 N
     */

    @Test
    public void testRoverNavigation_input1() throws IllegalInputParameterException, IllegalNavigationAreaException {

        /**** Initializing the plateau *******/

        Navigator navigator = new NavigatorImpl();

        Integer plateau_size_x = 5;
        Integer plateau_size_y = 5;

        navigator.initializePlateau(plateau_size_x, plateau_size_y);
        Plateau plateau = ((NavigatorImpl) navigator).getPlateau();

        /****** Initializing and Defining multiple Robotic Rovers situated in the plateau *******/

        navigator.initializeRovers(1, 2, "n", "1001");
        RoboticRover roboticRover = ((NavigatorImpl) navigator).getSquadOfRovers().get("1001");


        navigator.moveRobot("L", roboticRover, plateau);
        navigator.moveRobot("M", roboticRover, plateau);
        navigator.moveRobot("L", roboticRover, plateau);
        navigator.moveRobot("M", roboticRover, plateau);
        navigator.moveRobot("L", roboticRover, plateau);
        navigator.moveRobot("M", roboticRover, plateau);
        navigator.moveRobot("L", roboticRover, plateau);
        navigator.moveRobot("M", roboticRover, plateau);
        navigator.moveRobot("M", roboticRover, plateau);


        Position expected = new Position(1, 3, DirectionFactory.getDirection("n"));

        assertEquals(expected, roboticRover.getCurrentPosition());


    }

    /*
     ** Test's robot motion for input;
     *  initial position: 3 3 E
         motion pattern: MMRMMRMRRM
         expected output: 5 1 E
     */

    @Test
    public void testRoverNavigation_input2() throws IllegalInputParameterException, IllegalNavigationAreaException {

        /**** Initializing the plateau *******/

        Navigator navigator = new NavigatorImpl();

        Integer plateau_size_x = 5;
        Integer plateau_size_y = 5;

        navigator.initializePlateau(plateau_size_x, plateau_size_y);
        Plateau plateau = ((NavigatorImpl) navigator).getPlateau();


        /****** Initializing and Defining multiple Robotic Rovers situated in the plateau *******/

        navigator.initializeRovers(3, 3, "e", "1003");
        RoboticRover roboticRover3 = ((NavigatorImpl) navigator).getSquadOfRovers().get("1003");

        navigator.moveRobot("M", roboticRover3, plateau);
        navigator.moveRobot("M", roboticRover3, plateau);
        navigator.moveRobot("R", roboticRover3, plateau);
        navigator.moveRobot("M", roboticRover3, plateau);
        navigator.moveRobot("M", roboticRover3, plateau);
        navigator.moveRobot("R", roboticRover3, plateau);
        navigator.moveRobot("M", roboticRover3, plateau);
        navigator.moveRobot("R", roboticRover3, plateau);
        navigator.moveRobot("R", roboticRover3, plateau);
        navigator.moveRobot("M", roboticRover3, plateau);

        Position expected = new Position(5, 1, DirectionFactory.getDirection("e"));

        assertEquals(expected, roboticRover3.getCurrentPosition());


    }

    /*
     ** Test's robot motion to a location which is already occupied by another robot
     *  throws exception IllegalInputParameterException
     */

    @Test
    public void testRoverNavigation_spaceAlreadyOccupied() {

        /**** Initializing the plateau *******/

        Navigator navigator = new NavigatorImpl();

        Integer plateau_size_x = 5;
        Integer plateau_size_y = 5;

        navigator.initializePlateau(plateau_size_x, plateau_size_y);
        Plateau plateau = ((NavigatorImpl) navigator).getPlateau();

        /****** Initializing and Defining multiple Robotic Rovers situated in the plateau *******/

        navigator.initializeRovers(1, 2, "n", "1001");
        navigator.initializeRovers(0, 2, "n", "1002");
        RoboticRover roboticRover = ((NavigatorImpl) navigator).getSquadOfRovers().get("1001");
        RoboticRover roboticRover2 = ((NavigatorImpl) navigator).getSquadOfRovers().get("1002");


        try {
            navigator.moveRobot("L", roboticRover, plateau);
            navigator.moveRobot("M", roboticRover, plateau);


        } catch (Exception e) {

            assertEquals(ExceptionMessages.ILLEGAL_NAVIGATION_INPUT_ANOTHERROVEREXIST.getMessage(), e.getMessage());
        }


    }
}
