package playAlgorithm;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by zjm on 13/02/2018.
 */
public class AlgoVisualizer {

    private int sceneWidth;

    private int sceneHeight;

    private Circle[] circles;

    private AlgoFrame frame;

    private boolean isAnimated = true;

    /**
     * constructor
     *
     * @param sceneWidth
     * @param sceneHeight
     * @param num
     */
    public AlgoVisualizer(int sceneWidth, int sceneHeight, int num) {
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        circles = new Circle[num];
        for (int i = 0; i < num; i++) {
            int r = new Random().nextInt(sceneWidth / 2);
            int x = new Random().nextInt(sceneWidth - 2 * r) + r;
            int y = new Random().nextInt(sceneHeight - 2 * r) + r;
            int vx = new Random().nextInt(11) - 5;
            int vy = new Random().nextInt(11) - 5;
            circles[i] = new Circle(x, y, r, vx, vy);
        }

    }

    /**
     * animation run
     */
    public void run() {
        //把创建窗口放到事件的分发当中，官方推荐写法
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            //add listener
            frame.addKeyListener(new AlgoKeyListener());
            frame.addMouseListener(new AlgoMouseListener());
            new Thread(() -> doRun()).start();
        });
    }

    /**
     * execute concrete logic
     */
    private void doRun() {
        while (true) {
            frame.render(circles);
            AlgoVisHelper.pause(20);
            if(isAnimated){
                for (Circle circle : circles) {
                    circle.move(0, 0, frame.getCanvasWidth(), frame.getCanvasHeight());
                }
            }
        }
    }

    /**
     * inner keyboard listener
     */
    private class AlgoKeyListener extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent event) {
            if(event.getKeyChar() == ' '){
                isAnimated = !isAnimated;
            }
        }
    }

    /**
     * inner mouse listener
     */
    private class AlgoMouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent event) {
            //move position in order to remove the effect of frame header,
            //because frame header occupation some space
            event.translatePoint(0, frame.getCanvasHeight() - frame.getBounds().height);
//            System.out.println(event.getPoint());
            for(Circle circle : circles){
                if(circle.contain(event.getPoint())){
                    circle.isFilled = !circle.isFilled;
                }
            }
        }
    }
}
