public class DriverRaceData {
    private String racerName;
    private String racerTeamName;
    private String raceDate;
    private int racerPosition;

    public DriverRaceData(String racerName, String racerTeamName,String raceDate,int racerPosition){   // this class used for get details of the races such as date and position.
        this.setRacerName(racerName);
        this.setRacerTeamName(racerTeamName);
        this.setRaceDate(raceDate);
        this.setRacerPosition(racerPosition);
    }

    public String getRacerName() {
        return racerName;
    }           // Name of the driver that participated to the race

    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }       // Name of the driver that participated to the race

    public String getRacerTeamName() {
        return racerTeamName;
    }           // Team name of the driver that participated to the race

    public void setRacerTeamName(String racerTeamName) {
        this.racerTeamName = racerTeamName;
    }          // Team name of the driver that participated to the race

    public String getRaceDate() {
        return raceDate;
    }       // Date of race conduct

    public void setRaceDate(String raceDate) {
        this.raceDate = raceDate;
    }       // Date of race conduct

    public int getRacerPosition() {
        return racerPosition;
    }           // position of the driver who participated to the race

    public void setRacerPosition(int racerPosition) {
        this.racerPosition = racerPosition;
    }           // position of the driver who participated to the race
}
