package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.context.impl.NassaContext;
import com.epam.jwd.core_final.criteria.SpaceshipCriteria;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.epam.jwd.core_final.exception.UnasignedSpaceshipException;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipServiceActionTest {
    private NassaContext nassaContext=NassaContext.getInt();

    @Test
    public void findSpaceshipByCriteria() throws InvalidStateException {
        nassaContext.init();
        SpaceshipServiceAction spaceshipServiceAction=SpaceshipServiceAction.getInt();
        SpaceshipCriteria spaceshipCriteria= SpaceshipCriteria.newSpaceshipCriteria()
                .withFlightDistance(45L)
                .withIsReadyForNextMissions(true).build();
        Spaceship spaceship=spaceshipServiceAction
                .findSpaceshipByCriteria(spaceshipCriteria)
                .get();
        System.out.println(spaceship.toString());
        spaceshipServiceAction.assignSpaceshipOnMission(spaceship);
        System.out.println(spaceship.toString());

    }
}