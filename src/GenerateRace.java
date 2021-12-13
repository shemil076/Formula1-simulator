import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;



public class GenerateRace extends JFrame {
    public ArrayList<Formula1Driver> driver = Formula1ChampionshipManager.getData();                // accessing the array list from Formula1ChampionshipManager
    public ArrayList<RaceDetails> Races = Formula1ChampionshipManager.getRaceDateData();            //accessing the array list from Formula1ChampionshipManager
    ArrayList<Integer> positionsArrayList = new ArrayList<Integer>();
    ArrayList<RaceTeamData> raceTeamData = new ArrayList<RaceTeamData>();

    ImageIcon iconDialogBox = new ImageIcon("src/img/warning.png") ;

    JLabel labelDate;
    JLabel successfully;
    JTable raceTable;
    JScrollPane raceTableScrollPane;




    public static String stringDate;
    ImageIcon iconFrame = new ImageIcon("src/img/fast.png");                // importing the image
    JPanel container;


    public GenerateRace() {
        labelDate = new JLabel();
        raceTable = new JTable();
        successfully = new JLabel();
        container = new JPanel();
        Background newBackground = new Background(Color.decode("#780206"), Color.decode("#061161"),3);  // set the background

        add(container.add(newBackground));                                          // add the JPanel to the JFrame
        newBackground.setLayout(new FlowLayout());                                  // set the layout

        // font styles
        labelDate.setFont(new Font("Serif",Font.BOLD,30));
        labelDate.setForeground(Color.ORANGE);
        successfully.setFont(new Font("Serif",Font.BOLD,24));
        successfully.setForeground(Color.YELLOW);

        raceNow();              // creating random races

        raceTable.setBackground(Color.magenta);     // set the table colour
        raceTable.setOpaque(true);                  // set the opacity

        raceTableScrollPane = new JScrollPane(raceTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        String[] raceTableColumnNames = {"TEAM", "NAME", "CURRENT POINTS", "POSITION"};             // column names
        raceTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, raceTableColumnNames));        // setting the default table model
        labelDate.setText("Race table on : " + stringDate);
        addToTable(raceTeamData, raceTable);                                // adding data to the

//        labelDate.setText(stringDate);
        newBackground.add(labelDate);
        newBackground.add(raceTableScrollPane).setPreferredSize(new Dimension(900, 400));
        newBackground.add(successfully);

//        setLayout(new FlowLayout());
        setSize(950, 600);
        setTitle("Generate Race");
        setIconImage(iconFrame.getImage());             // set the frame icon

