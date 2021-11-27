import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;

public class SearchDriver extends JFrame implements ActionListener {
    ImageIcon iconFrame = new ImageIcon("src/img/fast.png");
    public ArrayList<RaceDetails> raceDataList = Formula1ChampionshipManager.getRaceDateData();
    public ArrayList<DriverRaceData> racerData = new ArrayList<DriverRaceData>();

    JLabel labelTopic;
    JLabel labelWarnings;
    JTextField searchRacer;
    JButton searchButton;
    JTable racerTable;
    JScrollPane racerTableScrollPane;
    ImageIcon iconSearchButton = new ImageIcon("src/img/searchName.png") ;
    JPanel container;

    public SearchDriver() {

        searchRacer = new JTextField(30);
        searchButton = new JButton("Search",iconSearchButton);
        labelTopic = new JLabel();
        labelWarnings = new JLabel();
        racerTable = new JTable();
        racerTableScrollPane = new JScrollPane(racerTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        container = new JPanel();




        Background newBackground = new Background(Color.decode("#360033"), Color.decode("#0b8793"),3);
        add(container.add(newBackground));
        newBackground.setLayout(new FlowLayout());

        labelTopic.setText("🔍 Enter the name of the driver 🔍");

        labelTopic.setFont(new Font("Serif",Font.BOLD,30));
        labelTopic.setForeground(Color.orange);
        labelWarnings.setFont(new Font("Serif",Font.BOLD,24));
        labelWarnings.setForeground(Color.YELLOW);



        String[] racerTableColumnNames = {"DRIVER NAME", "TEAM NAME", "DATE", "POSITION"};
        racerTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, racerTableColumnNames));

        racerTable.setBackground(Color.decode("#ffd194"));
        racerTable.setOpaque(true);
        addToRacerData();

        newBackground.add(labelTopic);
        newBackground.add(searchRacer).setPreferredSize(new Dimension(100, 25));
        newBackground.add(searchButton);
        newBackground.add(racerTableScrollPane).setPreferredSize(new Dimension(900, 400));
        newBackground.add(labelWarnings);


        searchButton.setToolTipText("Enter the full name of the driver.");
        searchButton.addActionListener(this);

        labelWarnings.setFont(new Font("Serif", Font.BOLD, 20));
        setIconImage(iconFrame.getImage());
//        setLayout(new FlowLayout());
        setSize(950, 600);
        setTitle("Search Driver");
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void addToRacerData() {
        for (RaceDetails raceDetails : raceDataList) {
            DriverRaceData newDiverData = new DriverRaceData(raceDetails.getDriverNameInRace(), raceDetails.getteamNameInRace(), raceDetails.getRaceDate(), raceDetails.getPosition());
            racerData.add(newDiverData);
        }
    }

    public void insertToRacerTable(ArrayList<DriverRaceData> racerData, JTable racerTable) {

        String getRacerInput = searchRacer.getText().toUpperCase();
        if (checkInput(getRacerInput)) {

            for (DriverRaceData racer : racerData) {
                String containName = racer.getRacerName();
                if (containName.equalsIgnoreCase(getRacerInput)) {
                    ((DefaultTableModel) racerTable.getModel()).addRow(new Object[]{
                            racer.getRacerName(),
                            racer.getRacerTeamName(),
                            racer.getRaceDate(),
                            racer.getRacerPosition()

                    });

                }
            }
        } else {
            labelWarnings.setText("⚠️Sorry incorrect name input ⚠️");

        }
    }


    public boolean checkInput(String inputName) {
        boolean foundName = false;
        for (DriverRaceData findRacerName : racerData) {
            if (findRacerName.getRacerName().equalsIgnoreCase(inputName)) {
                foundName = true;
                break;
            } else {
                foundName = false;
            }

        }
        return foundName;
    }

    public void removeRows() {                                                                                          // reference: https://www.codegrepper.com/code-examples/whatever/java+swing+jtable+remove+all+rows
        DefaultTableModel model = (DefaultTableModel) racerTable.getModel();
        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    public boolean checkTeams() {
        boolean foundTeams = false;
        if (racerData.size() > 0) {
            foundTeams = true;
        } else {
            foundTeams = false;

        }
        return foundTeams;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (checkTeams()) {
            if (e.getSource().equals(searchButton)) {
                labelWarnings.setText("");
                removeRows();
                insertToRacerTable(racerData, racerTable);
            }
        }else{
            labelWarnings.setText("⚠️No Races in the system, Please add races⚠️");

        }

    }
}
