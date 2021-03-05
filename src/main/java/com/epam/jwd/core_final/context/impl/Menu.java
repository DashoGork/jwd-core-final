package com.epam.jwd.core_final.context.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.context.ApplicationMenu;
import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.criteria.SpaceshipCriteria;
import com.epam.jwd.core_final.domain.*;
import com.epam.jwd.core_final.exception.UnasignedCrewMemberException;
import com.epam.jwd.core_final.factory.impl.CrewMemberFactory;
import com.epam.jwd.core_final.service.impl.CrewServiceAction;
import com.epam.jwd.core_final.service.impl.SpacemapServiceAction;
import com.epam.jwd.core_final.service.impl.SpaceshipServiceAction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu implements ApplicationMenu {
    private Scanner scanner=new Scanner(System.in);
    private NassaContext nassaContext=NassaContext.getInt();
    private CrewServiceAction crewServiceAction=CrewServiceAction.getInt();


    @Override
    public ApplicationContext getApplicationContext() {
        return null;
    }

    @Override
    public int printAvailableOptions() {
        int choise=0;
        System.out.println("You can do several things:\n 1.See all Crew Members\n " +
                "2.See all ships\n" +
                " 3. See all planets\n " +
                "4. Make new mission\n " +
                "5.Delete crew member\n " +
                "6. Exit");
        while(choise==0){
            try {
                choise=scanner.nextInt();
            }catch (Exception e){
                System.out.println("Only numbers!");
            }
        }
        scanner.nextLine();
        return choise;
    }

    @Override
    public Object handleUserInput(int choise) {
        boolean exit=false;
        while (!exit){
            switch (choise){
                case 1:for(CrewMember cr:nassaContext.getCrewMembers())
                    System.out.println(cr.toString());
                break;

                case 2:for(Spaceship sp:nassaContext.getSpaceships())
                    System.out.println(sp.toString());
                break;

            case 3:for(Planet pl:nassaContext.getPlanetMap())
                System.out.println(pl.toString());
                break;

            case 4:
                System.out.println("From: ");
                String planetFrom=scanner.nextLine();
                boolean ex1=nassaContext.getPlanetMap().stream().anyMatch(
                        planet -> planet.getName().equals(planetFrom));
                System.out.println("To: ");
                String planetTo=scanner.nextLine();
                boolean ex2=nassaContext.getPlanetMap().stream().anyMatch(
                        planet -> planet.getName().equals(planetTo));
                if (ex1 & ex2){
                    Planet planetFromP=(nassaContext.getPlanetMap().stream().
                            filter( planet -> planet.getName().equals(planetFrom))
                            .findFirst()).orElse(null);//or else won't work in any case
                    Planet planetToP=(nassaContext.getPlanetMap().stream().
                            filter( planet -> planet.getName().equals(planetTo))
                            .findFirst()).orElse(null);//or else won't work in any case
                    SpacemapServiceAction spacemapServiceAction=SpacemapServiceAction.getInt();
                    SpaceshipServiceAction spaceshipServiceAction=SpaceshipServiceAction.getInt();
                    CrewServiceAction crewServiceAction=CrewServiceAction.getInt();
                    CrewMemberCriteria crewMemberCriteriaMS= CrewMemberCriteria.newCrewMemberCriteria()
                            .withIsReadyForNextMissions(true)
                            .withRole(Role.MISSION_SPECIALIST)
                            .build();
                    CrewMemberCriteria crewMemberCriteriaFE= CrewMemberCriteria.newCrewMemberCriteria()
                            .withIsReadyForNextMissions(true)
                            .withRole(Role.FLIGHT_ENGINEER)
                            .build();
                    CrewMemberCriteria crewMemberCriteriaP= CrewMemberCriteria.newCrewMemberCriteria()
                            .withIsReadyForNextMissions(true)
                            .withRole(Role.PILOT)
                            .build();
                    CrewMemberCriteria crewMemberCriteriaC= CrewMemberCriteria.newCrewMemberCriteria()
                            .withIsReadyForNextMissions(true)
                            .withRole(Role.COMMANDER)
                            .build();
                    SpaceshipCriteria spaceshipCriteria= SpaceshipCriteria.newSpaceshipCriteria()
                            .withFlightDistance(Math.round(spacemapServiceAction.getDistanceBetweenPlanets(planetFromP,planetToP)))
                            .withIsReadyForNextMissions(true).build();
                    Spaceship spaceship=spaceshipServiceAction
                            .findSpaceshipByCriteria(spaceshipCriteria)
                            .get();

                    short numberOfMissionSpecialists=spaceship.getCrew().get(Role.MISSION_SPECIALIST);
                    short numberFlightEngineers=spaceship.getCrew().get(Role.FLIGHT_ENGINEER);
                    short numberOfPilots=spaceship.getCrew().get(Role.PILOT);
                    short numberOfCommanders=spaceship.getCrew().get(Role.COMMANDER);

                    List<CrewMember> assignedCrewMember=new ArrayList<>();
                    for(int i=0;i<numberOfMissionSpecialists;i++){
                        assignedCrewMember.add(((crewServiceAction.findCrewMemberByCriteria(crewMemberCriteriaMS)))
                                .orElseThrow(new UnasignedCrewMemberException()));
                        crewServiceAction.assignCrewMemberOnMission(assignedCrewMember.get(i));
                    }
                    for(int i=numberOfMissionSpecialists;i<numberFlightEngineers+numberOfMissionSpecialists;i++){
                        assignedCrewMember.add(((crewServiceAction.findCrewMemberByCriteria(crewMemberCriteriaFE)))
                                .orElseThrow(new UnasignedCrewMemberException()));
                        crewServiceAction.assignCrewMemberOnMission(assignedCrewMember.get(i));
                    }
                    for(int i=numberFlightEngineers+numberOfMissionSpecialists;
                        i<numberOfPilots+numberOfMissionSpecialists+numberFlightEngineers;i++){
                        assignedCrewMember.add(((crewServiceAction.findCrewMemberByCriteria(crewMemberCriteriaP)))
                                .orElseThrow(new UnasignedCrewMemberException()));
                        crewServiceAction.assignCrewMemberOnMission(assignedCrewMember.get(i));
                    }
                    for(int i=numberOfPilots+numberOfMissionSpecialists+numberFlightEngineers;
                        i<numberOfPilots+numberOfMissionSpecialists+numberOfCommanders+numberFlightEngineers;i++){
                        assignedCrewMember.add(((crewServiceAction.findCrewMemberByCriteria(crewMemberCriteriaC)))
                                .orElseThrow(new UnasignedCrewMemberException()));
                        crewServiceAction.assignCrewMemberOnMission(assignedCrewMember.get(i));
                    }
                    LocalDate dateOfStart=LocalDate.now();
                    LocalDate dateOfEnd=dateOfStart.plusDays(Math.round(spacemapServiceAction.getDistanceBetweenPlanets(planetFromP,planetToP)));
                    String nameOfMission= dateOfStart.toString();
                    int missionResult=1+(int)(Math.random()*6);

                    FlightMission flightMission=new FlightMission(nameOfMission,dateOfStart,dateOfEnd,
                            Math.round(spacemapServiceAction.getDistanceBetweenPlanets(planetFromP,planetToP)),
                            spaceship,assignedCrewMember,MissionResult.IN_PROGRESS,
                            planetToP,planetFromP);
                    nassaContext.getFlightMissions().add(flightMission);
                    System.out.println(flightMission.toString());
                }
                else{
                    System.out.println("One of those planets doesn't exist");
                }
                break;

                case 5:
                    System.out.println("Enter name of CrewMemmer");
                    String name=scanner.nextLine();
                    List <CrewMember> crewMemberList =crewServiceAction.findAllCrewMembers();
                    CrewMemberFactory crewMemberFactory=new CrewMemberFactory();
                    CrewMember crewMemberToDelete;
                    for(CrewMember cr:crewMemberList){
                        if(cr.getName().equals(name)){
                            crewMemberToDelete=crewMemberFactory.create(cr);
                            System.out.println("This crewMember was deleted: "
                                    + crewServiceAction.deleteCrewMemeber(crewMemberToDelete));
                            break;
                        }
                    }
                    break;
                case 6:exit=true;
                default:choise=printAvailableOptions();

            }
            if(choise==6) exit=true;
            choise=printAvailableOptions();
            if(choise==6) exit=true;
        }

        return null;
    }
}
