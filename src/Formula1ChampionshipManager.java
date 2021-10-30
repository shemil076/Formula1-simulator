public class Formula1ChampionshipManager implements ChampionshipManager{
    private int numberOfDrivers;
    private int numberOfCars;


    public static void main(String[] args) {
        printMenu();
    }


    public static void printMenu() {
        System.out.println("     __  __    __    ____  _  _    __  __  ____  _  _  __  __ ");
        System.out.println("    (  \\/  )  /__\\  (_  _)( \\( )  (  \\/  )( ___)( \\( )(  )(  )");
        System.out.println("     )    (  /(__)\\  _)(_  )  (    )    (  )__)  )  (  )(__)( ");
        System.out.println("    (_/\\/\\_)(__)(__)(____)(_)\\_)  (_/\\/\\_)(____)(_)\\_)(______)");

        System.out.println("");
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
        System.out.println("+----------------------------------------------------------------+");


    }


}

