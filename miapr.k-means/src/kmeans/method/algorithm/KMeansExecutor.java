package kmeans.method.algorithm;

import kmeans.method.point.Centroid;
import kmeans.method.point.Point;

import java.util.ArrayList;

/**
 * Created by Igor_Tonko on 04.02.2017.
 */
public class KMeansExecutor {

    private ArrayList<Point> pointList;
    private ArrayList<Centroid> centroidList;

    public KMeansExecutor(ArrayList<Point> pointList, ArrayList<Centroid> centroidList){
        this.pointList = pointList;
        this.centroidList = centroidList;
    }

    public ArrayList<Centroid> allocatePointsToCentroids(){
        for (Point point : pointList) {
            Centroid closestCentroid = findClosestCentroid(point);
            closestCentroid.addPoint(point);
        }

        return centroidList;
    }

    public boolean changeCentroidPositions(){

        boolean hasChangedCentroid = false;

        for (Centroid centroid : centroidList) {
            hasChangedCentroid = hasChangedCentroid | changeCentroidPosition(centroid);
        }

        return hasChangedCentroid;
    }

    private boolean changeCentroidPosition(Centroid centroid){

        double totalX = 0;
        double totalY = 0;
        ArrayList<Point> allocatedPoints = centroid.getAllocatedPoints();

        for(Point point : allocatedPoints){
            totalX += point.getXCoordinate();
            totalY += point.getYCoordinate();
        }

        double newX = totalX / allocatedPoints.size();
        double newY = totalY / allocatedPoints.size();
        return centroid.changeCoordinates(newX, newY);
    }

    private Centroid findClosestCentroid(Point point){
        Centroid closestCentroid = null;
        double minDistance = 9999999;

        for (Centroid centroid: centroidList) {
           double distance = calculateDistance(centroid, point);
            if(distance < minDistance){
                minDistance = distance;
                closestCentroid = centroid;
            }
        }
        return closestCentroid;
    }

    public double calculateDistance(Centroid centroid, Point point){
        double deltaX = point.getXCoordinate() - centroid.getXCoordinate();
        double deltaY = point.getYCoordinate() - centroid.getYCoordinate();

        return Math.sqrt(sqr(deltaX) + sqr(deltaY));
    }

    private double sqr(double a){
        return Math.pow(a, 2);
    }

}
