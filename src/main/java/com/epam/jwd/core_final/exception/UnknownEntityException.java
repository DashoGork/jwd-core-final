package com.epam.jwd.core_final.exception;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnknownEntityException extends RuntimeException {

    private final String entityName;
    private final Object[] args;
    static Logger logger = LogManager.getLogger();

    public UnknownEntityException(String entityName) {
        super();
        this.entityName = entityName;
        this.args = null;
    }

    public UnknownEntityException(String entityName, Object[] args) {
        super();
        this.entityName = entityName;
        this.args = args;
    }


    @Override
    public String getMessage() {//logging!
        // todo
        // you should use entityName, args (if necessary)
        logger.error("Unknown entity "+entityName+" "+args.toString());
        return null;
    }
}
