package com.epam.jwd.core_final.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoleTest {

    @Test
    public void getName() {
        Role rankCommander=Role.COMMANDER;
        Role rankPilot= Role.PILOT;
        String expectedCommander="COMMANDER";
        String expectedPilot="PILOT";
        assertEquals(expectedCommander,rankCommander.getName());
        assertEquals(expectedPilot,rankPilot.getName());
    }

    @Test
    public void resolveRoleById() {
        Role rankCommander=Role.resolveRoleById(4);
        Role rankPilot= Role.resolveRoleById(3);
        Role expectedCommander=Role.COMMANDER;
        Role expectedPilot=Role.PILOT;
        assertEquals(expectedCommander,rankCommander);
        assertEquals(expectedPilot,rankPilot);
    }
}