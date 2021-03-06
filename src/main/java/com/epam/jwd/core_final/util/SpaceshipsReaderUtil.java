package com.epam.jwd.core_final.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SpaceshipsReaderUtil {


    public static ArrayList<String> loadSpaceships(){
        ArrayList<String> subStringInformation=new ArrayList<>();
        try {
            File fileSpaceships=new File("C:\\spaceships");
            FileReader fileReader = new FileReader(fileSpaceships);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            bufferedReader.readLine();
            bufferedReader.readLine();
            String information=bufferedReader.readLine();
            while (information != null) {
                subStringInformation.add(information);
                information = bufferedReader.readLine();
            }
        }catch (
                IOException e){
            e.printStackTrace();
        }
        return subStringInformation;
    }

}
