package controller.orders;

import database.Connector;
import entity.Orders;
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
import java.util.ResourceBundle;

public class EditOrderController implements Initializable {

    public static Orders editOrder;
    public TextField ipNameCar;
    public TextArea ipFullName;
    public TextField ipDOB;
    public TextField ipAddress;
    public TextField ipDays;
    public TextField ipIDCar;
    public TextField ipTotalPrice;


    public void backToListOrder(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../javaFx/orders/Orders.fxml"));
        Main.rootStage.setScene(new Scene(root,830,550));
    }

    public void submit(ActionEvent actionEvent) {
        try{
            Connector cn = Connector.getInstance();
            PreparedStatement pp =cn.getConn().prepareStatement("Update orders set nameCar = ?,status= ?,color = ?, seats = ? , position = ?, Price= ? Where iDCar = ?");
            pp.setString(1,ipFullName.getText());
            pp.setString(2,ipDOB.getText());
            pp.setString(3,ipAddress.getText());
            pp.setString(4,ipNameCar.getText());
            pp.setString(5,ipDays.getText());
            pp.setString(6,ipTotalPrice.getText());
            pp.setString(6,ipIDCar.getText());
            pp.setInt(7,editOrder.getIDCar());
            pp.execute();
            backToListOrder(null);
        }catch(Exception e){
            e.getMessage();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try{
            ipNameCar.setText(editOrder.getNameCar());
            ipFullName.setText(editOrder.getFullName());
            ipDOB.setText(String.valueOf(editOrder.getDOB()));
            ipAddress.setText(editOrder.getAddress());
            ipDays.setText(String.valueOf(editOrder.getDays()));
            ipIDCar.setText(String.valueOf(editOrder.getIDCar()));
            ipTotalPrice.setText(String.valueOf(editOrder.getTotalPrice()));
        }catch(Exception e){
            e.getMessage();
        }
    }
}
