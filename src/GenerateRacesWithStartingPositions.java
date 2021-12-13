import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class GenerateRacesWithStartingPositions extends JFrame {

    JLabel GRLabelTopic;
    JLabel GRSuccessfully;
    JTable generatedTable;
    JScrollPane generatedTableScrollPane;

    ImageIcon iconFrame = new ImageIcon("src/img/fast.png");                // importing the image
    JPanel GRContainer;

    public int[] startingPositionArray = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 6, 7, 8, 9};
    public ArrayList<Formula1Driver> drivers = Formula1ChampionshipManager.getData();                // accessing the array list from Formula1ChampionshipManager
    public ArrayList<RaceDetails> raceData = Formula1ChampionshipManager.getRaceDateData();            //
    ArrayList<Integer> positions = new ArrayList<Integer>();
    ArrayList<Integer> startingPositionArrayList = new ArrayList<Integer>();
    ArrayList<RaceTeamData> raceTeamDetails = new ArrayList<RaceTeamData>();
    public static String stringDate;

    public GenerateRacesWithStartingPositions(){
        GRLabelTopic = new JLabel();
        generatedTable = new JTable();
        GRSuccessfully = new JLabel();
        GRContainer = new JPanel();
        Background newBackground = new Background(Color.decode("#780206"), Color.decode("#061161"),3);  // set the background
        generatedTableScrollPane = new JScrollPane(generatedTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        generateRace();

        String[] raceTableColumnNames = {"TEAM", "NAME", "CURRENT POINTS", "POSITION", "Starting Position"};
        generatedTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, raceTableColumnNames));
        GRLabelTopic.setText("Race table on : " + stringDate);
        addToTable(raceTeamDetails, generatedTable);

        add(GRContainer.add(newBackground));                                          // add the JPanel to the JFrame
        newBackground.setLayout(new FlowLayout());

        GRLabelTopic.setFont(new Font("Serif",Font.BOLD,30));
        GRLabelTopic.setForeground(Color.ORANGE);
        newBackground.add(GRLabelTopic);
        newBackground.add(generatedTableScrollPane).setPreferredSize(new Dimension(900, 400));
        newBackground.add(GRSuccessfully);

