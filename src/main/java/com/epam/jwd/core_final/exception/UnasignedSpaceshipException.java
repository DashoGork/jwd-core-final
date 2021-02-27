package com.epam.jwd.core_final.exception;

public class UnasignedSpaceshipException extends RuntimeException {
    public UnasignedSpaceshipException(){
        System.out.println("This spaceship cannot be assigned");
    }
}
