package com.epam.jwd.core_final.missionOnJSON;

import com.epam.jwd.core_final.domain.FlightMission;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteInJSONFile {

    public static void WriteInJSONFile(FlightMission flightMission) {


        JSONObject json = new JSONObject();

        json.put("startDate", flightMission.getStartDate().toString());
        json.put("endDate", flightMission.getEndDate().toString());
        json.put("distance", flightMission.getDistance().toString());
        json.put("assignedSpaceShift", flightMission.getAssignedSpaceShift().toString());
        json.put("assignedCrew", flightMission.getAssignedCrew().toString());
        json.put("missionResult", flightMission.getMissionResult().toString());
        json.put("from", flightMission.getFrom().toString());
        json.put("to", flightMission.getTo().toString());

        try {
            Files.write(Paths.get("output.json"), json.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
