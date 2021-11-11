import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formula1ChampionshipManager<HashTable> implements ChampionshipManager {
    public Scanner input = new Scanner(System.in);
    public Scanner delimiterInput = new Scanner(System.in).useDelimiter("\n");
    private int customTeamIndex = 0;
    private static boolean run = true;
    private int[] rangeNumber = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private String[] countryCodes = {"ARG", "AUS", "AUT", "BHR", "BEL", "BRA", "CAN", "CHL", "COL", "CZE", "DNK", "FIN", "FRA", "DEU", "HUN", "IND", "IRL", "ITA", "JPN", "LIE", "MYS", "MEX", "MCO", "MAR", "NLD", "NZL", "POL", "PRT", "RUS", "ZAF", "ESP", "SWE", "CHE", "THA", "GBR", "USA", "URY", "VEN", "ARE"};
    public String[] existingTeamsArray = {"MERCEDES", "RED BULL", "MCLAREN", "FERRARI", "ALPINE", "ALFA TAURI", "ASTON MARTIN", "WILLIAMS", "ALFA ROMEO RACING", "HAAS F1 TEAM"};
    private static boolean checkNumber = false, checkCountryCode = false, checkSuggestions = false;
    private static boolean checkExistingTeamName = true, checkDisplayTheVariousStatics = true, checkCreateANewDriver = true, vacantTeams = true, occupiedTeam = true, checkCustomOccupiedTeam = true, checkDeleteADriverAndTeam = true, checkChangeTheDriver = true, checkDriverName = true;
    private int firstPositions, secondPositions, thirdPositions, achievedSeasons, currentPoints, numberOfRaces;
    private static boolean checkTeamName = true;
    private String stringDate = new String();


    Hashtable<Integer, String> teams = new Hashtable<Integer, String>();
    Hashtable<String, String> countries = new Hashtable<String, String>();
    //    Hashtable<String, Integer> customCountryIndex = new Hashtable<String, Integer>();
    ArrayList<Formula1Driver> customTeamArray = new ArrayList<Formula1Driver>();
    ArrayList<Formula1Driver> finalTeamArray = new ArrayList<Formula1Driver>();
    ArrayList<Formula1Driver> sortTeamArray = new ArrayList<Formula1Driver>();
    ArrayList<String> dateArray = new ArrayList<String>();


    public static void main(String[] args) {
        Formula1ChampionshipManager championManager = new Formula1ChampionshipManager();
        Formula1Driver[] formula1DriversTeam = new Formula1Driver[10];

//        championManager.initialize(formula1DriversTeam);
        championManager.welcome();
        championManager.logo();

        while (run) {
            championManager.printMenu();
            championManager.mainMenu();
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
        System.out.println("|           999 or EXT         |       Exit the program                  |");
        System.out.println("+------------------------------------------------------------------------+");

        System.out.println("Enter the respective code for your requirement: ");


    }


    public void mainMenu() {
        if (delimiterInput.hasNext()) {
            String option = delimiterInput.next();
            switch (option.toUpperCase()) {
                case "100":
                case "CND":
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                          Create a New Driver                           |");
                    System.out.println("+------------------------------------------------------------------------+");
                    createANewDriver(existingTeamsArray);
                    break;

                case "101":
                case "DDT":
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                         Delete a Driver and Team                       |");
                    System.out.println("+------------------------------------------------------------------------+");
//                    deleteADriverAndTeam(formula1DriversTeam);
                    deleteADiverFromCustomTeam();
                    break;

                case "102":
                case "CTD":
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                           Change the Driver                            |");
                    System.out.println("|        ^_^ WARNING the team will be deleted from the system            |");
                    System.out.println("|         while changing the driver to an existing team ^_^              |");
                    System.out.println("+------------------------------------------------------------------------+");
//                    changeTheDriver(formula1DriversTeam);
                    changeTheDriver();
                    break;

                case "103":
                case "DVS":
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                       Display the Various Statics                      |");
                    System.out.println("+------------------------------------------------------------------------+");
//                    displayTheVariousStatics(formula1DriversTeam);
                    selectADiverFromCustomTeam();
                    break;


                case "104":
                case "DFT":
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                      Display Formula1 Driver Table                     |");
                    System.out.println("+------------------------------------------------------------------------+");
//                    displayFormula1DriverTable(formula1DriversTeam);
//                    displayFormula1DriverTable();
                    formula1DriversTable();
                    break;

                case "105":
                case "ARC":
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                             Add a Race Completed                       |");
                    System.out.println("+------------------------------------------------------------------------+");
                    addARaceCompleted();
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

//    public void initialize(Formula1Driver[] formula1DriversTeam) {
//        for (int i = 0; i < formula1DriversTeam.length; i++) {
//            formula1DriversTeam[i] = new Formula1Driver("~", "~", "~", 0, 0, 0, 0, 0, 0, 0);
//        }
//        teams.put(0, " 0 - MERCEDES");
//        teams.put(1, " 1 - RED BULL");
//        teams.put(2, " 2 - MCLAREN");
//        teams.put(3, " 3 - FERRARI");
//        teams.put(4, " 4 - ALPINE");
//        teams.put(5, " 5 - ALFA TAURI");
//        teams.put(6, " 6 - ASTON MARTIN");
//        teams.put(7, " 7 - WILLIAMS");
//        teams.put(8, " 8 - ALFA ROMEO RACING");
//        teams.put(9, " 9 - HAAS F1 TEAM");
//    }


//    public void createANewDriver(Formula1Driver[] formula1DriversTeam,String[] existingTeamsArray) {
//        while (checkCreateANewDriver) {
//
//            System.out.println("+------------------------------------------------------------------------+");
//            System.out.println("|         INPUT CODE         |              OPTION                       |");
//            System.out.println("+------------------------------------------------------------------------+");
//            System.out.println("|         1 or AET           |     Add a driver to an existing team      |");
//            System.out.println("|         2 or ACT           |     Add a driver to a custom team         |");
//            System.out.println("|         9 or BCK           |     Return To the main menu               |");
//            System.out.println("+------------------------------------------------------------------------+");
//            System.out.println("Enter the respective code for your requirement: ");
//
//
//            if (input.hasNext()) {
//                String respond = input.next();
//                switch (respond.toUpperCase()) {
//                    case "1":
//                    case "AET":
//                        System.out.println("+------------------------------------------------------------------------+");
//                        System.out.println("|                    Add a driver to an existing team                    |");
//                        System.out.println("+------------------------------------------------------------------------+");
//                        addToExistingTeam(formula1DriversTeam);
//                        break;
//
//                    case "2":
//                    case "ACT":
//                        System.out.println("+------------------------------------------------------------------------+");
//                        System.out.println("|                     Add a driver to a custom team                      |");
//                        System.out.println("+------------------------------------------------------------------------+");
//                        addToCustomTeam(existingTeamsArray);
//                        break;
//
//                    case "9":
//                    case "BCK":
//                        checkCreateANewDriver = false;
//                        break;
//                    default:
//                        System.out.println("Invalid option selected, 'Input out of range'");
//                }
//            } else {
//                System.out.println("Invalid in-put");                                                                      //if the user input an invalid input, the program will not terminate, just repeat by passing a warning
//            }
//        }
//        checkCreateANewDriver = true;
//
//    }


    public void Suggestions(String[] existingTeamsArray) {
        System.out.println("Suggestions:- ");
        if (customTeamArray.size() == 0) {
            for (int i = 0; i < existingTeamsArray.length; i++) {
                System.out.println(existingTeamsArray[i]);
                checkSuggestions = true;
            }

        } else {
            for (int i = 0; i < existingTeamsArray.length; i++) {
                for (int j = 0; j < customTeamArray.size(); j++) {
                    if (!(customTeamArray.get(j).getTeamOfDriver().contains(existingTeamsArray[i]))) {
                        System.out.println(existingTeamsArray[i]);
                        checkSuggestions = true;
                    }
                }
            }
        }

    }

//    public void addToExistingTeam(Formula1Driver[] formula1DriversTeam) {
//        checkVacantTeam(formula1DriversTeam);
//        if (vacantTeams) {
//            while (true) {
//                System.out.println("Enter the respective number of the team you prefer or \nenter 999 to return back : ");
//                if (input.hasNextInt()) {
//                    int teamNumber = input.nextInt();
//                    if (teamNumber == 999) {
//                        break;
//                    } else {
//                        findTeamsNumber(teamNumber);
//                        if (checkNumber) {
//                            if (!formula1DriversTeam[teamNumber].getDriverName().equals("~")) {
//                                System.out.println("Already the team has a driver");
//                            } else {
//                                System.out.println("Enter the name of the driver");
//                                if (delimiterInput.hasNext()) {
//                                    String name = delimiterInput.next();
//                                    System.out.println("");
//                                    System.out.println("Enter the country code you prefer from the following or \nenter 9 to add a custom country:  ");
//
//                                    printCountryTable();
//                                    System.out.println("");
//
//                                    while (true) {
//
//                                        System.out.println("Enter the code or enter 9 to add a custom country : ");
//                                        String country = input.next().toUpperCase();
//                                        if (country.equalsIgnoreCase("9")) {
//                                            System.out.println("Enter the country of the driver :");
//                                            String customCountry = delimiterInput.next().toUpperCase();
//                                            getStatistics();
//
//                                            formula1DriversTeam[teamNumber].setDriverLocation(customCountry);
//                                            formula1DriversTeam[teamNumber].setFirstPositions(firstPositions);
//                                            formula1DriversTeam[teamNumber].setSecondPositions(secondPositions);
//                                            formula1DriversTeam[teamNumber].setThirdPositions(thirdPositions);
//                                            formula1DriversTeam[teamNumber].setAchievedSeasons(achievedSeasons);
//                                            formula1DriversTeam[teamNumber].setNumberOfRaces(numberOfRaces);
//                                            formula1DriversTeam[teamNumber].setTeamOfDriver(teams.get(teamNumber));
//                                            formula1DriversTeam[teamNumber].setCurrentPoints(currentPoints);
//
//
//                                            break;
//                                        } else {
//                                            findCountryCode(country);
//                                            if (checkCountryCode) {
//                                                getStatistics();
//
//                                                formula1DriversTeam[teamNumber].setDriverLocation(countries.get(country));
//                                                formula1DriversTeam[teamNumber].setFirstPositions(firstPositions);
//                                                formula1DriversTeam[teamNumber].setSecondPositions(secondPositions);
//                                                formula1DriversTeam[teamNumber].setThirdPositions(thirdPositions);
//                                                formula1DriversTeam[teamNumber].setAchievedSeasons(achievedSeasons);
//                                                formula1DriversTeam[teamNumber].setNumberOfRaces(numberOfRaces);
//                                                formula1DriversTeam[teamNumber].setTeamOfDriver(teams.get(teamNumber));
//                                                formula1DriversTeam[teamNumber].setCurrentPoints(currentPoints);
//
//                                                break;
//                                            } else {
//                                                System.out.println("Invalid country code! :(");
//                                            }
//                                        }
//                                    }
//
//
//                                    formula1DriversTeam[teamNumber].setDriverName(name.toUpperCase());
//
//                                    System.out.println("");
//                                    System.out.println("Requirement is successfully completed");
//                                    System.out.println(name + " was added to the team " + teams.get(teamNumber));
//
//                                } else {
//                                    System.out.println("Invalid input data type, String Required");
//                                    input.next();
//                                }
//                            }
//                        } else {
//                            System.out.println("Team number is out of range");
//
//                        }
//
//                    }
//
//                } else {
//                    System.out.println("Invalid input data type, Integer Required");
//                    input.next();
//                }
//                checkNumber = false;
//                checkCountryCode = false;
//
//            }
//        } else {
//            System.out.println("No vacancy, Please try a custom team");
//        }
//    }

//    public void checkVacantTeam(Formula1Driver[] formula1DriversTeam) {
//        String[] vacantTeam = new String[formula1DriversTeam.length];
//        for (int i = 0; i < formula1DriversTeam.length; i++) {
//            vacantTeam[i] = formula1DriversTeam[i].getDriverName();
//        }
//        if ((vacantTeam[0].equals("~")) || (vacantTeam[1].equals("~")) || (vacantTeam[2].equals("~")) || (vacantTeam[3].equals("~")) || (vacantTeam[4].equals("~")) || (vacantTeam[5].equals("~")) || (vacantTeam[6].equals("~")) || (vacantTeam[7].equals("~0")) || (vacantTeam[8].equals("~")) || (vacantTeam[9].equals("~"))) {
//            System.out.println("Vacant teams: ");
//
//
//            if ((!vacantTeam[0].equals("~")) && (!vacantTeam[1].equals("~")) && (!vacantTeam[2].equals("~")) && (!vacantTeam[3].equals("~")) && (!vacantTeam[4].equals("~")) && (!vacantTeam[5].equals("~")) && (!vacantTeam[6].equals("~")) && (!vacantTeam[7].equals("~")) && (!vacantTeam[8].equals("~")) && (!vacantTeam[9].equals("~"))) {
//                System.out.println("NONE of the teams are vacant :(");
//                System.out.println("Please try to a the driver to a custom team :D");
//                System.out.println("");
//                vacantTeams = false;
//            } else {
//                for (int i = 0; i < vacantTeam.length; i++) {
//                    if (vacantTeam[i].equals("~")) {
//                        System.out.println(teams.get(i));
//                    }
//                }
//            }
//        } else {
////            System.out.println("No vacancy, Please try a custom team");
//            vacantTeams = false;
//        }
//        vacantTeams = true;
//    }


//    public void addToCustomTeam(String[] existingTeamsArray) {
//
//        while (true) {
//            System.out.println("Enter the full name of the driver or \nenter 999 to return back");
//            if (delimiterInput.hasNext()) {
//                String name = delimiterInput.next();
//                if (name.equals("999")) {
//                    break;
//                } else {
//                    System.out.println("Enter the name of your team: ");
////                    Suggestions(existingTeamsArray);
//
////                    if (!checkSuggestions) {
////                        System.out.println("NONE");
////                    }
//                    String teamName = delimiterInput.next().toUpperCase();
//
//
////                    checkExistingTeam(teamName);
//
////                    if (checkExistingTeamTeamName) {
//                    customTeamCheck(teamName);
//
//                    if (checkTeamName) {
//                        System.out.println("\nEnter the country code you prefer from the following or \nenter 9 to add a custom country");
//                        System.out.println("");
//                        printCountryTable();
//                        System.out.println("");
//
//                        while (true) {
//                            Formula1Driver newFormula1Driver = new Formula1Driver();
//                            System.out.println("Enter the code or enter 9 to add a custom country : ");
//                            String country = input.next().toUpperCase();
//
//                            if (country.equalsIgnoreCase("9")) {
//                                System.out.println("Enter the country of the driver :");
//                                String customCountry = delimiterInput.next().toUpperCase();
////                                    customCountryIndex.put(customCountry, countryIndex);
//                                getStatistics();
//                                newFormula1Driver.setDriverName(name);
//                                newFormula1Driver.setTeamOfDriver(teamName);
//                                newFormula1Driver.setFirstPositions(firstPositions);
//                                newFormula1Driver.setSecondPositions(secondPositions);
//                                newFormula1Driver.setThirdPositions(thirdPositions);
//                                newFormula1Driver.setNumberOfRaces(numberOfRaces);
//                                newFormula1Driver.setAchievedSeasons(achievedSeasons);
//                                newFormula1Driver.setCurrentPoints(currentPoints);
//                                newFormula1Driver.setDriverLocation(customCountry);
//
//                                customTeamArray.add(newFormula1Driver);
//
//
////                                customTeamIndex++;
//                                System.out.println("Requirement is successfully completed");
//                                System.out.println(name + " was added to the team " + newFormula1Driver.getTeamOfDriver());
//                                System.out.println("");
//                                break;
//                            } else {
//                                findCountryCode(country);
//                                if (checkCountryCode) {
////                                        customCountryIndex.put(country, countryIndex);
//                                    getStatistics();
//                                    newFormula1Driver.setDriverName(name);
//                                    newFormula1Driver.setTeamOfDriver(teamName);
//                                    newFormula1Driver.setFirstPositions(firstPositions);
//                                    newFormula1Driver.setSecondPositions(secondPositions);
//                                    newFormula1Driver.setThirdPositions(thirdPositions);
//                                    newFormula1Driver.setNumberOfRaces(numberOfRaces);
//                                    newFormula1Driver.setAchievedSeasons(achievedSeasons);
//                                    newFormula1Driver.setDriverLocation(countries.get(country));
//                                    newFormula1Driver.setCurrentPoints(currentPoints);
//
//
//                                    customTeamArray.add(newFormula1Driver);
//
//                                    customTeamIndex++;
//                                    System.out.println("Requirement is successfully completed");
//                                    System.out.println(name + " was added to the team " + newFormula1Driver.getTeamOfDriver());
//                                    System.out.println("");
//                                    break;
//                                } else {
//                                    System.out.println("Invalid country code! :(");
//                                }
//                            }
//                        }
//                        checkCountryCode = false;
////                        } else {
////                            System.out.println("Team name was already exist");
////                            System.out.println("");
////                        }
//                        checkTeamName = true;
//
//                    } else {
//                        System.out.println("Team name was already exist");
//                        System.out.println("");
//                    }
////                    checkExistingTeamTeamName = true;
//                }
//
//            } else {
//                System.out.println("Invalid input");
//
//            }
//        }
//        checkSuggestions = false;
//    }


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
//                            Formula1Driver newFormula1Driver = new Formula1Driver();
                                System.out.println("Enter the code or enter 9 to add a custom country : ");
                                String country = input.next().toUpperCase();

                                if (country.equalsIgnoreCase("9")) {
                                    System.out.println("Enter the country of the driver : ");
                                    String customCountry = delimiterInput.next().toUpperCase();

                                    getStatistics();
//                                newFormula1Driver.setDriverName(name);
//                                newFormula1Driver.setTeamOfDriver(teamName);
//                                newFormula1Driver.setDriverLocation(customCountry);
//                                newFormula1Driver.setFirstPositions(firstPositions);
//                                newFormula1Driver.setSecondPositions(secondPositions);
//                                newFormula1Driver.setThirdPositions(thirdPositions);
//                                newFormula1Driver.setNumberOfRaces(numberOfRaces);
//                                newFormula1Driver.setAchievedSeasons(achievedSeasons);
//                                newFormula1Driver.setCurrentPoints(currentPoints);

                                    customTeamArray.add(new Formula1Driver(name, customCountry, teamName, firstPositions, secondPositions, thirdPositions, achievedSeasons, currentPoints, numberOfRaces));
//                                customTeamArray.add(newFormula1Driver);

                                    System.out.println("Requirement is successfully completed");
                                System.out.println(name + " was added to the team " + teamName);
                                    System.out.println("");
                                    break;


                                } else {
                                    findCountryCode(country);
                                    if (checkCountryCode) {
                                        getStatistics();
//                                    newFormula1Driver.setDriverName(name);
//                                    newFormula1Driver.setTeamOfDriver(teamName);
//                                    newFormula1Driver.setDriverLocation(countries.get(country));
//                                    newFormula1Driver.setFirstPositions(firstPositions);
//                                    newFormula1Driver.setSecondPositions(secondPositions);
//                                    newFormula1Driver.setThirdPositions(thirdPositions);
//                                    newFormula1Driver.setNumberOfRaces(numberOfRaces);
//                                    newFormula1Driver.setAchievedSeasons(achievedSeasons);
//                                    newFormula1Driver.setCurrentPoints(currentPoints);

//                                    customTeamArray.add(newFormula1Driver);
                                        customTeamArray.add(new Formula1Driver(name, countries.get(country), teamName, firstPositions, secondPositions, thirdPositions, achievedSeasons, currentPoints, numberOfRaces));

                                        System.out.println("Requirement is successfully completed");
                                    System.out.println(name + " was added to the team " + teamName);
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
//                    checkTeamName = true;
                    }
                } else {
                    System.out.println("Driver name was already exist");
                    System.out.println("");
                }
                checkDriverName = true;

            } else {
                System.out.println("Invalid data input");
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

    public void customTeamCheck(String teamName) {
        for (Formula1Driver f1d : customTeamArray) {
            if (f1d.getTeamOfDriver().equals(teamName)) {
                checkTeamName = false;
            } else {
                checkTeamName = true;
            }
        }
//        for (int i = 0; i < customTeamArray.size(); i++) {
//            if (customTeamArray.get(i).getTeamOfDriver().contains(teamName)) {
//                checkTeamName = false;
//            } else {
//                checkTeamName = true;
//            }
//        }
    }

    public void driverNameCheck(String driverName) {
        for (int i = 0; i < customTeamArray.size(); i++) {
            if (customTeamArray.get(i).getDriverName().contains(driverName)) {
                checkDriverName = false;
            }
        }
    }


//    public void checkExistingTeam(String name) {
//        for (int i = 0; i < existingTeamsArray.length; i++) {
//            if (name.equalsIgnoreCase(existingTeamsArray[i])) {
//                checkExistingTeamTeamName = false;
//            }
//        }
//    }


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
                if (firstPositions >= 0) {
                    break;
                } else {
                    System.out.println("Please input a valid number");
                }
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
                if (secondPositions >= 0) {
                    break;
                } else {
                    System.out.println("Please input a valid number");
                }
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
                if (thirdPositions >= 0) {
                    break;
                } else {
                    System.out.println("Please input a valid number");
                }
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
                if (achievedSeasons >= 0) {
                    break;
                } else {
                    System.out.println("Please input a valid number");
                }
            } else {
                System.out.println("Invalid data input");
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
                    System.out.println("Please input a valid number");
                }
            } else {
                System.out.println("Invalid data input");
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
                    System.out.println("Please input a valid number");
                }
            } else {
                System.out.println("Invalid data input");
                System.out.println("");
                input.next();
            }
        }

    }

