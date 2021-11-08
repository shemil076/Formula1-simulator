import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class Formula1ChampionshipManager<HashTable> implements ChampionshipManager {
    private int numberOfDrivers;
    private int numberOfCars;
    public Scanner input = new Scanner(System.in);
    public Scanner delimiterInput = new Scanner(System.in).useDelimiter("\n");
    private int customTeamIndex = 0;
    private static boolean run = true;
    private int[] rangeNumber = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private String[] countryCodes = {"ARG", "AUS", "AUT", "BHR", "BEL", "BRA", "CAN", "CHL", "COL", "CZE", "DNK", "FIN", "FRA", "DEU", "HUN", "IND", "IRL", "ITA", "JPN", "LIE", "MYS", "MEX", "MCO", "MAR", "NLD", "NZL", "POL", "PRT", "RUS", "ZAF", "ESP", "SWE", "CHE", "THA", "GBR", "USA", "URY", "VEN", "ARE"};
    private String[] existingTeamsArray = {"MERCEDES", "RED BULL", "MCLAREN", "FERRARI", "ALPINE", "ALFA TAURI", "ASTON MARTIN", "WILLIAMS", "ALFA ROMEO RACING", "HAAS F1 TEAM"};
    private boolean checkNumber = false, checkCountryCode = false;
    private boolean checkExistingTeamTeamName = true, checkDisplayTheVariousStatics = true, checkTeamName = true, checkCreateANewDriver = true, vacantTeams = true, occupiedTeam = true, checkCustomOccupiedTeam = true;

    private int firstPositions, secondPositions, thirdPositions, achievedSeasons, currentPoints, numberOfRaces;


    Hashtable<Integer, String> teams = new Hashtable<Integer, String>();
    Hashtable<String, String> countries = new Hashtable<String, String>();
    //    Hashtable<String, Integer> customCountryIndex = new Hashtable<String, Integer>();
    ArrayList<Formula1Driver> customTeamArray = new ArrayList<Formula1Driver>();

    public static void main(String[] args) {
        Formula1ChampionshipManager championManager = new Formula1ChampionshipManager();
        Formula1Driver[] formula1DriversTeam = new Formula1Driver[10];

        championManager.initialize(formula1DriversTeam);
        championManager.welcome();
        championManager.logo();

        while (run) {
            championManager.printMenu();
            championManager.mainMenu(formula1DriversTeam);
        }
    }


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
        System.out.println("|           106 or SIF         |       Save in a File                    |");
        System.out.println("|           107 or SIF         |       Save in a File                    |");
        System.out.println("|           999 or EXT         |       Exit the program                  |");
        System.out.println("+------------------------------------------------------------------------+");

        System.out.println("Enter the respective code for your requirement: ");


    }


    public void mainMenu(Formula1Driver[] formula1DriversTeam) {
        if (input.hasNext()) {
            String option = input.next();
            switch (option.toUpperCase()) {
                case "100":
                case "CND":
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                          Create a New Driver                           |");
                    System.out.println("+------------------------------------------------------------------------+");
                    createANewDriver(formula1DriversTeam);
                    break;

                case "101":
                case "DDT":
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                         Delete a Driver and Team                       |");
                    System.out.println("+------------------------------------------------------------------------+");
                    break;

                case "102":
                case "CTD":
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                           Change the Driver                            |");
                    System.out.println("+------------------------------------------------------------------------+");
                    break;

                case "103":
                case "DVS":
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                       Display the Various Statics                      |");
                    System.out.println("+------------------------------------------------------------------------+");
                    displayTheVariousStatics(formula1DriversTeam);
                    break;


                case "104":
                case "DFT":
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                      Display Formula1 Driver Table                     |");
                    System.out.println("+------------------------------------------------------------------------+");
                    break;

                case "105":
                case "ARC":
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                             Add a Race Completed                       |");
                    System.out.println("+------------------------------------------------------------------------+");
                    break;

                case "106":
                case "SIF":
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                               Save in a File                           |");
                    System.out.println("+------------------------------------------------------------------------+");
                    break;


                case "999":
                case "EXT":
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                             Exit the program                           |");
                    System.out.println("+------------------------------------------------------------------------+");
                    exitTheProgram();
                    break;

                default:
                    System.out.println("Invalid option selected, 'Input out of range'");
            }
        } else {
            System.out.println("Invalid out-put");                                                                      //if the user input an invalid input, the program will not terminate, just repeat by passing a warning
        }
    }

    public void initialize(Formula1Driver[] formula1DriversTeam) {
        for (int i = 0; i < formula1DriversTeam.length; i++) {
            formula1DriversTeam[i] = new Formula1Driver("~", "~", "~", 0, 0, 0, 0, 0, 0, 0);
        }
        teams.put(0, " 0 - MERCEDES");
        teams.put(1, " 1 - RED BULL");
        teams.put(2, " 2 - MCLAREN");
        teams.put(3, " 3 - FERRARI");
        teams.put(4, " 4 - ALPINE");
        teams.put(5, " 5 - ALFA TAURI");
        teams.put(6, " 6 - ASTON MARTIN");
        teams.put(7, " 7 - WILLIAMS");
        teams.put(8, " 8 - ALFA ROMEO RACING");
        teams.put(9, " 9 - HAAS F1 TEAM");
    }


    public void createANewDriver(Formula1Driver[] formula1DriversTeam) {
        while (checkCreateANewDriver) {

            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("|         INPUT CODE         |              OPTION                       |");
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("|         1 or AET           |     Add a driver to an existing team      |");
            System.out.println("|         2 or ACT           |     Add a driver to a custom team         |");
            System.out.println("|         9 or BCK           |     Return To the main menu               |");
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("Enter the respective code for your requirement: ");


            if (input.hasNext()) {
                String respond = input.next();
                switch (respond.toUpperCase()) {
                    case "1":
                    case "AET":
                        System.out.println("+------------------------------------------------------------------------+");
                        System.out.println("|                    Add a driver to an existing team                    |");
                        System.out.println("+------------------------------------------------------------------------+");
                        addToExistingTeam(formula1DriversTeam);
                        break;

                    case "2":
                    case "ACT":
                        System.out.println("+------------------------------------------------------------------------+");
                        System.out.println("|                     Add a driver to a custom team                      |");
                        System.out.println("+------------------------------------------------------------------------+");
                        addToCustomTeam();
                        break;

                    case "9":
                    case "BCK":
                        checkCreateANewDriver = false;
                        break;
                    default:
                        System.out.println("Invalid option selected, 'Input out of range'");
                }
            } else {
                System.out.println("Invalid in-put");                                                                      //if the user input an invalid input, the program will not terminate, just repeat by passing a warning
            }
        }
        checkCreateANewDriver = true;

    }


    public void addToExistingTeam(Formula1Driver[] formula1DriversTeam) {
        checkVacantTeam(formula1DriversTeam);
        if (vacantTeams) {
            while (true) {
                System.out.println("Enter the respective number of the team you prefer or \nenter 999 to return back : ");
                if (input.hasNextInt()) {
                    int teamNumber = input.nextInt();
                    if (teamNumber == 999) {
                        break;
                    } else {
                        findTeamsNumber(teamNumber);
                        if (checkNumber) {
                            if (!formula1DriversTeam[teamNumber].getDriverName().equals("~")) {
                                System.out.println("Already the team has a driver");
                            } else {
                                System.out.println("Enter the name of the driver");
                                if (delimiterInput.hasNext()) {
                                    String name = delimiterInput.next();
                                    System.out.println("");
                                    System.out.println("Enter the country code you prefer from the following or \nenter 9 to add a custom country:  ");

                                    printCountryTable();
                                    System.out.println("");

                                    while (true) {

                                        System.out.println("Enter the code or enter 9 to add a custom country : ");
                                        String country = input.next().toUpperCase();
                                        if (country.equalsIgnoreCase("9")) {
                                            System.out.println("Enter the country of the driver :");
                                            String customCountry = delimiterInput.next().toUpperCase();
                                            getStatistics();

                                            formula1DriversTeam[teamNumber].setDriverLocation(customCountry);
                                            formula1DriversTeam[teamNumber].setFirstPositions(firstPositions);
                                            formula1DriversTeam[teamNumber].setSecondPositions(secondPositions);
                                            formula1DriversTeam[teamNumber].setThirdPositions(thirdPositions);
                                            formula1DriversTeam[teamNumber].setAchievedSeasons(achievedSeasons);
                                            formula1DriversTeam[teamNumber].setNumberOfRaces(numberOfRaces);
                                            formula1DriversTeam[teamNumber].setTeamOfDriver(teams.get(teamNumber));
                                            formula1DriversTeam[teamNumber].calculatePoints();


                                            break;
                                        } else {
                                            findCountryCode(country);
                                            if (checkCountryCode) {
                                                getStatistics();

                                                formula1DriversTeam[teamNumber].setDriverLocation(countries.get(country));
                                                formula1DriversTeam[teamNumber].setFirstPositions(firstPositions);
                                                formula1DriversTeam[teamNumber].setSecondPositions(secondPositions);
                                                formula1DriversTeam[teamNumber].setThirdPositions(thirdPositions);
                                                formula1DriversTeam[teamNumber].setAchievedSeasons(achievedSeasons);
                                                formula1DriversTeam[teamNumber].setNumberOfRaces(numberOfRaces);
                                                formula1DriversTeam[teamNumber].setTeamOfDriver(teams.get(teamNumber));
                                                formula1DriversTeam[teamNumber].calculatePoints();

                                                break;
                                            } else {
                                                System.out.println("Invalid country code! :(");
                                            }
                                        }
                                    }


                                    formula1DriversTeam[teamNumber].setDriverName(name.toUpperCase());

                                    System.out.println("");
                                    System.out.println("Requirement is successfully completed");
                                    System.out.println(name + " was added to the team " + teams.get(teamNumber));

                                } else {
                                    System.out.println("Invalid input data type, String Required");
                                    input.next();
                                }
                            }
                        } else {
                            System.out.println("Team number is out of range");

                        }

                    }

                } else {
                    System.out.println("Invalid input data type, Integer Required");
                    input.next();
                }
                checkNumber = false;
                checkCountryCode = false;

            }
        } else {
            System.out.println("No vacancy, Please try a custom team");
        }
    }


    public void checkVacantTeam(Formula1Driver[] formula1DriversTeam) {
        String[] vacantTeam = new String[formula1DriversTeam.length];
        for (int i = 0; i < formula1DriversTeam.length; i++) {
            vacantTeam[i] = formula1DriversTeam[i].getDriverName();
        }
        if ((vacantTeam[0].equals("~")) || (vacantTeam[1].equals("~")) || (vacantTeam[2].equals("~")) || (vacantTeam[3].equals("~")) || (vacantTeam[4].equals("~")) || (vacantTeam[5].equals("~")) || (vacantTeam[6].equals("~")) || (vacantTeam[7].equals("~0")) || (vacantTeam[8].equals("~")) || (vacantTeam[9].equals("~"))) {
            System.out.println("Vacant teams: ");


            if ((!vacantTeam[0].equals("~")) && (!vacantTeam[1].equals("~")) && (!vacantTeam[2].equals("~")) && (!vacantTeam[3].equals("~")) && (!vacantTeam[4].equals("~")) && (!vacantTeam[5].equals("~")) && (!vacantTeam[6].equals("~")) && (!vacantTeam[7].equals("~")) && (!vacantTeam[8].equals("~")) && (!vacantTeam[9].equals("~"))) {
                System.out.println("NONE of the teams are vacant :(");
                System.out.println("Please try to a the driver to a custom team :D");
                System.out.println("");
                vacantTeams = false;
            } else {
                for (int i = 0; i < vacantTeam.length; i++) {
                    if (vacantTeam[i].equals("~")) {
                        System.out.println(teams.get(i));
                    }
                }
            }
        } else {
//            System.out.println("No vacancy, Please try a custom team");
            vacantTeams = false;
        }
    }


    public void addToCustomTeam() {
        Formula1Driver newFormula1Driver = new Formula1Driver();
        while (true) {
            System.out.println("Enter the full name of the driver or \nenter 999 to return back");
            if (delimiterInput.hasNext()) {
                String name = delimiterInput.next();
                if (name.equals("999")) {
                    break;
                } else {
                    newFormula1Driver.setDriverName(name);

                    System.out.println("Enter the name of your team: ");
                    String teamName = delimiterInput.next().toUpperCase();

                    checkExistingTeam(teamName);

                    if (checkExistingTeamTeamName) {
                        customTeamCheck(teamName);
                        newFormula1Driver.setTeamOfDriver(teamName);

                        if (checkTeamName) {
                            System.out.println("\nEnter the country code you prefer from the following or \nenter 9 to add a custom country");
                            System.out.println("");
                            printCountryTable();
                            System.out.println("");

                            while (true) {
                                System.out.println("Enter the code or enter 9 to add a custom country : ");
                                String country = input.next().toUpperCase();

                                if (country.equalsIgnoreCase("9")) {
                                    System.out.println("Enter the country of the driver :");
                                    String customCountry = delimiterInput.next().toUpperCase();
//                                    customCountryIndex.put(customCountry, countryIndex);
                                    getStatistics();
                                    newFormula1Driver.setFirstPositions(firstPositions);
                                    newFormula1Driver.setSecondPositions(secondPositions);
                                    newFormula1Driver.setThirdPositions(thirdPositions);
                                    newFormula1Driver.setNumberOfRaces(numberOfRaces);
                                    newFormula1Driver.setAchievedSeasons(achievedSeasons);
                                    newFormula1Driver.setCurrentPoints(newFormula1Driver.getCurrentPoints());
                                    newFormula1Driver.setDriverLocation(customCountry);

                                    customTeamArray.add(customTeamIndex, newFormula1Driver);


                                    customTeamIndex++;
                                    System.out.println("Requirement is successfully completed");
                                    System.out.println(name + " was added to the team " + newFormula1Driver.getTeamOfDriver());
                                    System.out.println("");
                                    break;
                                } else {
                                    findCountryCode(country);
                                    if (checkCountryCode) {
//                                        customCountryIndex.put(country, countryIndex);
                                        getStatistics();
                                        newFormula1Driver.setFirstPositions(firstPositions);
                                        newFormula1Driver.setSecondPositions(secondPositions);
                                        newFormula1Driver.setThirdPositions(thirdPositions);
                                        newFormula1Driver.setNumberOfRaces(numberOfRaces);
                                        newFormula1Driver.setAchievedSeasons(achievedSeasons);
                                        newFormula1Driver.setCurrentPoints(newFormula1Driver.getCurrentPoints());
                                        newFormula1Driver.setDriverLocation(countries.get(country));


                                        customTeamArray.add(customTeamIndex, newFormula1Driver);

                                        customTeamIndex++;
                                        System.out.println("Requirement is successfully completed");
                                        System.out.println(name + " was added to the team " + newFormula1Driver.getTeamOfDriver());
                                        System.out.println("");
                                        break;
                                    } else {
                                        System.out.println("Invalid country code! :(");
                                    }
                                }
                            }
                            checkCountryCode = false;
                        } else {
                            System.out.println("Team name was already exist");
                            System.out.println("");
                        }
                        checkTeamName = true;

                    } else {
                        System.out.println("Team name was already exist");
                        System.out.println("");
                    }
                    checkExistingTeamTeamName = true;
                }

            } else {
                System.out.println("Invalid input");
            }
        }
    }

    public void findTeamsNumber(int number) {
        for (int i = 0; i < rangeNumber.length; i++) {
            if (rangeNumber[i] == number) {
                checkNumber = true;
            }
        }
    }

    private void findCountryCode(String countryCode) {
        for (int i = 0; i < countryCodes.length; i++) {
            if (countryCodes[i].equals(countryCode)) {
                checkCountryCode = true;
            }
        }
    }

    public void customTeamCheck(String name) {
        for (int i = 0; i < customTeamArray.size(); i++) {
            if (customTeamArray.get(i).getTeamOfDriver().contains(name)) {
                checkTeamName = false;
            }
        }
    }

    public void checkExistingTeam(String name) {
        for (int i = 0; i < existingTeamsArray.length; i++) {
            if (name.equalsIgnoreCase(existingTeamsArray[i])) {
                checkExistingTeamTeamName = false;
            }
        }
    }


    public void exitTheProgram() {
        thankYou();
        System.out.println("");
        logo();
        run = false;
    }

    public void welcome() {
        System.out.println("     ██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗");
        System.out.println("     ██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝");
        System.out.println("     ██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗  ");
        System.out.println("     ██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝  ");
        System.out.println("     ╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗");
        System.out.println("      ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝");
        System.out.println("");

    }

    public void thankYou() {
        System.out.println("████████╗██╗  ██╗ █████╗ ███╗   ██╗██╗  ██╗    ██╗   ██╗ ██████╗ ██╗   ██╗");
        System.out.println("╚══██╔══╝██║  ██║██╔══██╗████╗  ██║██║ ██╔╝    ╚██╗ ██╔╝██╔═══██╗██║   ██║");
        System.out.println("   ██║   ███████║███████║██╔██╗ ██║█████╔╝      ╚████╔╝ ██║   ██║██║   ██║");
        System.out.println("   ██║   ██╔══██║██╔══██║██║╚██╗██║██╔═██╗       ╚██╔╝  ██║   ██║██║   ██║");
        System.out.println("   ██║   ██║  ██║██║  ██║██║ ╚████║██║  ██╗       ██║   ╚██████╔╝╚██████╔╝");
        System.out.println("   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝       ╚═╝    ╚═════╝  ╚═════╝ ");
    }

    public void logo() {
        System.out.println("  _    _             /'_'_/.-''/                             _______");
        System.out.println("  \\`../ |o_..__     / /__   / /  -= WORLD CHAMPIONSHIP =-   _\\=.o.=/_");
        System.out.println("`.,(_)______(_).>  / ___/  / /                             |_|_____|_|");
        System.out.println("~~~~~~~~~~~~~~~~~~/_/~~~~~/_/~~~~~~~~~~~simulator~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("");
    }

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

    public void getStatistics() {
        while (true) {
            System.out.println("Enter the number of first positions the driver achieved: ");
            if (input.hasNextInt()) {
                firstPositions = input.nextInt();
                break;
            } else {
                System.out.println("Invalid data input");
                System.out.println("");
                input.next();
            }
        }

        while (true) {
            System.out.println("Enter the number of second positions the driver achieved: ");
            if (input.hasNextInt()) {
                secondPositions = input.nextInt();
                break;
            } else {
                System.out.println("Invalid data input");
                System.out.println("");
                input.next();
            }
        }
        while (true) {
            System.out.println("Enter the number of third positions the driver achieved:");
            if (input.hasNextInt()) {
                thirdPositions = input.nextInt();
                break;
            } else {
                System.out.println("Invalid data input");
                System.out.println("");
                input.next();
            }
        }
        while (true) {
            System.out.println("Enter the number of seasons achieved: ");
            if (input.hasNextInt()) {
                achievedSeasons = input.nextInt();
                break;
            }
            System.out.println("Invalid data input");
            System.out.println("");
            input.next();
        }
        while (true) {
            System.out.println("Enter the number of participated races: ");
            if (input.hasNextInt()) {
                numberOfRaces = input.nextInt();
                break;
            } else {
                System.out.println("Invalid data input");
                System.out.println("");
                input.next();
            }
        }
    }

    public void displayTheVariousStatics(Formula1Driver[] formula1DriversTeam) {
        while (checkDisplayTheVariousStatics) {

            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("|         INPUT CODE         |              OPTION                       |");
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("|         1 or SBT           |     Select a driver from pre build team   |");
            System.out.println("|         2 or SCT           |     Select a diver from custom team       |");
            System.out.println("|         9 or BCK           |     Return To the main menu               |");
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("Enter the respective code for your requirement: ");


            if (input.hasNext()) {
                String respond = input.next();
                switch (respond.toUpperCase()) {
                    case "1":
                    case "SBT":
                        System.out.println("+------------------------------------------------------------------------+");
                        System.out.println("|                 Select a driver from pre build team                    |");
                        System.out.println("+------------------------------------------------------------------------+");
                        selectADriverFromPreBuildTeam(formula1DriversTeam);

                        break;

                    case "2":
                    case "SCT":
                        System.out.println("+------------------------------------------------------------------------+");
                        System.out.println("|                   Select a diver from custom team                      |");
                        System.out.println("+------------------------------------------------------------------------+");
                        selectADiverFromCustomTeam();

                        break;

                    case "9":
                    case "BCK":
                        checkDisplayTheVariousStatics = false;
                        break;
                    default:
                        System.out.println("Invalid option selected, 'Input out of range'");
                }
            } else {
                System.out.println("Invalid in-put");                                                                      //if the user input an invalid input, the program will not terminate, just repeat by passing a warning
            }
        }
        checkDisplayTheVariousStatics = true;
    }

    public void checkOccupiedTeams(Formula1Driver[] formula1DriversTeam) {
        String[] occupiedTeams = new String[formula1DriversTeam.length];
        for (int i = 0; i < formula1DriversTeam.length; i++) {
            occupiedTeams[i] = formula1DriversTeam[i].getTeamOfDriver();
        }
        if ((occupiedTeams[0].equals("~")) || (occupiedTeams[1].equals("~")) || (occupiedTeams[2].equals("~")) || (occupiedTeams[3].equals("~")) || (occupiedTeams[4].equals("~")) || (occupiedTeams[5].equals("~")) || (occupiedTeams[6].equals("~")) || (occupiedTeams[7].equals("~")) || (occupiedTeams[8].equals("~")) || (occupiedTeams[9].equals("~"))) {
            System.out.println("Occupied Teams");

            if ((occupiedTeams[0].equals("~")) && (occupiedTeams[1].equals("~")) && (occupiedTeams[2].equals("~")) && (occupiedTeams[3].equals("~")) && (occupiedTeams[4].equals("~")) && (occupiedTeams[5].equals("~")) && (occupiedTeams[6].equals("~")) && (occupiedTeams[7].equals("~")) && (occupiedTeams[8].equals("~")) && (occupiedTeams[9].equals("~"))) {
                System.out.println("None");
                System.out.println("");
//
                occupiedTeam = false;
            } else {
                for (int i = 0; i < occupiedTeams.length; i++) {
                    if (!occupiedTeams[i].equals("~")) {
                        System.out.println(teams.get(i));
                        occupiedTeam = true;
                    }
                }
            }
        }else {
            for (int i = 0; i < occupiedTeams.length; i++) {
                if (!occupiedTeams[i].equals("~")) {
                    System.out.println(teams.get(i));
                    occupiedTeam = true;
                }
            }
        }


    }


    public void selectADriverFromPreBuildTeam(Formula1Driver[] formula1DriversTeam) {
        checkOccupiedTeams(formula1DriversTeam);
        if (occupiedTeam) {
            while (true) {
                System.out.println("Enter the number respective to the team name or \nenter 999 to return back: ");
                if (input.hasNextInt()) {
                    int teamIndex = input.nextInt();
                    if (teamIndex == 999) {
                        break;
                    } else {
                        findTeamsNumber(teamIndex);
                        if (checkNumber) {

                            String positionOne = String.format("%8d", formula1DriversTeam[teamIndex].getFirstPositions());
                            String positionTwo = String.format("%8d", formula1DriversTeam[teamIndex].getSecondPositions());
                            String positionThree = String.format("%8d", formula1DriversTeam[teamIndex].getThirdPositions());


                            System.out.println("+------------------------------------------------------------------------+");
                            System.out.println("Name of the Driver           : " + formula1DriversTeam[teamIndex].getDriverName());
                            System.out.println("");
                            System.out.println("Diver's location             : " + formula1DriversTeam[teamIndex].getDriverLocation());
                            System.out.println("");
                            System.out.println("Diver's team name            : " + formula1DriversTeam[teamIndex].getTeamOfDriver());
                            System.out.println("");
                            System.out.println("Total participated races     : " + formula1DriversTeam[teamIndex].getNumberOfRaces());
                            System.out.println("");
                            System.out.println("Total achieved seasons       : " + formula1DriversTeam[teamIndex].getAchievedSeasons());
                            System.out.println("");
                            System.out.println("Current points of the driver : " + formula1DriversTeam[teamIndex].getCurrentPoints());
                            System.out.println("");
                            System.out.println("");
                            System.out.println("+-----------------------HORIZONTAL HISTOGRAM ANALYSIS--------------------+");
                            System.out.println("");
                            System.out.println("First Positions  =" + positionOne + " |" + ("*").repeat(formula1DriversTeam[teamIndex].getFirstPositions()));
                            System.out.println("Second Positions =" + positionTwo + " |" + ("*").repeat(formula1DriversTeam[teamIndex].getSecondPositions()));
                            System.out.println("Third Positions  =" + positionThree + " |" + ("*").repeat(formula1DriversTeam[teamIndex].getThirdPositions()));

                            System.out.println("+------------------------------------------------------------------------+");
                        } else {
                            System.out.println("Team number out of range...");
                        }
                    }
                }
                else {
                    System.out.println("Invalid data input");
                    System.out.println("");
                    input.next();
                }
            }
        } else {
            System.out.println("Please add a team before this function :-(");
        }
        occupiedTeam = true;
    }

    public void checkCustomOccupiedTeams() {
        if (customTeamArray.size() > 0) {
            for (int i = 0; i < customTeamArray.size(); i++) {
                System.out.println(i + " - " + customTeamArray.get(i).getTeamOfDriver());
                checkCustomOccupiedTeam = true;
            }
        } else {
            System.out.println("None");
            System.out.println("");
            checkCustomOccupiedTeam = false;
        }
    }

    public void selectADiverFromCustomTeam(){
        checkCustomOccupiedTeams();
        if (checkCustomOccupiedTeam){
            while(true){
                System.out.println("Enter the number respective to the team name or \nenter 999 to return back: ");
                if(input.hasNextInt()){
                    int customTeamIndex = input.nextInt();
                    if (customTeamIndex == 999){
                        break;
                    }else {
                        if ((customTeamIndex >= 0) && (customTeamIndex < customTeamArray.size())){
                            String positionOne = String.format("%8d",customTeamArray.get(customTeamIndex).getFirstPositions());
                            String positionTwo = String.format("%8d",customTeamArray.get(customTeamIndex).getSecondPositions());
                            String positionThree = String.format("%8d",customTeamArray.get(customTeamIndex).getThirdPositions());

                            System.out.println("+------------------------------------------------------------------------+");
                            System.out.println("Name of the Driver           : " + customTeamArray.get(customTeamIndex).getDriverName());
                            System.out.println("");
                            System.out.println("Diver's location             : " + customTeamArray.get(customTeamIndex).getDriverLocation());
                            System.out.println("");
                            System.out.println("Diver's team name            : " + customTeamArray.get(customTeamIndex).getTeamOfDriver());
                            System.out.println("");
                            System.out.println("Total participated races     : " + customTeamArray.get(customTeamIndex).getNumberOfRaces());
                            System.out.println("");
                            System.out.println("Total achieved seasons       : " + customTeamArray.get(customTeamIndex).getAchievedSeasons());
                            System.out.println("");
                            System.out.println("Current points of the driver : " + customTeamArray.get(customTeamIndex).getCurrentPoints());
                            System.out.println("");
                            System.out.println("");
                            System.out.println("+-----------------------HORIZONTAL HISTOGRAM ANALYSIS--------------------+");
                            System.out.println("");
                            System.out.println("First Positions  =" + positionOne + " |" + ("*").repeat(customTeamArray.get(customTeamIndex).getFirstPositions()));
                            System.out.println("Second Positions =" + positionTwo + " |" + ("*").repeat(customTeamArray.get(customTeamIndex).getSecondPositions()));
                            System.out.println("Third Positions  =" + positionThree + " |" + ("*").repeat(customTeamArray.get(customTeamIndex).getThirdPositions()));

                            System.out.println("+------------------------------------------------------------------------+");


                        }else {
                            System.out.println("Invalid input range");
                        }
                    }

                }else {
                    System.out.println("Invalid data input");
                    System.out.println("");
                    input.next();
                }
            }

        }else{
            System.out.println("Please add a team before this function :-(");
        }
    }

}

