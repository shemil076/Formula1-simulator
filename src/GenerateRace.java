import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;



public class GenerateRace extends JFrame {
    public ArrayList<Formula1Driver> driver = Formula1ChampionshipManager.getData();
    public ArrayList<RaceDetails> Races = Formula1ChampionshipManager.getRaceDateData();
    ArrayList<Integer> positionsArrayList = new ArrayList<Integer>();
    ArrayList<RaceTeamData> raceTeamData = new ArrayList<RaceTeamData>();
    JLabel labelDate;
    JLabel successfully;
    JTable raceTable;
    JScrollPane raceTableScrollPane;
    public static String stringDate;
    ImageIcon iconFrame = new ImageIcon("src/img/fast.png");
    JPanel container;


    public GenerateRace() {
        labelDate = new JLabel();
        raceTable = new JTable();
        successfully = new JLabel();
        container = new JPanel();
        Background newBackground = new Background(Color.decode("#780206"), Color.decode("#061161"),3);

        add(container.add(newBackground));
        newBackground.setLayout(new FlowLayout());


        labelDate.setFont(new Font("Serif",Font.BOLD,30));
        labelDate.setForeground(Color.ORANGE);
        successfully.setFont(new Font("Serif",Font.BOLD,24));
        successfully.setForeground(Color.YELLOW);

        raceNow();






        raceTableScrollPane = new JScrollPane(raceTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        String[] raceTableColumnNames = {"TEAM", "NAME", "CURRENT POINTS", "POSITION"};
        raceTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, raceTableColumnNames));
        labelDate.setText("Race table on : " + stringDate);
        addToTable(raceTeamData, raceTable);


        successfully.setText("✨ Congratulations You have successfully generate a race ✨");


//        labelDate.setText(stringDate);
        newBackground.add(labelDate);
        newBackground.add(raceTableScrollPane).setPreferredSize(new Dimension(900, 400));
        newBackground.add(successfully);

//        setLayout(new FlowLayout());
        setSize(950, 600);
        setTitle("Generate Race");
        setIconImage(iconFrame.getImage());

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
    }

    public void raceNow() {
        raceTeamData.clear();
        positionsArrayList.clear();
        int day = (int) (Math.random() * (28 - 1 + 1) + 1);
        int month = (int) (Math.random() * (12 - 1 + 1) + 1);
        int year = (int) (Math.random() * (2021 - 2015 + 1) + 2015);

        String stringDay = Integer.toString(day);
        String stringMonth = Integer.toString(month);
        String stringYear = Integer.toString(year);

        stringDate = stringDay + "/" + stringMonth + "/" + stringYear;

        for (int i = 0; i < driver.size(); i++) {
            RaceDetails newRace = new RaceDetails(stringDate);
            RaceTeamData newRaceTeam;
            while (true) {
                int position = (int) (Math.random() * (driver.size() - 1 + 1) + 1);
                if (!(positionsArrayList.contains(position))) {
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

                    newRaceTeam = new RaceTeamData(driver.get(i).getTeamOfDriver(),driver.get(i).getDriverName(),driver.get(i).getCurrentPoints(),position);
                    raceTeamData.add(newRaceTeam);
                    newRace.setDriverNameTeamNamePosition(driver.get(i).getDriverName(), driver.get(i).getTeamOfDriver(), position);
                    Races.add(newRace);

                    positionsArrayList.add(position); // add position in to the array list in validation purpose
                    break;
                }
            }
        }
    }

    public boolean checkPositions(int position) {
        boolean checkPosition = true;
        for (int i = 0; i < positionsArrayList.size(); i++) {
            if (position == positionsArrayList.get(i)) { // ignore if the position is used previously, Assume that there cannot have more than one team in the same position
                checkPosition = false;
            } else {
                checkPosition = true;
            }
        }
        return checkPosition;
    }

    public static void addToTable(ArrayList<RaceTeamData> raceTeamData, JTable table) {
        for (RaceTeamData raceTeam : raceTeamData) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{
                    raceTeam.getTeamName(),
                    raceTeam.getDriverName(),
                    raceTeam.getCurrentPoints(),
                    raceTeam.getPosition()
            });
        }
    }
}
