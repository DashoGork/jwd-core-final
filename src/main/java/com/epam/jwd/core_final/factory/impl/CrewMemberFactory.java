package com.epam.jwd.core_final.factory.impl;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Rank;
import com.epam.jwd.core_final.domain.Role;
import com.epam.jwd.core_final.factory.EntityFactory;

// do the same for other entities
public class CrewMemberFactory implements EntityFactory<CrewMember> {//Exceptions!!!

    @Override
    public CrewMember create(String... args) {
        for(String each:args){
            String info[]=each.split(",");
            CrewMember crewMember=new CrewMember(info[1], Role.resolveRoleById(Integer.valueOf(info[0])),
                    Rank.resolveRankById(Integer.valueOf(info[2])));
            return crewMember;
        }
        return null;
    }
}
