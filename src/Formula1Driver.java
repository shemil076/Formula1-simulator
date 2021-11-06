public class Formula1Driver extends Driver{
    private int firstPositions;
    private int secondPositions;
    private int thirdPositions;
    private int achievedSeasons;
    private int currentPoints;
    private int numberOfRaces;

    public Formula1Driver(){}


    public Formula1Driver (String driverName, String driverLocation, String teamOfDriver,int driverStatics, int firstPositions, int secondPositions, int thirdPositions, int achievedSeasons, int currentPoints, int numberOfRaces){
        super(driverName, driverLocation, teamOfDriver,driverStatics);
        this.setFirstPositions(firstPositions);
        this.setSecondPositions(secondPositions);
        this.setThirdPositions(thirdPositions);
        this.setAchievedSeasons(achievedSeasons);
        this.currentPoints = currentPoints;
        this.setNumberOfRaces(numberOfRaces);
    }

    public int getFirstPositions() {
        return firstPositions;
    }

    public void setFirstPositions(int firstPositions) {
        this.firstPositions = firstPositions;
    }

    public int getSecondPositions() {
        return secondPositions;
    }

    public void setSecondPositions(int secondPositions) {
        this.secondPositions = secondPositions;
    }

    public int getThirdPositions() {
        return thirdPositions;
    }

    public void setThirdPositions(int thirdPositions) {
        this.thirdPositions = thirdPositions;
    }

    public int getAchievedSeasons() {
        return achievedSeasons;
    }

    public void setAchievedSeasons(int achievedSeasons) {
        this.achievedSeasons = achievedSeasons;
    }

    public int getNumberOfRaces() {
        return numberOfRaces;
    }

    public void setNumberOfRaces(int numberOfRaces) {
        this.numberOfRaces = numberOfRaces;
    }
}
