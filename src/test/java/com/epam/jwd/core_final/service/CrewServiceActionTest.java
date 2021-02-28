package com.epam.jwd.core_final.service;

import static org.junit.Assert.*;

import com.epam.jwd.core_final.context.impl.NassaContext;
import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Rank;
import com.epam.jwd.core_final.domain.Role;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.epam.jwd.core_final.service.impl.CrewServiceAction;
import org.junit.Test;

import java.util.List;

public class CrewServiceActionTest {

    @Test
    public void findAllCrewMembers() {
    }

    @Test
    public void findAllCrewMembersByCriteria() {
    }

    @Test
    public void findCrewMemberByCriteria() {
        CrewMemberCriteria criteria= CrewMemberCriteria.newCrewMemberCriteria().withRank(Rank.SECOND_OFFICER).withRole(Role.COMMANDER).build();
        NassaContext nassaContext=NassaContext.getInt();
        try {
            nassaContext.init();
        } catch (InvalidStateException e) {
            e.printStackTrace();
        }
        nassaContext.getCrewMembers();
        CrewServiceAction cres=CrewServiceAction.getInt();
        List<CrewMember> crewMemberList=cres.findAllCrewMembersByCriteria(criteria);
        for(CrewMember cr: crewMemberList){
            System.out.println(cr.toString());
        }
    }

    @Test
    public void updateCrewMemberDetails() {
        NassaContext nassaContext=NassaContext.getInt();
        try {
            nassaContext.init();
        } catch (InvalidStateException e) {
            e.printStackTrace();
        }
        CrewMember crewMember=new CrewMember("Davey Bentley",Role.COMMANDER,Rank.SECOND_OFFICER);
        crewMember.setReadyForNextMissions(false);
        System.out.println(crewMember.toString());
        CrewServiceAction cres=CrewServiceAction.getInt();
        cres.updateCrewMemberDetails(crewMember);

    }

    @Test
    public void assignCrewMemberOnMission() {
    }

    @Test
    public void createCrewMember() {
    }
}