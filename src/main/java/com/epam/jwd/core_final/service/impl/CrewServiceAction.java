package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.context.impl.NassaContext;
import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.exception.ImpToCreateCrewMemberException;
import com.epam.jwd.core_final.exception.UnasignedCrewMemberException;
import com.epam.jwd.core_final.factory.EntityFactory;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;
import com.epam.jwd.core_final.service.CrewService;
import com.epam.jwd.core_final.util.CrewMemberReaderUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class CrewServiceAction implements CrewService {
    private static CrewServiceAction crewServiceAction;
    private NassaContext nassaContext = NassaContext.getInt();
    private CrewMemberFactory factory = new CrewMemberFactory();


    private CrewServiceAction(){}

    public static CrewServiceAction getInt(){
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
    public List<CrewMember> findAllCrewMembersByCriteria(CrewMemberCriteria criteria) {
        List<CrewMember> crewMemberByCriteria=new ArrayList<>();
        List<CrewMember> crewMemberByCriteria1=findAllCrewMembers();
        crewMemberByCriteria=findAllCrewMembers().stream().filter(crewMember -> crewMember.equalse(criteria)==true).collect(Collectors.toList());
        return crewMemberByCriteria;
    }

    @Override
    public Optional<CrewMember> findCrewMemberByCriteria(CrewMemberCriteria criteria) {
        return findAllCrewMembers().stream().filter(crewMember -> crewMember.equalse(criteria)).findFirst();
    }

    @Override
    public CrewMember updateCrewMemberDetails(CrewMember crewMember) {//!
        Arrays.stream(nassaContext.getCrewMembers().stream().filter(crewMember1 -> crewMember1.getName().equals(crewMember.getName())==true)
                .peek(crewMember1 -> crewMember1.setRank(crewMember.getRank()))
                .peek(crewMember1 -> crewMember1.setRole(crewMember.getRole()))
        .peek(crewMember1->crewMember1.setReadyForNextMissions(crewMember.getReadyForNextMissions())).toArray());
        return ( null);
    }

    @Override
    public void assignCrewMemberOnMission(CrewMember crewMember) throws UnasignedCrewMemberException {//!//& в файл!!
        boolean unasigned =nassaContext.getCrewMembers().stream()
                .filter(crewMember1 -> crewMember1.getName()
                        .equals(crewMember.getName()))
                .anyMatch(crewMember1 -> crewMember1.getReadyForNextMissions().equals(false));
        try{
            if(unasigned) throw new UnasignedCrewMemberException();
            nassaContext.getCrewMembers().stream().filter(crewMember1 -> crewMember1.getName().equals(crewMember.getName())).forEach(crewMember1 -> crewMember1.setReadyForNextMissions(false));
        }catch (UnasignedCrewMemberException e){

        }
           }


    @Override
    public CrewMember createCrewMember(CrewMember spaceship) throws ImpToCreateCrewMemberException {//!!
       boolean alreadyEx=nassaContext.getCrewMembers().stream().anyMatch(crewMember -> crewMember.getName().equals(spaceship.getName()));
       CrewMember newCrewMember=null;
       try{
            if(alreadyEx) throw new ImpToCreateCrewMemberException();
            newCrewMember=factory.create(spaceship);
        }catch (ImpToCreateCrewMemberException e){
       }
        finally {
           return newCrewMember;
       }
    }

    public boolean deleteCrewMemeber(CrewMember crewMember){
        String linesFromFile[]= CrewMemberReaderUtil.loadCrewMember();
        String search =crewMember.getRole().getId().toString()+","+ crewMember.getName()+","+crewMember.getRank().getId().toString();

        String replace = "NULL";
        Charset charset = Charset.forName("cp1251");
        Path path= Paths.get("C:\\_work\\crew");

        try {
            Files.write(path,
                    Collections.singleton(new String(Files.readAllBytes(path), charset).replace(search, replace)));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
