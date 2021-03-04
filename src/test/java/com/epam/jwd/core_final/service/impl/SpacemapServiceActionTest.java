package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.context.impl.NassaContext;
import com.epam.jwd.core_final.domain.Planet;
import com.epam.jwd.core_final.exception.InvalidStateException;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpacemapServiceActionTest {

    @Test
    public void getRandomPlanet() {
        NassaContext nassaContext=NassaContext.getInt();
        try {
            nassaContext.init();
        } catch (InvalidStateException e) {
            e.printStackTrace();
        }
        SpacemapServiceAction spacemapServiceAction=SpacemapServiceAction.getInt();
        Planet planet= spacemapServiceAction.getRandomPlanet();
        System.out.println(planet.toString());

    }

    @Test
    public void getDistanceBetweenPlanets() {

    }
}