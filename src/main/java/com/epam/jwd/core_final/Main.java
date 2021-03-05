package com.epam.jwd.core_final;

import com.epam.jwd.core_final.context.Application;
import com.epam.jwd.core_final.context.impl.Menu;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.epam.jwd.core_final.refreshTimerTask.RefreshTimerTask;

import java.util.Timer;

public class Main {

    public static void main(String[] args)  {
        Timer timer=new Timer();
        RefreshTimerTask refreshTimerTask=new RefreshTimerTask();

        timer.schedule(refreshTimerTask,6000, 60000);

        try {
            Application.start();
        } catch (InvalidStateException e) {
            e.printStackTrace();
        }

        Menu menu = new Menu();
        int i=menu.printAvailableOptions();
        menu.handleUserInput(i);
    }
}