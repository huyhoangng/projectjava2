package controller.customer;


import com.sun.applet2.preloader.event.ConfigEvent;
import database.Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import rootStage.Main;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ResourceBundle;
public class AddCustomerController  {
        public TextField ipFullName;
        public DatePicker ipDob;
        public TextArea ipAddress;

        public void backToList(ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("../../javafx/customer/ListCustomer.fxml"));
            Main.rootStage.setScene(new Scene(root, 800, 600));
        }

        public void submit(ActionEvent actionEvent) {
            try {
                String fullName = ipFullName.getText();
                LocalDate dob = ipDob.getValue();
                String address = ipAddress.getText();


                Connector cn = Connector.getInstance();
                    PreparedStatement pp = cn.getConn().prepareStatement("INSERT INTO customerList(fullName, dob, address) VALUES (?,?,?);");
                    pp.setString(1,fullName);
                    pp.setDate(2, Date.valueOf(dob));
                    pp.setString(3,address);

                    pp.executeUpdate();

                backToList(null);
            }catch (Exception e){
                e.getMessage();
            }finally {
                ipFullName.setText("");
                ipDob.setValue(LocalDate.parse(""));
                ipAddress.setText("");
            }



        }
        private void showAlert(String message){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(message);
            alert.show();
        }
    }


