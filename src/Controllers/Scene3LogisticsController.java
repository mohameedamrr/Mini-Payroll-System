package Controllers;

import Classes.Logistics;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
public class Scene3LogisticsController {

    @FXML
    private Label partName;
    @FXML
    private Label partPrice;
    @FXML
    private Label partNumber;
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField numField;
    @FXML
    private Button partSubmit;
    @FXML
    private Button backButton;
    @FXML
    private Button exitButton;
    @FXML
    Label statusLabel2;

    private Stage stage;
    @FXML
    private AnchorPane scenePane;
    private Scene scene;
    private Parent root;
    String name;
    int numofparts;
    double price;
    Logistics L1 = new Logistics();



    public void submit(ActionEvent event) throws IOException{

        name = nameField.getText();
        price = Double.parseDouble(priceField.getText());
        numofparts = Integer.parseInt(numField.getText());

        L1.addPart(name,price,numofparts);
        statusLabel2.setText("Car Part added Successfully!");


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
        System.out.println("back");
    }

}

