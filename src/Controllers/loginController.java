package Controllers;

import Classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.IOException;

public class loginController {

    @FXML
    private Label myLabel1;

    @FXML
    private Label passwordLabel;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private Label statusLabel;

    @FXML
    private Button submitButton;

    @FXML
    private Label udernameLabel;

    @FXML
    private TextField usernameTextField;

    private String username;
    private String password;
    private Stage stage;
    private Scene scene;
    private Parent root;
    ImageView myImageView;
    Image myImage = new Image(getClass().getResourceAsStream("../Styling Sheets/styling1.css"));

    @FXML
    void submit(ActionEvent event) throws IOException {

        username = usernameTextField.getText();
        password = passwordTextField.getText();

        if( (Manager.getUsername().equals(username)) && (Manager.getPassword().equals(password)) ) {
            Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene1Manager.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } else if( (HR.getUsername().equals(username)) && (HR.getPassword().equals(password)) ) {
            Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene1HR.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } else if ( (Sales.getUsername().equals(username)) && (Sales.getPassword().equals(password)) ) {
            Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene1Sales.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } else if( (Service.getUsername().equals(username)) && (Service.getPassword().equals(password)) ) {
            Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene1Service.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } else if( (Logistics.getUsername().equals(username)) && (Logistics.getPassword().equals(password)) ) {
            Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene1Logistics.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } else {
            statusLabel.setText("Wrong Combinations of Username and Password");
        }
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
