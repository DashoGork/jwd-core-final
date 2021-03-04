package com.epam.jwd.core_final.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidStateException extends Exception {
    // todo
    static Logger logger = LogManager.getLogger();
    public  InvalidStateException(){logger.warn("InvalidStateException");}

}
