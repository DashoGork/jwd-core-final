package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.Rank;
import com.epam.jwd.core_final.domain.Role;
import com.epam.jwd.core_final.domain.Spaceship;

import java.util.Map;

/**
 * Should be a builder for {@link Spaceship} fields
 */
public class SpaceshipCriteria extends Criteria<Spaceship> {
    private Map<Role,Short> crew;
    private Long flightDistance;
    private Boolean isReadyForNextMissions;

    private SpaceshipCriteria(){}

    public static SpaceshipCriteria.SpaceshipBuilderCriteria newSpaceshipCriteria(){
        return new SpaceshipCriteria().new SpaceshipBuilderCriteria();
    }

    public class SpaceshipBuilderCriteria{

        private SpaceshipBuilderCriteria(){
        }


        public SpaceshipCriteria.SpaceshipBuilderCriteria withFlightDistance(Long flightDistance){
            SpaceshipCriteria.this.flightDistance=flightDistance;
            return this;
        }

        public SpaceshipCriteria.SpaceshipBuilderCriteria withIsReadyForNextMissions(Boolean isReadyForNextMissions){
            SpaceshipCriteria.this.isReadyForNextMissions=isReadyForNextMissions;
            return this;
        }

        public SpaceshipCriteria.SpaceshipBuilderCriteria withCrew(Map<Role,Short> crew){
            SpaceshipCriteria.this.crew=crew;
            return this;
        }

        public SpaceshipCriteria build(){
            return SpaceshipCriteria.this;
        }
    }

    public Map<Role, Short> getCrew() {
        return crew;
    }

    public Long getFlightDistance() {
        return flightDistance;
    }

    public Boolean getReadyForNextMissions() {
        return isReadyForNextMissions;
    }
}
