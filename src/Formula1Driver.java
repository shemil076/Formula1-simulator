import java.util.Comparator;
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
        this.setCurrentPoints(currentPoints);
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


    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }


    public static Comparator<Formula1Driver> Formula1DriverPoints = new Comparator<Formula1Driver>() {
        public int compare(Formula1Driver driver1, Formula1Driver driver2){
            int pointsOfDriver1 = driver1.getCurrentPoints();
            int pointsOfDriver2 = driver2.getCurrentPoints();

            return pointsOfDriver2 - pointsOfDriver1;
        }
    };

    @Override
    public String toString(){


        return "[ Name of the driver : " +  super.getDriverName() + " Team Name: " + super.getTeamOfDriver() +  " Number of Points: " + currentPoints + " ] ";
    }
}
