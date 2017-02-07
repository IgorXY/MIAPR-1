package kmeans.method.generator;

import javafx.scene.paint.Color;
import kmeans.method.point.Centroid;
import kmeans.method.point.Point;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Igor_Tonko on 04.02.2017.
 */
public class Randomizer {

    private int xCoordinateBound;
    private int yCoordinateBound;
    private Random randomGenerator;

    public Randomizer(int xCoordinateBound, int yCoordinateBound){
        this.xCoordinateBound = xCoordinateBound;
        this.yCoordinateBound = yCoordinateBound;
        this.randomGenerator = new Random();
    }

    public ArrayList<Point> generateRandomPoints(int pointsCount){
        ArrayList<Point> pointList = new ArrayList<>(pointsCount);

        for(int i = 0; i < pointsCount; i++){
            double xCoordinate = randomGenerator.nextInt(xCoordinateBound);
            double yCoordinate = randomGenerator.nextInt(yCoordinateBound);

            Point point = new Point(xCoordinate, yCoordinate);
            pointList.add(point);
        }

        return pointList;
    }

    public ArrayList<Centroid> generateRandomCentroids(int centroidCount){
        ArrayList<Centroid> centroidList = new ArrayList<>(centroidCount);

        for (int i = 0; i < centroidCount; i++) {
            double xCoordinate = randomGenerator.nextInt(xCoordinateBound);
            double yCoordinate = randomGenerator.nextInt(yCoordinateBound);
            Color color = generateRandomColor();

            Centroid centroid = new Centroid(xCoordinate, yCoordinate, color);
            centroidList.add(centroid);
        }

        return centroidList;
    }

    private Color generateRandomColor(){
        float r = randomGenerator.nextFloat();
        float g = randomGenerator.nextFloat();
        float b = randomGenerator.nextFloat();
        return Color.color(r, g, b);
    }
}
