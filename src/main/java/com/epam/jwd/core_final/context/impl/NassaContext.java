package com.epam.jwd.core_final.context.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.domain.BaseEntity;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.epam.jwd.core_final.factory.EntityFactory;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;
import com.epam.jwd.core_final.factory.impl.SpaceshipFactory;
import com.epam.jwd.core_final.util.CrewMemberReaderUtil;
import com.epam.jwd.core_final.util.SpaceshipsReaderUtil;

import java.util.ArrayList;
import java.util.Collection;

// todo
public class NassaContext implements ApplicationContext {

    // no getters/setters for them
    private Collection<CrewMember> crewMembers = new ArrayList<>();
    private Collection<Spaceship> spaceships = new ArrayList<>();
    private static EntityFactory factory1;
    private static EntityFactory factory2;


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
    }

    public  Collection<CrewMember> getCrewMembers() {
        return crewMembers;
    }

    public Collection<Spaceship> getSpaceships() {
        return spaceships;
    }
}
