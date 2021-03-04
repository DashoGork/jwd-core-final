package com.epam.jwd.core_final.factory.impl;

import com.epam.jwd.core_final.domain.*;
import com.epam.jwd.core_final.factory.EntityFactory;

public class SpaceshipFactory implements EntityFactory {
    @Override
    public BaseEntity create(String... args) {
        for(String each:args){
            String info[]=each.split(";");
            Spaceship spaceship=new Spaceship(info[0], Long.valueOf(info[1]),
                    Spaceship.stringToMap(info[2]));
            return spaceship;
        }
        return null;
    }


    public Spaceship create(Spaceship spaceship){
        Spaceship newSpaceship=new Spaceship(spaceship);
        return (newSpaceship);
    }
}
