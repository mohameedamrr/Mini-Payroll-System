package Controllers;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Scene3HRController implements Initializable {
    HR hr = new HR();
    @FXML
    private TextField NameTextField;

    @FXML
    private Label addressLabel;

    @FXML
    private TextField addressTextField;

    @FXML
    private Label ageLabel;

    @FXML
    private TextField ageTextField;

    @FXML
    private Button backButton;

    @FXML
    private Button checkIDButton;

    @FXML
    private ChoiceBox<String> departmentChoiceBox;

    @FXML
    private Label departmentLabel;

    @FXML
    private Button exitButton;

    @FXML
    private Label idLabel;

    @FXML
    private TextField idTextField;

    @FXML
    private Label myLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label salaryLabel;

    @FXML
    private TextField salaryTextField;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Label statusLabel;

    @FXML
    private Button submitButton;

    @FXML
    private Label statusLabel2;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private String[] departments = {"Manager","HR", "Logistics", "Service", "Sales"};
    private String name;
    private int age;
    private String address;
    private double salary;
    private int id;
    private String department;

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
        departmentChoiceBox.getItems().addAll(departments);
    }

    public void submit(ActionEvent event){
        name = NameTextField.getText();
        age = Integer.parseInt(ageTextField.getText());
        address = addressTextField.getText();
        salary = Double.parseDouble(salaryTextField.getText());
        id = Integer.parseInt(idTextField.getText());
        department = departmentChoiceBox.getValue();
        hr.addEmployee(name, age, address, salary, id, department);
        statusLabel2.setText("Employee Submitted Successfully!");
    }

    public void checkID(ActionEvent event) {
        id = Integer.parseInt(idTextField.getText());
        if(hr.findEmployee(id) == null) {
            statusLabel.setText("No Employee with that ID");
        } else {
            statusLabel.setText("ID Taken");
        }
    }
}

