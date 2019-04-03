package com.nasa.roboticRovers.exceptions;

/**
 * @author Efrem
 */

public enum ExceptionMessages {

    /************** Illegal Navigation Exceptions ***************/

    ILLEGAL_NAVIGATION_INPUT_OUTOFBORDER ("The input navigation information is outside the target plateau area"
            +"\n"+"Please enter an appropriate navigation information."),

    ILLEGAL_NAVIGATION_INPUT_ANOTHERROVEREXIST ("Another rover exists in the input navigation provided."),



    /************** Illegal Input Parameter Exceptions ***************/

    ILLEGAL_INPUT_PARAMETER("The input parameter provided is wrong; it should either be:"+"\n"+
                                    "'L' for rotate left by 90 degrees, "+"\n"+
                                    "'R' for rotate right by 90 degrees or"+"\n"+
                                    " 'M' for move one step in the cardinal direction."),


    ILLEGAL_DIRECTION_PARAMETER("The direction parameter provided is wrong; it should either be:"+"\n"+
                                    "'N' for North, "+"\n"+
                                    "'S' for South "+"\n"+
                                    "'E' for East or "+"\n"+
                                    "'W' for West "),

    PLATEAU_PARAMETERS_NOT_PROVIDED ("Plateau not initialized with appropriate parameters.");


    private final String message;

    ExceptionMessages(String message){

        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}
