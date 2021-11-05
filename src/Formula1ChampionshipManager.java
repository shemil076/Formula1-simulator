import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;


public class Formula1ChampionshipManager<HashTable> implements ChampionshipManager{
    private int numberOfDrivers;
    private int numberOfCars;
    public  Scanner input = new Scanner(System.in);
    private static boolean run = true;
    private boolean vacantTeams = true;
    private int [] rangeNumber ={0,1,2,3,4,5,6,7,8,9};
    private boolean check = false;

//    ArrayList<Formula1Driver> formula1DriversTeam = new ArrayList<Formula1Driver>();
    Hashtable<Integer, String> teams = new Hashtable<Integer, String>();

    public static void main(String[] args) {
        Formula1ChampionshipManager championManager = new Formula1ChampionshipManager();
        Formula1Driver [] formula1DriversTeam = new Formula1Driver[10];

        championManager.initialize(formula1DriversTeam);
//        championManager.checkVacantTeam(formula1DriversTeam);

        championManager.welcome();
        championManager.logo();

        while(run){
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


    public  void mainMenu(Formula1Driver[] formula1DriversTeam){
        if (input.hasNext()){
            String option = input.next();
            switch (option.toUpperCase()){
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
        }else {
            System.out.println("Invalid out-put");                                                                      //if the user input an invalid input, the program will not terminate, just repeat by passing a warning
        }
    }

    public void initialize(Formula1Driver[] formula1DriversTeam){
        for (int i = 0 ; i < formula1DriversTeam.length; i++){
            formula1DriversTeam[i] = new Formula1Driver("~", "~","~",0,0,0,0,0,0,0);
        }
        teams.put(0," 0 - MERCEDES");
        teams.put(1," 1 - RED BULL");
        teams.put(2," 2 - MCLAREN");
        teams.put(3," 3 - FERRARI");
        teams.put(4," 4 - ALPINE");
        teams.put(5," 5 - ALFA TAURI");
        teams.put(6," 6 - ASTON MARTIN");
        teams.put(7," 7 - WILLIAMS");
        teams.put(8," 8 - ALFA ROMEO RACING");
        teams.put(9," 9 - HAAS F1 TEAM");

    }



    public  void createANewDriver(Formula1Driver[] formula1DriversTeam){
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("|         INPUT CODE         |              OPTION                       |");
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("|         1 or AET           |     Add a driver to an existing team      |");
        System.out.println("|         2 or ACT           |     Add a driver to a custom team         |");
        System.out.println("|         9 or BCK           |     Return back                           |");
        System.out.println("+------------------------------------------------------------------------+");
        System.out.println("Enter the respective code for your requirement: ");


        if (input.hasNext()){
            String respond = input.next();
            switch (respond.toUpperCase()){
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

                    break;
                case "9":
                case "BCK":


                    break;


                default:
                    System.out.println("Invalid option selected, 'Input out of range'");
            }
        }else {
            System.out.println("Invalid out-put");                                                                      //if the user input an invalid input, the program will not terminate, just repeat by passing a warning
        }


    }



    public void addToExistingTeam(Formula1Driver[] formula1DriversTeam){
        checkVacantTeam(formula1DriversTeam);
        if (vacantTeams){
            while(true){
            System.out.println("Enter the respective number of the team you prefer or enter 999 to return back : ");
            if (input.hasNextInt()){
                int teamNumber = input.nextInt();
                if (teamNumber == 999){
                    break;
                }else {
                    findTeamsNumber(teamNumber);
                    if (check){
                        if (!formula1DriversTeam[teamNumber].getDriverName().equals("~")){
                            System.out.println("Already the team has a driver");

                        }else {
                            System.out.println("Enter the name of the driver");
                            if (input.hasNext()){
                                String name = input.next();
                                formula1DriversTeam[teamNumber].setDriverName(name.toUpperCase());
                                System.out.println("");
                                System.out.println("Requirement is successfully completed");
                                System.out.println(name + " is added to the team " + teams.get(teamNumber));

                            }else{
                                System.out.println("Invalid input data type, String Required");
                                input.next();
                            }
                        }
                    }else {
                        System.out.println("Team number is out of range");

                    }

                }

            } else {
                System.out.println("Invalid input data type, Integer Required");
                input.next();
            }
            check = false;

            }
        }else {
            System.out.println("No vacancy Please use custom team");
        }
    }

    public void checkVacantTeam(Formula1Driver[] formula1DriversTeam){
        String [] vacantTeam = new String[formula1DriversTeam.length];
        for (int i = 0 ; i < formula1DriversTeam.length ; i++){
            vacantTeam[i] = formula1DriversTeam[i].getDriverName();
        }
        if ((vacantTeam[0].equals("~")) || (vacantTeam[1].equals("~")) || (vacantTeam[2].equals("~")) || (vacantTeam[3].equals("~")) || (vacantTeam[4].equals("~")) || (vacantTeam[5].equals("~")) || (vacantTeam[6].equals("~")) || (vacantTeam[7].equals("~0")) ||(vacantTeam[8].equals("~")) || (vacantTeam[9].equals("~"))){
            System.out.println("Vacant teams: ");


            if ((!vacantTeam[0].equals("~")) && (!vacantTeam[1].equals("~")) && (!vacantTeam[2].equals("~")) && (!vacantTeam[3].equals("~")) && (!vacantTeam[4].equals("~")) && (!vacantTeam[5].equals("~")) && (!vacantTeam[6].equals("~")) && (!vacantTeam[7].equals("~")) && (!vacantTeam[8].equals("~")) && (!vacantTeam[9].equals("~"))){
                System.out.println("NONE of the teams are vacant :(");
                System.out.println("Please try to a the driver to a custom team :D");
                System.out.println("");
                vacantTeams = false;
            }else{
                for (int i = 0 ; i < vacantTeam.length ; i++){
                    if (vacantTeam[i].equals("~")){
                        System.out.println(teams.get(i));
                    }
                }
            }
        }
        else {
            System.out.println("No vacancy, Please try a custom team");
        }
    }



    public void findTeamsNumber(int number){
        for (int i = 0; i < rangeNumber.length ; i++){
            if(rangeNumber[i] == number){
                check = true;
            }
        }
    }


    public void exitTheProgram(){
        thankYou();
        run =false;
    }
    public  void welcome() {
        System.out.println("     ██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗");
        System.out.println("     ██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝");
        System.out.println("     ██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗  ");
        System.out.println("     ██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝  ");
        System.out.println("     ╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗");
        System.out.println("      ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝");
        System.out.println("");

    }

    public  void thankYou(){
        System.out.println("████████╗██╗  ██╗ █████╗ ███╗   ██╗██╗  ██╗    ██╗   ██╗ ██████╗ ██╗   ██╗");
        System.out.println("╚══██╔══╝██║  ██║██╔══██╗████╗  ██║██║ ██╔╝    ╚██╗ ██╔╝██╔═══██╗██║   ██║");
        System.out.println("   ██║   ███████║███████║██╔██╗ ██║█████╔╝      ╚████╔╝ ██║   ██║██║   ██║");
        System.out.println("   ██║   ██╔══██║██╔══██║██║╚██╗██║██╔═██╗       ╚██╔╝  ██║   ██║██║   ██║");
        System.out.println("   ██║   ██║  ██║██║  ██║██║ ╚████║██║  ██╗       ██║   ╚██████╔╝╚██████╔╝");
        System.out.println("   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝       ╚═╝    ╚═════╝  ╚═════╝ ");
    }

    public  void logo(){
        System.out.println("  _    _             /'_'_/.-''/                             _______");
        System.out.println("  \\`../ |o_..__     / /__   / /  -= WORLD CHAMPIONSHIP =-   _\\=.o.=/_");
        System.out.println("`.,(_)______(_).>  / ___/  / /                             |_|_____|_|");
        System.out.println("~~~~~~~~~~~~~~~~~~/_/~~~~~/_/~~~~~~~~~~~simulator~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("");
    }

}

