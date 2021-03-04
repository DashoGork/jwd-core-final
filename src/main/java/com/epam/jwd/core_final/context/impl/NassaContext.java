package com.epam.jwd.core_final.context.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.domain.*;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.epam.jwd.core_final.factory.EntityFactory;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;
import com.epam.jwd.core_final.factory.impl.PlanetFactory;
import com.epam.jwd.core_final.factory.impl.SpaceshipFactory;
import com.epam.jwd.core_final.util.CrewMemberReaderUtil;
import com.epam.jwd.core_final.util.PlanetReaderUtil;
import com.epam.jwd.core_final.util.SpaceshipsReaderUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

// todo
public class NassaContext implements ApplicationContext {
    private static NassaContext nassaContext;
    private NassaContext(){}
    public static NassaContext getInt(){
        if(nassaContext==null)
            nassaContext=new NassaContext();
        return nassaContext;
    }

    // no getters/setters for them
    private Collection<CrewMember> crewMembers = new ArrayList<>();
    private Collection<Spaceship> spaceships = new ArrayList<>();
    private Collection<Planet> planetMap = new ArrayList<>();
    private Collection<FlightMission> flightMissions=new ArrayList<>();
    private static EntityFactory factory1;
    private static EntityFactory factory2;
    private static EntityFactory factory3;


    @Override
    public <T extends BaseEntity> Collection<T> retrieveBaseEntityList(Class<T> tClass) {
        return null;
    }

    /**
     * You have to read input files, populate collections
     * @throws InvalidStateException
     */
    @Override
    public void init() throws InvalidStateException {//Exptions!!

        factory1=new CrewMemberFactory();
        for(String stringWithCrewMembers: CrewMemberReaderUtil.loadCrewMember()){
            crewMembers.add((CrewMember) factory1.create(stringWithCrewMembers));
        }
        factory2= new SpaceshipFactory();
        for(String stringWithSpaceships: SpaceshipsReaderUtil.loadSpaceships()){
            spaceships.add((Spaceship) factory2.create(stringWithSpaceships));
        }
        factory3=new PlanetFactory();
        for(String stringWithPlanets: PlanetReaderUtil.loadPlanet()){
            planetMap.add((Planet) factory3.create(stringWithPlanets));
        }
        planetMap=planetMap.stream().filter(planet -> planet.getName().equals("NULL")==false).collect(Collectors.toList());

    }

    public  Collection<CrewMember> getCrewMembers() {
        return crewMembers;
    }

    public Collection<Spaceship> getSpaceships() {
        return spaceships;
    }

    public Collection<Planet> getPlanetMap(){return planetMap;}

    public Collection<FlightMission> getFlightMissions(){return flightMissions;}
}
