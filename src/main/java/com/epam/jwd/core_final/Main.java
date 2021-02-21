package com.epam.jwd.core_final;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.factory.EntityFactory;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;
import com.epam.jwd.core_final.util.CrewMemberReaderUtil;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
         Collection<CrewMember> crewMembers = new ArrayList<>();

        EntityFactory factory = new CrewMemberFactory();
//        CrewMember d= (CrewMember) factory.create("1,Ann,2");
//        System.out.println(d.toString());

        for(String stringWithCrewMembers: CrewMemberReaderUtil.loadCrewMember()){
            crewMembers.add((CrewMember) factory.create(stringWithCrewMembers));
        }
        for(CrewMember cm: crewMembers){
            System.out.println(cm.toString());
        }
        //Application.start();
    }
}