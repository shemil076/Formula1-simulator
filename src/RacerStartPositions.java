public class RacerStartPositions {
    private String driverName;
    private int driverStartingPosition;


    public  RacerStartPositions(){}

    public RacerStartPositions(String driverName, int driverStartingPosition){
        this.setDriverName(driverName);
        this.setDriverStartingPosition(driverStartingPosition);
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getDriverStartingPosition() {
        return driverStartingPosition;
    }

    public void setDriverStartingPosition(int driverStartingPosition) {
        this.driverStartingPosition = driverStartingPosition;
    }
}
