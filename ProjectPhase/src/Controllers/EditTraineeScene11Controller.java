package Controllers;

import Exceptions.*;
import Mini_Payroll.Admin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jdk.jshell.EvalException;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditTraineeScene11Controller implements Initializable {
 Admin admin =new Admin();

    ObservableList<String> EditValue = FXCollections.observableArrayList("Name","Age","GPA","University Name","Academic Year");
    @FXML
    private Button BackButton;
    @FXML
    private Button ExitButton;
    @FXML
    private AnchorPane pane;
    @FXML
    private Label idLabel;
    @FXML
    private ChoiceBox<String> ChoiceBox;
    @FXML
    private TextField ValueTextField;
    @FXML
    private Label StatusLabel;
    @FXML
    private Button submitButton;
    @FXML
    private ImageView imageError;
    @FXML
    private ImageView imageSuccess;

    private int id= Admin.getStoredTrainee().getID();

    private Stage stage;
    private Scene scene;
    private Parent root;

    private String Choice;
    private String Value;

    @FXML
    public void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../FXML Files/ViewTraineesScene9.fxml"));
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
            stage = (Stage) pane.getScene().getWindow();
            stage.close();
        }
    }
    public void editTrainee(ActionEvent event){
        Choice = ChoiceBox.getValue();
        Value= ValueTextField.getText();

        try{
           admin.editTrainee(id,Choice,Value);
            StatusLabel.setText("Trainee Edited Successfully!");
            imageSuccess.setVisible(true);
            imageError.setVisible(false);
        }
        catch (TraineeAgeException e){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            StatusLabel.setText(e.getMessage());
        }
        catch (GPAOutOfRangeException e){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            StatusLabel.setText(e.getMessage());
        }
        catch(NumberFormatException NFE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            StatusLabel.setText("Please Enter Valid Format");
        }
        catch (StringContainsNumberException SCNE) {
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            StatusLabel.setText(SCNE.getMessage());
        }
        catch (YearNotFoundException YNFE) {
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            StatusLabel.setText(YNFE.getMessage());
        }
        catch (NullPointerException NFE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            StatusLabel.setText("Please Enter Valid Format");
        }
        catch (emptyStringException ESE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            StatusLabel.setText("Please Enter Valid Format");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ChoiceBox.setItems(EditValue);
        idLabel.setText(String.valueOf(id));
    }


}
