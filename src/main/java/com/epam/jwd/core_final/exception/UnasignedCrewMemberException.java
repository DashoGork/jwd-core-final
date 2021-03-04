package com.epam.jwd.core_final.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class UnasignedCrewMemberException extends RuntimeException implements Supplier<UnasignedCrewMemberException> {
    static Logger logger = LogManager.getLogger();

    public UnasignedCrewMemberException() {
        logger.error("This crew memeber cann't be assigned on this mission");
    }

    @Override
    public UnasignedCrewMemberException get() {
        return new UnasignedCrewMemberException();
    }
}
