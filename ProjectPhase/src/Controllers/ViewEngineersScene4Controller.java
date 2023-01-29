package Controllers;

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
import Mini_Payroll.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Mini_Payroll.Admin;
import java.io.IOException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

public class ViewEngineersScene4Controller implements Initializable {
    private Admin ad = new Admin();
    public Engineer engineer;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Button BackButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button EditButton;

    @FXML
    private Button ExitButton;
    @FXML
    private TableView<Engineer> engineerTable;
    @FXML
    private TableColumn<Engineer, String> Name;
    @FXML
    private TableColumn<Engineer,Integer> Age;
    @FXML
    private TableColumn<Engineer, Integer> ID;
    @FXML
    private TableColumn<Engineer, String> Position;
    @FXML
    private TableColumn<Engineer, Integer> workingHours;
    @FXML
    private TableColumn<Engineer, Double> Salary;

    Parent root ;
    Scene scene;
    Stage stage;


    ObservableList<Engineer> EngineerList = FXCollections.observableList(ad.viewEngineers());

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Name.setCellValueFactory(new PropertyValueFactory<Engineer, String>("name"));
        Age.setCellValueFactory(new PropertyValueFactory<Engineer, Integer>("age"));
        ID.setCellValueFactory(new PropertyValueFactory<Engineer, Integer>("ID"));
        Position.setCellValueFactory(new PropertyValueFactory<Engineer, String>("position"));
        workingHours.setCellValueFactory(new PropertyValueFactory<Engineer, Integer>("workingHours"));
        Salary.setCellValueFactory(new PropertyValueFactory<Engineer, Double>("salary"));

        engineerTable.setItems(EngineerList);
    }
    public void edit(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../FXML Files/EditEngineerScene5.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    public void delete(ActionEvent event) {
       try{
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Delete Engineer");
           alert.setHeaderText("You are about to delete an Engineer");
           alert.setContentText("Are you sure you want to Delete?");

           if(alert.showAndWait().get() == ButtonType.OK) {
               ad.deleteEngineer(engineer.getID());
               Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
               engineerTable.refresh();
               alert2.setTitle("Engineer Deleted");
               alert2.setHeaderText("You Deleted an Engineer!");
               alert2.setContentText("Engineer Deleted Successfully");
               if(alert2.showAndWait().get() == ButtonType.CLOSE){

               }
           }
       }
        catch (NoSuchElementException NSEE){        //We don't want any action to happen after closing without deleting
        }

    }

    @FXML
    public void getSelected(MouseEvent event){
        engineer =engineerTable.getSelectionModel().getSelectedItem();
        Admin.setStoredEngineer(engineer);
        EditButton.setVisible(true);
        DeleteButton.setVisible(true);
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
        root = FXMLLoader.load(getClass().getResource("../FXML Files/EngineerHomePageScene3.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }


}
