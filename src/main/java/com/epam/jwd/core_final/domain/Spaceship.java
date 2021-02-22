package com.epam.jwd.core_final.domain;

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
}
