package Controllers;

import Mini_Payroll.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

import java.io.IOException;


public class LoginScene1Controller {

    @FXML
    private AnchorPane Pane;
    @FXML
    private ImageView imageTime;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField usernameTextField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void login(ActionEvent event) throws IOException {
        if( (usernameTextField.getText().equals(Admin.getUsername())) && ( passwordTextField.getText().equals(Admin.getPassword()) ) ){
            root = FXMLLoader.load(getClass().getResource("../FXML Files/HomePageScene2.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        }
        else if(usernameTextField.getText().equals("") && ( passwordTextField.getText().equals(""))) {
            statusLabel.setText("Please Enter Username and Password");
        }
        else if (usernameTextField.getText().equals("")){
            statusLabel.setText("Please Enter Username");
        }
        else if (passwordTextField.getText().equals("")){
            statusLabel.setText("Please Enter Password");
        }
        else {
            statusLabel.setText("Wrong Combination of Username & Password");
        }
    }

}
