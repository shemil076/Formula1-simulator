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

    /**
     * Get the name of the driver
     * @return name of the driver
     */
    public String getRacerName() {
        return racerName;
    }           // Name of the driver that participated to the race


    /**
     * Set the name of the driver
     * @param racerName name of the driver
     */
    public void setRacerName(String racerName) {
        this.racerName = racerName;
    }       // Name of the driver that participated to the race

    /**
     * get the team name of the driver
     * @return the team name of the driver
     */
    public String getRacerTeamName() {
        return racerTeamName;
    }           // Team name of the driver that participated to the race

    /**
     *Set the team name of the driver
     * @param racerTeamName team name
     */
    public void setRacerTeamName(String racerTeamName) {
        this.racerTeamName = racerTeamName;
    }          // Team name of the driver that participated to the race

    /**
     * get the date of the race
     * @return the date
     */
    public String getRaceDate() {
        return raceDate;
    }       // Date of race conduct

    /**
     * set the date
     * @param raceDate date of the race
     */
    public void setRaceDate(String raceDate) {
        this.raceDate = raceDate;
    }       // Date of race conduct

    /**
     * get the position of the driver
     * @return position of the driver
     */
    public int getRacerPosition() {
        return racerPosition;
    }           // position of the driver who participated to the race

    /**
     * set the position of the driver
     * @param racerPosition position of the driver
     */
    public void setRacerPosition(int racerPosition) {
        this.racerPosition = racerPosition;
    }           // position of the driver who participated to the race
}
