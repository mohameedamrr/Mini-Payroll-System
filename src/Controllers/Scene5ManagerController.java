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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene5ManagerController {

    @FXML
    private Button backButton;

    @FXML
    private Button carPartsStockButton;

    @FXML
    private Button carStockButton;

    @FXML
    private Button exitButton;

    @FXML
    private Label myLabel1;

    @FXML
    private AnchorPane scenePane;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void back(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene1Manager.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void exit(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit");
        alert.setContentText("Are you sure you want to exit?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    public void viewCarPartsStock(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene6Manager.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void viewCarStock(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene7Manager.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}

