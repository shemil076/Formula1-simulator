import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class ProbabilityRace extends JFrame {
    JLabel rSPLabelTopic;
    JLabel lblStartPos;
    JTable rspGeneratedTable;
    JScrollPane rspGeneratedTableScrollPane;

    ImageIcon iconFrame = new ImageIcon("src/img/fast.png");// importing the image
    ImageIcon iconDialogBox = new ImageIcon("src/img/warning.png");
    ImageIcon iconImageLabel = new ImageIcon("src/img/f1.png") ;
    ImageIcon iconImageLabel2 = new ImageIcon("src/img/f2.png") ;
    ImageIcon iconImageLabel3 = new ImageIcon("src/img/f3.png") ;
    JPanel rSPContainer;
    JLabel imageLabel;
    JLabel imageLabel2;
    JLabel imageLabel3;


    /*
        Int array has used to involve probability to the algorithm, there are 20 ones, 15 twos, 5 threes, 5 fours, 1 six, seven, eight, and nine per each
        20 ones represent 40%, 15 twos represent 30%, 5 threes and fours represent 10% each and 1 six, seven, eight and nine represent 2% each
        each percentage has simplified  (divide by 2).
        Generating a random number 1-50 (including 1 and 50) as the index of  startingPositionArray.
        And the number of the array that represent by the index will assign according to the probability
    */
    public int[] startingPositionArray = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 6, 7, 8, 9}; //
    public ArrayList<Formula1Driver> drivers = Formula1ChampionshipManager.getData();                // accessing the array list from Formula1ChampionshipManager
    public ArrayList<RaceDetails> raceData = Formula1ChampionshipManager.getRaceDateData();            //
    public ArrayList<Formula1Driver> driversClone = new ArrayList<Formula1Driver>();
    ArrayList<Integer> startingPositionArrayList = new ArrayList<Integer>();
    ArrayList<RaceTeamData> raceTeamDetails = new ArrayList<RaceTeamData>();
    public static String stringDate;
    public static int  startPos;


    public ProbabilityRace() {
        rSPLabelTopic = new JLabel();
        rspGeneratedTable = new JTable();
        rSPContainer = new JPanel();
        lblStartPos = new JLabel();
        imageLabel = new JLabel();
        imageLabel2 = new JLabel();
        imageLabel3 = new JLabel();
        Background newBackground = new Background(Color.decode("#24c6dc"), Color.decode("#514a9d"), 3);  // set the background
        rspGeneratedTableScrollPane = new JScrollPane(rspGeneratedTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(rSPContainer.add(newBackground));                                          // add the JPanel to the JFrame
        imageLabel.setIcon(iconImageLabel);// set the layout
        imageLabel2.setIcon(iconImageLabel2);//
        imageLabel3.setIcon(iconImageLabel3);//
        newBackground.setLayout(new FlowLayout());                                  // set the layout

        // font styles
        rSPLabelTopic.setFont(new Font("Serif", Font.BOLD, 40));
        rSPLabelTopic.setForeground(Color.ORANGE);


        startRace();
        lblStartPos.setFont(new Font("Serif", Font.BOLD, 20));             // set the font style
        lblStartPos.setForeground(Color.green);

        String[] raceTableColumnNames = {"TEAM", "NAME", "CURRENT POINTS", "POSITION"};
        rspGeneratedTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, raceTableColumnNames));
        rSPLabelTopic.setText("Race table on : " + stringDate);
        addToTable(raceTeamDetails, rspGeneratedTable);


        newBackground.add(imageLabel).setPreferredSize(new Dimension(60, 50));
        newBackground.add(rSPLabelTopic);
        newBackground.add(lblStartPos);
        newBackground.add(rspGeneratedTableScrollPane).setPreferredSize(new Dimension(900, 400));
        newBackground.add(imageLabel).setPreferredSize(new Dimension(70,60));
        newBackground.add(imageLabel3).setPreferredSize(new Dimension(70,60));
        newBackground.add(imageLabel2).setPreferredSize(new Dimension(70,60));


        setSize(950, 600);
        setTitle("Generate Race");
        setIconImage(iconFrame.getImage());             // set the frame icon

        setResizable(false);                            // not allowing to stretch or resize
        setLocationRelativeTo(null);                     // set the location to the center of the screen
        setVisible(true);                               // // make the frame visible
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        popUpDialog();


    }


    /**
     * Generating the races with the involvement of probability
     */
    public void startRace() {

        raceTeamDetails.clear();
        driversClone.addAll(drivers);                                   // create a clone of the main array list
        Collections.shuffle(driversClone);                              // shuffle the array list. in order to randomise the starting positions
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

            while (true) {
                int probability = (int) (Math.random() * 49);               // random number generate as the index

                if (startingPositionArray[probability] <= driversClone.size()){
                     startPos = startingPositionArray[probability];
                    break;
                }
            }

            if (startPos == 1) {                                        // check whether the starting position is 1
                driver.setFirstPositions(1 + driver.getFirstPositions());
                driver.setCurrentPoints(25 + driver.getCurrentPoints());
                driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                driversClone.remove(driver);

                raceTeam = new RaceTeamData(driver.getTeamOfDriver(), driver.getDriverName(), driver.getCurrentPoints(), 1);
                raceTeamDetails.add(raceTeam); // add a new race to the raceTeamData arraylist

                newRace.setDriverNameTeamNamePosition(driver.getDriverName(), driver.getTeamOfDriver(), 1);
                raceData.add(newRace);          // remove the driver, if not it the driver will duplicate

                lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);
                otherPositions();       // method use to generate other positions of the race
                break;


            } else if (startPos == 2) {                 // check whether the starting position is 2

                driver.setFirstPositions(1 + driver.getFirstPositions());
                driver.setCurrentPoints(25 + driver.getCurrentPoints());
                driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                driversClone.remove(driver);

                raceTeam = new RaceTeamData(driver.getTeamOfDriver(), driver.getDriverName(), driver.getCurrentPoints(), 1);
                raceTeamDetails.add(raceTeam);      // add a new race to the raceTeamData arraylist

                newRace.setDriverNameTeamNamePosition(driver.getDriverName(), driver.getTeamOfDriver(), 1);
                raceData.add(newRace);                   // remove the driver, if not it the driver will duplicate

                lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);

                otherPositions();               // method use to generate other positions of the race
                break;

            } else if (startPos == 3) {             // check whether the starting position is 3

                driver.setFirstPositions(1 + driver.getFirstPositions());
                driver.setCurrentPoints(25 + driver.getCurrentPoints());
                driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                driversClone.remove(driver);        // remove the driver, if not it the driver will duplicate

                raceTeam = new RaceTeamData(driver.getTeamOfDriver(), driver.getDriverName(), driver.getCurrentPoints(), 1);
                raceTeamDetails.add(raceTeam);      // add a new race to the raceTeamData arraylist

                newRace.setDriverNameTeamNamePosition(driver.getDriverName(), driver.getTeamOfDriver(), 1);
                raceData.add(newRace);

                lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);

                otherPositions();               // method use to generate other positions of the race
                break;

            } else if (startPos == 4) {             // check whether the starting position is 4

                driver.setFirstPositions(1 + driver.getFirstPositions());
                driver.setCurrentPoints(25 + driver.getCurrentPoints());
                driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                driversClone.remove(driver);             // remove the driver, if not it the driver will duplicate

                raceTeam = new RaceTeamData(driver.getTeamOfDriver(), driver.getDriverName(), driver.getCurrentPoints(), 1);
                raceTeamDetails.add(raceTeam);                      // add a new race to the raceTeamData arraylist

                newRace.setDriverNameTeamNamePosition(driver.getDriverName(), driver.getTeamOfDriver(), 1);
                raceData.add(newRace);


                lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);

                otherPositions();            // method use to generate other positions of the race
                break;

            } else if (startPos == 5) {             // check whether the starting position is 5

                driver.setFirstPositions(1 + driver.getFirstPositions());
                driver.setCurrentPoints(25 + driver.getCurrentPoints());
                driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                driversClone.remove(driver);        // remove the driver, if not it the driver will duplicate

                raceTeam = new RaceTeamData(driver.getTeamOfDriver(), driver.getDriverName(), driver.getCurrentPoints(), 1);
                raceTeamDetails.add(raceTeam); // add a new race to the raceTeamData arraylist

                newRace.setDriverNameTeamNamePosition(driver.getDriverName(), driver.getTeamOfDriver(), 1);
                raceData.add(newRace);

                lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);

                otherPositions();                // method use to generate other positions of the race
                break;

            } else if (startPos == 6) {

                driver.setFirstPositions(1 + driver.getFirstPositions());
                driver.setCurrentPoints(25 + driver.getCurrentPoints());
                driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                driversClone.remove(driver);            // remove the driver, if not it the driver will duplicate

                raceTeam = new RaceTeamData(driver.getTeamOfDriver(), driver.getDriverName(), driver.getCurrentPoints(), 1);
                raceTeamDetails.add(raceTeam);                  // add a new race to the raceTeamData arraylist

                newRace.setDriverNameTeamNamePosition(driver.getDriverName(), driver.getTeamOfDriver(), 1);
                raceData.add(newRace);

                lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);

                otherPositions();               // method use to generate other positions of the race
                break;


            } else if (startPos == 7) {
                driver.setFirstPositions(1 + driver.getFirstPositions());
                driver.setCurrentPoints(25 + driver.getCurrentPoints());
                driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                driversClone.remove(driver);        // remove the driver, if not it the driver will duplicate

                raceTeam = new RaceTeamData(driver.getTeamOfDriver(), driver.getDriverName(), driver.getCurrentPoints(), 1);
                raceTeamDetails.add(raceTeam); // add a new race to the raceTeamData arraylist

                newRace.setDriverNameTeamNamePosition(driver.getDriverName(), driver.getTeamOfDriver(), 1);
                raceData.add(newRace);

                lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);

                otherPositions();             // method use to generate other positions of the race
                break;

            } else if (startPos == 8) {

                driver.setFirstPositions(1 + driver.getFirstPositions());
                driver.setCurrentPoints(25 + driver.getCurrentPoints());
                driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                driversClone.remove(driver);
//                    startingPositionArrayList.remove(startPos);

                raceTeam = new RaceTeamData(driver.getTeamOfDriver(), driver.getDriverName(), driver.getCurrentPoints(), 1);
                raceTeamDetails.add(raceTeam);                  // add a new race to the raceTeamData arraylist

                newRace.setDriverNameTeamNamePosition(driver.getDriverName(), driver.getTeamOfDriver(), 1);
                raceData.add(newRace);

                lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);

                otherPositions();
                break;

            } else if (startPos == 9) {

                driver.setFirstPositions(1 + driver.getFirstPositions());
                driver.setCurrentPoints(25 + driver.getCurrentPoints());
                driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                driversClone.remove(driver);

                raceTeam = new RaceTeamData(driver.getTeamOfDriver(), driver.getDriverName(), driver.getCurrentPoints(), 1);
                raceTeamDetails.add(raceTeam); // add a new race to the raceTeamData arraylist

                newRace.setDriverNameTeamNamePosition(driver.getDriverName(), driver.getTeamOfDriver(), 1);
                raceData.add(newRace);

                lblStartPos.setText("Starting position of " + driver.getDriverName() + " = " + startPos);

                otherPositions();
                break;
            }
            break;
        }
    }

    /**
     * generate other positions of the race
     */
    public void otherPositions() {

        Collections.shuffle(driversClone);                  // shuffle the array list in order to make sure that the positions are randomise
        for (Formula1Driver formula1Driver : driversClone) {

            RaceDetails newRace1 = new RaceDetails(stringDate);

            // update the details
            if (driversClone.indexOf(formula1Driver) == 0) {
                formula1Driver.setSecondPositions(1 + formula1Driver.getSecondPositions());
                formula1Driver.setCurrentPoints(18 + formula1Driver.getCurrentPoints());                // 2nd positions
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());


            } else if (driversClone.indexOf(formula1Driver) == 1) {
                formula1Driver.setThirdPositions(1 + formula1Driver.getThirdPositions());
                formula1Driver.setCurrentPoints(15 + formula1Driver.getCurrentPoints());              // 3rd positions
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());

            } else if (driversClone.indexOf(formula1Driver) == 2) {
                formula1Driver.setCurrentPoints(12 + formula1Driver.getCurrentPoints());              // 4th positions
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());

            } else if (driversClone.indexOf(formula1Driver) == 3) {
                formula1Driver.setCurrentPoints(10 + formula1Driver.getCurrentPoints());              // 5th positions
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());

            } else if (driversClone.indexOf(formula1Driver) == 4) {
                formula1Driver.setCurrentPoints(8 + formula1Driver.getCurrentPoints());                  // 6th positions
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());

            } else if (driversClone.indexOf(formula1Driver) == 5) {
                formula1Driver.setCurrentPoints(6 + formula1Driver.getCurrentPoints());                   // 7th positions
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());

            } else if (driversClone.indexOf(formula1Driver) == 6) {
                formula1Driver.setCurrentPoints(4 + formula1Driver.getCurrentPoints());               // 8th positions
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());

            } else if (driversClone.indexOf(formula1Driver) == 7) {
                formula1Driver.setCurrentPoints(2 + formula1Driver.getCurrentPoints());                  // 9th positions
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());

            } else if (driversClone.indexOf(formula1Driver) == 8) {
                formula1Driver.setCurrentPoints(1 + formula1Driver.getCurrentPoints());                   // 10th positions
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());

            } else {
                formula1Driver.setNumberOfRaces(1 + formula1Driver.getNumberOfRaces());                 // after 10th position

            }

            raceTeamDetails.add(new RaceTeamData(formula1Driver.getTeamOfDriver(), formula1Driver.getDriverName(), formula1Driver.getCurrentPoints(), driversClone.indexOf(formula1Driver) + 2)); // add a new race to the raceTeamData arraylist

            newRace1.setDriverNameTeamNamePosition(formula1Driver.getDriverName(), formula1Driver.getTeamOfDriver(), driversClone.indexOf(formula1Driver) + 2);
            raceData.add(newRace1);
        }

    }

    /**
     * Add data to the table
     *
     * @param raceTeamDetails array list of RaceTeamData class
     * @param table           JTable
     */
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


    /**
     * check whether there are teams on the system
     */
    public void popUpDialog() {
        if (drivers.size() == 0) {
            JOptionPane optionPane = new JOptionPane("Please add teams to the system", JOptionPane.WARNING_MESSAGE);
            JDialog dialog = optionPane.createDialog("Warning");
            dialog.setIconImage(iconDialogBox.getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
    }

}