//    public void displayTheVariousStatics(Formula1Driver[] formula1DriversTeam) {
//        while (checkDisplayTheVariousStatics) {
//
//            System.out.println("+------------------------------------------------------------------------+");
//            System.out.println("|         INPUT CODE         |              OPTION                       |");
//            System.out.println("+------------------------------------------------------------------------+");
//            System.out.println("|         1 or SBT           |     Select a driver from pre build team   |");
//            System.out.println("|         2 or SCT           |     Select a diver from custom team       |");
//            System.out.println("|         9 or BCK           |     Return To the main menu               |");
//            System.out.println("+------------------------------------------------------------------------+");
//            System.out.println("Enter the respective code for your requirement: ");
//
//
//            if (input.hasNext()) {
//                String respond = input.next();
//                switch (respond.toUpperCase()) {
//                    case "1":
//                    case "SBT":
//                        System.out.println("+------------------------------------------------------------------------+");
//                        System.out.println("|                 Select a driver from pre build team                    |");
//                        System.out.println("+------------------------------------------------------------------------+");
//                        selectADriverFromPreBuildTeam(formula1DriversTeam);
//
//                        break;
//
//                    case "2":
//                    case "SCT":
//                        System.out.println("+------------------------------------------------------------------------+");
//                        System.out.println("|                   Select a diver from custom team                      |");
//                        System.out.println("+------------------------------------------------------------------------+");
//                        selectADiverFromCustomTeam();
//
//                        break;
//
//                    case "9":
//                    case "BCK":
//                        checkDisplayTheVariousStatics = false;
//                        break;
//                    default:
//                        System.out.println("Invalid option selected, 'Input out of range'");
//                }
//            } else {
//                System.out.println("Invalid in-put");                                                                      //if the user input an invalid input, the program will not terminate, just repeat by passing a warning
//            }
//        }
//        checkDisplayTheVariousStatics = true;
//    }

