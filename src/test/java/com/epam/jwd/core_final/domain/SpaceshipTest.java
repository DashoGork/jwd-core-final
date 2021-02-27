package com.epam.jwd.core_final.domain;

import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.criteria.SpaceshipCriteria;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.epam.jwd.core_final.domain.Role.MISSION_SPECIALIST;
import static org.junit.Assert.*;

public class SpaceshipTest {

    @Test
    public void equalse() {
        Map<Role,Short> map=new HashMap<>();
        map.put(MISSION_SPECIALIST, (short) 5);
        Map<Role,Short> map1=new HashMap<>();
        map1.put(MISSION_SPECIALIST, (short) 6);

        Spaceship spaceship=new Spaceship("A",(long)123456,map);
        SpaceshipCriteria sp1=SpaceshipCriteria.newSpaceshipCriteria().withFlightDistance((long)123456).withCrew(map1).build();
        SpaceshipCriteria sp2=SpaceshipCriteria.newSpaceshipCriteria().withFlightDistance((long)1236).withCrew(map1).build();
        boolean expected1=true;
        boolean expected2=false;
        boolean d=spaceship.equalse(sp2);

        assertEquals(expected2,spaceship.equalse(sp1));
    }
}