package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.context.impl.NassaContext;
import com.epam.jwd.core_final.domain.Planet;
import com.epam.jwd.core_final.service.SpacemapService;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SpacemapServiceAction implements SpacemapService {
    private static NassaContext nassaContext=NassaContext.getInt();
    private static SpacemapServiceAction spacemapServiceAction;

    private SpacemapServiceAction(){}

    public static SpacemapServiceAction getInt(){
        if(spacemapServiceAction==null)
            spacemapServiceAction=new SpacemapServiceAction();
        return spacemapServiceAction;
    }


    @Override
    public Planet getRandomPlanet() {//!
        int random=(int)(Math.random()*(nassaContext.getPlanetMap().size()-1));
        ArrayList<Planet> pl= (ArrayList<Planet>) nassaContext.getPlanetMap();
        return pl.get(random);
    }

    @Override
    public double getDistanceBetweenPlanets(Planet first, Planet second) {
        return (Math.sqrt((second.getI()-first.getI())*(second.getI()-first.getI())+(second.getJ()-first.getJ())*(second.getJ()-first.getJ())));
    }
}
