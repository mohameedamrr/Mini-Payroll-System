package Controllers;

import Classes.Employee;
import Classes.HR;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Scene4HRController implements Initializable {

    HR hr = new HR();
    @FXML
    private Button backButton;

    @FXML
    private Button checkIDButton;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Button exitButton;

    @FXML
    private Label idLabel;

    @FXML
    private TextField idTextField;

    @FXML
    private Label myLabel1;

    @FXML
    private Label statusLabel1;

    @FXML
    private Label statusLabel2;

    @FXML
    private Button submitButton;

    @FXML
    private Label valueLabel;

    @FXML
    private Label valueLabel1;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private TextField valueTextField;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private int id;
    private String value;
    private String choice;

    private String[] choices = {"Name", "Age", "Address", "Department", "Salary"};

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
    void submit(ActionEvent event) {
        id = Integer.parseInt(idTextField.getText());
        choice = choiceBox.getValue();
        value = valueTextField.getText();

        Employee emp = hr.findEmployee(id);
        hr.editEmployeeList(emp,choice,value);
        statusLabel2.setText("Employee Edited Successfully!!");
        
    }

    @FXML
    void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene1HR.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(choices);
    }

    public void checkID(ActionEvent event) {
        id = Integer.parseInt(idTextField.getText());
        if(hr.findEmployee(id) == null) {
            statusLabel1.setText("Invalid ID");
        } else {
            statusLabel1.setText("Correct ID");
        }
    }



}
