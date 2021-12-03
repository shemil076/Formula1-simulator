import java.io.Serializable;
import java.util.ArrayList;

public class RaceDetails implements Serializable {
    private  String raceDate;
    private ArrayList<String> driverNamesInRace = new ArrayList<String>();      // add names of the drivers who participated to a race
    private ArrayList<String> teamNamesInRace = new ArrayList<String>();        // add names of the team which participated to a race
    private ArrayList<Integer> teamPositions = new ArrayList<Integer>();        // add the positions of the respective positions


//    private ArrayList<Integer> startPositionInRace = new ArrayList<Integer>();


    public RaceDetails(String raceDate){
        this.raceDate = raceDate;
    }

    public void setDriverNameTeamNamePosition(String driverNameInRace,String teamNameInRace, int teamPosition ){
        driverNamesInRace.add(driverNameInRace);
        teamNamesInRace.add(teamNameInRace);
        teamPositions.add(teamPosition);
    }

    /**
     *
     * @return race date
     */
    public  String getRaceDate(){
        return raceDate;
    }

    /**
     *
     * @return the name of the team
     */
    public String getteamNameInRace(){
        String teamnames = null;
        for (String name : teamNamesInRace){
            teamnames = name;
        }
        return teamnames;
    }

    /**
     *
     * @return the name of the driver
     */
    public String getDriverNameInRace(){
        String names = null;
        for (String name : driverNamesInRace){
            names = name;
        }
        return names;
    }

    /**
     *
     * @return the position of the driver
     */
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

