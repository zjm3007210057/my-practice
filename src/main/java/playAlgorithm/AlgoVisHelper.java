package playAlgorithm;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by zjm on 12/02/2018.
 */
public class AlgoVisHelper {

    /**
     * private constructor, not allow user use it
     */
    private AlgoVisHelper() {
    }

    /**
     * set line width
     * @param g2d
     * @param width
     */
    public static void setStrokeWidth(Graphics2D g2d, int width){
        g2d.setStroke(new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    /**
     * drawn circle with radius is r
     * @param g2d
     * @param x x-axis position of center
     * @param y y-axis position of center
     * @param r circle radius
     */
    public static void strokeCircle(Graphics2D g2d, int x, int y, int r){
        Ellipse2D circle = new Ellipse2D.Float(x-r, y-r, 2*r, 2*r);
        g2d.draw(circle);
    }

    /**
     * drawn fill circle with radius is r
     * @param g2d
     * @param x x-axis position of center
     * @param y y-axis position of center
     * @param r circle radius
     */
    public static void fillCircle(Graphics2D g2d, int x, int y, int r){
        Ellipse2D circle = new Ellipse2D.Float(x-r, y-r, 2*r, 2*r);
        g2d.fill(circle);
    }

    /**
     * set color
     * @param g2d
     * @param red
     */
    public static void setColor(Graphics2D g2d, Color red) {
        g2d.setColor(red);
    }

    /**
     * pause method
     * @param mills
     */
    public static void pause(int mills){
        try{
            Thread.sleep(mills);
        }catch (InterruptedException e){
            System.out.println("Error in sleeping");
        }
    }
}
