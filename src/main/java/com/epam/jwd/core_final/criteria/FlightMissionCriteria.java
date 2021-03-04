package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Should be a builder for {@link FlightMission} fields
 */
public class FlightMissionCriteria extends Criteria<FlightMission> {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long distance;
    private Spaceship assignedSpaceShift;
    private List<CrewMember> assignedCrew;
    private MissionResult missionResult;
    private Planet from;
    private Planet to;

    private FlightMissionCriteria(){}

    public static FlightMissionCriteria.FlightMissionBuilderCriteria newFlightMissionCriteria(){
        return new FlightMissionCriteria().new FlightMissionBuilderCriteria();
    }

    public class FlightMissionBuilderCriteria{
        private FlightMissionBuilderCriteria(){}

        public FlightMissionCriteria.FlightMissionBuilderCriteria withName(String name){
            FlightMissionCriteria.this.name=name;
            return this;
        }

        public FlightMissionCriteria.FlightMissionBuilderCriteria withStartDate(LocalDate start){
            FlightMissionCriteria.this.startDate=start;
            return this;
        }

        public FlightMissionCriteria.FlightMissionBuilderCriteria withEndDate(LocalDate end){
            FlightMissionCriteria.this.endDate=end;
            return this;
        }

        public FlightMissionCriteria.FlightMissionBuilderCriteria withDistance(Long dis){
            FlightMissionCriteria.this.distance=dis;
            return this;
        }

        public FlightMissionCriteria.FlightMissionBuilderCriteria withSpaceship(Spaceship spaceship){
            FlightMissionCriteria.this.assignedSpaceShift=spaceship;
            return this;
        }

        public FlightMissionCriteria.FlightMissionBuilderCriteria withCrewMembers(List<CrewMember> cw){
            FlightMissionCriteria.this.assignedCrew=cw;
            return this;
        }

        public FlightMissionCriteria.FlightMissionBuilderCriteria withMissionResult(MissionResult result){
            FlightMissionCriteria.this.missionResult=result;
            return this;
        }

        public FlightMissionCriteria.FlightMissionBuilderCriteria withStartPlanet(Planet planet){
            FlightMissionCriteria.this.from=planet;
            return this;
        }

        public FlightMissionCriteria.FlightMissionBuilderCriteria withEndPlanet(Planet planet){
            FlightMissionCriteria.this.to=planet;
            return this;
        }
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Long getDistance() {
        return distance;
    }

    public Spaceship getAssignedSpaceShift() {
        return assignedSpaceShift;
    }

    public List<CrewMember> getAssignedCrew() {
        return assignedCrew;
    }

    public MissionResult getMissionResult() {
        return missionResult;
    }

    public Planet getFrom() {
        return from;
    }

    public Planet getTo() {
        return to;
    }
}
