import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;

public class GUISimulator extends JFrame implements ActionListener, Comparable<Formula1Driver> {
    JButton sortStatisticsInDescending;
    JButton sortPointsInAscending;
    JButton firstPositionsDescending;
    JButton generateRandomRace;
    JButton generateResults;
    JButton displayCompleteRace;
    JButton searchRace;
    JLabel labelTopic;
    public ArrayList<Formula1Driver> driver = Formula1ChampionshipManager.getData();
    JTable driverTable;
    JScrollPane driverTableScrollPane;


    public GUISimulator(){

        labelTopic = new JLabel();
        sortStatisticsInDescending = new JButton("Sort Statistics");
        sortPointsInAscending = new JButton("Sort Points");
        firstPositionsDescending = new JButton("Sort Positions");
        generateRandomRace = new JButton("Generate Race");
        generateResults = new JButton("Generate Results");
        displayCompleteRace = new JButton("Display Races");
        searchRace = new JButton("Search Race");
        driverTable = new JTable();
        driverTableScrollPane = new JScrollPane(driverTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);



        labelTopic.setText("Formula 1 Driver Table");
        String[] columnNames = {"NAME", "TEAM", "COUNTRY", "NO.OF RACES", "POINTS", "1stPOSES", "2ndPOSES", "3rdPOSES"};
        driverTable.setModel(new javax.swing.table.DefaultTableModel(new Object [][]{}, columnNames));
        insertToTable(driver, driverTable);



        setLayout(new FlowLayout());
        setSize(950,600);
        setTitle("Formula1 simulator");

//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sortStatisticsInDescending.setToolTipText("Display statistics in descending order of points..");
        sortPointsInAscending.setToolTipText("Sort points of the driver according to ascending order..");
        firstPositionsDescending.setToolTipText("Sort in descending order according to first points.. ");
        generateRandomRace.setToolTipText("Generate (one) random race..");
        generateResults.setToolTipText("Generate results..");
        displayCompleteRace.setToolTipText("Display races in ascending order according to the date");
        searchRace.setToolTipText("Search details about race");


        sortStatisticsInDescending.addActionListener(this);

        add(labelTopic);
        add(driverTableScrollPane).setPreferredSize(new Dimension(900,400));
        add(sortStatisticsInDescending);
        add(sortPointsInAscending);
        add(firstPositionsDescending);
        add(generateRandomRace);
        add(generateResults);
        add(displayCompleteRace);
        add(searchRace);

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void insertToTable(ArrayList<Formula1Driver>f1Driver,JTable table){
        for(Formula1Driver formulaDriverTeams: f1Driver){
            ((DefaultTableModel)table.getModel()).addRow(new Object[]{
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
//    public void sort(){
//        Collections.sort(Formula1ChampionshipManager.formulaDriverTeams);
//    }

    public void removeRows(){
        DefaultTableModel dm = (DefaultTableModel) driverTable.getModel();
        int rowCount = dm.getRowCount();
//Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }


    @Override
    public int compareTo(Formula1Driver o) {
        return 0;
    }

    @Override
    public  void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(sortStatisticsInDescending)){
            removeRows();
            Collections.sort(Formula1ChampionshipManager.formulaDriverTeams);
            labelTopic.setText("Formula driver table in descending order according to the points..");
            insertToTable(driver, driverTable);
        }
    }


}
