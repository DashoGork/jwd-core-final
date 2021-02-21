package com.epam.jwd.core_final.domain;

/**
 * This class should be IMMUTABLE!
 * <p>
 * Expected fields:
 * <p>
 * inputRootDir {@link String} - base dir for all input files
 * outputRootDir {@link String} - base dir for all output files
 * crewFileName {@link String}
 * missionsFileName {@link String}
 * spaceshipsFileName {@link String}
 * <p>
 * fileRefreshRate {@link Integer}
 * dateTimeFormat {@link String} - date/time format for {@link java.time.format.DateTimeFormatter} pattern
 */
public final class ApplicationProperties {
    //todo
    static private ApplicationProperties applicationProperties;
    private final String inputRootDir;
    private final String outputRootDir;
    private final String crewFileName;
    private final String missionsFileName;
    private final String spaceshipsFileName;
    private final Integer fileRefreshRate;
    private final String dateTimeFormat;

    private ApplicationProperties(String inputRootDir,String outputRootDir,
                                 String crewFileName,String missionsFileName,String spaceshipsFileName,
                                 String fileRefreshRate,String dateTimeFormat){
        this.inputRootDir=inputRootDir;
        this.outputRootDir=outputRootDir;
        this.crewFileName=crewFileName;
        this.missionsFileName=missionsFileName;
        this.spaceshipsFileName=spaceshipsFileName;
        this.fileRefreshRate=Integer.valueOf(fileRefreshRate);
        this.dateTimeFormat=dateTimeFormat;
    }

    public static ApplicationProperties getInstance(String inputRootDir,String outputRootDir,
                                                    String crewFileName,String missionsFileName,String spaceshipsFileName,
                                                    String fileRefreshRate,String dateTimeFormat) {
        if(applicationProperties==null){
           applicationProperties= new ApplicationProperties(inputRootDir,outputRootDir,
                    crewFileName,missionsFileName,spaceshipsFileName,
                    fileRefreshRate,dateTimeFormat);
        }
        return applicationProperties;
    }

    public static ApplicationProperties getInstance(){
        return applicationProperties;
    }
    public String getCrewFileName() {
        return crewFileName;
    }

    @Override
    public String toString() {
        return "ApplicationProperties{" +
                "inputRootDir='" + inputRootDir + '\'' +
                ", outputRootDir='" + outputRootDir + '\'' +
                ", crewFileName='" + crewFileName + '\'' +
                ", missionsFileName='" + missionsFileName + '\'' +
                ", spaceshipsFileName='" + spaceshipsFileName + '\'' +
                ", fileRefreshRate=" + fileRefreshRate +
                ", dateTimeFormat='" + dateTimeFormat + '\'' +
                '}';
    }

    public String getOutputRootDir() {
        return outputRootDir;
    }
}
