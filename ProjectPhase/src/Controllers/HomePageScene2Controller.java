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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageScene2Controller {

    @FXML
    private AnchorPane Pane;
    @FXML
    private ImageView imageWork;
    @FXML
    private Button engineerButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button traineeButton;

    @FXML
    private Button CalcSalaryButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void EngineerPage(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../FXML Files/EngineerHomepageScene3.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void TraineePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../FXML Files/TraineeHomepageScene8.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void exit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit");
        alert.setContentText("Are you sure you want to exit?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) Pane.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    public void logout(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../FXML Files/LoginScene1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void CalcSalary(ActionEvent event) throws IOException{       //to be edited
        root = FXMLLoader.load(getClass().getResource("../FXML Files/CalculateSalaryScene7.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
