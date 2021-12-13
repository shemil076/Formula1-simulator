public interface ChampionshipManager {

    /**
     * Create a new driver
     * @param existingTeamsArray passing the teams already exist
     */
    void createANewDriver(String[] existingTeamsArray);

    /**
     * delete a driver(with the team) from the system
     */
    void deleteADriverAndTeam();

    /**
     * change the driver with another team
     */
    void changeTheDriver();

    /**
     * show the statics of the driver
     */
    void displayTheVariousStatics();

    /**
     * show the overall details of each and every team + driver
     */
    void displayFormula1DriverTable();

    /**
     * add races
     */
    void addARaceCompleted();

    /**
     * Exist the program
     */
    void exitTheProgram();
}
