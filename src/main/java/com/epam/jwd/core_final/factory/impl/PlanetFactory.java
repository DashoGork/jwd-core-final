package com.epam.jwd.core_final.factory.impl;

import com.epam.jwd.core_final.domain.BaseEntity;
import com.epam.jwd.core_final.domain.Planet;
import com.epam.jwd.core_final.factory.EntityFactory;

public class PlanetFactory implements EntityFactory {
    private int numberOfLine=1;
    private Planet nullPlanet=new Planet("NULL",-1,-1);
    @Override
    public Planet create(String... args) {
        int numberOfCol=1;
        for(String line:args){
            String[] subLine=line.split(",");
            for(String subsubLine:subLine)
            if(subsubLine.equals("null")) numberOfCol++;
            else{
                Planet planet=new Planet(subsubLine,numberOfLine+1,numberOfCol++);
                numberOfLine++;
                return planet;

            }
            numberOfLine++;
        }

        return nullPlanet;
    }
}