//    public void checkOccupiedTeams(Formula1Driver[] formula1DriversTeam) {
//        String[] occupiedTeams = new String[formula1DriversTeam.length];
//        for (int i = 0; i < formula1DriversTeam.length; i++) {
//            occupiedTeams[i] = formula1DriversTeam[i].getTeamOfDriver();
//        }
//        if ((occupiedTeams[0].equals("~")) || (occupiedTeams[1].equals("~")) || (occupiedTeams[2].equals("~")) || (occupiedTeams[3].equals("~")) || (occupiedTeams[4].equals("~")) || (occupiedTeams[5].equals("~")) || (occupiedTeams[6].equals("~")) || (occupiedTeams[7].equals("~")) || (occupiedTeams[8].equals("~")) || (occupiedTeams[9].equals("~"))) {
//            System.out.println("Occupied Teams");
//
//            if ((occupiedTeams[0].equals("~")) && (occupiedTeams[1].equals("~")) && (occupiedTeams[2].equals("~")) && (occupiedTeams[3].equals("~")) && (occupiedTeams[4].equals("~")) && (occupiedTeams[5].equals("~")) && (occupiedTeams[6].equals("~")) && (occupiedTeams[7].equals("~")) && (occupiedTeams[8].equals("~")) && (occupiedTeams[9].equals("~"))) {
//                System.out.println("None");
//                System.out.println("");
////
//                occupiedTeam = false;
//            } else {
//                for (int i = 0; i < occupiedTeams.length; i++) {
//                    if (!occupiedTeams[i].equals("~")) {
//                        System.out.println(teams.get(i));
//                        occupiedTeam = true;
//                    }
//                }
//            }
//        } else {
//            for (int i = 0; i < occupiedTeams.length; i++) {
//                if (!occupiedTeams[i].equals("~")) {
//                    System.out.println(teams.get(i));
//                    occupiedTeam = true;
//                }
//            }
//        }
//    }


