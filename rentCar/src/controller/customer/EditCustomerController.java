package controller.customer;

import database.Connector;
import entity.Customer;
import entity.OurCar;
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

public class EditCustomerController implements Initializable {
    public TextField ipFullName;
    public TextArea ipAddress;
    public TextField ipDOB;
    public static Customer editOurCustomer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            ipFullName.setText(editOurCustomer.getFullName());
            ipAddress.setText(editOurCustomer.getAddress());
            ipDOB.setText(String.valueOf(editOurCustomer.getDob()));
        }catch(Exception e){
            e.getMessage();
        }

    }

    public void backToListCustomer(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../javafx/customer/ListCustomer.fxml"));
        Main.rootStage.setScene(new Scene(root, 830, 550));
    }

    public void submit(ActionEvent actionEvent) {
        try{
            Connector cn = Connector.getInstance();
            PreparedStatement pp =cn.getConn().prepareStatement("Update customerlist set fullName = ?,dob= ?,address = ? Where iD = ?");
            pp.setString(1,ipFullName.getText());
            pp.setString(2,ipAddress.getText());
            pp.setString(3,ipDOB.getText());
            pp.execute();
            backToListCustomer(null);
        }catch(Exception e){
            e.getMessage();
        }
    }
}
