import java.util.Comparator;

public class Formula1Driver extends Driver implements Comparable<Formula1Driver>{
//    public static Comparator<? super Formula1Driver> PointsInAscending;
    private int firstPositions;
    private int secondPositions;
    private int thirdPositions;
    private int achievedSeasons;
    private int currentPoints;
    private int numberOfRaces;


    public Formula1Driver (String driverName, String driverLocation, String teamOfDriver, int firstPositions, int secondPositions, int thirdPositions, int achievedSeasons, int currentPoints, int numberOfRaces){
        super(driverName, driverLocation, teamOfDriver);
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

    /**
     * Override methode of compare according to the points of the driver else according to number of first positions
     * @param sortingTemp
     * @return
     */
    @Override
    public int compareTo(Formula1Driver sortingTemp){
        if (sortingTemp.getCurrentPoints() == this.currentPoints){              // check whether the the current points of the respective drivers are equal
            return sortingTemp.firstPositions - this.firstPositions;            // if so sort according to the number of first positions
        }else {
            return sortingTemp.getCurrentPoints() - this.currentPoints;         // if not sort according to current points
        }
    }


    /**
     * Override the compare method in order to sort in descending order according to the number of first positions
     */
    public static Comparator<Formula1Driver>FirstPositionsDescending = new Comparator<Formula1Driver>(){

        @Override
        public  int compare(Formula1Driver f1driver1, Formula1Driver f1driver2) {
            int achievedPositions1 = f1driver1.getFirstPositions();
            int achievedPositions2 = f1driver2.getFirstPositions();
            return achievedPositions2-achievedPositions1;                       // sort according to number of first positions
        }
    };


    /**
     * Override the compare method in order to sort in ascending order according to the points
     */
    public static Comparator<Formula1Driver> PointsInAscending = new Comparator<Formula1Driver>(){

        @Override
        public int compare(Formula1Driver f1driver1, Formula1Driver f1driver2) {
            int achievedPoints1 = f1driver1.getCurrentPoints();
            int achievedPoints2 = f1driver2.getCurrentPoints();
            return achievedPoints1-achievedPoints2;                             // sort according to number of points
        }
    };
}
