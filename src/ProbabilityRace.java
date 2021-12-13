import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ProbabilityRace extends JFrame {
    JLabel rSPLabelTopic;
    JLabel rSPSuccessfully;
    JLabel lblStartPos;
    JTable rspGeneratedTable;
    JScrollPane rspGeneratedTableScrollPane;

    ImageIcon iconFrame = new ImageIcon("src/img/fast.png");                // importing the image
    JPanel rSPContainer;

    public int[] startingPositionArray = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 6, 7, 8, 9};
    public ArrayList<Formula1Driver> drivers = Formula1ChampionshipManager.getData();                // accessing the array list from Formula1ChampionshipManager
    public ArrayList<RaceDetails> raceData = Formula1ChampionshipManager.getRaceDateData();            //
    public ArrayList<Formula1Driver> driversClone = new ArrayList<Formula1Driver>();
    ArrayList<RacerStartPositions> RacerStartPositionCollection = new ArrayList<RacerStartPositions>();
    ArrayList<Integer> positions = new ArrayList<Integer>();
    ArrayList<Integer> startingPositionArrayList = new ArrayList<Integer>();
    ArrayList<RaceTeamData> raceTeamDetails = new ArrayList<RaceTeamData>();
    public static String stringDate;
    public static boolean wining = false;



    public ProbabilityRace() {
        rSPLabelTopic = new JLabel();
        rspGeneratedTable = new JTable();
        rSPSuccessfully = new JLabel();
        rSPContainer = new JPanel();
        lblStartPos = new JLabel();
        Background newBackground = new Background(Color.decode("#780206"), Color.decode("#061161"), 3);  // set the background
        rspGeneratedTableScrollPane = new JScrollPane(rspGeneratedTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(rSPContainer.add(newBackground));                                          // add the JPanel to the JFrame
        newBackground.setLayout(new FlowLayout());                                  // set the layout

        // font styles
        rSPLabelTopic.setFont(new Font("Serif", Font.BOLD, 30));
        rSPLabelTopic.setForeground(Color.ORANGE);
        rSPSuccessfully.setFont(new Font("Serif", Font.BOLD, 24));
        rSPSuccessfully.setForeground(Color.YELLOW);

        startRace();
        lblStartPos.setFont(new Font("Serif",Font.BOLD,18));             // set the font style
        lblStartPos.setForeground(Color.green);

        String[] raceTableColumnNames = {"TEAM", "NAME", "CURRENT POINTS", "POSITION"};
        rspGeneratedTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, raceTableColumnNames));
        rSPLabelTopic.setText("Race table on : " + stringDate);
        addToTable(raceTeamDetails, rspGeneratedTable);


        newBackground.add(rSPLabelTopic);
        newBackground.add(lblStartPos);
        newBackground.add(rspGeneratedTableScrollPane).setPreferredSize(new Dimension(900, 400));
        newBackground.add(rSPSuccessfully);

