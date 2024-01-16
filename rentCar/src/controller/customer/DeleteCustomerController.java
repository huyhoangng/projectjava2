package controller.customer;

import database.Connector;
import entity.Customer;
import entity.OurCar;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import rootStage.Main;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class DeleteCustomerController implements Initializable {

    public Button btnYes;
    public Button btnNo;
    public Text txtN;

    public static Customer deleteCustomer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnYes.setOnAction(event -> handleDelete());
        btnNo.setOnAction(event -> {
            try{
                backToListCustomer();
            }catch (Exception e){
                e.getMessage();
            }

        });
        txtN.setText(deleteCustomer.getFullName());
    }
    public void backToListCustomer() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../javaFx/customer/ListCustomer.fxml"));
        Main.rootStage.setScene(new Scene(root,830,600));
    }
    public void handleDelete() {
        try{
            Connector cn = Connector.getInstance();
            PreparedStatement pp = cn.getConn().prepareStatement("Delete from ourcar where iDCar = ?");
            pp.setInt(1,deleteCustomer.getId());
            pp.execute();
            backToListCustomer();
        }catch (Exception e) {

        }
    }
}
