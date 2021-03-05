package com.epam.jwd.core_final.factory.impl;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Rank;
import com.epam.jwd.core_final.domain.Role;
import com.epam.jwd.core_final.factory.EntityFactory;

// do the same for other entities
public class CrewMemberFactory implements EntityFactory<CrewMember> {//Exceptions!!!
    CrewMember deletedCrewMember=new CrewMember("NULL",Role.MISSION_SPECIALIST,Rank.TRAINEE);
    @Override
    public CrewMember create(String... args) {
        for(String each:args){
            if(!each.equals("NULL")){
                String info[]=each.split(",");
                CrewMember crewMember=new CrewMember(info[1], Role.resolveRoleById(Integer.valueOf(info[0])),
                        Rank.resolveRankById(Integer.valueOf(info[2])));
                return crewMember;
            }

        }
        return deletedCrewMember;
    }

    public CrewMember create(CrewMember crewMember){
        CrewMember nCrewmemeber=new CrewMember(crewMember);
        return (nCrewmemeber);
    }
}
