package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.domain.Planet;
import com.epam.jwd.core_final.service.SpacemapService;

public class SpacemapServiceAction implements SpacemapService {
    @Override
    public Planet getRandomPlanet() {//!
        return null;
    }

    @Override
    public int getDistanceBetweenPlanets(Planet first, Planet second) {
        return (int)(Math.sqrt((second.getI()-first.getI())*(second.getI()-first.getI())+(second.getJ()-first.getJ())*(second.getJ()-first.getJ())));
    }
}
