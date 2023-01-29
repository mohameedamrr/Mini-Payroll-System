package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TraineeHomepageScene8Controller  {
    @FXML
    private AnchorPane Pane;
    @FXML
    private Button ViewTraineesButton;
    @FXML
    private Button AddTraineeButton;
    @FXML
    private Button ExitButton;
    @FXML
    private Button BackButton;

    Parent root ;
    Scene scene;
    Stage stage;
    public void back(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../FXML Files/HomePageScene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    public void exit(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit");
        alert.setContentText("Are you sure you want to exit?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) Pane.getScene().getWindow();
            stage.close();
        }

    }
    public void ViewTrainees(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../FXML Files/ViewTraineesScene9.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    public void AddTrainee (ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../FXML Files/AddTraineeScene10.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }



}
