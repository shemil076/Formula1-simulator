public class DriverRaceData {
    private String racerName;
    private String racerTeamName;
    private String raceDate;
    private int racerPosition;

    public DriverRaceData(String racerName, String racerTeamName,String raceDate,int racerPosition){
        this.setRacerName(racerName);
        this.setRacerTeamName(racerTeamName);
        this.setRaceDate(raceDate);
        this.setRacerPosition(racerPosition);
    }

    public String getRacerName() {
        return racerName;
    }

    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }

    public String getRacerTeamName() {
        return racerTeamName;
    }

    public void setRacerTeamName(String racerTeamName) {
        this.racerTeamName = racerTeamName;
    }

    public String getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(String raceDate) {
        this.raceDate = raceDate;
    }

    public int getRacerPosition() {
        return racerPosition;
    }

    public void setRacerPosition(int racerPosition) {
        this.racerPosition = racerPosition;
    }
}
