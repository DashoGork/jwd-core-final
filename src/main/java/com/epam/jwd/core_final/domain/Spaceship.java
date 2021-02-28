package com.epam.jwd.core_final.domain;

import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.criteria.SpaceshipCriteria;

import java.util.HashMap;
import java.util.Map;

/**
 * crew {@link java.util.Map<Role, Short>}
 * flightDistance {@link Long} - total available flight distance
 * isReadyForNextMissions {@link Boolean} - true by default. Set to false, after first failed mission
 */
public class Spaceship extends AbstractBaseEntity {
    //todo

    private Map<Role,Short> crew;
    private Long flightDistance;
    private boolean isReadyForNextMissions=true;

    public Spaceship(String name,Long flightDistance,Map<Role, Short> crew ) {
        super.setName(name);
        this.crew = crew;
        this.flightDistance = flightDistance;
    }

    public Spaceship(Spaceship spaceship){
        super.setName(spaceship.getName());
        this.flightDistance=spaceship.flightDistance;
        this.crew=spaceship.crew;
        this.isReadyForNextMissions=spaceship.isReadyForNextMissions;
    }

    /**
     for strings like {int:int,int:int,int:int,int:int}
     * */
    public static Map<Role,Short> stringToMap(String string){
        Map<Role,Short> roleShortMap=new HashMap<>();
        string=string.substring(1,string.length()-1);
        String subString[]=string.split(",");
        for(String each:subString){
            String numbers[]=each.split(":");
            roleShortMap.put(Role.resolveRoleById(Integer.valueOf(numbers[0])),Short.valueOf(numbers[1]));
        }
        return roleShortMap;
    }

    public Boolean equalse(SpaceshipCriteria criteria){
        int expected=0;
        int real=0;
        if(criteria.getFlightDistance()!=null){
            expected++;
            if(this.getFlightDistance().equals(criteria.getFlightDistance()))
            real++;
        }
        if(criteria.getCrew()!=null){
            expected++;
            if(this.getCrew().equals(criteria.getCrew()))
                real++;
        }
        if(criteria.getReadyForNextMissions()!=null){
            expected++;
            if(this.isReadyForNextMissions().equals(criteria.getReadyForNextMissions()))
                real++;

        }
        return (expected==real);
    }

    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return "Spaceship{" +
                "crew=" + crew +
                ", flightDistance=" + flightDistance +
                ", isReadyForNextMissions=" + isReadyForNextMissions +
                '}';
    }


    public Map<Role, Short> getCrew() {
        return crew;
    }

    public Long getFlightDistance() {
        return flightDistance;
    }

    public Boolean isReadyForNextMissions() {
        return isReadyForNextMissions;
    }

    public void setCrew(Map<Role, Short> crew) {
        this.crew = crew;
    }

    public void setFlightDistance(Long flightDistance) {
        this.flightDistance = flightDistance;
    }

    public void setReadyForNextMissions(boolean readyForNextMissions) {
        isReadyForNextMissions = readyForNextMissions;
    }


}
