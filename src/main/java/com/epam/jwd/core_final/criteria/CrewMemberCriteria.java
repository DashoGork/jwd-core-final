package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Rank;
import com.epam.jwd.core_final.domain.Role;

/**
 * Should be a builder for {@link CrewMember} fields
 */
public class CrewMemberCriteria extends Criteria<CrewMember> {
    private Role role;
    private Rank rank;
    private Boolean isReadyForNextMissions;

    private CrewMemberCriteria(){}

    private CrewMemberCriteria(Role role,Rank rank,Boolean isReadyForNextMissions){
        this.role=role;
        this.rank=rank;
        this.isReadyForNextMissions=isReadyForNextMissions;
    }

    public static CrewMemberBuilderCriteria newCrewMemberCriteria(){
        return new CrewMemberCriteria().new CrewMemberBuilderCriteria();
    }

    public class CrewMemberBuilderCriteria{

        private CrewMemberBuilderCriteria(){
        }


        public CrewMemberBuilderCriteria withRole(Role role){
            CrewMemberCriteria.this.role=role;
            return this;
        }

        public CrewMemberBuilderCriteria withRank(Rank rank){
            CrewMemberCriteria.this.rank=rank;
            return this;
        }

        public CrewMemberBuilderCriteria withIsReadyForNextMissions(boolean isReadyForNextMissions){
            CrewMemberCriteria.this.isReadyForNextMissions=isReadyForNextMissions;
            return this;
        }

        public CrewMemberCriteria build(){
            return CrewMemberCriteria.this;
        }
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
}
