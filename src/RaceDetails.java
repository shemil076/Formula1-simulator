import java.io.Serializable;
import java.util.ArrayList;

public class RaceDetails implements Serializable {
    private  String raceDate;
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
    public  String getRaceDate(){
        return raceDate;
    }
    public String getteamNameInRace(){
        String teamnames = null;
        for (String name : teamNamesInRace){
            teamnames = name;
        }
        return teamnames;
    }
    public String getDriverNameInRace(){
        String names = null;
        for (String name : driverNamesInRace){
            names = name;
        }
        return names;
    }

    public int getPosition(){
        int positions = 0;
        for (int i : teamPositions){
            positions =  i;
        }
        return positions;
    }

    @Override
    public String toString() {
        return raceDate;
    }

    public ArrayList<String> getDriverNamesInRace() {
        return driverNamesInRace;
    }

    public ArrayList<String> getTeamNamesInRace() {
        return teamNamesInRace;
    }

    public ArrayList<Integer> getTeamPositions() {
        return teamPositions;
    }
}

