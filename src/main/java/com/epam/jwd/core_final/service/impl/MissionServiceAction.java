package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.context.impl.NassaContext;
import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.criteria.FlightMissionCriteria;
import com.epam.jwd.core_final.domain.FlightMission;
import com.epam.jwd.core_final.factory.EntityFactory;
import com.epam.jwd.core_final.factory.impl.FlightMissionFactory;
import com.epam.jwd.core_final.service.MissionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MissionServiceAction implements MissionService {
    private NassaContext nassaContext=NassaContext.getInt();
    private static MissionServiceAction missionServiceAction;
    private static FlightMissionFactory factory=new FlightMissionFactory();


    private MissionServiceAction(){}

    public static MissionServiceAction getInt(){
        if(missionServiceAction==null)
            missionServiceAction=new MissionServiceAction();
        return missionServiceAction;
    }

    @Override
    public List<FlightMission> findAllMissions() {
        return (List)nassaContext.getFlightMissions();
    }

    @Override
    public List<FlightMission> findAllMissionsByCriteria(FlightMissionCriteria criteria) {
        return findAllMissions().stream().
                filter(flightMission -> flightMission.equalse(criteria)).
                collect(Collectors.toList());
    }

    @Override
    public Optional<FlightMission> findMissionByCriteria(FlightMissionCriteria criteria) {
        return findAllMissions().stream().
                filter(flightMission -> flightMission.equalse(criteria)).
                findFirst();
    }

    @Override
    public FlightMission updateSpaceshipDetails(FlightMission flightMission) {
        //nassaContext.getSpaceships().
        // stream().filter(spaceship -> spaceship.getName().equals(flightMission.getName())).
        // for
        return null;
    }

    @Override
    public FlightMission createMission(FlightMission flightMission) {
        FlightMission fl=factory.create(flightMission);
        nassaContext.getFlightMissions().add((FlightMission) factory.create(flightMission));
        return fl;
    }


}
