package com.epam.jwd.core_final.domain;

import com.epam.jwd.core_final.criteria.FlightMissionCriteria;

import java.time.LocalDate;
import java.util.List;

/**
 * Expected fields:
 * <p>
 * missions name {@link String}
 * start date {@link java.time.LocalDate}
 * end date {@link java.time.LocalDate}
 * distance {@link Long} - missions distance
 * assignedSpaceShift {@link Spaceship} - not defined by default
 * assignedCrew {@link java.util.List<CrewMember>} - list of missions members based on ship capacity - not defined by default
 * missionResult {@link MissionResult}
 * from {@link Planet}
 * to {@link Planet}
 */
public class FlightMission extends AbstractBaseEntity {
    // todo

    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long distance;
    private Spaceship assignedSpaceShift;
    private List<CrewMember> assignedCrew;
    private MissionResult missionResult;
    private Planet from;
    private Planet to;

    public FlightMission(String name, LocalDate startDate, LocalDate endDate, Long distance,
                         Spaceship assignedSpaceShift,
                         List<CrewMember> assignedCrew, MissionResult missionResult,
                         Planet from, Planet to) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.distance = distance;
        this.assignedSpaceShift = assignedSpaceShift;
        this.assignedCrew = assignedCrew;
        this.missionResult = missionResult;
        this.from = from;
        this.to = to;
    }

    public FlightMission(FlightMission fl) {
        this.name = fl.name;
        this.startDate = fl.startDate;
        this.endDate = fl.endDate;
        this.distance = fl.distance;
        this.assignedSpaceShift = fl.assignedSpaceShift;
        this.assignedCrew = fl.assignedCrew;
        this.missionResult = fl.missionResult;
        this.from = fl.from;
        this.to = fl.to;
    }


    public Boolean equalse(FlightMissionCriteria flightMissionCriteria){
        int expected=0;
        int real=0;

        if(flightMissionCriteria.getMissionResult()!=null){
            expected++;
            if(this.getMissionResult().equals(flightMissionCriteria.getMissionResult()))
                real++;
        }
        if(flightMissionCriteria.getTo()!=null){
            expected++;
            if(this.getTo().equals(flightMissionCriteria.getTo()))
                real++;
        }
        if(flightMissionCriteria.getFrom()!=null){
            expected++;
            if(this.getFrom().equals(flightMissionCriteria.getFrom()))
                real++;
        }
        if(flightMissionCriteria.getDistance()!=null){
            expected++;
            if(this.getDistance().equals(flightMissionCriteria.getDistance()))
                real++;
        }
        if(flightMissionCriteria.getAssignedCrew()!=null){
            expected++;
            if(this.getAssignedCrew().equals(flightMissionCriteria.getAssignedCrew()))
                real++;
        }
        if(flightMissionCriteria.getEndDate()!=null){
            expected++;
            if(this.getEndDate().equals(flightMissionCriteria.getEndDate()))
                real++;
        }
        if(flightMissionCriteria.getStartDate()!=null){
            expected++;
            if(this.getStartDate().equals(flightMissionCriteria.getStartDate()))
                real++;
        }
        if(flightMissionCriteria.getName()!=null){
            expected++;
            if(this.getName().equals(flightMissionCriteria.getName()))
                real++;
        }
        if(flightMissionCriteria.getAssignedSpaceShift()!=null){
            expected++;
            if(this.getAssignedSpaceShift().equals(flightMissionCriteria.getAssignedSpaceShift()))
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

    @Override
    public String toString() {
        return "FlightMission{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", distance=" + distance +
                ", assignedSpaceShift=" + assignedSpaceShift +
                ", assignedCrew=" + assignedCrew +
                ", missionResult=" + missionResult +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
