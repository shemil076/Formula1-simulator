public class RaceTeamData {
    private String teamName;
    private String driverName;
    private int currentPoints;
    private int position;

    public RaceTeamData(String teamName,String driverName, int currentPoints,int position){
        this.setTeamName(teamName);
        this.setDriverName(driverName);
        this.setCurrentPoints(currentPoints);
        this.setPosition(position);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
