public class Formula1Driver extends Driver implements Comparable<Formula1Driver>{
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
        if (sortingTemp.getCurrentPoints() == this.currentPoints){
            return sortingTemp.firstPositions - this.firstPositions;
        }else {
            return sortingTemp.getCurrentPoints() - this.currentPoints;
        }
    }


}
