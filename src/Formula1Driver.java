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
        this.firstPositions = firstPositions;
        this.secondPositions = secondPositions;
        this.thirdPositions = thirdPositions;
        this.achievedSeasons = achievedSeasons;
        this.currentPoints = currentPoints;
        this.numberOfRaces = numberOfRaces;
    }

}
