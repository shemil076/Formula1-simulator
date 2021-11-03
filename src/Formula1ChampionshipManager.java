import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager{
    private int numberOfDrivers;
    private int numberOfCars;
    public  Scanner input = new Scanner(System.in);
    private static boolean run = true;


    public static void main(String[] args) {
        Formula1ChampionshipManager championManager = new Formula1ChampionshipManager();

        championManager.welcome();
        championManager.logo();
        while(run){
            championManager.printMenu();
          championManager.mainMenu();
        }


    }


    public void printMenu() {
        System.out.println("       __  __    __    ____  _  _    __  __  ____  _  _  __  __ ");
        System.out.println("      (  \\/  )  /__\\  (_  _)( \\( )  (  \\/  )( ___)( \\( )(  )(  )");
        System.out.println("       )    (  /(__)\\  _)(_  )  (    )    (  )__)  )  (  )(__)( ");
        System.out.println("      (_/\\/\\_)(__)(__)(____)(_)\\_)  (_/\\/\\_)(____)(_)\\_)(______)");

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
        System.out.println("|           999 or EXT         |       Exit the program                  |");
        System.out.println("+------------------------------------------------------------------------+");

        System.out.println("Enter the respective code for your requirement: ");


    }


    public  void mainMenu(){
        if (input.hasNext()){
            String option = input.next();
            switch (option.toUpperCase()){
                case "100":
                case "CND":
                    System.out.println("+------------------------------------------------------------------------+");
                    System.out.println("|                          Create a New Driver                           |");
                    System.out.println("+------------------------------------------------------------------------+");
                    CreateANewDriver();
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


    public  void CreateANewDriver(){
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
                    addToExistingTeam();
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

    public void addToExistingTeam(){

        while (true){
            System.out.println("Select the team to add the driver");
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("|           001          |                MERCEDES                       |");
            System.out.println("|           002          |                RED BULL                       |");
            System.out.println("|           003          |                MCLAREN                        |");
            System.out.println("|           004          |                FERRARI                        |");
            System.out.println("|           005          |                ALPINE                         |");
            System.out.println("|           006          |                ALFA TAURI                     |");
            System.out.println("|           007          |                ASTON MARTIN                   |");
            System.out.println("|           008          |                WILLIAMS                       |");
            System.out.println("|           009          |                ALFA ROMEO RACING              |");
            System.out.println("|           010          |                HAAS F1 TEAM                   |");
            System.out.println("+------------------------------------------------------------------------+");
            System.out.println("Enter the respective code for the team you prefer or enter 999 to exit: ");

            if (input.hasNextInt()){
                int teamNumber = input.nextInt();
                if (teamNumber == 999 ){
                    break;
                }
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
    }



}

