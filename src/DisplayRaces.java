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
    ImageIcon iconFrame = new ImageIcon("src/img/fast.png") ;       // import an image
    ImageIcon iconDialogBox = new ImageIcon("src/img/warning.png") ; // // import an image
    ImageIcon iconImageLabel = new ImageIcon("src/img/f1.png") ;
    ImageIcon iconImageLabel2 = new ImageIcon("src/img/f2.png") ;
    ImageIcon iconImageLabel3 = new ImageIcon("src/img/f3.png") ;
    JLabel warningLabel = new JLabel();

    JLabel imageLabel;
    JLabel imageLabel2;
    JLabel imageLabel3;
    JPanel container;


    public DisplayRaces(){

        labelTopic = new JLabel();
        displayRacesTable = new JTable();
        container = new JPanel();
        imageLabel = new JLabel();
        imageLabel2 = new JLabel();
        imageLabel3 = new JLabel();
        Background newBackground = new Background(Color.decode("#23074d"), Color.decode("#cc5333"),3);  // set the background  refered a code


        add(container.add(newBackground));
        newBackground.setLayout(new FlowLayout());                              // set the layout
        imageLabel.setIcon(iconImageLabel);// set the layout
        imageLabel2.setIcon(iconImageLabel2);//
        imageLabel3.setIcon(iconImageLabel3);//



        labelTopic.setFont(new Font("Serif",Font.BOLD,24));         // set the formatting of the text
        labelTopic.setForeground(Color.white);                                  // change the font colour

        warningLabel.setFont(new Font("Serif",Font.BOLD,20));        // set the formatting of the text
        warningLabel.setForeground(Color.white);                                // change the font colour

        sortDate();                                                             // sort the raceData array list according to the date

        displayRacesTableScrollPane = new JScrollPane(displayRacesTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        labelTopic.setText("???? Races Detail table sorted according to date ????");
        String[] displayRacesTableColumnNames = {"DATE", "TEAM NAME", "DRIVER NAME", "POSITION"};
        displayRacesTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, displayRacesTableColumnNames));        // set the default Table model
        addToDisplayRacesTable(raceData,displayRacesTable);                                                                         // add data to the table

        warningLabel.setText(null);


        displayRacesTable.setBackground(Color.cyan);
        displayRacesTable.setOpaque(true);

        newBackground.add(imageLabel).setPreferredSize(new Dimension(60,50));
        newBackground.add(labelTopic);
        newBackground.add(displayRacesTableScrollPane).setPreferredSize(new Dimension(900, 400));               // set the scroll pane size
        newBackground.add(warningLabel);
        newBackground.add(imageLabel).setPreferredSize(new Dimension(70,60));
        newBackground.add(imageLabel3).setPreferredSize(new Dimension(70,60));
        newBackground.add(imageLabel2).setPreferredSize(new Dimension(70,60));
        checkData();                                                                                                        // the whether the races are available in the system
        sortDate();                                                                                                         // sort according to the data

        setIconImage(iconFrame.getImage());         // set an image to the frame
//        setLayout(new FlowLayout());
        setSize(950, 600);             // set the size of the frame
        setTitle("Display Races");                  // set the frame title
        setResizable(false);                        // not allowing to stretch or resize
        setLocationRelativeTo(null);                // set the location to the center of the screen
        setVisible(true);                           // make the frame visible
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        popUpDialog();                          // display a dialog box if needed
    }


    /**
     *  compare and sort according to date
     */
    public static Comparator<RaceDetails> raceInfo = new Comparator<RaceDetails>(){
        DateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");      // set the date format
        @Override
        public int compare(RaceDetails raceDate1, RaceDetails raceDate2) {          // pass race date from RaceDetail class
            try {
                return formattedDate.parse(raceDate1.getRaceDate()).compareTo(formattedDate.parse(raceDate2.getRaceDate()));        // compare the array list according to the date
            } catch (ParseException e) {
                throw new RuntimeException();
            }

        }
    };

    /**
     * Sort the array list according to date
     */
    public void sortDate(){
        Collections.sort(Formula1ChampionshipManager.raceDetailsList,raceInfo);         // sort according to the date
    }


    /**
     *add data to the table
     * @param raceData arrayList in RaceDetail class
     * @param table JTable
     */
    public static void addToDisplayRacesTable(ArrayList<RaceDetails> raceData, JTable table) {
        for (RaceDetails raceTeamData : raceData) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{         //
                    raceTeamData.getRaceDate(),                                 //  add race date to the respective row
                    raceTeamData.getTeamNamesInRace(),                          //  add team name to the respective row
                    raceTeamData.getDriverNameInRace(),                         //  add driver name to the respective row
                    raceTeamData.getPosition()                                  //  add position to the respective row
            });
        }
    }


    /**
     * Check the number of races in the system.
     * because if there is no teams nothing to display
     */
    public void  checkData(){
        if (raceData.size() == 0){

            warningLabel.setText("?????? Please add races to display Race details ??????");

        }
    }


    /**
     * check whether there are teams to display. If not display a warning o dialog box
     */
    public void popUpDialog(){
        if (raceData.size() == 0){
            JOptionPane optionPane = new JOptionPane("Teams not found",JOptionPane.WARNING_MESSAGE);
            JDialog dialog = optionPane.createDialog("404 Warning");
            dialog.setIconImage(iconDialogBox.getImage());                  // set a favicon
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
    }
}