        setResizable(false);                            // not allowing to stretch or resize
        setLocationRelativeTo(null);                     // set the location to the center of the screen
        setVisible(true);                               // // make the frame visible
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        greet();
//
    }


    /**
     * check whether there are teams in the system
     */
    public void greet(){
        if (driver.size() > 0){
            successfully.setText("✨ Congratulations You have successfully generate a race ✨");
        }else{
            popUpDialog();
        }
    }

    /**
     * generate random races
     */
    public void raceNow() {
        raceTeamData.clear();
        positionsArrayList.clear();
        int day = (int) (Math.random() * (28 - 1 + 1) + 1);             // set random numbers as a day
        int month = (int) (Math.random() * (12 - 1 + 1) + 1);           // set random numbers as a month
//        int year = (int) (Math.random() * (2021 - 2015 + 1) + 2015);    // set random numbers as a year

        String stringDay = Integer.toString(day);
        String stringMonth = Integer.toString(month);
//        String stringYear = Integer.toString(year);

        stringDate = stringDay + "/" + stringMonth + "/" + "2021";

        // use the same method as in the add race method
        for (int i = 0; i < driver.size(); i++) {
            RaceDetails newRace = new RaceDetails(stringDate);
            while (true) {
                int position = (int) (Math.random() * (driver.size() - 1 + 1) + 1);  // generate random positions
                if (!(positionsArrayList.contains(position))) {   // prove that there cannot be more than one driver in a single position
                    switch (position) {
                        // update the details such as current points and the number of position of the driver according to the user input
                        case 1:
                            driver.get(i).setCurrentPoints(25 + driver.get(i).getCurrentPoints());
                            driver.get(i).setFirstPositions(1 + driver.get(i).getFirstPositions());
                            driver.get(i).setNumberOfRaces(1 + driver.get(i).getNumberOfRaces());
                            break;
                        case 2:
                            driver.get(i).setCurrentPoints(18 + driver.get(i).getCurrentPoints());
                            driver.get(i).setSecondPositions(1 + driver.get(i).getSecondPositions());
                            driver.get(i).setNumberOfRaces(1 + driver.get(i).getNumberOfRaces());

                            break;
                        case 3:
                            driver.get(i).setCurrentPoints(15 + driver.get(i).getCurrentPoints());
                            driver.get(i).setThirdPositions(1 + driver.get(i).getThirdPositions());
                            driver.get(i).setNumberOfRaces(1 + driver.get(i).getNumberOfRaces());

                            break;
                        case 4:
                            driver.get(i).setCurrentPoints(12 + driver.get(i).getCurrentPoints());
                            driver.get(i).setNumberOfRaces(1 + driver.get(i).getNumberOfRaces());

                            break;
                        case 5:
                            driver.get(i).setCurrentPoints(10 + driver.get(i).getCurrentPoints());
                            driver.get(i).setNumberOfRaces(1 + driver.get(i).getNumberOfRaces());

                            break;
                        case 6:
                            driver.get(i).setCurrentPoints(8 + driver.get(i).getCurrentPoints());
                            driver.get(i).setNumberOfRaces(1 + driver.get(i).getNumberOfRaces());
                            break;
                        case 7:
                            driver.get(i).setCurrentPoints(6 + driver.get(i).getCurrentPoints());
                            driver.get(i).setNumberOfRaces(1 + driver.get(i).getNumberOfRaces());

                            break;
                        case 8:
                            driver.get(i).setCurrentPoints(4 + driver.get(i).getCurrentPoints());
                            driver.get(i).setNumberOfRaces(1 + driver.get(i).getNumberOfRaces());

                            break;
                        case 9:
                            driver.get(i).setCurrentPoints(2 + driver.get(i).getCurrentPoints());
                            driver.get(i).setNumberOfRaces(1 + driver.get(i).getNumberOfRaces());

                            break;
                        case 10:
                            driver.get(i).setCurrentPoints(1 + driver.get(i).getCurrentPoints());
                            driver.get(i).setNumberOfRaces(1 + driver.get(i).getNumberOfRaces());

                            break;
                        default:

                            driver.get(i).setNumberOfRaces(1 + driver.get(i).getNumberOfRaces());
                            break;
                    }

                    raceTeamData.add(new RaceTeamData(driver.get(i).getTeamOfDriver(),driver.get(i).getDriverName(),driver.get(i).getCurrentPoints(),position)); // add a new race to the raceTeamData arraylist
                    newRace.setDriverNameTeamNamePosition(driver.get(i).getDriverName(), driver.get(i).getTeamOfDriver(), position);
                    Races.add(newRace);

                    positionsArrayList.add(position); // add position in to the array list in validation purpose
                    break;
                }
            }
        }
    }


    /**
     * add data to the table
     * @param raceTeamData arraylist in RaceTeamData
     * @param table JTable
     */
    public static void addToTable(ArrayList<RaceTeamData> raceTeamData, JTable table) {
        for (RaceTeamData raceTeam : raceTeamData) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{                     // pass the objects to the default table module.
                    raceTeam.getTeamName(),                                                 // Team name
                    raceTeam.getDriverName(),                                               // Driver Name
                    raceTeam.getCurrentPoints(),                                            // current points
                    raceTeam.getPosition()                                                  // positions
            });
        }
    }

    /**
     * check whether there are teams on the system
     */
    public void popUpDialog(){
        if (driver.size() == 0){
            JOptionPane optionPane = new JOptionPane("Please add teams to the system",JOptionPane.WARNING_MESSAGE);
            JDialog dialog = optionPane.createDialog("Warning");
            dialog.setIconImage(iconDialogBox.getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
    }
}
