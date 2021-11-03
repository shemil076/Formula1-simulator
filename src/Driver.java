public abstract class Driver {
    private String driverName;
    private String driverLocation;
    private String teamOfDriver;
    private int driverStatics;


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

    public int getDriverStatics() {
        return driverStatics;
    }

    public void setDriverStatics(int driverStatics) {
        this.driverStatics = driverStatics;
    }
}

