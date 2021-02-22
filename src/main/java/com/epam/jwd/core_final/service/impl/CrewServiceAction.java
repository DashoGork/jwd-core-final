package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.context.impl.NassaContext;
import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.service.CrewService;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CrewServiceAction implements CrewService {
    private CrewServiceAction crewServiceAction;
    private NassaContext nassaContext = new NassaContext();

    private CrewServiceAction(){}

    public CrewServiceAction getInt(){
        if(crewServiceAction==null){
            crewServiceAction= new CrewServiceAction();
        }
        return crewServiceAction;
    }

    @Override
    public List<CrewMember> findAllCrewMembers() {
        return (List)nassaContext.getCrewMembers();
    }

    @Override
    public List<CrewMember> findAllCrewMembersByCriteria(Criteria<? extends CrewMember> criteria) {
        return null;
    }

    @Override
    public Optional<CrewMember> findCrewMemberByCriteria(Criteria<? extends CrewMember> criteria) {
        return Optional.empty();
    }

    @Override
    public CrewMember updateCrewMemberDetails(CrewMember crewMember) {
        return null;
    }

    @Override
    public void assignCrewMemberOnMission(CrewMember crewMember) throws RuntimeException {

    }

    @Override
    public CrewMember createCrewMember(CrewMember spaceship) throws RuntimeException {
        return null;
    }
}
