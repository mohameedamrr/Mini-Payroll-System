package Controllers;

import Classes.Car_Part;
import Classes.Logistics;
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


public class Scene6LogisticsController implements Initializable {
    @FXML
    private Button Back;
    @FXML
    private Button Exit;

    public Car_Part getCar() {
        return Car_Part;
    }


    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private AnchorPane scenePane;
    Car_Part Car_Part;
    @FXML
    private TableView<Car_Part> tableView;
    @FXML
    private TableColumn<Car_Part, String> Description;
    @FXML
    private TableColumn<Car_Part, Double> Price;
    @FXML
    private TableColumn<Car_Part, Integer> NumberOfParts;
    ObservableList<Car_Part> carList = FXCollections.observableList(Logistics.viewParts());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Description.setCellValueFactory(new PropertyValueFactory<Car_Part, String>("Description"));
        Price.setCellValueFactory(new PropertyValueFactory<Car_Part, Double>("Price"));
        NumberOfParts.setCellValueFactory(new PropertyValueFactory<Car_Part,Integer>("NumberOfParts"));

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
}
