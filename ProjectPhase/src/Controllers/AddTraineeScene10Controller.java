package Controllers;

import Exceptions.*;
import Mini_Payroll.Admin;
import Mini_Payroll.Trainee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class AddTraineeScene10Controller implements Initializable {

    @FXML
    private AnchorPane Pane;
    @FXML
    private Button backButton;
    @FXML
    private Button exitButton;
    @FXML
    private TextField NameTextField;
    @FXML
    private TextField AgeTextField;
    @FXML
    private TextField GPATextField;
    @FXML
    private TextField UniNameTextField;
    @FXML
    private TextField AcademicYearTextField;
    @FXML
    private Button submitButton;
    @FXML
    private Label VerifyLabel;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private ImageView imageError;
    @FXML
    private ImageView imageSuccess;

    ObservableList<String> EditValue = FXCollections.observableArrayList("Freshmen","Sophomore","Junior","Senior 1","Senior 2");

    Parent root ;
    Scene scene;
    Stage stage;
    Admin admin = new Admin();

    public void submit(ActionEvent event) throws IOException{

        try {

            String name = NameTextField.getText();
            int age=parseInt(AgeTextField.getText());
            float GPA=parseFloat(GPATextField.getText());
            String uniName=UniNameTextField.getText();
            String AcademicYear=choiceBox.getValue();
            admin.addTrainee(name,age,GPA,uniName,AcademicYear);
            VerifyLabel.setText("Trainee Added Successfully!");
            imageError.setVisible(false);
            imageSuccess.setVisible(true);
        }
        catch (StringContainsNumberException SCNE){
            imageError.setVisible(true);
            VerifyLabel.setText("Name Contains Number!");

        }
        catch (TraineeAgeException TAE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            VerifyLabel.setText(TAE.getMessage());
        }
        catch (GPAOutOfRangeException GORE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            VerifyLabel.setText(GORE.getMessage());
        }
        catch (YearNotFoundException YNFE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            VerifyLabel.setText(YNFE.getMessage());
        }
        catch (emptyStringException ESE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            VerifyLabel.setText("Please Enter Valid Format");
        }
        catch (NumberFormatException NFE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
                VerifyLabel.setText("Enter Correct Format!");
        }
        catch (NullPointerException NPE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            VerifyLabel.setText("Enter Correct Format!");
        }

    }
    public void back(ActionEvent event) throws  IOException{

        root = FXMLLoader.load(getClass().getResource("../FXML FILES/TraineeHomepageScene8.fxml"));
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setItems(EditValue);

    }


}
