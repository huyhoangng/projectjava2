package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import rootStage.Main;


import java.io.IOException;

public class HomeController {
        public void goToCar(ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("../javaFx/cars/OurCar.fxml"));

            Main.rootStage.setScene(new Scene(root, 830,550));
        }


        public void goToCostomer(ActionEvent actionEvent) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("../javaFx/customer/ListCustomer.fxml"));

            Main.rootStage.setScene(new Scene(root, 830,550));
        }


    public void goToDoneList(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../javaFx/orders/Orders.fxml"));

        Main.rootStage.setScene(new Scene(root, 830,550));
    }
}

