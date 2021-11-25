
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Formula1ChampionshipManager<HashTable> implements ChampionshipManager {
    public Scanner input = new Scanner(System.in);                                                                      // global static variable of Scanner class
    public Scanner delimiterInput = new Scanner(System.in).useDelimiter("\n");                                          // used delimiter to avoid spaces when getting inputs
    private static boolean run = true;
    private final String[] countryCodes = {"ARG", "AUS", "AUT", "BHR", "BEL", "BRA", "CAN", "CHL", "COL", "CZE", "DNK", "FIN", "FRA", "DEU", "HUN", "IND", "IRL", "ITA", "JPN", "LIE", "MYS", "MEX", "MCO", "MAR", "NLD", "NZL", "POL", "PRT", "RUS", "ZAF", "ESP", "SWE", "CHE", "THA", "GBR", "USA", "URY", "VEN", "ARE"}; // assign iso country codes to validate purpose
    public String[] existingTeamsArray = {"MERCEDES", "RED BULL", "MCLAREN", "FERRARI", "ALPINE", "ALFA TAURI", "ASTON MARTIN", "WILLIAMS", "ALFA ROMEO RACING", "HAAS F1 TEAM"};
    private static boolean checkCountryCode = false;
    private static boolean checkCustomOccupiedTeam = true, checkDriverName = true;
    private int firstPositions, secondPositions, thirdPositions, achievedSeasons, currentPoints, numberOfRaces;
    private static boolean checkTeamName = true;
    private String stringDate;


    Hashtable<String, String> countries = new Hashtable<String, String>(); // use a hash table to store countries and iso codes
    public static ArrayList<Formula1Driver> formulaDriverTeams = new ArrayList<Formula1Driver>(); // store formula driver teams
    public static ArrayList<RaceDetails> raceDetailsList = new ArrayList<RaceDetails>();
    ArrayList<String> dateArray = new ArrayList<String>(); // store date of races
    ArrayList<Integer> positionsArrayList = new ArrayList<Integer>(); // store positions (validation purpose)


    public static void main(String[] args) {
        Formula1ChampionshipManager championManager = new Formula1ChampionshipManager();

        championManager.welcome();
        championManager.logo();
        championManager.loadTeamDetails();
        while (run) {
            championManager.printMenu();
            championManager.mainMenu();
        }
        championManager.saveInformationInAFile();

    }

    /**
     * Print the main menu into the console
     */
    public void printMenu() {

        System.out.println("|                              MAIN MENU                                 |");
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("|           INPUT CODE         |              OPTION                     |");
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("|           100 or CND         |       Create a New Driver               |");
        System.out.println("|           101 or DDT         |       Delete a Driver and Team          |");
        System.out.println("|           102 or CTD         |       Change the Driver                 |");
        System.out.println("|           103 or DVS         |       Display the Various Statics       |");
        System.out.println("|           104 or DFT         |       Display Formula1 Driver Table     |");
        System.out.println("|           105 or ARC         |       Add a Race Completed              |");
        System.out.println("|           106 or GUI         |       Open GUI                          |");
        System.out.println("|           999 or EXT         |       Exit the program                  |");
        System.out.println("+------------------------------------------------------------------------+");

        System.out.println("Enter the respective code for your requirement: ");


    }

    /**
     * Proceed the options according to the users response
     */
    public void mainMenu() {
        if (delimiterInput.hasNext()) {
            String option = delimiterInput.next(); // ignore spaces of the string input
            switch (option.toUpperCase()) {
                case "100", "CND" -> {
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                          Create a New Driver                           |");
                    System.out.println("+------------------------------------------------------------------------+");
                    createANewDriver(existingTeamsArray); // create a new driver
                }
                case "101", "DDT" -> {
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                         Delete a Driver and Team                       |");
                    System.out.println("+------------------------------------------------------------------------+");
                    deleteADriverAndTeam(); //Delete team
                }
                case "102", "CTD" -> {
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                           Change the Driver                            |");
                    System.out.println("|        ^_^ WARNING the team will be deleted from the system            |");
                    System.out.println("|         while changing the driver to an existing team ^_^              |");
                    System.out.println("+------------------------------------------------------------------------+");
                    changeTheDriver(); // change the driver from a team to another
                }
                case "103", "DVS" -> {
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                       Display the Various Statics                      |");
                    System.out.println("+------------------------------------------------------------------------+");
                    displayTheVariousStatics(); // display the statics of driver in each team
                }
                case "104", "DFT" -> {
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                      Display Formula1 Driver Table                     |");
                    System.out.println("+------------------------------------------------------------------------+");
                    displayFormula1DriverTable(); // display the driver table
                }
                case "105", "ARC" -> {
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                             Add a Race Completed                       |");
                    System.out.println("+------------------------------------------------------------------------+");
                    addARaceCompleted(); // add a race completed
                }
                case "106", "GUI"->{
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                               Open GUI                                 |");
                    System.out.println("+------------------------------------------------------------------------+\n");
                    System.out.println("GUI has opened up, and return to the main menu... \n");
                    new GUISimulator();
                }
                case "999", "EXT" -> {
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                             Exit the program                           |");
                    System.out.println("+------------------------------------------------------------------------+");
                    exitTheProgram();  // Exit the program
                }

                case "200"->{

                    printRaceDetails();
                }

                default -> System.out.println("⚠️Invalid option selected, 'Input out of range'\n");
            }
        } else {
            System.out.println("⚠️Invalid out-put\n");
        }
    }


    /**
     * Create a new driver according to the details of the user.
     *
     * @param existingTeamsArray an array that use to check the teams
     */
    public void createANewDriver(String[] existingTeamsArray) {
        while (true) {
            System.out.println("Enter the full name of the driver or \nenter 999 to return back");
            if (delimiterInput.hasNext()) {
                String name = delimiterInput.next().toUpperCase();  // ignore spaces of the string input

                driverNameCheck(name);

                if (checkDriverName) {     // check whether the driver name is valid

                    if (name.equalsIgnoreCase("999")) { // sentinel value
                        break;
                    } else {
                        System.out.println("Enter the name of your team: ");
                        String teamName = delimiterInput.next().toUpperCase();

                        teamNameCheck(teamName);  // check whether the team is valid


                        if (checkTeamName) {
                            System.out.println("\nEnter the country code you prefer from the following or \nenter 9 to add a custom country");
                            System.out.println("");
                            printCountryTable();     // print the table of countries
                            System.out.println(" ");

                            while (true) {
                                System.out.println("Enter the code or enter 9 to add a custom country : "); // 9 to add a custom country
                                String country = input.next().toUpperCase();

                                if (country.equalsIgnoreCase("9")) { // sentinel value
                                    System.out.println("Enter the country of the driver : ");
                                    String customCountry = delimiterInput.next().toUpperCase(); // ignore spaces from user input

                                    getStatistics();  // get inputs from user about statistics

                                    formulaDriverTeams.add(new Formula1Driver(name, customCountry, teamName, firstPositions, secondPositions, thirdPositions, achievedSeasons, currentPoints, numberOfRaces));

                                    System.out.println("Requirement is successfully completed");
                                    System.out.println(name + " was added to the team " + teamName);
                                    System.out.println(" ");
                                    break;


                                } else {
                                    findCountryCode(country);
                                    if (checkCountryCode) {   //check whether the country code is valid
                                        getStatistics();
                                        formulaDriverTeams.add(new Formula1Driver(name, countries.get(country), teamName, firstPositions, secondPositions, thirdPositions, achievedSeasons, currentPoints, numberOfRaces));

                                        System.out.println("Requirement is successfully completed");
                                        System.out.println(name + " was added to the team " + teamName);
                                        System.out.println(" ");
                                        break;


                                    } else {
                                        System.out.println("⚠️Invalid country code! :(\n");
                                    }
                                }
                            }
                            checkCountryCode = false; // set to the default value

                        } else {
                            System.out.println("⚠️Team name was already exist\n");
                        }
                    }
                } else {
                    System.out.println("⚠️Driver name was already exist\n");
                    System.out.println(" ");
                }
                checkDriverName = true; // set to the default value

            } else {
                System.out.println("⚠️Invalid data input\n");
            }
        }

    }


    /**
     * Check whether the iso country code is in the system.
     * @param countryCode ISO country code that use to identify the country.
     */
    private void findCountryCode(String countryCode) {
        for (int i = 0; i < countryCodes.length; i++) {
            if (countryCodes[i].equals(countryCode)) {
                checkCountryCode = true;
            }
        }
    }

    /**
     * check whether the team was used before.
     * @param teamName string input of the team name.
     */
    public void teamNameCheck(String teamName) {
        for (Formula1Driver f1driver : formulaDriverTeams) {
            if (f1driver.getTeamOfDriver().equals(teamName)) {
                checkTeamName = false;
            } else {
                checkTeamName = true;
            }
        }
    }

    /**
     * check whether the driver name is used before
     *
     * @param driverName string input of the driver name
     */
    public void driverNameCheck(String driverName) {
        for (int i = 0; i < formulaDriverTeams.size(); i++) {
            if (formulaDriverTeams.get(i).getDriverName().contains(driverName)) {
                checkDriverName = false;
            }
        }
    }


    /**
     * Exit the program.
     */
    public  void exitTheProgram() {
        thankYou();
        System.out.println(" ");
        logo();
        run = false;

    }

    /**
     * welcome of the program (used an ASCII art)
     */
    public void welcome() {
        System.out.println("     ██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗");
        System.out.println("     ██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝");
        System.out.println("     ██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗  ");
        System.out.println("     ██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝  ");
        System.out.println("     ╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗");
        System.out.println("      ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝");
        System.out.println("");

    }

    /**
     * Thank you of the program (used an ASCII art)
     */
    public void thankYou() {
        System.out.println("████████╗██╗  ██╗ █████╗ ███╗   ██╗██╗  ██╗    ██╗   ██╗ ██████╗ ██╗   ██╗");
        System.out.println("╚══██╔══╝██║  ██║██╔══██╗████╗  ██║██║ ██╔╝    ╚██╗ ██╔╝██╔═══██╗██║   ██║");
        System.out.println("   ██║   ███████║███████║██╔██╗ ██║█████╔╝      ╚████╔╝ ██║   ██║██║   ██║");
        System.out.println("   ██║   ██╔══██║██╔══██║██║╚██╗██║██╔═██╗       ╚██╔╝  ██║   ██║██║   ██║");
        System.out.println("   ██║   ██║  ██║██║  ██║██║ ╚████║██║  ██╗       ██║   ╚██████╔╝╚██████╔╝");
        System.out.println("   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝       ╚═╝    ╚═════╝  ╚═════╝ ");
    }

    /**
     * Logo of the program (used an ASCII art)
     */
    public void logo() {
        System.out.println("  _    _             /'_'_/.-''/                             _______");
        System.out.println("  \\`../ |o_..__     / /__   / /  -= WORLD CHAMPIONSHIP =-   _\\=.o.=/_");
        System.out.println("`.,(_)______(_).>  / ___/  / /                             |_|_____|_|");
        System.out.println("~~~~~~~~~~~~~~~~~~/_/~~~~~/_/~~~~~~~~~~~simulator~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("");
    }

    /**
     * Print the table of country and the respective iso country code.
     */
    public void printCountryTable() {
        countries.put("ARG", "Argentina");
        countries.put("AUS", "Australia");
        countries.put("AUT", "Austria");
        countries.put("BHR", "Bahrain");
        countries.put("BEL", "Belgium");
        countries.put("BRA", "Brazil");
        countries.put("CAN", "Canada");
        countries.put("CHL", "Chile");
        countries.put("COL", "Colombia");
        countries.put("CZE", "CzechRepublic");
        countries.put("DNK", "Denmark");
        countries.put("FIN", "Finland");
        countries.put("FRA", "France");
        countries.put("DEU", "Germany");
        countries.put("HUN", "Hungary");
        countries.put("IND", "India");
        countries.put("IRL", "Ireland");
        countries.put("ITA", "Italy");
        countries.put("JPN", "Japan");
        countries.put("LIE", "Liechtenstein");
        countries.put("MYS", "Malaysia");
        countries.put("MEX", "Mexico");
        countries.put("MCO", "Monaco");
        countries.put("MAR", "Morocco");
        countries.put("NLD", "Netherlands");
        countries.put("NZL", "New Zealand");
        countries.put("POL", "Poland");
        countries.put("PRT", "Portugal");
        countries.put("RUS", "Russia");
        countries.put("ZAF", "South Africa");
        countries.put("ESP", "Spain");
        countries.put("SWE", "Sweden");
        countries.put("CHE", "Switzerland");
        countries.put("THA", "Thailand");
        countries.put("GBR", "UnitedKingdom");
        countries.put("USA", "United States");
        countries.put("URY", "Uruguay");
        countries.put("VEN", "Venezuela");
        countries.put("ARE", "United Arab Emirates");

        System.out.println("+------------------------------------------------------------------------------------+");
        System.out.println("| Code -  Country   | Code -  Country    | Code -  Country     | Code - country      |");
        System.out.println("+-------------------+--------------------+---------------------+---------------------+");
        System.out.println("| ARG - Argentina   | AUS -Australia     | AUT - Austria       | BHR - Bahrain       |");
        System.out.println("| BEL - Belgium     | BRA - Brazil       | CAN - Canada        | CHL - Chile         |");
        System.out.println("| COL - Colombia    | CZE - CzechRepublic| DNK - Denmark       | FIN - Finland       |");
        System.out.println("| FRA - France      | DEU - Germany      | HUN - Hungary       | IND - India         |");
        System.out.println("| IRL - Ireland     | ITA - Italy        | JPN - Japan         | LIE - Liechtenstein |");
        System.out.println("| MYS - Malaysia    | MEX - Mexico       | MCO - Monaco        | MAR - Morocco       |");
        System.out.println("| NLD - Netherlands | NZL - New Zealand  | POL - Poland        | PRT - Portugal      |");
        System.out.println("| RUS - Russia      | ZAF - South Africa | ESP - Spain         | SWE - Sweden        |");
        System.out.println("| CHE - Switzerland | THA - Thailand     | GBR - UnitedKingdom | USA - United States |");
        System.out.println("| URY - Uruguay     | VEN - Venezuela    | ARE - United Arab Emirates                |");
        System.out.println("+------------------------------------------------------------------------------------+");
    }

    /**
     * get the inputs such as firstPositions,secondPositions, thirdPositions, numberOfRaces, etc.
     */
    public void getStatistics() {
        while (true) {
            System.out.println("Enter the number of first positions the driver achieved: ");
            if (input.hasNextInt()) { // data type validation
                firstPositions = input.nextInt();
                if (firstPositions >= 0) { // ignore minus values
                    break;
                } else {
                    System.out.println("⚠️Please input a valid number");
                }
            } else {
                System.out.println("⚠️Invalid data input");
                System.out.println("");
                input.next();
            }
        }

        while (true) {
            System.out.println("Enter the number of second positions the driver achieved: ");
            if (input.hasNextInt()) { // data type validation
                secondPositions = input.nextInt();
                if (secondPositions >= 0) { // ignore minus values
                    break;
                } else {
                    System.out.println("⚠️Please input a valid number\n");
                }
            } else {
                System.out.println("⚠️Invalid data input\n");
                System.out.println(" ");
                input.next();
            }
        }
        while (true) {
            System.out.println("Enter the number of third positions the driver achieved:");
            if (input.hasNextInt()) { // data type validation
                thirdPositions = input.nextInt();
                if (thirdPositions >= 0) { // ignore minus values
                    break;
                } else {
                    System.out.println("⚠️Please input a valid number\n");
                }
            } else {
                System.out.println("⚠️Invalid data input\n");
                System.out.println(" ");
                input.next();
            }
        }
        while (true) {
            System.out.println("Enter the number of seasons achieved: ");
            if (input.hasNextInt()) { // data type validation
                achievedSeasons = input.nextInt();
                if (achievedSeasons >= 0) { // ignore minus values
                    break;
                } else {
                    System.out.println("⚠️Please input a valid number\n");
                }
            } else {
                System.out.println("⚠️Invalid data input\n");
                System.out.println(" ");
                input.next();
            }
        }
        while (true) {
            System.out.println("Enter the number of participated races: ");
            if (input.hasNextInt()) { // data type validation
                numberOfRaces = input.nextInt();
                if (numberOfRaces >= 0) { // ignore minus values
                    break;
                } else {
                    System.out.println("⚠️Please input a valid number\n");
                }
            } else {
                System.out.println("⚠️Invalid data input\n");
                System.out.println(" ");
                input.next();
            }
        }
        while (true) {
            System.out.println("Enter the number of points the driver owned: ");
            if (input.hasNextInt()) { // data type validation
                currentPoints = input.nextInt();
                if (currentPoints >= 0) { // ignore minus values
                    break;
                } else {
                    System.out.println("⚠️Please input a valid number\n");
                }
            } else {
                System.out.println("⚠️Invalid data input\n");
                System.out.println(" ");
                input.next();
            }
        }

    }


    /**
     * print the used team names and print none if there are no teams in the system
     */
    public void checkCustomOccupiedTeams() {
        if (formulaDriverTeams.size() > 0) { // check whether the team list is empty or not
            for (int i = 0; i < formulaDriverTeams.size(); i++) {
                System.out.println(i + " - " + formulaDriverTeams.get(i).getTeamOfDriver() + " \n\tDriver : " + formulaDriverTeams.get(i).getDriverName() + "\n"); // print the team name and the driver name of the team
                checkCustomOccupiedTeam = true;
            }
        } else {
            System.out.println("None"); // if there is no any team, print "none"
            System.out.println(" ");
            checkCustomOccupiedTeam = false;
        }
    }

    /**
     * print the statistics of the team and the driver with a horizontal histogram.
     */
    public void displayTheVariousStatics() {
        System.out.println("Teams available in the system:");
        checkCustomOccupiedTeams();
        if (checkCustomOccupiedTeam) {
            while (true) {
                System.out.println("Enter the number respective to the team name or \nenter 999 to return back: ");
                if (input.hasNextInt()) {
                    int selectedCustomTeamNumber = input.nextInt();
                    if (selectedCustomTeamNumber == 999) { // sentinel value
                        break;
                    } else {
                        if ((selectedCustomTeamNumber >= 0) && (selectedCustomTeamNumber < formulaDriverTeams.size())) {  // validate the input team id number
                            String positionOne = String.format("%8d", formulaDriverTeams.get(selectedCustomTeamNumber).getFirstPositions()); // use string formatting
                            String positionTwo = String.format("%8d", formulaDriverTeams.get(selectedCustomTeamNumber).getSecondPositions()); // use string formatting
                            String positionThree = String.format("%8d", formulaDriverTeams.get(selectedCustomTeamNumber).getThirdPositions()); // use string formatting

                            System.out.println("+------------------------------------------------------------------------+");
                            System.out.println("Name of the Driver           : " + formulaDriverTeams.get(selectedCustomTeamNumber).getDriverName()); // get the name of the driver and print
                            System.out.println(" ");
                            System.out.println("Diver's location             : " + formulaDriverTeams.get(selectedCustomTeamNumber).getDriverLocation()); // get the location of the driver and print
                            System.out.println(" ");
                            System.out.println("Diver's team name            : " + formulaDriverTeams.get(selectedCustomTeamNumber).getTeamOfDriver()); // get team name of the driver and print
                            System.out.println(" ");
                            System.out.println("Total participated races     : " + formulaDriverTeams.get(selectedCustomTeamNumber).getNumberOfRaces()); // get the number of participated races and print
                            System.out.println(" ");
                            System.out.println("Total achieved seasons       : " + formulaDriverTeams.get(selectedCustomTeamNumber).getAchievedSeasons()); // get the total seasons achieved and print
                            System.out.println("");
                            System.out.println("Current points of the driver : " + formulaDriverTeams.get(selectedCustomTeamNumber).getCurrentPoints()); // get the current points and print
                            System.out.println(" ");
                            System.out.println(" ");
                            System.out.println("+-----------------------HORIZONTAL HISTOGRAM ANALYSIS--------------------+");
                            System.out.println(" ");
                            System.out.println("First Positions  =" + positionOne + " |" + ("*").repeat(formulaDriverTeams.get(selectedCustomTeamNumber).getFirstPositions()));  // print the stars according to the number of first positions
                            System.out.println("Second Positions =" + positionTwo + " |" + ("*").repeat(formulaDriverTeams.get(selectedCustomTeamNumber).getSecondPositions())); // print stars according to the number of second positions
                            System.out.println("Third Positions  =" + positionThree + " |" + ("*").repeat(formulaDriverTeams.get(selectedCustomTeamNumber).getThirdPositions())); // print stars according to the number of third positions

                            System.out.println("+------------------------------------------------------------------------+");


                        } else {
                            System.out.println("⚠️Invalid input range\n");
                        }
                    }

                } else {
                    System.out.println("⚠️Invalid data input\n");
                    System.out.println(" ");
                    input.next();
                }
            }

        } else {
            System.out.println("⚠️Please add a team before this function :-(\n");
        }
    }


    /**
     * Delete the driver and the team from the system
     */
    public void deleteADriverAndTeam() {
        System.out.println("Teams available in the system:");
        checkCustomOccupiedTeams();
        if (checkCustomOccupiedTeam) {
            while (true) {
                System.out.println("Enter the number respective to the team name or \nenter 999 to return back: ");
                if (input.hasNextInt()) { // data type validation
                    int customTeamNumber = input.nextInt();
                    if (customTeamNumber == 999) { // sentinel value
                        break;
                    } else {
                        if ((customTeamNumber >= 0) && (customTeamNumber < formulaDriverTeams.size())) { // check whether the input team number is between the range
                            formulaDriverTeams.remove(customTeamNumber); // remove the team according to the user's input from the system
                            System.out.println("Request successfully completed\n");
                            break;

                        } else {
                            System.out.println("⚠️Invalid input range\n");
                        }
                    }

                } else {
                    System.out.println("⚠️Invalid data input\n");
                    System.out.println(" ");
                    input.next();
                }
            }
        } else {
            System.out.println("⚠️Please add a team before this function :-(\n");
        }
    }


    /**
     * print the formula 1 driver table according to the descending order of the points gain.
     * if the points are equal it display according to the number of first positions.
     */
    public void displayFormula1DriverTable() {
        if (formulaDriverTeams.size() > 0) {  // prove that there are teams available in the system
            Collections.sort(formulaDriverTeams);
            System.out.println("Number of teams: " + formulaDriverTeams.size());
            System.out.println(" ");
            String formulaTableFormat = "| %-4d | %-20s | %-25s | %-24s| %-6d | %-8d |\n"; // java table formatting
            System.out.format("+------+----------------------+---------------------------+-------------------------+--------+----------+\n");
            System.out.format("| POS  |      TEAM NAME       |       DRIVER NAME         |          COUNTRY        | POINTS | 1stPOSES |\n");
            System.out.format("+------+----------------------+---------------------------+-------------------------+--------+----------+\n");

            for (int i = 0; i < formulaDriverTeams.size(); i++) {
                System.out.format(formulaTableFormat, i + 1, formulaDriverTeams.get(i).getTeamOfDriver(), formulaDriverTeams.get(i).getDriverName(), formulaDriverTeams.get(i).getDriverLocation(), formulaDriverTeams.get(i).getCurrentPoints(), formulaDriverTeams.get(i).getFirstPositions()); // print the relevant values
                System.out.format("+------+----------------------+---------------------------+-------------------------+--------+----------+\n");
            }
            System.out.println("\n");
        } else {
            System.out.println("⚠️Add teams to display the FORMULA 1 DRIVER TABLE\n");
        }

    }


    /**
     * Change the driver for another existing and delete the previous team.
     * Also remove the details of the team that the driver wants to change with.
     */
    public void changeTheDriver() {
        if (formulaDriverTeams.size() > 1) {
            checkCustomOccupiedTeams();
            if (checkCustomOccupiedTeam) {
                while (true) {
                    System.out.println("Enter the respective code to the team name to change the driver or \nenter 999 to return back: ");
                    if (input.hasNextInt()) {
                        int changeFromTeamNumber = input.nextInt();
                        if (changeFromTeamNumber == 999) { // sentinel value
                            break;
                        } else {
                            if ((changeFromTeamNumber >= 0) && (changeFromTeamNumber < formulaDriverTeams.size())) {
                                for (int i = 0; i < formulaDriverTeams.size(); i++) {
                                    if (!(i == changeFromTeamNumber)) { // ignore the team that selected in the above
                                        System.out.println(i + " - " + formulaDriverTeams.get(i).getTeamOfDriver() + " \n\tDriver : " + formulaDriverTeams.get(i).getDriverName() + "\n"); // print the teams except the team selected first

                                    }
                                }
                                System.out.println("Enter the code respect to the team you want to change with: ");
                                if (input.hasNextInt()) {
                                    int changeToTeamNumber = input.nextInt();

                                    if ((changeToTeamNumber >= 0) && changeToTeamNumber < formulaDriverTeams.size()) {  // make sure that the input is in between the range

//
                                        formulaDriverTeams.get(changeToTeamNumber).setDriverName(formulaDriverTeams.get(changeFromTeamNumber).getDriverName()); // setting the previous team driver to the new existing team
                                        formulaDriverTeams.get(changeToTeamNumber).setDriverLocation(formulaDriverTeams.get(changeFromTeamNumber).getDriverLocation()); // setting the previous team driver's location to the new existing team
                                        formulaDriverTeams.get(changeToTeamNumber).setFirstPositions(formulaDriverTeams.get(changeFromTeamNumber).getFirstPositions()); // setting the previous team driver's number of first position to the new existing team
                                        formulaDriverTeams.get(changeToTeamNumber).setSecondPositions(formulaDriverTeams.get(changeFromTeamNumber).getSecondPositions()); // setting the previous team  driver's number of second positions to the new existing team
                                        formulaDriverTeams.get(changeToTeamNumber).setThirdPositions(formulaDriverTeams.get(changeFromTeamNumber).getThirdPositions()); // setting the previous team driver's number of third positions to the new existing team
                                        formulaDriverTeams.get(changeToTeamNumber).setAchievedSeasons(formulaDriverTeams.get(changeFromTeamNumber).getAchievedSeasons()); // setting the previous team diver's seasonal achievements to the new existing team
                                        formulaDriverTeams.get(changeToTeamNumber).setNumberOfRaces(formulaDriverTeams.get(changeFromTeamNumber).getNumberOfRaces()); // setting the previous team driver participated races count to the new existing team
                                        formulaDriverTeams.get(changeToTeamNumber).setCurrentPoints(formulaDriverTeams.get(changeFromTeamNumber).getCurrentPoints()); // setting the  previous team driver's points to the new existing team


                                        // print the details of the driver in the new team
                                        System.out.println("Request successfully completed and deleted the team " + formulaDriverTeams.get(changeFromTeamNumber).getTeamOfDriver() + "\n");
                                        System.out.println("Preview Details \n");
                                        System.out.println("Team Name       : " + formulaDriverTeams.get(changeToTeamNumber).getTeamOfDriver());
                                        System.out.println("Driver Name     : " + formulaDriverTeams.get(changeToTeamNumber).getDriverName());
                                        System.out.println("Driver Location : " + formulaDriverTeams.get(changeToTeamNumber).getDriverLocation());
                                        System.out.println("Current points  : " + formulaDriverTeams.get(changeToTeamNumber).getCurrentPoints());

                                        formulaDriverTeams.remove(changeFromTeamNumber); // remove the previous team from the system, because it will stay as a ghost in the system without a driver, because one driver can be in only one team
                                        break;
                                    } else {
                                        System.out.println("⚠️Input out of range :(\n");
                                    }
                                } else {
                                    System.out.println("⚠️Invalid input data type! Integer required :(\n");
                                    input.next();
                                }
                            } else {
                                System.out.println("⚠️Input out of range :(\n");
                            }
                        }

                    } else {
                        System.out.println("⚠️Invalid input data type! Integer required :( \n");
                        input.next();
                    }
                }

            } else {
                System.out.println("⚠️Add teams before changing\n");
            }
        } else {
            System.out.println("⚠️Please add more teams to change the driver\n");
        }

    }


    /**
     * Add a race completed at a moment.
     */
    public void addARaceCompleted() {
        if (formulaDriverTeams.size() > 1) {  // Does not make sense if only one team participated to the race
            positionsArrayList.clear(); // clear the position array list, if not in the next race cannot assign positions due to the validation of ignoring used positions
            while (true) {
                if (checkDate()) {
                    // print the instructions
                    System.out.println("\n+------------------------------------------------------------------------+");
                    System.out.println("| INSTRUCTIONS:-                                                         |");
                    System.out.println("|           ⚠ Enter the position of the driver as a int value (1,2,3,etc)|");
                    System.out.println("|           ⚠ Enter 0 if the driver was not participated to the race     |");
                    System.out.println("+------------------------------------------------------------------------+\n");

                    System.out.println("  _    _             _    _         ");
                    System.out.println(" \\\\`../ |o_..__     \\\\`../ |o_..__  ");
                    System.out.println("`.,(_)______(_).>  `.,(_)______(_).>");
                    System.out.println("\t\t\t\t\t\t\t\tRace Date:- 🏎️ " + stringDate);
                    System.out.println("");



                    dateArray.add(stringDate); // store the date into an array list



                    for (int i = 0; i < formulaDriverTeams.size(); i++) {
                    RaceDetails newRace = new RaceDetails(stringDate);
                        while (true) {
                            System.out.println("Enter the position of team : " + formulaDriverTeams.get(i).getTeamOfDriver() + " \n\t\tDriver : " + formulaDriverTeams.get(i).getDriverName() + " :");
                            if (input.hasNextInt()) {
                                int position = input.nextInt();
                                if ((position > 0) && (position <= formulaDriverTeams.size())) { // validate the point to make sure the input position is between the range
                                    if (checkPositions(position)) {

                                        switch (position) {
                                            // update the details such as current points and the number of position of the driver according to the user input
                                            case 1:
                                                formulaDriverTeams.get(i).setCurrentPoints(25 + formulaDriverTeams.get(i).getCurrentPoints());
                                                formulaDriverTeams.get(i).setFirstPositions(1 + formulaDriverTeams.get(i).getFirstPositions());
                                                formulaDriverTeams.get(i).setNumberOfRaces(1 + formulaDriverTeams.get(i).getNumberOfRaces());
                                                System.out.println("✨ Congratulations! You won the 1st place\n");
                                                break;
                                            case 2:
                                                formulaDriverTeams.get(i).setCurrentPoints(18 + formulaDriverTeams.get(i).getCurrentPoints());
                                                formulaDriverTeams.get(i).setSecondPositions(1 + formulaDriverTeams.get(i).getSecondPositions());
                                                formulaDriverTeams.get(i).setNumberOfRaces(1 + formulaDriverTeams.get(i).getNumberOfRaces());
                                                System.out.println("✨ Congratulations! You won the 2nd place\n");
                                                break;
                                            case 3:
                                                formulaDriverTeams.get(i).setCurrentPoints(15 + formulaDriverTeams.get(i).getCurrentPoints());
                                                formulaDriverTeams.get(i).setThirdPositions(1 + formulaDriverTeams.get(i).getThirdPositions());
                                                formulaDriverTeams.get(i).setNumberOfRaces(1 + formulaDriverTeams.get(i).getNumberOfRaces());
                                                System.out.println("✨ Congratulations! You won the 3rd place\n");
                                                break;
                                            case 4:
                                                formulaDriverTeams.get(i).setCurrentPoints(12 + formulaDriverTeams.get(i).getCurrentPoints());
                                                formulaDriverTeams.get(i).setNumberOfRaces(1 + formulaDriverTeams.get(i).getNumberOfRaces());
                                                System.out.println("✨ Congratulations! You won the 4th place\n");
                                                break;
                                            case 5:
                                                formulaDriverTeams.get(i).setCurrentPoints(10 + formulaDriverTeams.get(i).getCurrentPoints());
                                                formulaDriverTeams.get(i).setNumberOfRaces(1 + formulaDriverTeams.get(i).getNumberOfRaces());
                                                System.out.println("✨ Congratulations! You won the 5th place\n");
                                                break;
                                            case 6:
                                                formulaDriverTeams.get(i).setCurrentPoints(8 + formulaDriverTeams.get(i).getCurrentPoints());
                                                formulaDriverTeams.get(i).setNumberOfRaces(1 + formulaDriverTeams.get(i).getNumberOfRaces());
                                                System.out.println("✨ Congratulations! You won the 6th place\n");
                                                break;
                                            case 7:
                                                formulaDriverTeams.get(i).setCurrentPoints(6 + formulaDriverTeams.get(i).getCurrentPoints());
                                                formulaDriverTeams.get(i).setNumberOfRaces(1 + formulaDriverTeams.get(i).getNumberOfRaces());
                                                System.out.println("✨ Congratulations! You won the 7th place\n");
                                                break;
                                            case 8:
                                                formulaDriverTeams.get(i).setCurrentPoints(4 + formulaDriverTeams.get(i).getCurrentPoints());
                                                formulaDriverTeams.get(i).setNumberOfRaces(1 + formulaDriverTeams.get(i).getNumberOfRaces());
                                                System.out.println("✨ Congratulations! You won the 8th place\n");
                                                break;
                                            case 9:
                                                formulaDriverTeams.get(i).setCurrentPoints(2 + formulaDriverTeams.get(i).getCurrentPoints());
                                                formulaDriverTeams.get(i).setNumberOfRaces(1 + formulaDriverTeams.get(i).getNumberOfRaces());
                                                System.out.println("✨ Congratulations! You won the 9th place\n");
                                                break;
                                            case 10:
                                                formulaDriverTeams.get(i).setCurrentPoints(1 + formulaDriverTeams.get(i).getCurrentPoints());
                                                formulaDriverTeams.get(i).setNumberOfRaces(1 + formulaDriverTeams.get(i).getNumberOfRaces());
                                                System.out.println("✨ Congratulations! You won the 10th place\n");
                                                break;
                                            default:
                                                System.out.println("We appreciate your participation!\n");
                                                formulaDriverTeams.get(i).setNumberOfRaces(1 + formulaDriverTeams.get(i).getNumberOfRaces());
                                                break;

                                        }

                                        newRace.setDriverNameTeamNamePosition(formulaDriverTeams.get(i).getDriverName(),formulaDriverTeams.get(i).getTeamOfDriver(),position);
                                        raceDetailsList.add(newRace);      // updating the race details array list
                                        positionsArrayList.add(position); // add position in to the array list in validation purpose
                                        break;
                                    } else {
                                        System.out.println("⚠️The position is taken by another player retry the correct position\n");
                                    }

                                } else {
                                    System.out.println("⚠️Invalid input range \n");
                                }

                            } else {
                                System.out.println("⚠️Invalid input type \n");
                                input.next();
                            }
                        }
                    }
                    break;

                } else {
                    System.out.println("⏲️Please enter a valid date 📅\n");
                }

            }
        } else {
            System.out.println("⚠️Please add teams before adding a race 🏎️🏎️🏎️🏎️\n");
        }

    }

    /**
     * Date validation
     *
     * @return true if input is valid, else return false
     */
    public boolean checkDate() {
        System.out.println("Enter the date with the following format\n DD/MM/YYYY");
        stringDate = input.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // make sure that the date  is taken to an order
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(stringDate); // check whether the input date is valid
            return true; // if valid
        } catch (Exception e) {
            return false; // if not valid
        }
    }

    /**
     * Check the entered position is valid.
     *
     * @param position int input of position
     * @return true if the position is valid else return false
     */
    public boolean checkPositions(int position) {
        boolean checkPosition = true;
        for (int i = 0; i < positionsArrayList.size(); i++) {
            if (position == positionsArrayList.get(i)) { // ignore if the position is used previously, Assume that there cannot have more than one team in the same position
                checkPosition = false;
            } else {
                checkPosition = true;
            }
        }
        return checkPosition;
    }


    /**
     * Save the final data of the teams into a file
     */
    public void saveInformationInAFile() {                                                                              // reference https://samderlust.com/dev-blog/java/write-read-arraylist-object-file-java
        try {
            FileOutputStream writeInfo = new FileOutputStream("teamDetails.ser");                                 // create a file output stream
            ObjectOutputStream writeStream = new ObjectOutputStream(writeInfo);                                         // handle the object to be written into files that FileOutputStream created

            writeStream.writeObject(formulaDriverTeams);                                                                // write the objects in the arraylist in tp the file
            writeStream.flush();
            writeStream.close();
            System.out.println("INFORMATION HAS BEEN SAVED TO A FILE\n");
        } catch (IOException e) {
            System.out.println("⚠️Something went wrong\n");
        }
    }

    /**
     * Load the data from the saved file.
     */
    public void loadTeamDetails() {                                                                                      // reference https://samderlust.com/dev-blog/java/write-read-arraylist-object-file-java
        try {
            // read the information in the file to the program
            FileInputStream readInfo = new FileInputStream("teamDetails.ser");
            ObjectInputStream readStream = new ObjectInputStream(readInfo);
            formulaDriverTeams = (ArrayList<Formula1Driver>) readStream.readObject();                                   // assign values to the main array list and casted the values
            readStream.close();                                                                                         // close the reading stream
            System.out.println("File loaded...\n");
        } catch (FileNotFoundException e) {
            System.out.println("⚠️No file to load!\n");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("⚠️Something went wrong!\n");
        }
    }
    public static ArrayList<Formula1Driver> getData(){
        return formulaDriverTeams;
    }

    public static ArrayList<RaceDetails> getRaceDateData(){
        return raceDetailsList;
    }

/////////////               test method              ////////////////////

    public void printRaceDetails(){
        for (RaceDetails race: raceDetailsList){
            System.out.println(race.getteamNameInRace() + " " + race.getDriverNameInRace() + " Position : " + race.getPosition());

            System.out.println(race.getRaceDate());
        }
    }

}

