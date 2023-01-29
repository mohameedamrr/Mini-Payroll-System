package Controllers;

import Classes.Employee;
import Classes.HR;
import Classes.Service;
import Classes.appointments;
import javafx.fxml.Initializable;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Scene2ServiceController implements Initializable {
    @FXML
    private Button backButton;

    @FXML
    private TableColumn<appointments, String> cartype;

    @FXML
    private TableColumn<appointments, String> date;

    @FXML
    private Button exitButton;

    @FXML
    private Label myLabel1;

    @FXML
    private TableView<appointments> myTable;

    @FXML
    private TableColumn<appointments, String> name;

    @FXML
    private TableColumn<appointments, Integer> phonenumber;

    @FXML
    private TableColumn<appointments, Double> MyAmount;

    @FXML
    private TableColumn<appointments, String> MyPaymentType;

    @FXML
    private AnchorPane scenePane;
    private Stage stage;
    private Scene scene;

    appointments ap = new appointments();


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
     public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene1Service.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    ObservableList<appointments> list = FXCollections.observableList(Service.viewAppointments());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        name.setCellValueFactory(new PropertyValueFactory<appointments,String>("Name"));
        date.setCellValueFactory(new PropertyValueFactory<appointments,String>("appDate"));
        cartype.setCellValueFactory(new PropertyValueFactory<appointments,String>("Cartype"));
        phonenumber.setCellValueFactory(new PropertyValueFactory<appointments,Integer>("PhoneNumber"));
        MyPaymentType.setCellValueFactory(new PropertyValueFactory<appointments,String>("PaymentType"));
        MyAmount.setCellValueFactory(new PropertyValueFactory<appointments,Double>("Amount"));


        myTable.setItems(list);
    }

}


