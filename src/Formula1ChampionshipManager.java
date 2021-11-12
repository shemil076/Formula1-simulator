import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class Formula1ChampionshipManager<HashTable> implements ChampionshipManager {
    public Scanner input = new Scanner(System.in);
    public Scanner delimiterInput = new Scanner(System.in).useDelimiter("\n");
    private static boolean run = true;
    private final int[] rangeNumber = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final String[] countryCodes = {"ARG", "AUS", "AUT", "BHR", "BEL", "BRA", "CAN", "CHL", "COL", "CZE", "DNK", "FIN", "FRA", "DEU", "HUN", "IND", "IRL", "ITA", "JPN", "LIE", "MYS", "MEX", "MCO", "MAR", "NLD", "NZL", "POL", "PRT", "RUS", "ZAF", "ESP", "SWE", "CHE", "THA", "GBR", "USA", "URY", "VEN", "ARE"};
    public String[] existingTeamsArray = {"MERCEDES", "RED BULL", "MCLAREN", "FERRARI", "ALPINE", "ALFA TAURI", "ASTON MARTIN", "WILLIAMS", "ALFA ROMEO RACING", "HAAS F1 TEAM"};
    private static boolean checkCountryCode = false;
    private static boolean checkCustomOccupiedTeam = true, checkDriverName = true;
    private int firstPositions, secondPositions, thirdPositions, achievedSeasons, currentPoints, numberOfRaces;
    private static boolean checkTeamName = true;
    private String stringDate;


    Hashtable<String, String> countries = new Hashtable<String, String>();
    ArrayList<Formula1Driver> customTeamArray = new ArrayList<Formula1Driver>();
    ArrayList<String> dateArray = new ArrayList<String>();
    ArrayList<Integer> positionsArrayList = new ArrayList<Integer>();

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
        System.out.println("|           999 or EXT         |       Exit the program                  |");
        System.out.println("+------------------------------------------------------------------------+");

        System.out.println("Enter the respective code for your requirement: ");


    }

    /**
     * Proceed the options according to the users response
     */
    public void mainMenu() {
        if (delimiterInput.hasNext()) {
            String option = delimiterInput.next();
            switch (option.toUpperCase()) {
                case "100", "CND" -> {
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                          Create a New Driver                           |");
                    System.out.println("+------------------------------------------------------------------------+");
                    createANewDriver(existingTeamsArray);
                }
                case "101", "DDT" -> {
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                         Delete a Driver and Team                       |");
                    System.out.println("+------------------------------------------------------------------------+");
                    deleteADriverAndTeam();
                }
                case "102", "CTD" -> {
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                           Change the Driver                            |");
                    System.out.println("|        ^_^ WARNING the team will be deleted from the system            |");
                    System.out.println("|         while changing the driver to an existing team ^_^              |");
                    System.out.println("+------------------------------------------------------------------------+");
                    changeTheDriver();
                }
                case "103", "DVS" -> {
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                       Display the Various Statics                      |");
                    System.out.println("+------------------------------------------------------------------------+");
                    displayTheVariousStatics();
                }
                case "104", "DFT" -> {
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                      Display Formula1 Driver Table                     |");
                    System.out.println("+------------------------------------------------------------------------+");
                    displayFormula1DriverTable();
                }
                case "105", "ARC" -> {
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                             Add a Race Completed                       |");
                    System.out.println("+------------------------------------------------------------------------+");
                    addARaceCompleted();
                }
                case "999", "EXT" -> {
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                             Exit the program                           |");
                    System.out.println("+------------------------------------------------------------------------+");
                    exitTheProgram();
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
                String name = delimiterInput.next();

                driverNameCheck(name);

                if (checkDriverName) {

                    if (name.equalsIgnoreCase("999")) {
                        break;
                    } else {
                        System.out.println("Enter the name of your team: ");
                        String teamName = delimiterInput.next().toUpperCase();

                        customTeamCheck(teamName);


                        if (checkTeamName) {
                            System.out.println("\nEnter the country code you prefer from the following or \nenter 9 to add a custom country");
                            System.out.println("");
                            printCountryTable();
                            System.out.println("");

                            while (true) {
                                System.out.println("Enter the code or enter 9 to add a custom country : ");
                                String country = input.next().toUpperCase();

                                if (country.equalsIgnoreCase("9")) {
                                    System.out.println("Enter the country of the driver : ");
                                    String customCountry = delimiterInput.next().toUpperCase();

                                    getStatistics();

                                    customTeamArray.add(new Formula1Driver(name, customCountry, teamName, firstPositions, secondPositions, thirdPositions, achievedSeasons, currentPoints, numberOfRaces));

                                    System.out.println("Requirement is successfully completed");
                                    System.out.println(name + " was added to the team " + teamName);
                                    System.out.println("");
                                    break;


                                } else {
                                    findCountryCode(country);
                                    if (checkCountryCode) {
                                        getStatistics();
                                        customTeamArray.add(new Formula1Driver(name, countries.get(country), teamName, firstPositions, secondPositions, thirdPositions, achievedSeasons, currentPoints, numberOfRaces));

                                        System.out.println("Requirement is successfully completed");
                                        System.out.println(name + " was added to the team " + teamName);
                                        System.out.println("");
                                        break;


                                    } else {
                                        System.out.println("⚠️Invalid country code! :(\n");
                                    }
                                }
                            }
                            checkCountryCode = false;

                        } else {
                            System.out.println("⚠️Team name was already exist\n");
                        }
                    }
                } else {
                    System.out.println("⚠️Driver name was already exist\n");
                    System.out.println("");
                }
                checkDriverName = true;

            } else {
                System.out.println("⚠️Invalid data input\n");
            }
        }

    }


    /**
     * Check whether the iso country code is in the system.
     *
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
     *
     * @param teamName string input of the team name.
     */
    public void customTeamCheck(String teamName) {
        for (Formula1Driver f1driver : customTeamArray) {
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
        for (int i = 0; i < customTeamArray.size(); i++) {
            if (customTeamArray.get(i).getDriverName().contains(driverName)) {
                checkDriverName = false;
            }
        }
    }


    /**
     * Exit the program.
     */
    public void exitTheProgram() {
        thankYou();
        System.out.println("");
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
            if (input.hasNextInt()) {
                firstPositions = input.nextInt();
                if (firstPositions >= 0) {
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
            if (input.hasNextInt()) {
                secondPositions = input.nextInt();
                if (secondPositions >= 0) {
                    break;
                } else {
                    System.out.println("⚠️Please input a valid number\n");
                }
            } else {
                System.out.println("⚠️Invalid data input\n");
                System.out.println("");
                input.next();
            }
        }
        while (true) {
            System.out.println("Enter the number of third positions the driver achieved:");
            if (input.hasNextInt()) {
                thirdPositions = input.nextInt();
                if (thirdPositions >= 0) {
                    break;
                } else {
                    System.out.println("⚠️Please input a valid number\n");
                }
            } else {
                System.out.println("⚠️Invalid data input\n");
                System.out.println("");
                input.next();
            }
        }
        while (true) {
            System.out.println("Enter the number of seasons achieved: ");
            if (input.hasNextInt()) {
                achievedSeasons = input.nextInt();
                if (achievedSeasons >= 0) {
                    break;
                } else {
                    System.out.println("⚠️Please input a valid number\n");
                }
            } else {
                System.out.println("⚠️Invalid data input\n");
                System.out.println("");
                input.next();
            }
        }
        while (true) {
            System.out.println("Enter the number of participated races: ");
            if (input.hasNextInt()) {
                numberOfRaces = input.nextInt();
                if (numberOfRaces >= 0) {
                    break;
                } else {
                    System.out.println("⚠️Please input a valid number\n");
                }
            } else {
                System.out.println("⚠️Invalid data input\n");
                System.out.println("");
                input.next();
            }
        }
        while (true) {
            System.out.println("Enter the number of points the driver owned: ");
            if (input.hasNextInt()) {
                currentPoints = input.nextInt();
                if (currentPoints >= 0) {
                    break;
                } else {
                    System.out.println("⚠️Please input a valid number\n");
                }
            } else {
                System.out.println("⚠️Invalid data input\n");
                System.out.println("");
                input.next();
            }
        }

    }


    /**
     * print the used team names and print none if there are no teams in the system
     */
    public void checkCustomOccupiedTeams() {
        if (customTeamArray.size() > 0) {
            for (int i = 0; i < customTeamArray.size(); i++) {
                System.out.println(i + " - " + customTeamArray.get(i).getTeamOfDriver() + " \n\tDriver : " + customTeamArray.get(i).getDriverName() + "\n");
                checkCustomOccupiedTeam = true;
            }
        } else {
            System.out.println("None");
            System.out.println("");
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
                    if (selectedCustomTeamNumber == 999) {
                        break;
                    } else {
                        if ((selectedCustomTeamNumber >= 0) && (selectedCustomTeamNumber < customTeamArray.size())) {
                            String positionOne = String.format("%8d", customTeamArray.get(selectedCustomTeamNumber).getFirstPositions());
                            String positionTwo = String.format("%8d", customTeamArray.get(selectedCustomTeamNumber).getSecondPositions());
                            String positionThree = String.format("%8d", customTeamArray.get(selectedCustomTeamNumber).getThirdPositions());

                            System.out.println("+------------------------------------------------------------------------+");
                            System.out.println("Name of the Driver           : " + customTeamArray.get(selectedCustomTeamNumber).getDriverName());
                            System.out.println("");
                            System.out.println("Diver's location             : " + customTeamArray.get(selectedCustomTeamNumber).getDriverLocation());
                            System.out.println("");
                            System.out.println("Diver's team name            : " + customTeamArray.get(selectedCustomTeamNumber).getTeamOfDriver());
                            System.out.println("");
                            System.out.println("Total participated races     : " + customTeamArray.get(selectedCustomTeamNumber).getNumberOfRaces());
                            System.out.println("");
                            System.out.println("Total achieved seasons       : " + customTeamArray.get(selectedCustomTeamNumber).getAchievedSeasons());
                            System.out.println("");
                            System.out.println("Current points of the driver : " + customTeamArray.get(selectedCustomTeamNumber).getCurrentPoints());
                            System.out.println("");
                            System.out.println("");
                            System.out.println("+-----------------------HORIZONTAL HISTOGRAM ANALYSIS--------------------+");
                            System.out.println("");
                            System.out.println("First Positions  =" + positionOne + " |" + ("*").repeat(customTeamArray.get(selectedCustomTeamNumber).getFirstPositions()));
                            System.out.println("Second Positions =" + positionTwo + " |" + ("*").repeat(customTeamArray.get(selectedCustomTeamNumber).getSecondPositions()));
                            System.out.println("Third Positions  =" + positionThree + " |" + ("*").repeat(customTeamArray.get(selectedCustomTeamNumber).getThirdPositions()));

                            System.out.println("+------------------------------------------------------------------------+");


                        } else {
                            System.out.println("⚠️Invalid input range\n");
                        }
                    }

                } else {
                    System.out.println("⚠️Invalid data input\n");
                    System.out.println("");
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
                if (input.hasNextInt()) {
                    int customTeamNumber = input.nextInt();
                    if (customTeamNumber == 999) {
                        break;
                    } else {
                        if ((customTeamNumber >= 0) && (customTeamNumber < customTeamArray.size())) {
                            customTeamArray.remove(customTeamNumber);
                            System.out.println("Request successfully completed\n");
                            break;

                        } else {
                            System.out.println("⚠️Invalid input range\n");
                        }
                    }

                } else {
                    System.out.println("⚠️Invalid data input\n");
                    System.out.println("");
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
        if (customTeamArray.size() > 0) {
            Collections.sort(customTeamArray);
            System.out.println("Number of teams: " + customTeamArray.size());
            System.out.println("");
            String formulaTableFormat = "| %-4d | %-20s | %-25s | %-24s| %-6d | %-8d |\n";
            System.out.format("+------+----------------------+---------------------------+-------------------------+--------+----------+\n");
            System.out.format("| POS  |      TEAM NAME       |       DRIVER NAME         |          COUNTRY        | POINTS | 1stPOSES |\n");
            System.out.format("+------+----------------------+---------------------------+-------------------------+--------+----------+\n");

            for (int i = 0; i < customTeamArray.size(); i++) {
                System.out.format(formulaTableFormat, i + 1, customTeamArray.get(i).getTeamOfDriver(), customTeamArray.get(i).getDriverName(), customTeamArray.get(i).getDriverLocation(), customTeamArray.get(i).getCurrentPoints(), customTeamArray.get(i).getFirstPositions());
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
        if (customTeamArray.size() > 1) {
            checkCustomOccupiedTeams();
            if (checkCustomOccupiedTeam) {
                while (true) {
                    System.out.println("Enter the respective code to the team name to change the driver or \nenter 999 to return back: ");
                    if (input.hasNextInt()) {
                        int changeFromTeamNumber = input.nextInt();
                        if (changeFromTeamNumber == 999) {
                            break;
                        } else {
                            if ((changeFromTeamNumber >= 0) && (changeFromTeamNumber < customTeamArray.size())) {
                                for (int i = 0; i < customTeamArray.size(); i++) {
                                    if (!(i == changeFromTeamNumber)) {
                                        System.out.println(i + " - " + customTeamArray.get(i).getTeamOfDriver() + " \n\tDriver : " + customTeamArray.get(i).getDriverName() + "\n");

                                    }
                                }
                                System.out.println("Enter the code respect to the team you want to change with: ");
                                if (input.hasNextInt()) {
                                    int changeToTeamNumber = input.nextInt();

                                    if ((changeToTeamNumber >= 0) && changeToTeamNumber < customTeamArray.size()) {

//
                                        customTeamArray.get(changeToTeamNumber).setDriverName(customTeamArray.get(changeFromTeamNumber).getDriverName());
                                        customTeamArray.get(changeToTeamNumber).setDriverLocation(customTeamArray.get(changeFromTeamNumber).getDriverLocation());
                                        customTeamArray.get(changeToTeamNumber).setFirstPositions(customTeamArray.get(changeFromTeamNumber).getFirstPositions());
                                        customTeamArray.get(changeToTeamNumber).setSecondPositions(customTeamArray.get(changeFromTeamNumber).getSecondPositions());
                                        customTeamArray.get(changeToTeamNumber).setThirdPositions(customTeamArray.get(changeFromTeamNumber).getThirdPositions());
                                        customTeamArray.get(changeToTeamNumber).setAchievedSeasons(customTeamArray.get(changeFromTeamNumber).getAchievedSeasons());
                                        customTeamArray.get(changeToTeamNumber).setNumberOfRaces(customTeamArray.get(changeFromTeamNumber).getNumberOfRaces());
                                        customTeamArray.get(changeToTeamNumber).setCurrentPoints(customTeamArray.get(changeFromTeamNumber).getCurrentPoints());


                                        System.out.println("Request successfully completed and deleted the team " + customTeamArray.get(changeFromTeamNumber).getTeamOfDriver() + "\n");
                                        System.out.println("Preview Details \n");
                                        System.out.println("Team Name       : " + customTeamArray.get(changeToTeamNumber).getTeamOfDriver());
                                        System.out.println("Driver Name     : " + customTeamArray.get(changeToTeamNumber).getDriverName());
                                        System.out.println("Driver Location : " + customTeamArray.get(changeToTeamNumber).getDriverLocation());
                                        System.out.println("Current points  : " + customTeamArray.get(changeToTeamNumber).getCurrentPoints());

                                        customTeamArray.remove(changeFromTeamNumber);
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
        if (customTeamArray.size() > 1) {
            positionsArrayList.clear();
            while (true) {
                if (checkDate()) {
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

                    dateArray.add(stringDate);

                    for (int i = 0; i < customTeamArray.size(); i++) {
                        while (true) {
                            System.out.println("Enter the position of team : " + customTeamArray.get(i).getTeamOfDriver() + " \n\t\tDriver : " + customTeamArray.get(i).getDriverName() + " :");
                            if (input.hasNextInt()) {
                                int position = input.nextInt();
                                if ((position >= 0) && (position <= customTeamArray.size())) {
                                    if (checkPositions(position)) {

                                        switch (position) {
                                            case 1:
                                                customTeamArray.get(i).setCurrentPoints(25 + customTeamArray.get(i).getCurrentPoints());
                                                customTeamArray.get(i).setFirstPositions(1 + customTeamArray.get(i).getFirstPositions());
                                                System.out.println("✨ Congratulations! You won the 1st place\n");
                                                break;
                                            case 2:
                                                customTeamArray.get(i).setCurrentPoints(18 + customTeamArray.get(i).getCurrentPoints());
                                                customTeamArray.get(i).setSecondPositions(1 + customTeamArray.get(i).getSecondPositions());
                                                System.out.println("✨ Congratulations! You won the 2nd place\n");
                                                break;
                                            case 3:
                                                customTeamArray.get(i).setCurrentPoints(15 + customTeamArray.get(i).getCurrentPoints());
                                                customTeamArray.get(i).setThirdPositions(1 + customTeamArray.get(i).getThirdPositions());
                                                System.out.println("✨ Congratulations! You won the 3rd place\n");
                                                break;
                                            case 4:
                                                customTeamArray.get(i).setCurrentPoints(12 + customTeamArray.get(i).getCurrentPoints());
                                                System.out.println("✨ Congratulations! You won the 4th place\n");
                                                break;
                                            case 5:
                                                customTeamArray.get(i).setCurrentPoints(10 + customTeamArray.get(i).getCurrentPoints());
                                                System.out.println("✨ Congratulations! You won the 5th place\n");
                                                break;
                                            case 6:
                                                customTeamArray.get(i).setCurrentPoints(8 + customTeamArray.get(i).getCurrentPoints());
                                                System.out.println("✨ Congratulations! You won the 6th place\n");
                                                break;
                                            case 7:
                                                customTeamArray.get(i).setCurrentPoints(6 + customTeamArray.get(i).getCurrentPoints());
                                                System.out.println("✨ Congratulations! You won the 7th place\n");
                                                break;
                                            case 8:
                                                customTeamArray.get(i).setCurrentPoints(4 + customTeamArray.get(i).getCurrentPoints());
                                                System.out.println("✨ Congratulations! You won the 8th place\n");
                                                break;
                                            case 9:
                                                customTeamArray.get(i).setCurrentPoints(2 + customTeamArray.get(i).getCurrentPoints());
                                                System.out.println("✨ Congratulations! You won the 9th place\n");
                                                break;
                                            case 10:
                                                customTeamArray.get(i).setCurrentPoints(1 + customTeamArray.get(i).getCurrentPoints());
                                                System.out.println("✨ Congratulations! You won the 10th place\n");
                                                break;
                                            case 0:
                                                System.out.println("Participate in the next time\n");
                                                break;
                                            default:
                                                System.out.println("We appreciate your participation!\n");
                                                break;

                                        }
                                        positionsArrayList.add(position);
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(stringDate);
            return true;
        } catch (Exception e) {
            return false;
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
            if (position == positionsArrayList.get(i)) {
                checkPosition = false;
//                    return false;
            } else {
//                    return true;
                checkPosition = true;
            }
        }
        return checkPosition;
    }


    /**
     * Save the final data of the teams into a file
     */
    public void saveInformationInAFile() {                                                                               // reference https://samderlust.com/dev-blog/java/write-read-arraylist-object-file-java
        try {
            FileOutputStream writeInfo = new FileOutputStream("teamDetails.ser");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeInfo);

            writeStream.writeObject(customTeamArray);
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
    public void loadTeamDetails() {                                                                                      // reference https://samderlust.com/dev-blog/java/write-read-arraylist-object-file-javal
        try {
            FileInputStream readInfo = new FileInputStream("teamDetails.ser");
            ObjectInputStream readStream = new ObjectInputStream(readInfo);
            customTeamArray = (ArrayList<Formula1Driver>) readStream.readObject();
            readStream.close();
            System.out.println("File loaded...\n");
        } catch (FileNotFoundException e) {
            System.out.println("⚠️No file to load!\n");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("⚠️Something went wrong!\n");
        }
    }

}

