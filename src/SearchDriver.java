import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SearchDriver extends JFrame {
    ImageIcon iconFrame = new ImageIcon("src/img/fast.png") ;
    public ArrayList<RaceDetails> raceDataList = Formula1ChampionshipManager.getRaceDateData();
    public ArrayList<DriverRaceData> racerData = new ArrayList<DriverRaceData>();

    public SearchDriver() {

        addToRacerData();

        for (DriverRaceData racerGetData : racerData) {
            System.out.println(racerGetData.getRacerName() +" " + racerGetData.getRacerTeamName() +" " + racerGetData.getRaceDate() + " " + racerGetData.getRacerPosition() );
        }



        setIconImage(iconFrame.getImage());
        setLayout(new FlowLayout());
        setSize(950, 600);
        setTitle("Search Driver");
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void addToRacerData(){
        for (RaceDetails raceDetails : raceDataList) {
            DriverRaceData newDiverData = new DriverRaceData(raceDetails.getDriverNameInRace(),raceDetails.getteamNameInRace(),raceDetails.getRaceDate(),raceDetails.getPosition());
            racerData.add(newDiverData);
        }
    }

}
