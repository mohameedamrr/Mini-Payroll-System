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

public class Scene3ManagerController implements Initializable {

    @FXML
    private TableView<Employee> table;

    @FXML
    private TableColumn<Employee, String> address;

    @FXML
    private TableColumn<Employee, Integer> age;

    @FXML
    private TableColumn<Employee, String> department;

    @FXML
    private TableColumn<Employee, Integer> id;

    @FXML
    private TableColumn<Employee, String> name;

    @FXML
    private TableColumn<Employee, Double> salary;

    @FXML
    private Button backButton;

    @FXML
    private Button exitButton;

    @FXML
    private Label myLabel1;

    @FXML
    private AnchorPane scenePane;

    private Stage stage;
    private Scene scene;
    private Parent root;

    ObservableList<Employee> list = FXCollections.observableList(HR.viewEmployeeList());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        id.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("ID"));
        name.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
        department.setCellValueFactory(new PropertyValueFactory<Employee,String>("department"));
        age.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("age"));
        address.setCellValueFactory(new PropertyValueFactory<Employee,String>("address"));
        salary.setCellValueFactory(new PropertyValueFactory<Employee,Double>("salary"));

        table.setItems(list);
    }

    public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene1Manager.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
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
}

