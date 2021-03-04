package com.epam.jwd.core_final.context;

// todo replace Object with your own types
@FunctionalInterface
public interface ApplicationMenu {

    ApplicationContext getApplicationContext();

    default int printAvailableOptions() {return -1;
    }

    default Object handleUserInput(int i) {
        return null;
    }
}
