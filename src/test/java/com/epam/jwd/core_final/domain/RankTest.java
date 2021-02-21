package com.epam.jwd.core_final.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class RankTest {

    //Rank rankTrainee=Rank.TRAINEE;
    //Rank rankFirstOfficer= Rank.FIRST_OFFICER;


    @Test
    public void getName() {
        Rank rankTrainee=Rank.TRAINEE;
        Rank rankFirstOfficer= Rank.FIRST_OFFICER;
        String expectedTrainee="TRAINEE";
        String expectedFirstOfficer="FIRST_OFFICER";
        assertEquals(expectedFirstOfficer,rankFirstOfficer.getName());
        assertEquals(expectedTrainee,rankTrainee.getName());
    }

    @Test
    public void resolveRankById() {
        Rank rankTrainee =Rank.resolveRankById(1);
        Rank rankFirstOfficer =Rank.resolveRankById(3);
        Rank expectedTrainee=Rank.TRAINEE;
        Rank expectedFirstOfficer=Rank.FIRST_OFFICER;
        assertEquals(expectedTrainee,rankTrainee);
        assertEquals(expectedFirstOfficer,rankFirstOfficer);

    }
}