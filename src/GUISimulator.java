import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import static com.sun.tools.javac.resources.CompilerProperties.Warnings.Warning;


public class GUISimulator extends JFrame implements ActionListener {
    JButton sortStatisticsInDescending;
    JButton sortPointsInAscending;
    JButton firstPositionsDescending;
    JButton generateRandomRace;
    JButton generateResults;
    JButton displayCompleteRace;
    JButton searchDriver;
    JLabel labelTopic;
    public ArrayList<Formula1Driver> driver = Formula1ChampionshipManager.getData();    // accessing an array list in Formula1ChampionshipManager class
    JTable driverTable;
    JScrollPane driverTableScrollPane;


    // get images
    ImageIcon iconFrame = new ImageIcon("src/img/fast.png") ;
    ImageIcon iconSortStatisticsInDescending = new ImageIcon("src/img/descending.png") ;
    ImageIcon iconSortPointsInAscending = new ImageIcon("src/img/ascending.png") ;
    ImageIcon iconFirstPositionsDescending = new ImageIcon("src/img/positions.png") ;
    ImageIcon iconGenerateRandomRace = new ImageIcon("src/img/racing.png") ;
    ImageIcon iconGenerateResults = new ImageIcon("src/img/stage.png") ;
    ImageIcon iconDisplayCompleteRace = new ImageIcon("src/img/finish.png") ;
    ImageIcon iconSearchDriver = new ImageIcon("src/img/search.png") ;
    ImageIcon iconDialogBox = new ImageIcon("src/img/warning.png") ;

    JPanel container;

    public GUISimulator() {
        container = new JPanel();

        labelTopic = new JLabel();
        Background newBackground = new Background(Color.cyan,Color.magenta,3);             // set the background color

//        container.setLayout(new BorderLayout());
        add(container.add(newBackground));

        // initializing buttons with icons
        sortStatisticsInDescending = new JButton("Sort Statistics",iconSortStatisticsInDescending);
        sortPointsInAscending = new JButton("Sort Points",iconSortPointsInAscending);
        firstPositionsDescending = new JButton("Sort Positions",iconFirstPositionsDescending);
        generateRandomRace = new JButton("Generate Race",iconGenerateRandomRace);
        generateResults = new JButton("Generate Results",iconGenerateResults);
        displayCompleteRace = new JButton("Display Races",iconDisplayCompleteRace);
        searchDriver = new JButton("Search Race",iconSearchDriver);


        driverTable = new JTable();
        driverTableScrollPane = new JScrollPane(driverTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        driverTable.setBackground(Color.yellow);                // set the background colour of the table
        driverTable.setOpaque(true);

        labelTopic.setText("🚔 Formula 1 Driver Table 🚔");
        labelTopic.setFont(new Font("Serif",Font.BOLD,24));             // set the font style
        labelTopic.setForeground(Color.black);

        String[] columnNames = {"NAME", "TEAM", "COUNTRY", "NO.OF RACES", "POINTS", "1stPOSES", "2ndPOSES", "3rdPOSES"};    // column names
        driverTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, columnNames));                   // setting the model of table
        insertToTable(driver, driverTable);                                                                             // insert data by calling the method that create to insert data


//        setLayout(new FlowLayout());
        newBackground.setLayout(new FlowLayout());              // set the layout


        setSize(950, 600);              // set the Frame size
        setTitle("Formula1 simulator");             // set the Frame name
        setIconImage(iconFrame.getImage());         // set a Favicon

        // setting tool tips
        sortStatisticsInDescending.setToolTipText("Display statistics in descending order of points..");
        sortPointsInAscending.setToolTipText("Sort points of the driver according to ascending order..");
        firstPositionsDescending.setToolTipText("Sort in descending order according to the number of first positions.. ");
        generateRandomRace.setToolTipText("Generate (one) random race..");
        generateResults.setToolTipText("Generate results..");
        displayCompleteRace.setToolTipText("Display races in ascending order according to the date");
        searchDriver.setToolTipText("Search details about race");


        // actions
        sortStatisticsInDescending.addActionListener(this);
        sortPointsInAscending.addActionListener(this);
        firstPositionsDescending.addActionListener(this);
        generateRandomRace.addActionListener(this);
        generateResults.addActionListener(this);
        displayCompleteRace.addActionListener(this);
        searchDriver.addActionListener(this);




        // adding components to the JPanel
        newBackground.add(labelTopic);
        newBackground.add(driverTableScrollPane).setPreferredSize(new Dimension(900, 400));                 // set the size of the scroll pane
        newBackground.add(sortStatisticsInDescending);
        newBackground.add(sortPointsInAscending);
        newBackground.add(firstPositionsDescending);
        newBackground.add(generateRandomRace);
        newBackground.add(generateResults);
        newBackground.add(displayCompleteRace);
        newBackground.add(searchDriver);



