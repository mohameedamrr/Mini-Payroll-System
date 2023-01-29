package Controllers;

import Mini_Payroll.Admin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.IOException;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("../FXML Files/LoginScene1.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Mini Payroll System");
        Image icon = new Image("Media/moneyIcon.png");
        stage.getIcons().add(icon);
        scene.getStylesheets().add(getClass().getResource("../Stylings/styling1.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {

        Admin admin = new Admin();
                                    // We know that this code is correct so no need to handle any exceptions
        try {
            // Create engineer objects using add
            admin.addEngineer("Mostafa Mohamed", 50, "Manager", 100);             //1
            admin.addEngineer("Mohamed Saeed", 50, "Department Manager", 150);    //2
            admin.addEngineer("Mohy Ismail", 39, "Project Manager", 200);         //3
            admin.addEngineer("Ahmed Refaat", 42, "Team Leader", 180);            //4
            admin.addEngineer("Ali Sameh", 25, "Team Member", 280);               //5
            admin.addEngineer("Mohsen Mohamed", 34, "Team Leader", 160);          //6
            admin.addEngineer("Karim Ahmed", 29, "Department Manager", 150);      //7
            admin.addEngineer("Mariam Mackawy", 25, "Project Manager", 120);      //8
            admin.addEngineer("Mina Morgan", 33, "Team Leader", 100);             //9
            admin.addEngineer("Habiba Mohamed", 36, "Team Member", 280);          //10
            admin.addEngineer("Laila Sherif", 31, "Team Member", 280);            //11
            admin.addEngineer("Omar Emad", 29, "Department Manager", 150);        //12
            admin.addEngineer("Ali Ahmed", 32, "Team Member", 280);               //13
            admin.addEngineer("Abdelrahman Ahmed", 42, "Team Leader", 100);       //14
            admin.addEngineer("Sara Ahmed", 27, "Team Member", 280);              //15

            // Create trainee objects using add
            admin.addTrainee("Ahmed Sameh", 19, 3.38f, "Ain Shams", "Sophomore");      //17
            admin.addTrainee("Youssef Walid", 20, 3.00f, "Ain Shams", "Sophomore");    //18
            admin.addTrainee("Adham Haytham", 19, 3.99f, "Ain Shams", "Sophomore");    //19
            admin.addTrainee("Omar Ashraf", 20, 3.50f, "Ain Shams", "Sophomore");      //20
            admin.addTrainee("Mohamed Amr", 19, 3.28f, "Ain Shams", "Sophomore");      //21
            admin.addTrainee("Sara Ahmed", 21, 2.80f, "GUC", "Junior");                //22
            admin.addTrainee("Salma Mohamed", 22, 2.69f, "AUC", "Senior 1");           //23
            admin.addTrainee("Nour Labib", 23, 3.09f, "GUC", "Senior 2");              //24
            admin.addTrainee("Nadia Elgendy", 21, 3.19f, "BUC", "Junior");             //25
            admin.addTrainee("Mazen Ali", 20, 2.90f, "Ain Shams", "Sophomore");         //26
        }
        catch (Exception e){
        }


        launch(args);
    }




}
