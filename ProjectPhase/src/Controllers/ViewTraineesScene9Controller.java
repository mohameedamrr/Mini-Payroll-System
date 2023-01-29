package Controllers;

import Mini_Payroll.Admin;
import Mini_Payroll.Trainee;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

public class ViewTraineesScene9Controller implements Initializable {
    private Admin ad = new Admin();
    Trainee trainee;
    @FXML
    private AnchorPane Pane;
    @FXML
    private Button backButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button editButton;

    @FXML
    private Button exitButton;
    @FXML
    private TableView<Trainee> TableView;
    @FXML
    private TableColumn<Trainee, String> Name;
    @FXML
    private TableColumn<Trainee,Integer> Age;
    @FXML
    private TableColumn<Trainee, Float> gpa;
    @FXML
    private TableColumn<Trainee, String> uniName;
    @FXML
    private TableColumn<Trainee,String>AcademicYear;
    @FXML
    private TableColumn<Trainee, Integer> ID;

    Parent root ;
    Scene scene;
    Stage stage;


    ObservableList<Trainee> TraineeList = FXCollections.observableList(ad.viewTrainees());

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Name.setCellValueFactory(new PropertyValueFactory<Trainee, String>("name"));
        Age.setCellValueFactory(new PropertyValueFactory<Trainee, Integer>("age"));
        ID.setCellValueFactory(new PropertyValueFactory<Trainee, Integer>("ID"));
        gpa.setCellValueFactory(new PropertyValueFactory<Trainee, Float>("gpa"));
        uniName.setCellValueFactory(new PropertyValueFactory<Trainee, String>("Uni"));
        AcademicYear.setCellValueFactory(new PropertyValueFactory<Trainee, String>("year"));

        TableView.setItems(TraineeList);

    }
    @FXML
    public void getSelected(MouseEvent event){
        trainee =TableView.getSelectionModel().getSelectedItem();
        Admin.setStoredTrainee(trainee);
        editButton.setVisible(true);
        deleteButton.setVisible(true);
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
    public void back(ActionEvent event) throws  IOException{

        root = FXMLLoader.load(getClass().getResource("../FXML Files/TraineeHomePageScene8.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    public void edit(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../FXML Files/EditTraineeScene11.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    public void delete(ActionEvent event) throws IOException{
            try{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Delete Trainee");
                alert.setHeaderText("You are about to delete a Trainee");
                alert.setContentText("Are you sure you want to Delete?");

                if(alert.showAndWait().get() == ButtonType.OK) {
                    ad.deleteTrainee(trainee.getID());
                    Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                    TableView.refresh();
                    alert2.setTitle("Trainee Deleted");
                    alert2.setHeaderText("You Deleted a Trainee!");
                    alert2.setContentText("Trainee Deleted Successfully");
                 if (alert2.showAndWait().get() == ButtonType.CLOSE) {
                    }
                }
             }
            catch (NoSuchElementException NSEE){        //We don't want any action to happen after closing without deleting
            }
    }
}

