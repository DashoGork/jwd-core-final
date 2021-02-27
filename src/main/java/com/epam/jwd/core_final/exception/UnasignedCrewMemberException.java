package com.epam.jwd.core_final.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnasignedCrewMemberException extends RuntimeException {
    static Logger logger = LogManager.getLogger();

    public UnasignedCrewMemberException() {
        System.out.println("This crew memeber cann't be assigned on this mission");
    }
}
