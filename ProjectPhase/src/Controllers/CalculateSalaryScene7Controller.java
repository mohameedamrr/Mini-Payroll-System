package Controllers;

import Mini_Payroll.Admin;
import Mini_Payroll.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculateSalaryScene7Controller {

    @FXML
    private TextField IDTextfield;

    @FXML
    private AnchorPane Pane;

    @FXML
    private Button backButton;

    @FXML
    private Button checkIDButton;

    @FXML
    private Label checkIDLabel;

    @FXML
    private Button exitButton;

    @FXML
    private Label statusLabel;

    @FXML
    private Button CalculateButton;
    @FXML
    private ImageView imageError;
    @FXML
    private ImageView imageSuccess;

    private Employee emp;
    private Admin admin = new Admin();

    private Integer ID;
    private boolean isEngineer = false;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../FXML Files/HomePageScene2.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void checkID(ActionEvent event) {
        try {
            ID = Integer.parseInt(IDTextfield.getText());
            emp = admin.findEngineer(ID);
            if (emp != null) {
                checkIDLabel.setText("Engineer Found with Name: " + emp.getName());
                imageError.setVisible(false);
                imageSuccess.setVisible(true);
                isEngineer = true;
            } else if (admin.findTrainee(ID) != null) {
                emp = admin.findTrainee(ID);
                checkIDLabel.setText("Trainee Found with Name: " + emp.getName());
                imageError.setVisible(false);
                imageSuccess.setVisible(true);
            } else {
                checkIDLabel.setText("ID Not Found!");
                imageSuccess.setVisible(false);
                imageError.setVisible(true);
            }
        }
        catch (NumberFormatException NFE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            checkIDLabel.setText("Empty ID, Please Enter ID");
        }

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

    @FXML
    public void CalcSalary(ActionEvent event) {
        try {
            checkID(event);
            if (isEngineer == true) {
                statusLabel.setText("Engineer with ID " + emp.getID() + " has a salary of: " + emp.getSalary() + "$.");
                imageSuccess.setVisible(true);
                imageError.setVisible(false);
            } else if ((isEngineer == false) && (emp != null)) {
                statusLabel.setText("Trainee with ID " + emp.getID() + " has a salary of: " + emp.getSalary() + "$.");
                imageSuccess.setVisible(true);
                imageError.setVisible(false);
            } else {
                statusLabel.setText("Employee Not Found, Please Enter a Valid ID");
                imageSuccess.setVisible(false);
                imageError.setVisible(true);
            }

        }
        catch (NullPointerException NPE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            statusLabel.setText("Employee Not Found, Please Enter a Valid ID");
        }

    }

}