//        setLayout(new FlowLayout());
        setSize(950, 600);
        setTitle("Generate Race");
        setIconImage(iconFrame.getImage());             // set the frame icon

        setResizable(false);                            // not allowing to stretch or resize
        setLocationRelativeTo(null);                     // set the location to the center of the screen
        setVisible(true);                               // // make the frame visible
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

    }

    public void test(int line){
        System.out.println("This " + line);
        System.out.println(raceTeamDetails.size());

        for (RaceTeamData e : raceTeamDetails){
            System.out.println(e.getTeamName() +" "+ e.getDriverName()+" " + e.getCurrentPoints() +" " + e.getPosition() );
        }
    }



    public void startRace() {

        raceTeamDetails.clear();
        driversClone.addAll(drivers);
        Collections.shuffle(driversClone);
        startingPositionArrayList.clear();

        int day = (int) (Math.random() * (28 - 1 + 1) + 1);             // set random numbers as a day
        int month = (int) (Math.random() * (12 - 1 + 1) + 1);           // set random numbers as a month
//        int year = (int) (Math.random() * (2021 - 2015 + 1) + 2015);    // set random numbers as a year

        String stringDay = Integer.toString(day);
        String stringMonth = Integer.toString(month);
//        String stringYear = Integer.toString(year);

        stringDate = stringDay + "/" + stringMonth + "/" + "2021";




        for (Formula1Driver driver : driversClone) {
            RaceDetails newRace = new RaceDetails(stringDate);
            RaceTeamData raceTeam;



//            while (true){
//                startPos = (int) (Math.random() * driversClone.size()+ 1);
//                if (!(startingPositionArrayList.contains(startPos))){
//                    startingPositionArrayList.add(startPos);
//                    break;
//                }
//            }




//            while (true){
            int probability = (int) (Math.random() * 49);

            int startPos = startingPositionArray[probability];


            if (startPos == 1){



//                if (probability >= 1 && probability <=40){



                    driver.setFirstPositions(1 + driver.getFirstPositions());
                    driver.setCurrentPoints(25 + driver.getCurrentPoints());
                    driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                    driversClone.remove(driver);
//                    startingPositionArrayList.remove(startPos);

                    raceTeam = new RaceTeamData(driver.getTeamOfDriver(),driver.getDriverName(),driver.getCurrentPoints(), 1);
                    raceTeamDetails.add(raceTeam); // add a new race to the raceTeamData arraylist

                    newRace.setDriverNameTeamNamePosition(driver.getDriverName(),driver.getTeamOfDriver(),1);
                    raceData.add(newRace);

                    lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);
                    otherPositions( newRace);
                    break;
//                }
//                break;

            }else if (startPos == 2){


//                if (probability >= 41 && probability <=70){

                    driver.setFirstPositions(1 + driver.getFirstPositions());
                    driver.setCurrentPoints(25 + driver.getCurrentPoints());
                    driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                    driversClone.remove(driver);
//                    startingPositionArrayList.remove(startPos);

                    raceTeam = new RaceTeamData(driver.getTeamOfDriver(),driver.getDriverName(),driver.getCurrentPoints(), 1);
                    raceTeamDetails.add(raceTeam); // add a new race to the raceTeamData arraylist

                    newRace.setDriverNameTeamNamePosition(driver.getDriverName(),driver.getTeamOfDriver(),1);
                    raceData.add(newRace);

                    lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);

                    otherPositions( newRace);
                    break;
//                }
//                break;

            }else if (startPos == 3){


//                if (probability >= 71 && probability <=80){


                    driver.setFirstPositions(1 + driver.getFirstPositions());
                    driver.setCurrentPoints(25 + driver.getCurrentPoints());
                    driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                    driversClone.remove(driver);
//                    startingPositionArrayList.remove(startPos);

                    raceTeam = new RaceTeamData(driver.getTeamOfDriver(),driver.getDriverName(),driver.getCurrentPoints(), 1);
                    raceTeamDetails.add(raceTeam); // add a new race to the raceTeamData arraylist

                    newRace.setDriverNameTeamNamePosition(driver.getDriverName(),driver.getTeamOfDriver(),1);
                    raceData.add(newRace);

                    lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);

                    otherPositions( newRace);
                    break;
//                }
//                break;

            }else if (startPos == 4){


//                if (probability >= 81 && probability <=90){



                    driver.setFirstPositions(1 + driver.getFirstPositions());
                    driver.setCurrentPoints(25 + driver.getCurrentPoints());
                    driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                    driversClone.remove(driver);
//                    startingPositionArrayList.remove(startPos);

                    raceTeam = new RaceTeamData(driver.getTeamOfDriver(),driver.getDriverName(),driver.getCurrentPoints(), 1);
                    raceTeamDetails.add(raceTeam); // add a new race to the raceTeamData arraylist

                    newRace.setDriverNameTeamNamePosition(driver.getDriverName(),driver.getTeamOfDriver(),1);
                    raceData.add(newRace);


                    lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);

                    otherPositions( newRace);
                    break;
//                }
//                break;

            }else if (startPos == 5){


//                if (probability >= 91 && probability <=92){



                    driver.setFirstPositions(1 + driver.getFirstPositions());
                    driver.setCurrentPoints(25 + driver.getCurrentPoints());
                    driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                    driversClone.remove(driver);
//                    startingPositionArrayList.remove(startPos);

                    raceTeam = new RaceTeamData(driver.getTeamOfDriver(),driver.getDriverName(),driver.getCurrentPoints(), 1);
                    raceTeamDetails.add(raceTeam); // add a new race to the raceTeamData arraylist
                    newRace.setDriverNameTeamNamePosition(driver.getDriverName(),driver.getTeamOfDriver(),1);
                    raceData.add(newRace);

                    lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);

                    otherPositions( newRace);
                    break;
//                }
//                break;

            }else if (startPos == 6){


//                if (probability >= 93 && probability <=94){



                    driver.setFirstPositions(1 + driver.getFirstPositions());
                    driver.setCurrentPoints(25 + driver.getCurrentPoints());
                    driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                    driversClone.remove(driver);
//                    startingPositionArrayList.remove(startPos);

                    raceTeam = new RaceTeamData(driver.getTeamOfDriver(),driver.getDriverName(),driver.getCurrentPoints(), 1);
                    raceTeamDetails.add(raceTeam); // add a new race to the raceTeamData arraylist
                    newRace.setDriverNameTeamNamePosition(driver.getDriverName(),driver.getTeamOfDriver(),1);
                    raceData.add(newRace);

                    lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);

                    otherPositions( newRace);
                    break;
//                }
//                break;

            }else if (startPos == 7){



//                if (probability >= 95 && probability <=96){




                    driver.setFirstPositions(1 + driver.getFirstPositions());
                    driver.setCurrentPoints(25 + driver.getCurrentPoints());
                    driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                    driversClone.remove(driver);
//                    startingPositionArrayList.remove(startPos);

                    raceTeam = new RaceTeamData(driver.getTeamOfDriver(),driver.getDriverName(),driver.getCurrentPoints(), 1);
                    raceTeamDetails.add(raceTeam); // add a new race to the raceTeamData arraylist
                    newRace.setDriverNameTeamNamePosition(driver.getDriverName(),driver.getTeamOfDriver(),1);
                    raceData.add(newRace);

                    lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);

                    otherPositions( newRace);
                    break;
