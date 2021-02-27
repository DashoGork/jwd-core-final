package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.context.impl.NassaContext;
import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.criteria.SpaceshipCriteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;
import com.epam.jwd.core_final.factory.impl.SpaceshipFactory;
import com.epam.jwd.core_final.service.SpaceshipService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SpaceshipServiceAction implements SpaceshipService {
    private NassaContext nassaContext = new NassaContext();
    private SpaceshipFactory factory = new SpaceshipFactory();
    private SpaceshipServiceAction spaceshipServiceAction;

    private SpaceshipServiceAction(){
        spaceshipServiceAction=new SpaceshipServiceAction();
    }

    public SpaceshipServiceAction getInt(){
        if(spaceshipServiceAction==null)
            spaceshipServiceAction=new SpaceshipServiceAction();
        return spaceshipServiceAction;
    }

    @Override
    public List<Spaceship> findAllSpaceships() {
        return (List)nassaContext.getSpaceships();
    }

    @Override
    public List<Spaceship> findAllSpaceshipsByCriteria(SpaceshipCriteria criteria) {
        List<Spaceship> spaceships=new ArrayList<>();
        spaceships=findAllSpaceships().stream().filter(spaceship -> spaceship.equalse(criteria)).collect(Collectors.toList());
        return spaceships;
    }

    @Override
    public Optional<Spaceship> findSpaceshipByCriteria(SpaceshipCriteria criteria) {
        return findAllSpaceships().stream().filter(spaceship -> spaceship.equalse(criteria)).findFirst();
    }

    @Override
    public Spaceship updateSpaceshipDetails(Spaceship spaceship) {
        return null;
    }

    @Override
    public void assignSpaceshipOnMission(Spaceship crewMember) throws RuntimeException {

    }

    @Override
    public Spaceship createSpaceship(Spaceship spaceship) throws RuntimeException {
        return null;
    }
}
