package com.epam.jwd.core_final.missionOnJSON;
import com.fasterxml.jackson.core.JsonParser;
import org.json.simple.parser.JSONParser;
import org.json.JSONObject;
import java.io.FileReader;

public class ReadFromJSONFile {

    public static void readJsonSimple() throws Exception {
        FileReader reader = new FileReader("output.json");
        JSONParser jsonParser = new JSONParser();
        System.out.println(jsonParser.parse(reader));
       reader.close();
    }
}
