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
    private Boolean isReadyForNextMissions=true;

    public CrewMemberCriteria(Role role) {
        this.role = role;
    }

    public CrewMemberCriteria(Rank rank) {
        this.rank = rank;
    }

    public CrewMemberCriteria(Boolean isReadyForNextMissions) {
        this.isReadyForNextMissions = isReadyForNextMissions;
    }
}
