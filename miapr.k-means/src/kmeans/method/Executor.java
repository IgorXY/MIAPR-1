package kmeans.method;

import javafx.scene.canvas.Canvas;
import kmeans.method.algorithm.KMeansExecutor;
import kmeans.method.drawing.Drawer;
import kmeans.method.generator.Randomizer;
import kmeans.method.point.Centroid;
import kmeans.method.point.Point;

import java.util.ArrayList;

/**
 * Created by Igor_Tonko on 04.02.2017.
 */
public class Executor {

    private Drawer drawer;
    private KMeansExecutor kMeansExecutor;

    public Executor(Canvas canvas){
        drawer = new Drawer(canvas);
        drawer.cleanCanvas();
    }

    public void initializeValues(int pointCount, int centroidCount){
        Randomizer randomizer = new Randomizer((int) drawer.getXCoordinateBound(), (int) drawer.getYCoordinateBound());
        ArrayList<Point> pointList = randomizer.generateRandomPoints(pointCount);
        ArrayList<Centroid> centroidList = randomizer.generateRandomCentroids(centroidCount);

        kMeansExecutor = new KMeansExecutor(pointList, centroidList);
        ArrayList<Centroid> allocatedCentroids = kMeansExecutor.allocatePointsToCentroids();

        drawer.cleanCanvas();
        drawer.drawCentroids(allocatedCentroids);
    }

    public void performCalculation(){
        while (kMeansExecutor.changeCentroidPositions()){
            ArrayList<Centroid> allocatedCentroids = kMeansExecutor.allocatePointsToCentroids();
            drawer.cleanCanvas();
            drawer.drawCentroids(allocatedCentroids);
        }
    }

}
