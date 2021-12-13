import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;

public class SearchDriver extends JFrame implements ActionListener {
    ImageIcon iconFrame = new ImageIcon("src/img/fast.png");
    ImageIcon iconDialogBox = new ImageIcon("src/img/warning.png") ;
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
        setAlwaysOnTop(true);

        popUpDialog();
    }

    /**
     * add details DriverRaceData class array
     */
    public void addToRacerData() {
        for (RaceDetails raceDetails : raceDataList) {
            DriverRaceData newDiverData = new DriverRaceData(raceDetails.getDriverNameInRace(), raceDetails.getteamNameInRace(), raceDetails.getRaceDate(), raceDetails.getPosition());
            racerData.add(newDiverData);
        }
    }


    /**
     * add data to the table
     * @param racerData DriverRaceData class array
     * @param racerTable JTable
     */
    public void insertToRacerTable(ArrayList<DriverRaceData> racerData, JTable racerTable) {

        String getRacerInput = searchRacer.getText().toUpperCase();
        if (checkInput(getRacerInput)) {                                // check the input gain from the user is valid or not
            for (DriverRaceData racer : racerData) {
                String containName = racer.getRacerName();              // find the matching object to the user input

                // add the detail for the table
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

            // if the user input in not valid, popup a dialog box
            labelWarnings.setText("⚠️Sorry incorrect name input ⚠️");
            JOptionPane optionPane = new JOptionPane("404 Driver Not Found",JOptionPane.WARNING_MESSAGE);
            JDialog dialog = optionPane.createDialog("404 Warning");
            dialog.setIconImage(iconDialogBox.getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);

        }
    }


    /**
     * check the input gain from the user is valid or not
     * @param inputName boolean value
     * @return a boolean value
     */
    public boolean checkInput(String inputName) {
        boolean foundName = false;
        for (DriverRaceData findRacerName : racerData) {
            if (findRacerName.getRacerName().equalsIgnoreCase(inputName)) {    //   find the matching object
                foundName = true;
                break;
            } else {
                foundName = false;
            }

        }
        return foundName;
    }

    /**
     * remove previous rows of the table in order to add new details
     */
    public void removeRows() {                                                                         // reference: https://www.codegrepper.com/code-examples/whatever/java+swing+jtable+remove+all+rows
        DefaultTableModel model = (DefaultTableModel) racerTable.getModel();
        int rowCount = model.getRowCount();

        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    /**
     * check whether there are teams in the system
     * @return boolean value
     */
    public boolean checkTeams() {
        boolean foundTeams = false;
        if (racerData.size() > 0) {
            foundTeams = true;
        } else {
            foundTeams = false;

        }
        return foundTeams;
    }


    /**
     * overide the actionPerformed
     * @param e event
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if (checkTeams()) {
            if (e.getSource().equals(searchButton)) {

                // set the output that user request
                labelWarnings.setText("");
                removeRows();
                insertToRacerTable(racerData, racerTable);
            }
        }else{
            labelWarnings.setText("⚠️No Races in the system, Please add races⚠️");
            JOptionPane optionPane = new JOptionPane("Please add races",JOptionPane.WARNING_MESSAGE);
            JDialog dialog = optionPane.createDialog("Warning");
            dialog.setIconImage(iconDialogBox.getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }

    }

    /**
     * pass a dialog box if there are no team in the system
     */
    public void popUpDialog(){
        if (raceDataList.size() == 0){
            JOptionPane optionPane = new JOptionPane("Please add teams to the system",JOptionPane.WARNING_MESSAGE);
            JDialog dialog = optionPane.createDialog("Warning");
            dialog.setIconImage(iconDialogBox.getImage());
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
    }
}
