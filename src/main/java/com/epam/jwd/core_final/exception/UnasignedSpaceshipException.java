package com.epam.jwd.core_final.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class UnasignedSpaceshipException extends RuntimeException implements Supplier<UnasignedSpaceshipException> {
    static Logger logger = LogManager.getLogger();
    public UnasignedSpaceshipException(){
        logger.error("This spaceship cannot be assigned");
    }

    @Override
    public UnasignedSpaceshipException get() {
        return new UnasignedSpaceshipException();
    }
}
