package playAlgorithm;

import java.awt.*;

/**
 * Created by zjm on 13/02/2018.
 */
public class Circle {

    //center position
    public int x, y;

    //radius
    private int r;

    //speed
    public int vx, vy;

    public boolean isFilled = false;

    //constructor
    public Circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }

    //get radius
    public int getR() {
        return r;
    }

    //move position
    public void move(int minx, int miny, int maxx, int maxy){
        x += vx;
        y += vy;
        checkCollision(minx, miny, maxx, maxy);
    }

    /**
     * deal with collision
     * @param minx
     * @param miny
     * @param maxx
     * @param maxy
     */
    private void checkCollision(int minx, int miny, int maxx, int maxy){
        if(x - r < minx){
            x = r;
            vx = -vx;
        }
        if(x + r >= maxx){
            x = maxx - r;
            vx = -vx;
        }
        if(y - r < miny){
            y = r;
            vy = -vy;
        }
        if(y + r >= maxy){
            y = maxy - r;
            vy = -vy;
        }
    }

    /**
     * judge point p is inside of circle
     * @param p
     * @return
     */
    public boolean contain(Point p){
        return (x - p.x) * (x - p.x) + (y - p.y) * (y - p.y) <= r*r;
    }
}
