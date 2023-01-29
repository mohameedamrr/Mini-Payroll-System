package Controllers;

import Classes.Car_Model;
import Classes.Logistics;
import Classes.Sales;
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

public class Scene5LogisticsController {

    Sales s1 = new Sales();
    Logistics l1 = new Logistics();
    @FXML
    private Button Back;
    @FXML
    private Button Exit;
    @FXML
    private Button Submit;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private AnchorPane scenePane;
    @FXML
    TextField modelText;
    @FXML
    TextField priceText;
    @FXML
    Label statusLabel2;


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



    public void submit(ActionEvent event){
        Car_Model model = s1.returnCar();
        double price = Double.parseDouble(priceText.getText());
        l1.changePrice(model,price);

        statusLabel2.setText("Car price Changed Successfully!");
    }
    public void back(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene4Logistics.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}
