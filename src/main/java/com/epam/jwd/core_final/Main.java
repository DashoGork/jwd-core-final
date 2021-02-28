package com.epam.jwd.core_final;

import com.epam.jwd.core_final.context.impl.NassaContext;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.epam.jwd.core_final.factory.EntityFactory;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;
import com.epam.jwd.core_final.util.CrewMemberReaderUtil;
import com.epam.jwd.core_final.util.SpaceshipsReaderUtil;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args)  {
//        EntityFactory factory = new CrewMemberFactory();
//        ArrayList<CrewMember>crewMembers=new ArrayList<>();
//        for(String stringWithCrewMembers: CrewMemberReaderUtil.loadCrewMember()){
//            crewMembers.add((CrewMember) factory.create(stringWithCrewMembers));
//        }
//        for(CrewMember cr:crewMembers){
//            System.out.println(cr.toString());
//        }
        NassaContext nassaContext=NassaContext.getInt();
        try {
            nassaContext.init();
        } catch (InvalidStateException e) {
            e.printStackTrace();
        }
        //Application.start();
    }
}