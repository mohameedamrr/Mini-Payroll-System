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


public class Scene2SalesController implements Initializable{

    Sales s1 = new Sales();

    @FXML
    private Button viewButton;


    @FXML
    private AnchorPane scenePane;

    private Stage stage;
    private Scene scene;
    private Parent root;
    Car_Model Car;
    @FXML
    private TableView<Car_Model> tableView;
    @FXML
    private TableColumn<Car_Model, String> Name;
    @FXML
    private TableColumn<Car_Model,Integer> Year;
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
    private Button exitButton;

    @FXML
    private Button backButton;

    @FXML
    private Label myLabel;

    @FXML
    private Button sellButton;

    ObservableList<Car_Model> carList = FXCollections.observableList(Logistics.viewCars());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Name.setCellValueFactory(new PropertyValueFactory<Car_Model, String>("Name"));
        Model.setCellValueFactory(new PropertyValueFactory<Car_Model, String>("Model"));
        Year.setCellValueFactory(new PropertyValueFactory<Car_Model, Integer>("Year"));
        Price.setCellValueFactory(new PropertyValueFactory<Car_Model, Double>("Price"));
        Description.setCellValueFactory(new PropertyValueFactory<Car_Model, String>("Description"));
        Type.setCellValueFactory(new PropertyValueFactory<Car_Model, String>("Type"));
        Color.setCellValueFactory(new PropertyValueFactory<Car_Model, String>("Color"));
        quantity.setCellValueFactory(new PropertyValueFactory<Car_Model, Integer>("Quantity"));

        tableView.setItems(carList);
    }

    public void getSelected(MouseEvent event){
        Car =tableView.getSelectionModel().getSelectedItem();
        s1.storeCar(Car);

        sellButton.setVisible(true);


        //return Car;

    }
    public void sellCar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene3Sales.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

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

    public void back(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene1Sales.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
