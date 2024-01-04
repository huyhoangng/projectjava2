package controller.car;


import database.Connector;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import rootStage.Main;


import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class AddCarController implements Initializable{
    public TextField ipName;
    public TextArea ipPosition;
    public TextField ipSeats;
    public TextField ipPrice;
    public TextField ipColor;
    public TextField ipStatus;


    public void backToList(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../javaFx/cars/OurCar.fxml"));
        Main.rootStage.setScene(new Scene(root,830,550));
    }
    public void submit(ActionEvent actionEvent){
            String name = ipName.getText();
            String position = ipPosition.getText();
            String status = ipStatus.getText();
            String seats = ipSeats.getText();
            String color = ipColor.getText();
            String price = ipPrice.getText();


            Connector cn = Connector.getInstance();
            try{
                PreparedStatement pp = cn.getConn().prepareStatement("INSERT INTO ourcar(nameCar, status, color,seats,position,Price) VALUES (?,?,?,?,?,?);");
                pp.setString(1,name);
                pp.setString(2,status);
                pp.setString(3,color);
                pp.setInt(4, Integer.parseInt(seats));
                pp.setString(5,position);
                pp.setDouble(6, Double.parseDouble(price));
                pp.executeUpdate();
                backToList(null);
            }catch (Exception e) {
                e.getMessage();
            } finally {
                ipName.setText("");
                ipPosition.setText("");
                ipStatus.setText("");
                 ipSeats.setText("");
                 ipColor.setText("");
               ipPrice.setText("");
            }



    }

    private void showAlert(String message){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(message);
        alert.show();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}