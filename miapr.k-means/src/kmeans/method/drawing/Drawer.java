package kmeans.method.drawing;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import kmeans.method.point.Centroid;
import kmeans.method.point.Point;

import java.util.ArrayList;

/**
 * Created by Igor_Tonko on 04.02.2017.
 */
public class Drawer {

    private Canvas canvas;

    public Drawer(Canvas canvas){
        this.canvas = canvas;
    }

    public void drawCentroids(ArrayList<Centroid> centroidList){
        for(Centroid centroid : centroidList){
            drawCentroid(centroid);
            if(centroid.getAllocatedPoints() != null){
                drawPoints(centroid.getAllocatedPoints(), centroid.getColor());
            }
        }
    }

    private void drawPoints(ArrayList<Point> pointList, Color color){
        for (Point point : pointList) {
            drawPoint(point, color);
        }
    }

    public void cleanCanvas(){
        this.canvas.getGraphicsContext2D().setFill(Color.WHITE);
        this.canvas.getGraphicsContext2D().fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public double getXCoordinateBound(){
        return canvas.getWidth();
    }

    public double getYCoordinateBound(){
        return canvas.getHeight();
    }

    private void drawPoint(Point point, Color color){
        double x = point.getXCoordinate();
        double y = point.getYCoordinate();
        double r = 1.0;

        canvas.getGraphicsContext2D().setFill(color);
        canvas.getGraphicsContext2D().fillOval(x - r, y - r, r*2, r*2);
    }

    private void drawCentroid(Centroid centroid){
        double x = centroid.getXCoordinate();
        double y = centroid.getYCoordinate();
        double r = 10.0;

        canvas.getGraphicsContext2D().setFill(centroid.getColor());
        canvas.getGraphicsContext2D().fillRect(x - r, y - r, r*2, r*2);
    }

}
