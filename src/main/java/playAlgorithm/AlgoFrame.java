package playAlgorithm;

import javax.swing.*;
import java.awt.*;

/**
 * define myself JFrame
 * Created by zjm on 11/02/2018.
 */
public class AlgoFrame extends JFrame {

    /**
     * frame width
     */
    private int canvasWidth;

    /**
     * frame height
     */
    private int canvasHeight;

    /**
     * circle array
     */
    private Circle[] circles;

    /**
     * constructor
     * @param title
     */
    public AlgoFrame(String title){
        this(title, 1024, 768);
    }

    /**
     * constructor
     * @param title
     * @param canvasWidth
     * @param canvasHeight
     */
    public AlgoFrame(String title, int canvasWidth, int canvasHeight){
        super(title);
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        AlgoPanel canvas = new AlgoPanel();
//        canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        setContentPane(canvas);
        pack();//resize window size
        setResizable(false);//use can not resize frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit program after user click x mark
        setVisible(true);//set visible
    }

    //drawn again(move)
    public void render(Circle[] circles){
        this.circles = circles;
        repaint();
    }

    //get methods

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    /**
     * private class panel
     */
    private class AlgoPanel extends JPanel{

        /**
         * constructor, open double buffered
         */
        public AlgoPanel() {
            super(true);
        }

        /**
         * draw picture
         * @param g
         */
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            //Anti-Aliased
            RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);

            AlgoVisHelper.setStrokeWidth(g2d, 1);//set line width
            AlgoVisHelper.setColor(g2d, Color.RED);
            for(Circle circle : circles){
                if(circle.isFilled){
                    AlgoVisHelper.fillCircle(g2d, circle.x, circle.y, circle.getR());
                }else {
                    AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}
