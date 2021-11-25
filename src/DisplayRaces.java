import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class DisplayRaces extends JFrame {

    public ArrayList<RaceDetails> raceData = Formula1ChampionshipManager.getRaceDateData();
    JLabel labelTopic;
    JTable displayRacesTable;
    JScrollPane displayRacesTableScrollPane;
    ImageIcon iconFrame = new ImageIcon("src/img/fast.png") ;

    public DisplayRaces(){

        labelTopic = new JLabel();
        displayRacesTable = new JTable();
        sortDate();

        displayRacesTableScrollPane = new JScrollPane(displayRacesTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        String[] displayRacesTableColumnNames = {"DATE", "TEAM NAME", "DRIVER NAME", "POSITION"};
        labelTopic.setText("Races Detail table sorted according to date");
        displayRacesTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, displayRacesTableColumnNames));
        addToDisplayRacesTable(raceData,displayRacesTable);
        add(labelTopic);
        add(displayRacesTableScrollPane).setPreferredSize(new Dimension(900, 400));



        setIconImage(iconFrame.getImage());
        sortDate();
        setLayout(new FlowLayout());
        setSize(950, 600);
        setTitle("Display Races");
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    public static Comparator<RaceDetails> raceInfo = new Comparator<RaceDetails>(){
        DateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
        @Override
        public int compare(RaceDetails raceDate1, RaceDetails raceDate2) {
            try {
                return formattedDate.parse(raceDate1.getRaceDate()).compareTo(formattedDate.parse(raceDate2.getRaceDate()));
            } catch (ParseException e) {
                throw new RuntimeException();
            }

        }
    };

    public void sortDate(){
        Collections.sort(Formula1ChampionshipManager.raceDetailsList,raceInfo);
    }

    public static void addToDisplayRacesTable(ArrayList<RaceDetails> raceData, JTable table) {
        for (RaceDetails raceTeamData : raceData) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{
                    raceTeamData.getRaceDate(),
                    raceTeamData.getTeamNamesInRace(),
                    raceTeamData.getDriverNameInRace(),
                    raceTeamData.getPosition()
            });
        }
    }

}