//                }
//                break;

            }else if (startPos == 8){


//                if (probability >= 97 && probability <=98){



                    driver.setFirstPositions(1 + driver.getFirstPositions());
                    driver.setCurrentPoints(25 + driver.getCurrentPoints());
                    driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                    driversClone.remove(driver);
//                    startingPositionArrayList.remove(startPos);

                    raceTeam = new RaceTeamData(driver.getTeamOfDriver(),driver.getDriverName(),driver.getCurrentPoints(), 1);
                    raceTeamDetails.add(raceTeam); // add a new race to the raceTeamData arraylist
                    newRace.setDriverNameTeamNamePosition(driver.getDriverName(),driver.getTeamOfDriver(),1);
                    raceData.add(newRace);

                    lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);

                    otherPositions( newRace);
                    break;
//                }
//                break;

            }else if (startPos == 9){


//                if (probability >= 99 && probability <=100){



                    driver.setFirstPositions(1 + driver.getFirstPositions());
                    driver.setCurrentPoints(25 + driver.getCurrentPoints());
                    driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                    driversClone.remove(driver);
//                    startingPositionArrayList.remove(startPos);

                    raceTeam = new RaceTeamData(driver.getTeamOfDriver(),driver.getDriverName(),driver.getCurrentPoints(), 1);
                    raceTeamDetails.add(raceTeam); // add a new race to the raceTeamData arraylist
                    newRace.setDriverNameTeamNamePosition(driver.getDriverName(),driver.getTeamOfDriver(),1);
                    raceData.add(newRace);

                    lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);

                    otherPositions( newRace);
                    break;


//                }
//                break;

            }
            break;
//            }

        }
    }
//  raceTeam = new  RaceTeamData(driversClone.get(i).getTeamOfDriver(),driversClone.get(i).getDriverName(),driversClone.get(i).getCurrentPoints(),i+2,startingPositionArrayList.get(i));


    public  void otherPositions(RaceDetails newRace){

        Collections.shuffle(driversClone);
        for (Formula1Driver formula1Driver : driversClone) {
            if (driversClone.indexOf(formula1Driver) == 0){
                formula1Driver.setSecondPositions(1 + formula1Driver.getSecondPositions());
                formula1Driver.setCurrentPoints(18 + formula1Driver.getCurrentPoints());
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());


            }else if (driversClone.indexOf(formula1Driver) == 1){
                formula1Driver.setThirdPositions(1 + formula1Driver.getThirdPositions());
                formula1Driver.setCurrentPoints(15 + formula1Driver.getCurrentPoints());
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());

            }else if (driversClone.indexOf(formula1Driver) == 2){
                formula1Driver.setCurrentPoints(12 + formula1Driver.getCurrentPoints());
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());

            }else if (driversClone.indexOf(formula1Driver) == 3){
                formula1Driver.setCurrentPoints(10 + formula1Driver.getCurrentPoints());
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());

            }else if (driversClone.indexOf(formula1Driver) == 4){
                formula1Driver.setCurrentPoints(8 + formula1Driver.getCurrentPoints());
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());

            }else if (driversClone.indexOf(formula1Driver) == 5){
                formula1Driver.setCurrentPoints(6 + formula1Driver.getCurrentPoints());
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());

            }else if (driversClone.indexOf(formula1Driver) == 6){
                formula1Driver.setCurrentPoints(4 + formula1Driver.getCurrentPoints());
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());

            }else if (driversClone.indexOf(formula1Driver) == 7){
                formula1Driver.setCurrentPoints(2 + formula1Driver.getCurrentPoints());
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());

            }else if (driversClone.indexOf(formula1Driver) == 8){
                formula1Driver.setCurrentPoints(1 + formula1Driver.getCurrentPoints());
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());

            }else{
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());

            }

            raceTeamDetails.add(new RaceTeamData(formula1Driver.getTeamOfDriver(),formula1Driver.getDriverName(),formula1Driver.getCurrentPoints(), driversClone.indexOf(formula1Driver)+2)); // add a new race to the raceTeamData arraylist
            newRace.setDriverNameTeamNamePosition(formula1Driver.getDriverName(),formula1Driver.getTeamOfDriver(),driversClone.indexOf(formula1Driver)+2);
            raceData.add(newRace);

        }

    }

    public static void addToTable(ArrayList<RaceTeamData> raceTeamDetails, JTable table) {
        for (RaceTeamData raceTeam : raceTeamDetails) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{
                    raceTeam.getTeamName(),
                    raceTeam.getDriverName(),
                    raceTeam.getCurrentPoints(),
                    raceTeam.getPosition()
            });
        }
    }


}
