package com.epam.jwd.core_final.refreshTimerTask;

import com.epam.jwd.core_final.context.impl.NassaContext;
import com.epam.jwd.core_final.exception.InvalidStateException;

import java.util.TimerTask;

public class RefreshTimerTask extends TimerTask {
    private NassaContext nassaContext=NassaContext.getInt();

    @Override
    public void run() {
        try {
            nassaContext.initCrewMembers();
            System.out.println("\nData have been updated\n");
        } catch (InvalidStateException e) {
            e.printStackTrace();
        }
    }
}
