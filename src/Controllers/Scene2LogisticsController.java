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
import java.io.IOException;

public class Scene2LogisticsController {

        Logistics l1 = new Logistics();
        @FXML
        private Stage stage;
        @FXML
        private Scene scene;
        @FXML
        private Parent root;
        @FXML
        private AnchorPane scenePane;
        @FXML
        TextField nameText;         //1
        @FXML
        TextField priceText;       //2
        @FXML
        TextField yearText;       //3
        @FXML
        TextField modelText;     //4
        @FXML
        TextField descriptionText;  //5
        @FXML
        TextField typeText;      //6
        @FXML
        TextField colorText;     //7
        @FXML
        TextField quantityText; ///8
        @FXML
        Label statusLabel2; //9
        @FXML
        private Button Back;
        @FXML
        private Button Exit;
        @FXML
        private Button Submit;



        public void back(ActionEvent event) throws IOException
        {
            root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene1Logistics.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
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



        public void submit(ActionEvent event){
            String name = nameText.getText();
            String model = modelText.getText();
            String description = descriptionText.getText();
            String type = typeText.getText();
            String Color = colorText.getText();
            int Quantity = Integer.parseInt(quantityText.getText());
            int year = Integer.parseInt(yearText.getText());
            double price = Double.parseDouble(priceText.getText());
            l1.addCar(name,price,year,model,description,type,Color,Quantity);
            statusLabel2.setText("Car Added Successfully!");
        }
}
