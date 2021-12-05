import javax.swing.*;
import java.awt.*;

public class GenerateRacesWithStartingPositions extends JFrame {

    JLabel GRLabelTopic;
    JLabel GRSuccessfully;
    JTable generatedTable;
    JScrollPane generatedTableScrollPane;

    ImageIcon iconFrame = new ImageIcon("src/img/fast.png");                // importing the image
    JPanel GRContainer;

    public GenerateRacesWithStartingPositions(){
        GRLabelTopic = new JLabel();
        generatedTable = new JTable();
        GRSuccessfully = new JLabel();
        GRContainer = new JPanel();
        Background newBackground = new Background(Color.decode("#780206"), Color.decode("#061161"),3);  // set the background
        generatedTableScrollPane = new JScrollPane(generatedTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add(GRContainer.add(newBackground));                                          // add the JPanel to the JFrame
        newBackground.setLayout(new FlowLayout());

        newBackground.add(GRLabelTopic);
        newBackground.add(generatedTableScrollPane).setPreferredSize(new Dimension(900, 400));
        newBackground.add(GRSuccessfully);

//        setLayout(new FlowLayout());
        setSize(950, 600);
        setTitle("Generate Race");
        setIconImage(iconFrame.getImage());             // set the frame icon

        setResizable(false);                            // not allowing to stretch or resize
        setLocationRelativeTo(null);                     // set the location to the center of the screen
        setVisible(true);                               // // make the frame visible
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

}
