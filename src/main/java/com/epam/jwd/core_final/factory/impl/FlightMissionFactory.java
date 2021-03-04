package com.epam.jwd.core_final.factory.impl;

import com.epam.jwd.core_final.criteria.FlightMissionCriteria;
import com.epam.jwd.core_final.domain.BaseEntity;
import com.epam.jwd.core_final.domain.FlightMission;
import com.epam.jwd.core_final.factory.EntityFactory;

public class FlightMissionFactory implements EntityFactory {
    public FlightMission create(FlightMission flightMission){
        FlightMission fl=new FlightMission(flightMission);
        return (fl);
    }

    @Override
    public FlightMission create(String... args) {
        return null;
    }


}
