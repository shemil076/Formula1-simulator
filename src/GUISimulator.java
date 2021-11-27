import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;


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
    ImageIcon iconFrame = new ImageIcon("src/img/fast.png") ;
    ImageIcon iconSortStatisticsInDescending = new ImageIcon("src/img/descending.png") ;
    ImageIcon iconSortPointsInAscending = new ImageIcon("src/img/ascending.png") ;
    ImageIcon iconFirstPositionsDescending = new ImageIcon("src/img/positions.png") ;
    ImageIcon iconGenerateRandomRace = new ImageIcon("src/img/racing.png") ;
    ImageIcon iconGenerateResults = new ImageIcon("src/img/stage.png") ;
    ImageIcon iconDisplayCompleteRace = new ImageIcon("src/img/finish.png") ;
    ImageIcon iconSearchDriver = new ImageIcon("src/img/search.png") ;




    JPanel container;


    public GUISimulator() {

        container = new JPanel();


        labelTopic = new JLabel();
        Background newBackground = new Background(Color.cyan,Color.magenta,3);



//        container.setLayout(new BorderLayout());
        add(container.add(newBackground));

        sortStatisticsInDescending = new JButton("Sort Statistics",iconSortStatisticsInDescending);
        sortPointsInAscending = new JButton("Sort Points",iconSortPointsInAscending);
        firstPositionsDescending = new JButton("Sort Positions",iconFirstPositionsDescending);
        generateRandomRace = new JButton("Generate Race",iconGenerateRandomRace);
        generateResults = new JButton("Generate Results",iconGenerateResults);
        displayCompleteRace = new JButton("Display Races",iconDisplayCompleteRace);
        searchDriver = new JButton("Search Race",iconSearchDriver);
        driverTable = new JTable();
        driverTableScrollPane = new JScrollPane(driverTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        driverTable.setBackground(Color.yellow);
        driverTable.setOpaque(true);

        labelTopic.setText("🚔 Formula 1 Driver Table 🚔");
        labelTopic.setFont(new Font("Serif",Font.BOLD,24));
        labelTopic.setForeground(Color.black);

        String[] columnNames = {"NAME", "TEAM", "COUNTRY", "NO.OF RACES", "POINTS", "1stPOSES", "2ndPOSES", "3rdPOSES"};
        driverTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, columnNames));                   // setting the model of table
        insertToTable(driver, driverTable);                                                                             // insert data by calling the method that create to insert data


//        setLayout(new FlowLayout());
        newBackground.setLayout(new FlowLayout());


        setSize(950, 600);
        setTitle("Formula1 simulator");
        setIconImage(iconFrame.getImage());

        sortStatisticsInDescending.setToolTipText("Display statistics in descending order of points..");
        sortPointsInAscending.setToolTipText("Sort points of the driver according to ascending order..");
        firstPositionsDescending.setToolTipText("Sort in descending order according to the number of first positions.. ");
        generateRandomRace.setToolTipText("Generate (one) random race..");
        generateResults.setToolTipText("Generate results..");
        displayCompleteRace.setToolTipText("Display races in ascending order according to the date");
        searchDriver.setToolTipText("Search details about race");


        sortStatisticsInDescending.addActionListener(this);
        sortPointsInAscending.addActionListener(this);
        firstPositionsDescending.addActionListener(this);
        generateRandomRace.addActionListener(this);
        generateResults.addActionListener(this);
        displayCompleteRace.addActionListener(this);
        searchDriver.addActionListener(this);





        newBackground.add(labelTopic);
        newBackground.add(driverTableScrollPane).setPreferredSize(new Dimension(900, 400));
        newBackground.add(sortStatisticsInDescending);
        newBackground.add(sortPointsInAscending);
        newBackground.add(firstPositionsDescending);
        newBackground.add(generateRandomRace);
        newBackground.add(generateResults);
        newBackground.add(displayCompleteRace);
        newBackground.add(searchDriver);

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * insert data into a table as rows from an array list
     * @param f1Driver pass the array list
     * @param driverTable JTable parameter
     */
    public static void insertToTable(ArrayList<Formula1Driver> f1Driver, JTable driverTable) {
        for (Formula1Driver formulaDriverTeams : f1Driver) {
            ((DefaultTableModel) driverTable.getModel()).addRow(new Object[]{
                    formulaDriverTeams.getDriverName(),
                    formulaDriverTeams.getTeamOfDriver(),
                    formulaDriverTeams.getDriverLocation(),
                    formulaDriverTeams.getNumberOfRaces(),
                    formulaDriverTeams.getCurrentPoints(),
                    formulaDriverTeams.getFirstPositions(),
                    formulaDriverTeams.getSecondPositions(),
                    formulaDriverTeams.getThirdPositions()

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
        removeRows();
        Collections.sort(Formula1ChampionshipManager.formulaDriverTeams);
        labelTopic.setText("🚔 Formula driver table in descending order according to the points 🚔");
        insertToTable(driver, driverTable);
    }

    /**
     * Sorting the array list in ascending order according to the number of points
     */
    public void sortPointsInAscending() {
        removeRows();
        Collections.sort(Formula1ChampionshipManager.formulaDriverTeams, Formula1Driver.PointsInAscending);
        labelTopic.setText("🚔Formula driver table in ascending order according to the points 🚔");
        insertToTable(driver, driverTable);
    }

    /**
     * Sorting the array list in descending order according to the number of first positions
     */
    public void sortPositionsInDescending() {
        removeRows();
        Collections.sort(Formula1ChampionshipManager.formulaDriverTeams, Formula1Driver.FirstPositionsDescending);
        labelTopic.setText("🚔 Formula driver table in descending order according to the FIRST POSITIONS 🚔");
        insertToTable(driver, driverTable);

    }




    /**
     * Overide the actionPerformed method
     * @param e action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(sortStatisticsInDescending)) {
            sortStatisticsInDescending();

        } else if (e.getSource().equals(sortPointsInAscending)) {
            sortPointsInAscending();


        } else if (e.getSource().equals(firstPositionsDescending)) {
            sortPositionsInDescending();

        } else if (e.getSource().equals(generateRandomRace)) {
            new GenerateRace() ;

        } else if (e.getSource().equals(generateResults)) {


        } else if (e.getSource().equals(displayCompleteRace)) {
            new  DisplayRaces();

        }else if (e.getSource().equals(searchDriver)) {
            new SearchDriver();

        }
    }
}




