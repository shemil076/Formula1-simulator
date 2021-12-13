import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
public class test {
    JTable probabilityTable = new JTable();
    ArrayList<Integer> startingPositions = new ArrayList<Integer>();
    ArrayList<Formula1Driver> driversDuplicate = new ArrayList<Formula1Driver>();
    String date;
    JLabel label4 = new JLabel(" ");
    JLabel label5 = new JLabel(" ");
    String[] positionsStorage = new String[Formula1ChampionshipManager.formulaDriverTeams.size()];


    public test() {
        // Frame
        JFrame frame = new JFrame(" Formula 1 Championship Manager Program.");
        frame.getContentPane().setBackground(Color.black);
        frame.getContentPane().setForeground(Color.white);
        frame.setBounds(100, 100, 650, 220);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

        // Label
        label4.setText("🏁 Random Probability race details.");
        frame.getContentPane().add(label4);
        label4.setBounds(20,0,700,50);
        label4.setForeground(Color.white);
        label4.setFont(new Font("Calibre",Font.BOLD,22));

        // Table
        probabilityTable.setModel(new DefaultTableModel(new Object[][]{}, new String[]{"Race date", "1st place", "2nd place", "3rd place"}));  // Table heading.
        probabilityTable.setBackground(Color.white);
        probabilityTable.setForeground(Color.black);
        probabilityTable.setGridColor(Color.blue);
        probabilityTable.setSelectionBackground(Color.blue);
        probabilityTable.setSelectionForeground(Color.white);
        probabilityTable.setFont(new Font("Serif", Font.PLAIN, 16));
        probabilityTable.setRowHeight(25);

        // Pane
        JScrollPane pane= new JScrollPane(probabilityTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.blue);
        pane.setBounds(5, 110, 620, 60);
        frame.getContentPane().add(pane);


        // Generating the random date.
        int randomDate = (int) (Math.random() * (27 - 1 + 1) + 1);
        String dd = Integer.toString(randomDate);
        int randomMonth = (int) (Math.random() * (11 - 1 + 1) + 1);
        String MM = Integer.toString(randomMonth);
        date = dd + "/" + MM + "/" + "2021";

        driversDuplicate.addAll(Formula1ChampionshipManager.formulaDriverTeams);
        int startingPosition = 0;



        for (Formula1Driver driver : Formula1ChampionshipManager.formulaDriverTeams) {

            // Generating the starting position.
            while (true) {
                startingPosition = (int) (Math.random() * Formula1ChampionshipManager.formulaDriverTeams.size()) + 1;
                if (!startingPositions.contains(startingPosition)) {
                    startingPositions.add(startingPosition);
                    break;
                }
            }

            int randomNumber = (int) (Math.random() * 100) + 1;   // Generating the random number.

            if (startingPosition == 1) {
                if (randomNumber > 0 && randomNumber < 41) {
                    positionsStorage[0] = driver.getDriverName();
                    driver.setCurrentPoints(25 + driver.getCurrentPoints());
                    driver.setFirstPositions(1 + driver.getFirstPositions());
                    driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                    driversDuplicate.remove(driver);

                    randomPlaces();
                    break;
                }
                break;
            } else if (startingPosition == 2) {
                if (randomNumber > 39 && randomNumber < 71) {
                    positionsStorage[0] = driver.getDriverName();
                    driver.setCurrentPoints(25 + driver.getCurrentPoints());
                    driver.setFirstPositions(1 + driver.getFirstPositions());
                    driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                    driversDuplicate.remove(driver);

                    randomPlaces();
                    break;
                }
                break;
            } else if (startingPosition == 3) {
                if (randomNumber > 69 && randomNumber < 81) {
                    positionsStorage[0] = driver.getDriverName();
                    driver.setCurrentPoints(25 + driver.getCurrentPoints());
                    driver.setFirstPositions(1 + driver.getFirstPositions());
                    driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                    driversDuplicate.remove(driver);

                    randomPlaces();
                    break;
                }
                break;
            } else if (startingPosition == 4) {
                if (randomNumber > 79 && randomNumber < 91) {
                    positionsStorage[0] = driver.getDriverName();
                    driver.setCurrentPoints(25 + driver.getCurrentPoints());
                    driver.setFirstPositions(1 + driver.getFirstPositions());
                    driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                    driversDuplicate.remove(driver);

                    randomPlaces();
                    break;
                }
                break;
            } else if (startingPosition > 4 && startingPosition < 10) {
                if (randomNumber > 89 && randomNumber < 93) {
                    positionsStorage[0] = driver.getDriverName();
                    driver.setCurrentPoints(25 + driver.getCurrentPoints());
                    driver.setFirstPositions(1 + driver.getFirstPositions());
                    driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
                    driversDuplicate.remove(driver);

                    randomPlaces();
                    break;
                }
                break;
            }
            break;
        }

        // For the null issue.
//        if(positionsStorage[0] == null) {
//            Collections.shuffle(Formula1ChampionshipManager.formulaDriverTeams);
//            for (int i = 0; i < Formula1ChampionshipManager.formulaDriverTeams.size(); i++) {
//                positionsStorage[i] = Formula1ChampionshipManager.formulaDriverTeams.get(i).getDriverName();
//                Formula1ChampionshipManager.formulaDriverTeams.get(i).driver.setNumberOfRaces(1 + driver.getNumberOfRaces());
//                Formula1ChampionshipManager.formulaDriverTeams.get(i).setPoints(Formula1ChampionshipManager.pointsScheme[i]);
//                if (i == 0) {
//                    Formula1ChampionshipManager.formulaDriverTeams.get(i).setFirstPositions(1 + driver.getFirstPositions());
//                } else if (i == 1) {
//                    Formula1ChampionshipManager.formulaDriverTeams.get(i).setPosition2(1);
//                } else if (i == 2) {
//                    Formula1ChampionshipManager.formulaDriverTeams.get(i).setPosition3(1);
//                }
//            }
//        }


//        Formula1ChampionshipManager.races.add(new RaceData(date, positionsStorage));

        ((DefaultTableModel) probabilityTable.getModel()).addRow(new Object[]{date, positionsStorage[0], positionsStorage[1],positionsStorage[2]});

        label5.setText("Starting Position of Mr." + positionsStorage[0] + " - " + startingPosition);
        frame.getContentPane().add(label5);
        label5.setBounds(20,50,700,50);
        label5.setForeground(Color.BLUE);
        label5.setFont(new Font("Calibre",Font.BOLD,20));
    }

