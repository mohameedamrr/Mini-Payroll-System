package Controllers;
import Classes.*;
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

public class Scene3SalesController {
    private String S;
    private Sales s1 = new Sales();


    @FXML
    private Label addressLabel;

    @FXML
    private TextField addressTextField;

    @FXML
    private Label ageLabel;

    @FXML
    private TextField ageTextField;

    @FXML
    private Button backButton;

    @FXML
    private RadioButton cashRadio, creditRadio;


    @FXML
    private Button exitButton;

    @FXML
    private Label idLabel;

    @FXML
    private TextField idTextField;

    @FXML
    private Label myLabel;

    @FXML
    private Label naemLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label paymentTypeLabel;

    @FXML
    private Button recieptButton1;

    @FXML
    private Label statusLabel;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Button submitButton;
    @FXML
    private ToggleGroup tgPay;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene2Sales.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void exit(ActionEvent event) throws IOException{
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
    void radioButton (ActionEvent event){
        if(cashRadio.isSelected()) {
            S="Cash";
        }
        else if (creditRadio.isSelected()) {
            S="Credit";
        }

    }

    @FXML
    void submit(ActionEvent event) throws IOException{
        String nameText = nameTextField.getText();
        String addressText = addressTextField.getText();
        int Age = Integer.parseInt(ageTextField.getText());
        int NationalID = Integer.parseInt(idTextField.getText());
        s1.sellCar(s1.returnCar().getModel(),S, s1.returnCar().getPrice(), nameText, addressText, Age, NationalID);
        if (s1.returnCar().getQuantity() == 0) {
            statusLabel.setText("Out of stock");
        }else statusLabel.setText("Sold");

    }

}
