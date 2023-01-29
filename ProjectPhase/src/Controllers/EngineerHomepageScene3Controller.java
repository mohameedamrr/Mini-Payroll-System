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

public class EngineerHomepageScene3Controller {

    @FXML
    private Button AddEngineerButton;

    @FXML
    private AnchorPane Pane;

    @FXML
    private Button ViewEngineersButton;

    @FXML
    private Button backButton;

    @FXML
    private Button exitButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void AddEngineer(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../FXML Files/AddEngineerScene6.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ViewEngineers(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../FXML Files/ViewEngineersScene4.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void back(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../FXML Files/HomePageScene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void exit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit");
        alert.setContentText("Are you sure you want to exit?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) Pane.getScene().getWindow();
            stage.close();
        }
    }

}

