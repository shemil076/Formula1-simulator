import java.io.Serializable;

public abstract class Driver implements Serializable {          // abstract class of driver
    private String driverName;
    private String driverLocation;
    private String teamOfDriver;


    public Driver(String driverName, String driverLocation, String teamOfDriver){
        this.driverName = driverName;
        this.driverLocation = driverLocation;
        this.teamOfDriver = teamOfDriver;
    }


    /**
     * Get the name of the driver
     * @return driver name
     */
    public String getDriverName() {
        return driverName;
    }           // Name of the driver

    /**
     * Set the driver name
     * @param driverName name of the driver
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }       // Name of the driver

    /**
     * get the location of the driver
     * @return location of the driver
     */
    public String getDriverLocation() {
        return driverLocation;
    }       // Location or the country of the driver

    /**
     * set the location of the driver
     * @param driverLocation location of the driver
     */
    public void setDriverLocation(String driverLocation) {
        this.driverLocation = driverLocation;
    }      // Location or the country of the driver

    /**
     * get the team name of the driver
     * @return name of the driver
     */
    public String getTeamOfDriver() {
        return teamOfDriver;
    }       // Team name of the driver

}

