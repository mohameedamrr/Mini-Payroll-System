package Controllers;
import Exceptions.EngineerAgeException;
import Exceptions.StringContainsNumberException;
import Exceptions.WorkingHoursException;
import Exceptions.emptyStringException;
import javafx.collections.FXCollections;
import Mini_Payroll.*;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class AddEngineerScene6Controller implements Initializable {
    Admin admin = new Admin();
    Engineer engineer;

    ObservableList<String> PositionStatus = FXCollections.observableArrayList("Manager","Department Manager","Project Manager","Team Leader","Team Member");
    @FXML
    private ChoiceBox PositionChoice;
    @FXML
    private AnchorPane Pane;
    @FXML
    private Button AddButton;
    @FXML
    private Button BackButton;
    @FXML
    private Button ExitButton;
    @FXML
    private TextField NameTextField;
    @FXML
    private TextField WorkingHoursTextField;
    @FXML
    private TextField AgeTextField;
    @FXML
    private Label LabelText;

    @FXML
    private ImageView imageError;
    @FXML
    private ImageView imageSuccess;
    String Name;
    int Age ;
    int WorkingHours;
    String Position;
    Parent root;
    Scene scene;
    Stage stage;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        PositionChoice.setItems(PositionStatus);
    }

    @FXML
    public void Add(ActionEvent event) throws IOException{

        try {
            Name = NameTextField.getText();
            Position = (String) PositionChoice.getValue();
            Age = Integer.parseInt(AgeTextField.getText());
            WorkingHours= Integer.parseInt(WorkingHoursTextField.getText());
            engineer=admin.addEngineer(Name,Age,Position,WorkingHours);
            LabelText.setText("Engineer Added Successfully with ID: " + engineer.getID());
            imageError.setVisible(false);
            imageSuccess.setVisible(true);

        }
        catch (NullPointerException NPE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            LabelText.setText("Enter Correct Format!");
        }
        catch (NumberFormatException NFE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            LabelText.setText("Enter Correct Format!");
        }
        catch(StringContainsNumberException SCNE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            LabelText.setText("Name Contains Number!");
        }
        catch (EngineerAgeException EAE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            LabelText.setText(EAE.getMessage());
        }
        catch (emptyStringException ESE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            LabelText.setText("Please Enter Valid Format");
        }
        catch (WorkingHoursException WHE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            LabelText.setText(WHE.getMessage());
        }
    }



    @FXML
    public void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../FXML Files/EngineerHomepageScene3.fxml"));
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
