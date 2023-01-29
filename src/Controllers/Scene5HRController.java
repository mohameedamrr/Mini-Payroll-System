package Controllers;

import Classes.Employee;
import Classes.HR;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene5HRController {

    HR hr = new HR();
    @FXML
    private Button backButton;

    @FXML
    private Button checkIDButton;

    @FXML
    private Button exitButton;

    @FXML
    private Label idLabel;

    @FXML
    private TextField idTextField;

    @FXML
    private Label myLabel2;

    @FXML
    private Button noButton;

    @FXML
    private Label statusLabel1;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Label statusLabel2;

    @FXML
    private Button yesButton;

    private int id;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene1HR.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void checkID(ActionEvent event) {
        id = Integer.parseInt(idTextField.getText());
        if(hr.findEmployee(id) == null) {
            statusLabel1.setText("Invalid ID");
        } else {
            statusLabel1.setText("Correct ID");
        }
    }

    @FXML
    void exit(ActionEvent event) {
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
    void no(ActionEvent event) {
        statusLabel2.setText("Employee is Not Deleted!");
    }

    @FXML
    void yes(ActionEvent event) {
        id = Integer.parseInt(idTextField.getText());
        Employee emp = hr.findEmployee(id);
        hr.deleteEmployee(emp);
        statusLabel2.setText("Employee Deleted Successfully!!");
    }

}
