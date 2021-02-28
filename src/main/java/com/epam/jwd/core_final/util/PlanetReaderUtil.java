package com.epam.jwd.core_final.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public final  class PlanetReaderUtil {
    private PlanetReaderUtil(){}

    public static ArrayList<String> loadPlanet(){
        ArrayList<String> subStringInformation=new ArrayList<>();
        try {
            File fileSpacemap=new File("C:\\spacemap");
            FileReader fileReader = new FileReader(fileSpacemap);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            String information=bufferedReader.readLine();
            while (information != null) {
                subStringInformation.add(information);
                information = bufferedReader.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return subStringInformation;
    }

}
