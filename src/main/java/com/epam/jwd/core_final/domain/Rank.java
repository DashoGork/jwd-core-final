package com.epam.jwd.core_final.domain;

import com.epam.jwd.core_final.exception.UnknownEntityException;

public enum Rank implements BaseEntity {
    TRAINEE(1L),
    SECOND_OFFICER(2L),
    FIRST_OFFICER(3L),
    CAPTAIN(4L);

    private final Long id;

    Rank(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    /**
     * todo via java.lang.enum methods!
     */
    @Override
    public String getName() {
        return this.toString();
    }

    /**
     * todo via java.lang.enum methods!
     *
     * @throws UnknownEntityException if such id does not exist
     */
    public static Rank resolveRankById(int id) throws UnknownEntityException {
        UnknownEntityException e=new UnknownEntityException(Integer.toString(id));
        boolean exists=false;
        for(Rank rank:Rank.values()){
            if (id == rank.getId()) return rank;
        }
        if(!exists) {
            e.getMessage();
            throw e;
        }
        return null;
    }
}