//    public void selectADriverFromPreBuildTeam(Formula1Driver[] formula1DriversTeam) {
//        checkOccupiedTeams(formula1DriversTeam);
//        if (occupiedTeam) {
//            while (true) {
//                System.out.println("Enter the number respective to the team name or \nenter 999 to return back: ");
//                if (input.hasNextInt()) {
//                    int teamIndex = input.nextInt();
//                    if (teamIndex == 999) {
//                        break;
//                    } else {
//                        findTeamsNumber(teamIndex);
//                        if (checkNumber) {
//
//                            String positionOne = String.format("%8d", formula1DriversTeam[teamIndex].getFirstPositions());
//                            String positionTwo = String.format("%8d", formula1DriversTeam[teamIndex].getSecondPositions());
//                            String positionThree = String.format("%8d", formula1DriversTeam[teamIndex].getThirdPositions());
//
//
//                            System.out.println("+------------------------------------------------------------------------+");
//                            System.out.println("Name of the Driver           : " + formula1DriversTeam[teamIndex].getDriverName());
//                            System.out.println("");
//                            System.out.println("Diver's location             : " + formula1DriversTeam[teamIndex].getDriverLocation());
//                            System.out.println("");
//                            System.out.println("Diver's team name            : " + formula1DriversTeam[teamIndex].getTeamOfDriver());
//                            System.out.println("");
//                            System.out.println("Total participated races     : " + formula1DriversTeam[teamIndex].getNumberOfRaces());
//                            System.out.println("");
//                            System.out.println("Total achieved seasons       : " + formula1DriversTeam[teamIndex].getAchievedSeasons());
//                            System.out.println("");
//                            System.out.println("Current points of the driver : " + formula1DriversTeam[teamIndex].getCurrentPoints());
//                            System.out.println("");
//                            System.out.println("");
//                            System.out.println("+-----------------------HORIZONTAL HISTOGRAM ANALYSIS--------------------+");
//                            System.out.println("");
//                            System.out.println("First Positions  =" + positionOne + " |" + ("*").repeat(formula1DriversTeam[teamIndex].getFirstPositions()));
//                            System.out.println("Second Positions =" + positionTwo + " |" + ("*").repeat(formula1DriversTeam[teamIndex].getSecondPositions()));
//                            System.out.println("Third Positions  =" + positionThree + " |" + ("*").repeat(formula1DriversTeam[teamIndex].getThirdPositions()));
//
//                            System.out.println("+------------------------------------------------------------------------+");
//                        } else {
//                            System.out.println("Team number out of range...");
//                        }
//                    }
//                } else {
//                    System.out.println("Invalid data input");
//                    System.out.println("");
//                    input.next();
//                }
//                checkNumber = false;
//            }
//        } else {
//            System.out.println("Please add a team before this function :-(");
//        }
//        occupiedTeam = true;
//    }

    public void checkCustomOccupiedTeams() {
        if (customTeamArray.size() > 0) {
            for (int i = 0; i < customTeamArray.size(); i++) {
                System.out.println(i + " - " + customTeamArray.get(i).getTeamOfDriver() + " \n\tDriver : " +customTeamArray.get(i).getDriverName() + "\n");
                checkCustomOccupiedTeam = true;
            }
        } else {
            System.out.println("None");
            System.out.println("");
            checkCustomOccupiedTeam = false;
        }
    }

    public void selectADiverFromCustomTeam() {
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
                            System.out.println("Invalid input range");
                        }
                    }

                } else {
                    System.out.println("Invalid data input");
                    System.out.println("");
                    input.next();
                }
            }

        } else {
            System.out.println("Please add a team before this function :-(");
        }
    }

