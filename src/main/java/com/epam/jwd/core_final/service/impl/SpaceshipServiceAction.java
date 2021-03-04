package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.context.impl.NassaContext;
import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.criteria.SpaceshipCriteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.exception.ImpToCreateCrewMemberException;
import com.epam.jwd.core_final.exception.ImpToCreateSpaceshipException;
import com.epam.jwd.core_final.exception.UnasignedCrewMemberException;
import com.epam.jwd.core_final.exception.UnasignedSpaceshipException;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;
import com.epam.jwd.core_final.factory.impl.SpaceshipFactory;
import com.epam.jwd.core_final.service.SpaceshipService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class SpaceshipServiceAction implements SpaceshipService {
    private NassaContext nassaContext = NassaContext.getInt();
    private SpaceshipFactory factory = new SpaceshipFactory();
    private static SpaceshipServiceAction spaceshipServiceAction;

    private SpaceshipServiceAction(){ }

    public static SpaceshipServiceAction getInt(){
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

        return (findAllSpaceships().stream().filter(spaceship -> spaceship.equalse(criteria)).findFirst());
    }

    @Override
    public Spaceship updateSpaceshipDetails(Spaceship spaceship) {
        List<Spaceship> spaceshipNew= nassaContext.getSpaceships().stream().filter(spaceship1 -> spaceship1.getName().equals(spaceship.getName())==true)
                .peek(spaceship1 -> spaceship1.setFlightDistance(spaceship.getFlightDistance())).collect(Collectors.toList());

        return spaceshipNew.get(0);
    }

    @Override
    public void assignSpaceshipOnMission(Spaceship crewMember) throws UnasignedSpaceshipException {
        boolean unasigned =nassaContext.getSpaceships().stream()
                .filter(spaceship -> spaceship.getName()
                        .equals(crewMember.getName())==true)
                .anyMatch(spaceship -> spaceship.isReadyForNextMissions().equals(false));
        try{
            if(unasigned) throw new UnasignedSpaceshipException();
            nassaContext.getSpaceships().stream().filter(spaceship -> spaceship.getName().equals(crewMember.getName())).forEach(spaceship -> spaceship.setReadyForNextMissions(false));
        }catch (UnasignedCrewMemberException e){

        }

    }

    @Override
    public Spaceship createSpaceship(Spaceship spaceship) throws ImpToCreateSpaceshipException {
        boolean alreadyEx=nassaContext.getSpaceships().stream().anyMatch(spaceship1 -> spaceship1.getName().equals(spaceship.getName()));
        Spaceship newSpaceship=null;
        try{
            if(alreadyEx) throw new ImpToCreateCrewMemberException();
            newSpaceship=factory.create(spaceship);
        }catch (ImpToCreateCrewMemberException e){
        }
        finally {
            return newSpaceship;
        }
    }
}