        setResizable(false);            // not allow to resize
        setLocationRelativeTo(null);    // show the frame in the center of the screen
        setVisible(true);               // giving access to show the JFrame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      // terminate the program when needed.
        setAlwaysOnTop(true);

        popUpDialog();

    }

    /**
     * insert data into a table as rows from an array list
     * @param f1Driver pass the array list
     * @param driverTable JTable parameter
     */
    public static void insertToTable(ArrayList<Formula1Driver> f1Driver, JTable driverTable) {
        for (Formula1Driver formulaDriverTeams : f1Driver) {
            ((DefaultTableModel) driverTable.getModel()).addRow(new Object[]{                   // pass the objects to the default table module.
                    formulaDriverTeams.getDriverName(),                                         //  Driver name
                    formulaDriverTeams.getTeamOfDriver(),                                       //  Team name of the driver
                    formulaDriverTeams.getDriverLocation(),                                     //  Location of the driver
                    formulaDriverTeams.getNumberOfRaces(),                                      //  number of races
                    formulaDriverTeams.getCurrentPoints(),                                      //  current positions
                    formulaDriverTeams.getFirstPositions(),                                     // number of first positions
                    formulaDriverTeams.getSecondPositions(),                                    // number of second positions
                    formulaDriverTeams.getThirdPositions()                                      // number of third positions

            });
        }
    }

    /**
     * Remove the rows from the table
     */
    public void removeRows() {                                                                                          // reference: https://www.codegrepper.com/code-examples/whatever/java+swing+jtable+remove+all+rows
        DefaultTableModel model = (DefaultTableModel) driverTable.getModel();
        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    /**
     * Sorting the array list in descending order according to the number of points
     */
    public void sortStatisticsInDescending() {
        if (driver.size() == 0){
            JOptionPane optionPane = new JOptionPane("Teams not found \n Add teams before proceeding",JOptionPane.WARNING_MESSAGE);
            JDialog dialog = optionPane.createDialog("404 Warning");
            dialog.setIconImage(iconDialogBox.getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }

        removeRows();
        Collections.sort(Formula1ChampionshipManager.formulaDriverTeams);                                           // calling the sort in descending order according to the number of points
        labelTopic.setText("🚔 Formula driver table in descending order according to the points 🚔");
        insertToTable(driver, driverTable);                                                                         // inserting data to the table
    }

    /**
     * Sorting the array list in ascending order according to the number of points
     */
    public void sortPointsInAscending() {
        if (driver.size() == 0){
            JOptionPane optionPane = new JOptionPane("Teams not found \n Add teams before proceeding",JOptionPane.WARNING_MESSAGE);
            JDialog dialog = optionPane.createDialog("404 Warning");
            dialog.setIconImage(iconDialogBox.getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }

        removeRows();
        Collections.sort(Formula1ChampionshipManager.formulaDriverTeams, Formula1Driver.PointsInAscending);            // calling the sort in ascending order according to number of points
        labelTopic.setText("🚔Formula driver table in ascending order according to the points 🚔");
        insertToTable(driver, driverTable);                                                                              // inserting data to the table
    }

    /**
     * Sorting the array list in descending order according to the number of first positions
     */
    public void sortPositionsInDescending() {
        if (driver.size() == 0){
            JOptionPane optionPane = new JOptionPane("Teams not found \n Add teams before proceeding",JOptionPane.WARNING_MESSAGE);
            JDialog dialog = optionPane.createDialog("404 Warning");
            dialog.setIconImage(iconDialogBox.getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }

        removeRows();
        Collections.sort(Formula1ChampionshipManager.formulaDriverTeams, Formula1Driver.FirstPositionsDescending);      // calling the sort method in descending order according to number of first positions
        labelTopic.setText("🚔 Formula driver table in descending order according to the FIRST POSITIONS 🚔");
        insertToTable(driver, driverTable);                                                                              // inserting data to the table

    }

    /**
     *  check whether there are teams on the system
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



    /**
     * Overide the actionPerformed method
     * @param e action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(sortStatisticsInDescending)) {         // if  "Sort Statistics"  button pressed
            sortStatisticsInDescending();

        } else if (e.getSource().equals(sortPointsInAscending)) {       // if  "Sort Points"  button pressed
            sortPointsInAscending();

        } else if (e.getSource().equals(firstPositionsDescending)) {   // if  "Sort Positions"  button pressed
            sortPositionsInDescending();

        } else if (e.getSource().equals(generateRandomRace)) {          // if  "Generate Race"  button pressed
            new GenerateRace() ;

        } else if (e.getSource().equals(generateResults)) {             // if  "Generate Results" button pressed
            new ProbabilityRace();

        } else if (e.getSource().equals(displayCompleteRace)) {         // if  "Display Races"  button pressed
            new  DisplayRaces();

        }else if (e.getSource().equals(searchDriver)) {                 // if  "Search Race"  button pressed
            new SearchDriver();
        }
    }
}









