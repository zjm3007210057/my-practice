package playAlgorithm;

/**
 * Created by zjm on 11/02/2018.
 */
public class SwingTest {

    public static void main(String[] args) {

        int sceneWidth = 800;
        int sceneHeight = 800;
        int N = 10;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
        visualizer.run();
    }
}
