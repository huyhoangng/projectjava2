package controller.car;

import database.Connector;
import entity.OurCar;
import javafx.beans.value.ObservableDoubleValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import rootStage.Main;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class EditCarController implements Initializable {

    public TextField ipNameCar;
    public TextArea ipPosition;
    public TextField ipSeats;
    public TextField ipPrice;
    public TextField ipColor;
    public TextField ipStatus;

    public static OurCar editOurCar;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            ipNameCar.setText(editOurCar.getNameCar());
            ipPosition.setText(editOurCar.getPosition());
            ipSeats.setText(editOurCar.getSeats());
            ipPrice.setText(String.valueOf(editOurCar.getPrice()));
            ipColor.setText(editOurCar.getColor());
            ipStatus.setText(editOurCar.getStatus());

        }catch(Exception e){
            e.getMessage();
        }
    }

    public void backToListCar(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../javaFx/cars/OurCar.fxml"));
        Main.rootStage.setScene(new Scene(root,830,550));
    }

    public void submit(ActionEvent actionEvent) {
        try{
            Connector cn = Connector.getInstance();
            PreparedStatement pp =cn.getConn().prepareStatement("Update ourcar set nameCar = ?,status= ?,color = ?, seats = ? , position = ?, Price= ? Where iDCar = ?");
            pp.setString(1,ipNameCar.getText());
            pp.setString(2,ipStatus.getText());
            pp.setString(3,ipColor.getText());
            pp.setString(4,ipSeats.getText());
            pp.setString(5,ipPosition.getText());
            pp.setString(6,ipPrice.getText());
            pp.setInt(7,editOurCar.getIdCar());
            pp.execute();
            backToListCar(null);
        }catch(Exception e){
            e.getMessage();
        }
    }
}
