import java.util.ArrayList;

public class RaceDetails {
    private String raceDate;
    private ArrayList<String> driverNamesInRace = new ArrayList<String>();
    private ArrayList<String> teamNamesInRace = new ArrayList<String>();
    private ArrayList<Integer> teamPositions = new ArrayList<Integer>();
//    private ArrayList<Integer> startPositionInRace = new ArrayList<Integer>();


    public RaceDetails(String raceDate){
        this.raceDate = raceDate;
    }

    public void setDriverNameTeamNamePosition(String driverNameInRace,String teamNameInRace, int teamPosition ){
        driverNamesInRace.add(driverNameInRace);
        teamNamesInRace.add(teamNameInRace);
        teamPositions.add(teamPosition);
    }
}

