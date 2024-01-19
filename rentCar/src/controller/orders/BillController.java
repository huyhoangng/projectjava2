package controller.orders;

import database.Connector;
import entity.Bill;
import entity.OurCar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

import java.net.InterfaceAddress;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class BillController implements Initializable {
    public Text billName;
    public Text billDob;
    public Text billAddress;
    public Text billNameCar;
    public Text billTotalPrice;
    public Text billPrice;
    public Text billDays;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setOrderAndCustomerInfo(String fullName, String dob, String address, String nameCar, Integer price, Integer days, Integer carId, Integer customerId) {
        Integer totalPrice = price * days;
        System.out.println(carId);
        System.out.println(customerId);
        billName.setText(fullName);
        billDob.setText(dob);
        billAddress.setText(address);
        billNameCar.setText(nameCar);
        billPrice.setText(String.valueOf(price));
        billDays.setText(String.valueOf(days));
        billTotalPrice.setText(String.valueOf(totalPrice));

        try {
            Connector cn = Connector.getInstance();
            PreparedStatement pn = cn.getConn().prepareStatement("UPDATE orders SET totalPrice = ? WHERE carID = ? AND customerID = ?");
            pn.setInt(1, totalPrice);
            pn.setInt(2, carId);
            pn.setInt(3, customerId);
            pn.executeUpdate();  // Use executeUpdate instead of execute for UPDATE statement
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
