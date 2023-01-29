package Controllers;

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
public class Scene1LogisticsController {
    @FXML
    private AnchorPane scenePane;
    @FXML
    private Button AddCar;
    @FXML
    private Button AddPart;
    @FXML
    private Button Exit;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private Button Change;
    @FXML
    private Button viewParts;
    @FXML
    private Button viewCars;
    @FXML
    private Button logoutButton;


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




    public void carAdder (ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene2Logistics.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }


    public void partAdder(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene3Logistics.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    public void ViewCar(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene4Logistics.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    public void ViewPart(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/Scene6Logistics.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public void logout(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../JavaFX/loginScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

}

