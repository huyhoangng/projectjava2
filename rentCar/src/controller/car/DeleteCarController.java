package controller.car;

import database.Connector;
import entity.OurCar;
import javafx.event.ActionEvent;
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

public class DeleteCarController implements Initializable {

    public Button btnYes;
    public Button btnNo;
    public Text txtN;

    public static OurCar deleteOurCar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnYes.setOnAction(event -> handleDelete());
        btnNo.setOnAction(event -> {
            try{
                backToListCar();
            }catch (Exception e){
                e.getMessage();
            }

        });
        txtN.setText(deleteOurCar.getNameCar());
    }
    public void backToListCar() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../javaFx/cars/OurCar.fxml"));
        Main.rootStage.setScene(new Scene(root,830,600));
    }
    public void handleDelete() {
        try{
            Connector cn = Connector.getInstance();
            PreparedStatement pp = cn.getConn().prepareStatement("Delete from ourcar where iDCar = ?");
            pp.setInt(1,deleteOurCar.getIdCar());
            pp.execute();
            backToListCar();
        }catch (Exception e) {

        }
    }
}
