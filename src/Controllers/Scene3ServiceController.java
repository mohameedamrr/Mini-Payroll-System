package Controllers;

import Classes.Service;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Scene3ServiceController {
    @FXML
    private TextField myNameTextField;

    @FXML
    private TextField myTypeTextField;
    @FXML
    private TextField myPhoneTextField;
    @FXML
    private TextField myPaymentTextField;
    @FXML
    private TextField myAmountTextField;
    @FXML
    private Label myStatusLabel;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private DatePicker myDateField;
    private Stage stage;
    private Parent root;
    private  Scene scene;

    public void Submit(ActionEvent event) throws IOException {
 LocalDate myDate = myDateField.getValue();
 String myFormattedDate=myDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        if(Service.checkDate(myFormattedDate)==false){
            myStatusLabel.setText("Appointment added successfully");
            int amount =Integer.parseInt(myPhoneTextField.getText());
            int phone=Integer.parseInt(myAmountTextField.getText());
            Service.addAppointment(myNameTextField.getText(),myFormattedDate,
                    myTypeTextField.getText(),amount, myPaymentTextField.getText(),phone);
        }
        else{
            myStatusLabel.setText("Invalid Appointment date");

        }


    }
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
    public void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene1Service.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }


}
