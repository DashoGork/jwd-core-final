package com.epam.jwd.core_final.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

public class ImpToCreateCrewMemberException extends RuntimeException{
    static Logger logger = LogManager.getLogger();
public ImpToCreateCrewMemberException(){logger.warn("ImpToCreateCrewMemberException()");}




}
