package com.epam.jwd.core_final.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ImpToCreateSpaceshipException extends RuntimeException{
    static Logger logger = LogManager.getLogger();
    public ImpToCreateSpaceshipException(){
        logger.warn("ImpToCreateSpaceshipException");
    }
}
