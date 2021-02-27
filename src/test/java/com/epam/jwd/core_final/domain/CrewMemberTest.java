package com.epam.jwd.core_final.domain;

import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrewMemberTest {

    @Test
    public void equalse() {
        CrewMember crewMember=new CrewMember("A",Role.COMMANDER,Rank.FIRST_OFFICER);
        CrewMemberCriteria cr1=CrewMemberCriteria.newCrewMemberCriteria().withRank(Rank.FIRST_OFFICER).withRole(Role.COMMANDER).build();
        CrewMemberCriteria cr2=CrewMemberCriteria.newCrewMemberCriteria().withRank(Rank.CAPTAIN).withRole(Role.COMMANDER).build();
        boolean expected1=true;
        boolean expected2=false;
        assertEquals(expected1,crewMember.equalse(cr1));
        assertEquals(expected2,crewMember.equalse(cr2));
    }
}