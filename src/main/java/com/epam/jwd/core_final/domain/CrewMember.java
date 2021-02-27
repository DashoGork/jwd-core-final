package com.epam.jwd.core_final.domain;

import com.epam.jwd.core_final.criteria.CrewMemberCriteria;

/**
 * Expected fields:
 * <p>
 * role {@link Role} - member role
 * rank {@link Rank} - member rank
 * isReadyForNextMissions {@link Boolean} - true by default. Set to false, after first failed mission
 */
public class CrewMember extends AbstractBaseEntity {
    // todo
    private Role role;
    private Rank rank;
    private Boolean isReadyForNextMissions=true;

    public CrewMember(String name, Role role, Rank rank) {
        super.setName(name);
        this.role = role;
        this.rank = rank;
    }

    public CrewMember(CrewMember crewMember){
        super.setName(crewMember.getName());
        this.role=crewMember.role;
        this.rank=crewMember.rank;
        this.isReadyForNextMissions=crewMember.isReadyForNextMissions;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Role getRole() {
        return role;
    }

    public Rank getRank() {
        return rank;
    }

    public Boolean getReadyForNextMissions() {
        return isReadyForNextMissions;
    }

    public Boolean equalse(CrewMemberCriteria crewMemberCriteria){
        int expected=0;
        int real=0;

        if(crewMemberCriteria.getRole()!=null){
            expected++;
            if(this.getRole().equals(crewMemberCriteria.getRole()))
            real++;
        }
        if(crewMemberCriteria.getRank()!=null){
            expected++;
            if(this.getRank().equals(crewMemberCriteria.getRank()))
            real++;
        }
        if(crewMemberCriteria.getReadyForNextMissions()!=null){
            expected++;
            if(this.getReadyForNextMissions().equals(crewMemberCriteria.getReadyForNextMissions()))
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
        return "CrewMember{" +
                "name="+this.getName()+
                ", role=" + role +
                ", rank=" + rank +
                ", isReadyForNextMissions=" + isReadyForNextMissions +
                '}';
    }

    public void setReadyForNextMissions(Boolean readyForNextMissions) {
        isReadyForNextMissions = readyForNextMissions;
    }
}