    public void randomPlaces() {

        Collections.shuffle(driversDuplicate);
        for (int c=0; c < driversDuplicate.size(); c++) {

            if (c == 0) {
                positionsStorage[1] = driversDuplicate.get(c).getDriverName();
                int index = Formula1ChampionshipManager.formulaDriverTeams.indexOf(driversDuplicate.get(c));
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setCurrentPoints(18 + driversDuplicate.get(c).getCurrentPoints());
//                Formula1ChampionshipManager.formulaDriverTeams.get(index).;
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setNumberOfRaces(1 +  driversDuplicate.get(c).getNumberOfRaces());


            } else if (c == 1) {
                positionsStorage[2] = driversDuplicate.get(c).getDriverName();
                int index = Formula1ChampionshipManager.formulaDriverTeams.indexOf(driversDuplicate.get(c));
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setCurrentPoints(15 + driversDuplicate.get(c).getCurrentPoints());
//                Formula1ChampionshipManager.formulaDriverTeams.get(index).setPosition3(1);
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setNumberOfRaces(1 +  driversDuplicate.get(c).getNumberOfRaces());



            } else if (c == 2) {
                positionsStorage[2] = driversDuplicate.get(c).getDriverName();
                int index = Formula1ChampionshipManager.formulaDriverTeams.indexOf(driversDuplicate.get(c));
//                Formula1ChampionshipManager.formulaDriverTeams.get(index).setPoints(12);
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setNumberOfRaces(1 +  driversDuplicate.get(c).getNumberOfRaces());

            }else if (c == 3) {
                positionsStorage[3] = driversDuplicate.get(c).getDriverName();
                int index = Formula1ChampionshipManager.formulaDriverTeams.indexOf(driversDuplicate.get(c));
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setCurrentPoints(15 + driversDuplicate.get(c).getCurrentPoints());
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setNumberOfRaces(1 +  driversDuplicate.get(c).getNumberOfRaces());

            }else if (c == 4) {
                positionsStorage[4] = driversDuplicate.get(c).getDriverName();
                int index = Formula1ChampionshipManager.formulaDriverTeams.indexOf(driversDuplicate.get(c));
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setCurrentPoints(15 + driversDuplicate.get(c).getCurrentPoints());
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setNumberOfRaces(1 +  driversDuplicate.get(c).getNumberOfRaces());

            }else if (c == 5) {
                positionsStorage[5] = driversDuplicate.get(c).getDriverName();
                int index = Formula1ChampionshipManager.formulaDriverTeams.indexOf(driversDuplicate.get(c));
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setCurrentPoints(15 + driversDuplicate.get(c).getCurrentPoints());
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setNumberOfRaces(1 +  driversDuplicate.get(c).getNumberOfRaces());

            }else if (c == 6) {
                positionsStorage[6] = driversDuplicate.get(c).getDriverName();
                int index = Formula1ChampionshipManager.formulaDriverTeams.indexOf(driversDuplicate.get(c));
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setCurrentPoints(15 + driversDuplicate.get(c).getCurrentPoints());
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setNumberOfRaces(1 +  driversDuplicate.get(c).getNumberOfRaces());

            }else if (c == 7) {
                positionsStorage[7] = driversDuplicate.get(c).getDriverName();
                int index = Formula1ChampionshipManager.formulaDriverTeams.indexOf(driversDuplicate.get(c));
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setCurrentPoints(15 + driversDuplicate.get(c).getCurrentPoints());
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setNumberOfRaces(1 +  driversDuplicate.get(c).getNumberOfRaces());

            }else if (c == 8) {
                positionsStorage[8] = driversDuplicate.get(c).getDriverName();
                int index = Formula1ChampionshipManager.formulaDriverTeams.indexOf(driversDuplicate.get(c));
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setCurrentPoints(15 + driversDuplicate.get(c).getCurrentPoints());
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setNumberOfRaces(1 +  driversDuplicate.get(c).getNumberOfRaces());

            } else {
                positionsStorage[c+1] = driversDuplicate.get(c).getDriverName();
                int index = Formula1ChampionshipManager.formulaDriverTeams.indexOf(driversDuplicate.get(c));
                Formula1ChampionshipManager.formulaDriverTeams.get(index).setNumberOfRaces(1 +  driversDuplicate.get(c).getNumberOfRaces());
            }
        }
    }
}
