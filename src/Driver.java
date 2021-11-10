public abstract class Driver {
    private String driverName;
    private String driverLocation;
    private String teamOfDriver;


    public Driver(String driverName, String driverLocation, String teamOfDriver){
        this.driverName = driverName;
        this.driverLocation = driverLocation;
        this.teamOfDriver = teamOfDriver;
    }



    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

    public void setDriverLocation(String driverLocation) {
        this.driverLocation = driverLocation;
    }

    public String getTeamOfDriver() {
        return teamOfDriver;
    }

    public void setTeamOfDriver(String teamOfDriver) {
        this.teamOfDriver = teamOfDriver;
    }

}

