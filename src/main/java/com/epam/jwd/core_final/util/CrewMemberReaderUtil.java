package com.epam.jwd.core_final.util;

import java.io.*;

public final class CrewMemberReaderUtil {
    private CrewMemberReaderUtil() {
    }

    public static String[] loadCrewMember(){
        String[] subStringInformation=null;
        try {
            File fileCrewMember=new File("C:\\_work\\crew");
            FileReader fileReader = new FileReader(fileCrewMember);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            String information=bufferedReader.readLine();
            subStringInformation=information.split(";");
        }catch (IOException e){
            e.printStackTrace();
        }
        return subStringInformation;
    }
}
