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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditEngineerScene5Controller implements Initializable {

    Admin admin = new Admin();
    ObservableList<String> EditValue = FXCollections.observableArrayList("Name","Age","Position","Working Hours");
    @FXML
    private Label IDLabel;

    @FXML
    private AnchorPane Pane;

    @FXML
    private Label ValueLabel;

    @FXML
    private TextField ValueTextField;

    @FXML
    private Button backButton;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Button exitButton;

    @FXML
    private Label statusLabel;

    @FXML
    private Button submitButton;
    @FXML
    private ImageView imageError;
    @FXML
    private ImageView imageSuccess;

    private int ID = Admin.getStoredEngineer().getID();

    private String choice;

    private String value;

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../FXML Files/ViewEngineersScene4.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void editEngineer(ActionEvent event) {
        choice = (String) choiceBox.getValue();
        value = ValueTextField.getText();
        try{
            admin.editEngineer(ID,choice,value);
            statusLabel.setText("Engineer Edited Successfully!");
            imageSuccess.setVisible(true);
            imageError.setVisible(false);
        }
        catch(EngineerAgeException EAE) {
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            statusLabel.setText(EAE.getMessage());
        }
        catch(PositionNotFoundException PNFE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            statusLabel.setText(PNFE.getMessage());
        }
        catch (NumberFormatException NFE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            statusLabel.setText("Please Enter Valid Format");
        }
        catch (WorkingHoursException WHE) {
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            statusLabel.setText(WHE.getMessage());
        }
        catch (emptyStringException ESE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            statusLabel.setText("Please Enter Valid Format");
        }
        catch (StringContainsNumberException SCNE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            statusLabel.setText(SCNE.getMessage());
        }
        catch (NullPointerException NFE){
            imageSuccess.setVisible(false);
            imageError.setVisible(true);
            statusLabel.setText("Please Enter Valid Format");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.setItems(EditValue);
        IDLabel.setText(String.valueOf(ID));
    }
}
