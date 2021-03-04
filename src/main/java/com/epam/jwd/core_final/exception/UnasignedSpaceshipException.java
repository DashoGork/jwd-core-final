package com.epam.jwd.core_final.exception;

import java.util.function.Supplier;

public class UnasignedSpaceshipException extends RuntimeException implements Supplier<UnasignedSpaceshipException> {
    public UnasignedSpaceshipException(){
        System.out.println("This spaceship cannot be assigned");
    }

    @Override
    public UnasignedSpaceshipException get() {
        return new UnasignedSpaceshipException();
    }
}
