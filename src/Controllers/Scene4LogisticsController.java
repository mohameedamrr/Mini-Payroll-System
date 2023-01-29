package Controllers;

import Classes.Car_Model;
import Classes.Logistics;
import Classes.Sales;
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
import java.util.ResourceBundle;


public class Scene4LogisticsController implements Initializable {
    @FXML
    private Button Back;
    @FXML
    private Button Exit;

    public Car_Model getCar() {
        return Car;
    }

    Sales s1 = new Sales();

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private AnchorPane scenePane;
    Car_Model Car;
    @FXML
    private TableView<Car_Model> tableView;
    @FXML
    private TableColumn<Car_Model, String> Name;
    @FXML
    private TableColumn<Car_Model, Integer> Year;
    @FXML
    private TableColumn<Car_Model, Double> Price;
    @FXML
    private TableColumn<Car_Model, String> Description;
    @FXML
    private TableColumn<Car_Model, String> Type;
    @FXML
    private TableColumn<Car_Model, String> Color;
    @FXML
    private TableColumn<Car_Model, String> Model;
    @FXML
    private TableColumn<Car_Model, Integer> quantity;

    @FXML
    private Button changeCarPriceButton;
    ObservableList<Car_Model> carList = FXCollections.observableList(Logistics.viewCars());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Name.setCellValueFactory(new PropertyValueFactory<Car_Model, String>("Name"));
        Model.setCellValueFactory(new PropertyValueFactory<Car_Model, String>("Model"));
        Year.setCellValueFactory(new PropertyValueFactory<Car_Model, Integer>("Year"));
        Price.setCellValueFactory(new PropertyValueFactory<Car_Model, Double>("Price"));
        Description.setCellValueFactory(new PropertyValueFactory<Car_Model, String>("Description"));
        Type.setCellValueFactory(new PropertyValueFactory<Car_Model, String>("Type"));
        quantity.setCellValueFactory(new PropertyValueFactory<Car_Model,Integer>("Quantity"));
        Color.setCellValueFactory(new PropertyValueFactory<Car_Model, String>("Color"));

        tableView.setItems(carList);
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

    public void back(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene1Logistics.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void getSelected(MouseEvent event){
        Car =tableView.getSelectionModel().getSelectedItem();
        s1.storeCar(Car);
        //return Car;

    }
    public void changeCarPrice(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene5Logistics.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}