//    public void deleteADriverAndTeam(Formula1Driver[] formula1DriversTeam) {
//        while (checkDeleteADriverAndTeam) {
//
//            System.out.println("+------------------------------------------------------------------------+");
//            System.out.println("|         INPUT CODE  |              OPTION                              |");
//            System.out.println("+------------------------------------------------------------------------+");
//            System.out.println("|         1 or DBT    | Delete a driver and the team from pre build team |");
//            System.out.println("|         2 or DCT    | Delete a diver and the team from custom team     |");
//            System.out.println("|         9 or BCK    | Return To the main menu                          |");
//            System.out.println("+------------------------------------------------------------------------+");
//            System.out.println("Enter the respective code for your requirement: ");
//
//
//            if (input.hasNext()) {
//                String respond = input.next();
//                switch (respond.toUpperCase()) {
//                    case "1":
//                    case "DBT":
//                        System.out.println("+------------------------------------------------------------------------+");
//                        System.out.println("|                 Delete a driver from pre build team                    |");
//                        System.out.println("+------------------------------------------------------------------------+");
//                        deleteADriverFromPreBuildTeam(formula1DriversTeam);
//
//
//                        break;
//
//                    case "2":
//                    case "DCT":
//                        System.out.println("+------------------------------------------------------------------------+");
//                        System.out.println("|                   Delete a diver from custom team                      |");
//                        System.out.println("+------------------------------------------------------------------------+");
//                        deleteADiverFromCustomTeam();
//                        break;
//
//                    case "9":
//                    case "BCK":
//                        checkDeleteADriverAndTeam = false;
//                        break;
//                    default:
//                        System.out.println("Invalid option selected, 'Input out of range'");
//                }
//            } else {
//                System.out.println("Invalid in-put");                                                                      //if the user input an invalid input, the program will not terminate, just repeat by passing a warning
//            }
//        }
//        checkDeleteADriverAndTeam = true;
//    }

