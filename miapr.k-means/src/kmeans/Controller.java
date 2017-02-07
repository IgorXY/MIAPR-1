package kmeans;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import kmeans.method.Executor;


public class Controller {

    @FXML
    public TextField pointsCountField;
    @FXML
    public TextField centroidCountField;
    @FXML
    private Label errorLabel;
    @FXML
    private Canvas canvas;
    @FXML
    private Button computeButton;

    private Executor executor;


    public void initialize(){
        executor = new Executor(canvas);
    }

    public void onInitializeButtonClick(ActionEvent actionEvent) {
        try{
            int pointCount = Integer.parseInt(pointsCountField.getText());
            int centroidCount = Integer.parseInt(centroidCountField.getText());

            if(pointCount < 1000 || pointCount > 100000){
                errorLabel.setText("Points count should be between 1000 and 100 000.");
                return;
            }

            if(centroidCount < 2 || centroidCount > 20){
                errorLabel.setText("Centroid count should be between 2 and 20.");
                return;
            }

            executor.initializeValues(pointCount, centroidCount);

            computeButton.setDisable(false);
            errorLabel.setText("");
        }
        catch (Exception e) {
            errorLabel.setText("Incorrect input value.");
        }
    }

    public void onComputeButtonClick(ActionEvent actionEvent) {
        executor.performCalculation();
        computeButton.setDisable(true);
    }
}
