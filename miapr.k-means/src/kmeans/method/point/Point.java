package kmeans.method.point;

import javafx.scene.paint.Color;

/**
 * Created by Igor_Tonko on 04.02.2017.
 */
public class Point {

    private double xCoordinate;
    private double yCoordinate;

    public Point(double xCoordinate, double yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public double getXCoordinate(){
        return xCoordinate;
    }

    public double getYCoordinate(){
        return yCoordinate;
    }
}
