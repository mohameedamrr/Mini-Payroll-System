package Controllers;

import Classes.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javafx.scene.Parent;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {

        HR hr1 = new HR("Ahmed Mostafa",28 ,"Cairo", 10000,21333);
        HR hr2 = new HR("Mohamed Gamal",32 ,"Cairo", 15000,21213);
        HR hr3 = new HR("Hossam Ahmed",45 ,"Alexandria", 20000,85671);
        Service s1 = new Service("Mikel Hany",28 ,"Alexandria", 7000,21378);
        Service s2 = new Service("Mahmoud Lotfy",33 ,"Aswan", 10000,85307);
        Service s3 = new Service("Nadia Elgendy",45 ,"Cairo", 13000,93271);
        Manager M1 = new Manager("Mostafa Mohamed",55 ,"Cairo", 70000,11111);
        Sales u1= new Sales("Mohamed Karim",27 ,"Alexandria", 8000,22289);
        Sales u2= new Sales("Ahmed Samir",30 ,"Ismailia", 10000,11765);
        Sales u3= new Sales("Lotfy Labib",40 ,"Cairo", 15000,70798);
        Logistics l1= new Logistics("Ahmed Helmy",29 ,"Asiut", 8500,11182);
        Logistics l2= new Logistics("Ahmed Ezz",35 ,"Cairo", 10500,68712);
        Logistics l3= new Logistics("Mona Zaki",40 ,"Alexandria", 12000,11679);

        l1.addCar("MERCEDES", 900000, 2022, "C180", "TURBO", "SUV","Black", 50);
        l1.addCar("MERCEDES", 1000000, 2022, "CLA200", "Sports", "Sedan","Blue", 100);
        l2.addCar("MERCEDES", 1500000, 2022, "E450COUPE", "M50", "Sedan","Dark Blue", 50);
        l3.addCar("MERCEDES", 2000000, 2022, "MAYBACH", "Convertible", "Sedan","Grey", 70);


        l1.addPart("Bumper", 5000, 200);
        l2.addPart("Doors", 10000, 600);
        l3.addPart("HeadLights", 400, 20000);


        s1.addAppointment("Mohamed","05-05-2022","BMW X6",01222334,"Visa",237472);
        s2.addAppointment("Mohamed","10-05-2022","BMW X5",0164334,"Visa",23555552);
        s3.addAppointment("Ahmed","11-05-2022","BMW X6",0152333433,"Visa",333372);
        s1.addAppointment("Adham","08-05-2022","BMW 8series",01223434,"Visa",237472);


        u1.sellCar("E450COUPE","Cash",900000,"Ahmed Sameh","Cairo",19,21414124);
        u1.sellCar("CLA200", "Credit", 1000000, "Adham Haythem", "Alexandria", 20, 29108);
        u2.sellCar("C180", "Cash", 1500000, "Mohamed Amro", "Isamilia", 45, 2138012);
        u3.sellCar("MAYBACH", "Credit", 2000000, "Youssef Walid ", "Fayoum", 39, 219312);

        launch(args);
    }

    @Override
    public void start(Stage stage)  {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../JavaFX/loginScreen.fxml"));
        } catch (IOException e) {
            System.out.println("Error");
        }
        Scene scene = new Scene(root);

            stage.setTitle("Mercedes Car Agency");
            Image icon = new Image("Images/bmwLogo.png");
            stage.getIcons().add(icon);
            scene.getStylesheets().add(getClass().getResource("../Styling Sheets/styling1.css").toExternalForm());


            stage.setScene(scene);
            stage.show();



    }



}