//    public void deleteADriverFromPreBuildTeam(Formula1Driver[] formula1DriversTeam) {
//        checkOccupiedTeams(formula1DriversTeam);
//        if (occupiedTeam) {
//            finalTeamArray.clear();
//            while (true) {
//                System.out.println("Enter the number respective to the team name or \nenter 999 to return back: ");
//                if (input.hasNextInt()) {
//                    int teamNumber = input.nextInt();
//                    if (teamNumber == 999) {
//                        break;
//                    } else {
//                        findTeamsNumber(teamNumber);
//                        if (checkNumber) {
//                            if (formula1DriversTeam[teamNumber].getDriverName().equals("~")) {
//                                System.out.println("Already the team" + formula1DriversTeam[teamNumber].getTeamOfDriver() + "is vacant");
//                            } else {
//                                formula1DriversTeam[teamNumber].setDriverLocation("~");
//                                formula1DriversTeam[teamNumber].setFirstPositions(0);
//                                formula1DriversTeam[teamNumber].setSecondPositions(0);
//                                formula1DriversTeam[teamNumber].setThirdPositions(0);
//                                formula1DriversTeam[teamNumber].setAchievedSeasons(0);
//                                formula1DriversTeam[teamNumber].setNumberOfRaces(0);
//                                formula1DriversTeam[teamNumber].setTeamOfDriver("~");
//                                formula1DriversTeam[teamNumber].setDriverName("~");
//                                formula1DriversTeam[teamNumber].setCurrentPoints(0);
//
//                                System.out.println("Request successfully completed");
//                            }
//
//                        } else {
//                            System.out.println("Invalid input range");
//                        }
//                    }
//                } else {
//                    System.out.println("Invalid input data type, Integer required");
//                    input.next();
//                }
//                checkNumber = false;
//            }
//        } else {
//            System.out.println("Please add a team before this function :-(");
//        }
//        occupiedTeam = false;
//    }

    public void deleteADiverFromCustomTeam() {
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
                            System.out.println("Request successfully completed");
                            break;

                        } else {
                            System.out.println("Invalid input range");
                        }
                    }

                } else {
                    System.out.println("Invalid data input");
                    System.out.println("");
                    input.next();
                }
            }
        } else {
            System.out.println("Please add a team before this function :-(");
        }
    }

