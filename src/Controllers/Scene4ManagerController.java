package Controllers;

import Classes.*;
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

public class Scene4ManagerController implements Initializable{

    @FXML
    private TableColumn<SalesRecord, String> address;

    @FXML
    private TableColumn<SalesRecord, Integer> age;

    @FXML
    private TableColumn<SalesRecord, Double> amount;

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<SalesRecord, String> carModel;

    @FXML
    private TableColumn<SalesRecord, String> customerName;

    @FXML
    private Button exitButton;

    @FXML
    private Label myLabel1;

    @FXML
    private TableColumn<SalesRecord, Integer> nationalID;

    @FXML
    private TableColumn<SalesRecord, String> paymentType;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private TableColumn<SalesRecord, String> transactionType;

    @FXML
    private TableView table;

    private Stage stage;
    private Scene scene;
    private Parent root;

    ObservableList<Employee> list = FXCollections.observableList(SalesRecord.viewSalesRecords());

    @FXML
    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene1Manager.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void exit(ActionEvent event) throws IOException{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit");
        alert.setContentText("Are you sure you want to exit?");

        if(alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            stage.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customerName.setCellValueFactory(new PropertyValueFactory<SalesRecord,String>("Name"));
        carModel.setCellValueFactory(new PropertyValueFactory<SalesRecord,String>("carModel"));
        age.setCellValueFactory(new PropertyValueFactory<SalesRecord,Integer>("Age"));
        nationalID.setCellValueFactory(new PropertyValueFactory<SalesRecord,Integer>("NationalID"));
        address.setCellValueFactory(new PropertyValueFactory<SalesRecord,String>("Address"));
        paymentType.setCellValueFactory(new PropertyValueFactory<SalesRecord,String>("PaymentType"));
        transactionType.setCellValueFactory(new PropertyValueFactory<SalesRecord,String>("TransactionType"));
        amount.setCellValueFactory(new PropertyValueFactory<SalesRecord,Double>("Amount"));


        table.setItems(list);
    }
}