//        setLayout(new FlowLayout());
        setSize(950, 600);
        setTitle("Generate Race with starting positions");
        setIconImage(iconFrame.getImage());             // set the frame icon

        setResizable(false);                            // not allowing to stretch or resize
        setLocationRelativeTo(null);                     // set the location to the center of the screen
        setVisible(true);                               // // make the frame visible
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

    }



    public void generateRace() {
        raceTeamDetails.clear();
        positions.clear();
        startingPositionArrayList.clear();

        int day = (int) (Math.random() * (28 - 1 + 1) + 1);             // set random numbers as a day
        int month = (int) (Math.random() * (12 - 1 + 1) + 1);           // set random numbers as a month
        int year = (int) (Math.random() * (2021 - 2015 + 1) + 2015);    // set random numbers as a year

        String stringDay = Integer.toString(day);
        String stringMonth = Integer.toString(month);
//        String stringYear = Integer.toString(year);


        stringDate = stringDay + "/" + stringMonth + "/" + "2021";

        for (int i = 0; i < drivers.size(); i++) {
            RaceDetails newRace = new RaceDetails(stringDate);
            RaceTeamData raceTeam;
            while (true) {
                int position = (int) (Math.random() * (drivers.size() - 1 + 1) + 1);
                if (!(positions.contains(position))) {
                    while (true){
                        int startingPos = (int)(Math.random()* (49) + 0);
                        if((!(startingPositionArrayList.contains(startingPositionArray[startingPos]))) && (startingPositionArray[startingPos] <= drivers.size())){

                            switch (position) {
                                // update the details such as current points and the number of position of the driver according to the user input
                                case 1:
                                    drivers.get(i).setCurrentPoints(25 + drivers.get(i).getCurrentPoints());
                                    drivers.get(i).setFirstPositions(1 + drivers.get(i).getFirstPositions());
                                    drivers.get(i).setNumberOfRaces(1 + drivers.get(i).getNumberOfRaces());

                                    break;
                                case 2:
                                    drivers.get(i).setCurrentPoints(18 + drivers.get(i).getCurrentPoints());
                                    drivers.get(i).setSecondPositions(1 + drivers.get(i).getSecondPositions());
                                    drivers.get(i).setNumberOfRaces(1 + drivers.get(i).getNumberOfRaces());


                                    break;
                                case 3:
                                    drivers.get(i).setCurrentPoints(15 + drivers.get(i).getCurrentPoints());
                                    drivers.get(i).setThirdPositions(1 + drivers.get(i).getThirdPositions());
                                    drivers.get(i).setNumberOfRaces(1 + drivers.get(i).getNumberOfRaces());



                                    break;
                                case 4:
                                    drivers.get(i).setCurrentPoints(12 + drivers.get(i).getCurrentPoints());
                                    drivers.get(i).setNumberOfRaces(1 + drivers.get(i).getNumberOfRaces());



                                    break;
                                case 5:
                                    drivers.get(i).setCurrentPoints(10 + drivers.get(i).getCurrentPoints());
                                    drivers.get(i).setNumberOfRaces(1 + drivers.get(i).getNumberOfRaces());



                                    break;
                                case 6:
                                    drivers.get(i).setCurrentPoints(8 + drivers.get(i).getCurrentPoints());
                                    drivers.get(i).setNumberOfRaces(1 + drivers.get(i).getNumberOfRaces());

                                    break;
                                case 7:
                                    drivers.get(i).setCurrentPoints(6 + drivers.get(i).getCurrentPoints());
                                    drivers.get(i).setNumberOfRaces(1 + drivers.get(i).getNumberOfRaces());



                                    break;
                                case 8:
                                    drivers.get(i).setCurrentPoints(4 + drivers.get(i).getCurrentPoints());
                                    drivers.get(i).setNumberOfRaces(1 + drivers.get(i).getNumberOfRaces());


                                    break;
                                case 9:
                                    drivers.get(i).setCurrentPoints(2 + drivers.get(i).getCurrentPoints());
                                    drivers.get(i).setNumberOfRaces(1 + drivers.get(i).getNumberOfRaces());



                                    break;
                                case 10:
                                    drivers.get(i).setCurrentPoints(1 + drivers.get(i).getCurrentPoints());
                                    drivers.get(i).setNumberOfRaces(1 + drivers.get(i).getNumberOfRaces());



                                    break;
                                default:

                                    drivers.get(i).setNumberOfRaces(1 + drivers.get(i).getNumberOfRaces());
                                    break;
                            }

                            raceTeam = new RaceTeamData(drivers.get(i).getTeamOfDriver(),drivers.get(i).getDriverName(),drivers.get(i).getCurrentPoints(),position,startingPositionArray[startingPos]);
                            raceTeamDetails.add(raceTeam); // add a new race to the raceTeamData arraylist
                            newRace.setDriverNameTeamNamePosition(drivers.get(i).getDriverName(), drivers.get(i).getTeamOfDriver(), position);
                            raceData.add(newRace);

                            startingPositionArrayList.add(startingPositionArray[startingPos]);
                            positions.add(position); // add position in to the array list in validation purpose
                            break;
                        }
                    }
                    break;
                }
            }
        }

    }


    public static void addToTable(ArrayList<RaceTeamData> raceTeamData, JTable table) {
        for (RaceTeamData raceTeam : raceTeamData) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{
                    raceTeam.getTeamName(),
                    raceTeam.getDriverName(),
                    raceTeam.getCurrentPoints(),
                    raceTeam.getPosition(),
                    raceTeam.getStartingPosition()
            });
        }
    }

}