//    public void addAllToAnArrayList(Formula1Driver[] formula1DriversTeam) {
//        for (int i = 0; i < formula1DriversTeam.length; i++) {
//            if ((!formula1DriversTeam[i].getDriverName().equals("~")) && (!formula1DriversTeam[i].getDriverName().equals("~"))) {
//                finalTeamArray.add(formula1DriversTeam[i]);
//            } else {
//                continue;
//            }
//        }
//
//        for (int i = 0; i < customTeamArray.size(); i++) {
//            finalTeamArray.add(customTeamArray.get(i));
//        }
//    }

//    public void checkFinalArray() {
//        if (finalTeamArray.size() > 0) {
//            System.out.println("All the occupied teams in the system");
//            for (int i = 0; i < finalTeamArray.size(); i++) {
//                System.out.println(i + finalTeamArray.get(i).getTeamOfDriver() + " - " + finalTeamArray.get(i).getDriverName());
//            }
//        } else {
//            System.out.println("Please add teams");
//        }
//    }


//    public void displayFormula1DriverTable() {
////        addAllToAnArrayList(formula1DriversTeam);
//        if (customTeamArray.size() > 0) {
//            for (int i = 0; i < customTeamArray.size(); i++) {
//                sortTeamArray.add(customTeamArray.get(i));
//            }
//
//            Collections.sort(sortTeamArray, Formula1Driver.Formula1DriverPoints);
//            for (Formula1Driver driver : sortTeamArray) {
//                System.out.println(driver);
//            }
//
//        } else {
//            System.out.println("Please add teams");
//        }
//        sortTeamArray.clear();
//        finalTeamArray.clear();
//    }

    public void formula1DriversTable(){
       if (customTeamArray.size() > 0){
           Collections.sort(customTeamArray);
           System.out.println("Number of teams: " + customTeamArray.size());
           System.out.println("");
           String formulaTableFormat = "| %-4d | %-20s | %-25s | %-24s| %-6d | %-8d |\n";
           System.out.format("+------+----------------------+---------------------------+-------------------------+--------+----------+\n");
           System.out.format("| POS  |      TEAM NAME       |       DRIVER NAME         |          COUNTRY        | POINTS | 1stPOSES |\n");
           System.out.format("+------+----------------------+---------------------------+-------------------------+--------+----------+\n");

           for (int i = 0 ; i < customTeamArray.size() ; i++){
               System.out.format(formulaTableFormat, i+1 ,customTeamArray.get(i).getTeamOfDriver(), customTeamArray.get(i).getDriverName(), customTeamArray.get(i).getDriverLocation(), customTeamArray.get(i).getCurrentPoints(), customTeamArray.get(i).getFirstPositions());
               System.out.format("+------+----------------------+---------------------------+-------------------------+--------+----------+\n");
           }
           System.out.println("\n");
       }
       else {
           System.out.println("Add teams to display the FORMULA 1 DRIVER TABLE");
       }

    }




