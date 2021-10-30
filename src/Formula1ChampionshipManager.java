import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager{
    private int numberOfDrivers;
    private int numberOfCars;
    public static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {
        welcome();
//        thankYou();
        while(true){
            printMenu();
            mainMenu();
        }


    }


    public static void printMenu() {
        System.out.println("     __  __    __    ____  _  _    __  __  ____  _  _  __  __ ");
        System.out.println("    (  \\/  )  /__\\  (_  _)( \\( )  (  \\/  )( ___)( \\( )(  )(  )");
        System.out.println("     )    (  /(__)\\  _)(_  )  (    )    (  )__)  )  (  )(__)( ");
        System.out.println("    (_/\\/\\_)(__)(__)(____)(_)\\_)  (_/\\/\\_)(____)(_)\\_)(______)");

        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|      INPUT CODE      |              OPTION                     |");
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|      100 or CND      |       Create a New Driver               |");
        System.out.println("|      101 or DDT      |       Delete a Driver and Team          |");
        System.out.println("|      102 or CTD      |       Change the Driver                 |");
        System.out.println("|      103 or DVS      |       Display the Various Statics       |");
        System.out.println("|      104 or DFT      |       Display Formula1 Driver Table     |");
        System.out.println("|      105 or ARC      |       Add a Race Completed              |");
        System.out.println("|      106 or SIF      |       Save in a File                    |");
        System.out.println("|      999 or EXT      |       Exit                              |");
        System.out.println("+----------------------------------------------------------------+");

        System.out.println("Enter the respective code for your requirement: ");


    }


    public static void mainMenu(){
        if (input.hasNext()){
            String option = input.next();
            switch (option.toUpperCase()){
                case "100":
                case "CND":
                    System.out.println("+----------------------------------------------------------------+");
                    System.out.println("|                      Create a New Driver                       |");
                    System.out.println("+----------------------------------------------------------------+\n");

                    break;

                case "101":
                case "DDT":
                    System.out.println("+----------------------------------------------------------------+");
                    System.out.println("|                   Delete a Driver and Team                     |");
                    System.out.println("+----------------------------------------------------------------+\n");

                    break;

                case "102":
                case "CTD":
                    System.out.println("+----------------------------------------------------------------+");
                    System.out.println("|                       Change the Driver                        |");
                    System.out.println("+----------------------------------------------------------------+\n");

                    break;

                case "103":
                case "DVS":
                    System.out.println("+----------------------------------------------------------------+");
                    System.out.println("|                    Display the Various Statics                 |");
                    System.out.println("+----------------------------------------------------------------+\n");

                    break;


                case "104":
                case "DFT":
                    System.out.println("+----------------------------------------------------------------+");
                    System.out.println("|                  Display Formula1 Driver Table                 |");
                    System.out.println("+----------------------------------------------------------------+\n");

                    break;

                case "105":
                case "ARC":
                    System.out.println("+----------------------------------------------------------------+");
                    System.out.println("|                       Add a Race Completed                     |");
                    System.out.println("+----------------------------------------------------------------+\n");

                    break;

                case "106":
                case "SIF":
                    System.out.println("+----------------------------------------------------------------+");
                    System.out.println("|                         Save in a File                         |");
                    System.out.println("+----------------------------------------------------------------+\n");

                    break;

                case "999":
                case "EXT":
                    System.out.println("+----------------------------------------------------------------+");
                    System.out.println("|                              Exit                              |");
                    System.out.println("+----------------------------------------------------------------+\n");

                    break;

                default:
                    System.out.println("Invalid option selected, 'Input out of range'");
            }
        }else {
            System.out.println("Invalid out-put");                                                                      //if the user input an invalid input, the program will not terminate, just repeat by passing a warning
        }
    }

    public static void welcome() {
        System.out.println("  ██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗");
        System.out.println("  ██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝");
        System.out.println("  ██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗  ");
        System.out.println("  ██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝  ");
        System.out.println("  ╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗");
        System.out.println("   ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝");
    }

    public static void thankYou(){
        System.out.println("████████╗██╗  ██╗ █████╗ ███╗   ██╗██╗  ██╗    ██╗   ██╗ ██████╗ ██╗   ██╗");
        System.out.println("╚══██╔══╝██║  ██║██╔══██╗████╗  ██║██║ ██╔╝    ╚██╗ ██╔╝██╔═══██╗██║   ██║");
        System.out.println("   ██║   ███████║███████║██╔██╗ ██║█████╔╝      ╚████╔╝ ██║   ██║██║   ██║");
        System.out.println("   ██║   ██╔══██║██╔══██║██║╚██╗██║██╔═██╗       ╚██╔╝  ██║   ██║██║   ██║");
        System.out.println("   ██║   ██║  ██║██║  ██║██║ ╚████║██║  ██╗       ██║   ╚██████╔╝╚██████╔╝");
        System.out.println("   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝       ╚═╝    ╚═════╝  ╚═════╝ ");
    }
}

