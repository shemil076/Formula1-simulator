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

    public DisplayRaces(){



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
        for (RaceDetails raceDatum : raceData) {
            System.out.println( raceDatum.getRaceDate());
        }
    }


}
