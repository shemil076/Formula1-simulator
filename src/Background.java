// referred from https://pastebin.com/7v6BjccA
import javax.swing.*;
import java.awt.*;
import java.awt.Color;



public class Background extends JPanel {
    public static int VERTICAL = 0;
    public static int HORIZONTAL = 1;
    public static int DIAGONAL_DOWN = 2;
    public static int DIAGONAL_UP = 3;

    private Color color1;
    private Color color2;
    private int direction;



    public Background(Color color1, Color color2, int direction){
        super();
        this.color1 = color1;
        this.color2 = color2;
        this.direction = direction;
    }

    //    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        GradientPaint paint ;

        if (direction == HORIZONTAL){
            paint = new GradientPaint(0,getHeight()/2, color1,getWidth(),getHeight()/2,color2);
        }else if (direction == DIAGONAL_DOWN){
            paint = new GradientPaint(0,getHeight(), color1,getWidth(),0,color2);
        }else if (direction == DIAGONAL_UP){
            paint = new GradientPaint(0,0, color1,getWidth(),getHeight()/2,color2);
        }else {
            paint = new GradientPaint(0,0,color1,0 ,getHeight(),color2);
        }
        g2d.setPaint(paint);
        g2d.fillRect(0,0,getWidth(),getHeight());


    }

}