//    public void changeTheDriver(Formula1Driver[] formula1DriversTeam){
//        while (checkChangeTheDriver) {
//
//            System.out.println("+------------------------------------------------------------------------+");
//            System.out.println("|         INPUT CODE       |              OPTION                         |");
//            System.out.println("+------------------------------------------------------------------------+");
//            System.out.println("|         1 or DBT         | Change a driver  from pre build team        |");
//            System.out.println("|         2 or DCT         | Change a diver from custom team             |");
//            System.out.println("|         9 or BCK         | Return To the main menu                     |");
//            System.out.println("+------------------------------------------------------------------------+");
//            System.out.println("Enter the respective code for your requirement: ");
//
//
//            if (input.hasNext()) {
//                String respond = input.next();
//                switch (respond.toUpperCase()) {
//                    case "1":
//                    case "DBT":
//                        System.out.println("+------------------------------------------------------------------------+");
//                        System.out.println("|                 Change a driver  from pre build team                   |");
//                        System.out.println("+------------------------------------------------------------------------+");
//                        changeADriverFromPreBuildTeam(formula1DriversTeam);
//
//                        break;
//
//                    case "2":
//                    case "DCT":
//                        System.out.println("+------------------------------------------------------------------------+");
//                        System.out.println("|                   Change a diver from custom team                      |");
//                        System.out.println("+------------------------------------------------------------------------+");
//
//                        break;
//
//                    case "9":
//                    case "BCK":
//                        checkChangeTheDriver = false;
//                        break;
//                    default:
//                        System.out.println("Invalid option selected, 'Input out of range'");
//                }
//            } else {
//                System.out.println("Invalid in-put");                                                                      //if the user input an invalid input, the program will not terminate, just repeat by passing a warning
//            }
//        }
//        checkChangeTheDriver = true;
//    }

    public void changeTheDriver(){
       if (customTeamArray.size() > 1){
           checkCustomOccupiedTeams();
           if (checkCustomOccupiedTeam){
               while(true){
                   System.out.println("Enter the respective code to the team name to change the driver or \nenter 999 to return back: ");
                   if (input.hasNextInt()){
                       int changeFromTeamNumber = input.nextInt();
                       if(changeFromTeamNumber == 999){
                           break;
                       }else {
                           if ((changeFromTeamNumber >=0) && (changeFromTeamNumber < customTeamArray.size())){
                               for (int i = 0 ; i < customTeamArray.size() ; i++){
                                   if (!(i == changeFromTeamNumber)){
                                       System.out.println(i + " - " + customTeamArray.get(i).getTeamOfDriver() + " \n\tDriver : " +customTeamArray.get(i).getDriverName() + "\n");

                                   }
                               }
                               System.out.println("Enter the code respect to the team you want to change with: ");
                               if (input.hasNextInt()){
                                   int changeToTeamNumber = input.nextInt();

                                   if ((changeToTeamNumber >= 0) && changeToTeamNumber < customTeamArray.size()){
                                       Formula1Driver getDriver = customTeamArray.get(changeToTeamNumber);
                                       System.out.println("Request successfully completed and deleted the team " + customTeamArray.get(changeFromTeamNumber).getTeamOfDriver() + "\n");
                                       System.out.println("Preview Details \n");
                                       System.out.println("Team Name       : " + customTeamArray.get(changeToTeamNumber).getTeamOfDriver());
                                       System.out.println("Driver Name     : " + customTeamArray.get(changeToTeamNumber).getDriverName());
                                       System.out.println("Driver Location : " + customTeamArray.get(changeToTeamNumber).getDriverLocation());
                                       System.out.println("Current points  : " + customTeamArray.get(changeToTeamNumber).getCurrentPoints());

                                       customTeamArray.remove(changeFromTeamNumber);
                                       break;
                                   }else {
                                       System.out.println("Input out of range :(");
                                   }
                               }else {
                                   System.out.println("Invalid input data type! Integer required :(");
                               }
                           }else {
                               System.out.println("Input out of range :(");
                           }
                       }

                   }else {
                       System.out.println("Invalid input data type! Integer required :( ");
                   }
               }

           }else {
               System.out.println("Add teams before changing ");
           }
       }else {
           System.out.println("Please add more teams to change the driver");
       }

    }

    public void addARaceCompleted(){
//        if (customTeamArray.size() > 0){

            while(true){
                if(checkDate()){
                    System.out.println("\n+------------------------------------------------------------------------+");
                    System.out.println("| INSTRUCTIONS:-                                                         |");
                    System.out.println("|           ⚠ Enter the position of the driver as a int value (1,2,3,etc)|");
                    System.out.println("|           ⚠ Enter 0 if the driver was not participated to the race     |");
                    System.out.println("+------------------------------------------------------------------------+\n");

                    System.out.println("  _    _             _    _         ");
                    System.out.println(" \\\\`../ |o_..__     \\\\`../ |o_..__  ");
                    System.out.println("`.,(_)______(_).>  `.,(_)______(_).>");
                    System.out.println("\t\t\t\t\t\t\t\tRace Date:- 🏎️ " + stringDate);

                    dateArray.add(stringDate);




                }else {
                    System.out.println("⏲️Please enter a valid date 📅\n");
                }
            }

//        }else {
//            System.out.println("Please add teams before adding a race 🏎️🏎️🏎️🏎️");
//        }
    }

    public boolean checkDate(){
        System.out.println("Enter the date with the following format\n DD/MM/YYYY");
        stringDate = input.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(stringDate);
//            System.out.println("TRUE");
            return true;
        } catch (Exception e) {
//            System.out.println("FALSE");
            return false;
        }
    }

}

