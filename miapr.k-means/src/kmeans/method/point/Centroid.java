package kmeans.method.point;

import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Created by Igor_Tonko on 04.02.2017.
 */
public class Centroid {

    private double xCoordinate;
    private double yCoordinate;
    private Color color;
    private ArrayList<Point> allocatedPoints;

    public Centroid(double xCoordinate, double yCoordinate, Color color){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.color = color;

        allocatedPoints = new ArrayList<>();
    }

    public void addPoint(Point point){
        if(point != null){
            allocatedPoints.add(point);
        }
    }

    public boolean changeCoordinates(double newXCoordinate, double newYCoordinate){

        if((int)xCoordinate != (int)newXCoordinate || (int)yCoordinate != (int)newYCoordinate){
            allocatedPoints = new ArrayList<>();
            xCoordinate = newXCoordinate;
            yCoordinate = newYCoordinate;
            return true;
        }
        return false;
    }

    public Color getColor(){
        return this.color;
    }

    public double getXCoordinate(){
        return xCoordinate;
    }

    public double getYCoordinate(){
        return yCoordinate;
    }

    public ArrayList<Point> getAllocatedPoints(){
        return allocatedPoints;
    }
}
