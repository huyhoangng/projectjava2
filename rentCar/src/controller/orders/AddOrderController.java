package controller.orders;

import database.Connector;
import entity.Orders;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import rootStage.Main;

import java.net.URL;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class AddOrderController implements Initializable {



        public static Orders addOrder;
    public TextField ipDOB;
    public TextField ipFullName;
    public TextArea ipAddress;
    public TextField ipIDCar;
    public TextField ipDays;
    public TextField ipNameCar;

        public void submit(ActionEvent actionEvent){
            String fullName= ipFullName.getText();
            String namecar = ipNameCar.getText();
            String dob = String.valueOf(ipDOB.getText());
            String address = ipAddress.getText();
            String idCar = ipIDCar.getText();
            String days = ipDays.getText();



            Connector cn = Connector.getInstance();
            try{
                PreparedStatement pp = cn.getConn().prepareStatement("INSERT INTO ourcar(nameCar, status, color,seats,position,Price) VALUES (?,?,?,?,?,?);");
                pp.setString(1,fullName);
                pp.setString(2,namecar);
                pp.setString(3, String.valueOf(dob));
                pp.setString(4,address);
                pp.setString(5,idCar);
                pp.setString(6,days);
                pp.executeUpdate();
                backToListOrder(null);
            }catch (Exception e) {
                e.getMessage();
            } finally {
                ipFullName.setText("");
                ipNameCar.setText("");
                ipDOB.setText("");
                ipAddress.setText("");
                ipIDCar.setText("");
                ipDays.setText("");
                ipNameCar.setText("");
            }
        }

        private void showAlert(String message){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(message);
            alert.show();

        }


        @Override
        public void initialize(URL location, ResourceBundle resources) {
            try{
                ipNameCar.setText(addOrder.getNameCar());
                ipIDCar.setText(String.valueOf(addOrder.getIDCar()));
                ipAddress.setText(addOrder.getAddress());
                ipDOB.setText(String.valueOf(addOrder.getDOB()));
                ipDays.setText(String.valueOf(addOrder.getDays()));
                ipFullName.setText(addOrder.getFullName());


            }catch(Exception e){
                e.getMessage();
            }
        }

        public void backToListOrder(ActionEvent actionEvent) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("../../javaFx/orders/Orders.fxml"));
            Main.rootStage.setScene(new Scene(root,830,600));
        }

}
