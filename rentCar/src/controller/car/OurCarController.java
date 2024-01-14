package controller.car;

import database.Connector;
import entity.OurCar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rootStage.Main;


import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
public class OurCarController implements Initializable {

        public TableView<OurCar> tbView;
        public TableColumn<OurCar,String> tcNameCar;
        public TableColumn<OurCar,String> tcStatus;
        public TableColumn<OurCar,String> tcColor;
        public TableColumn<OurCar,String> tcPosition;
        public TableColumn<OurCar,String> tcSeats;
        public TableColumn<OurCar, Integer> tcPrice;
        public TableColumn<OurCar, Integer> tcIDCar;



        public TableColumn<OurCar,Button> tcEdit;
        public TableColumn<OurCar,Button> tcDelete;

    @Override
        public void initialize(URL url, ResourceBundle resourceBundle){
            tcIDCar.setCellValueFactory(new PropertyValueFactory<OurCar,Integer>("idCar"));
            tcNameCar.setCellValueFactory(new PropertyValueFactory<OurCar,String>("nameCar"));
            tcStatus.setCellValueFactory(new PropertyValueFactory<OurCar,String>("status"));
            tcColor.setCellValueFactory(new PropertyValueFactory<OurCar,String>("color"));
            tcPosition.setCellValueFactory(new PropertyValueFactory<OurCar,String>("position"));
            tcSeats.setCellValueFactory(new PropertyValueFactory<OurCar, String>("seats"));
            tcPrice.setCellValueFactory(new PropertyValueFactory<OurCar,Integer>("price"));
            tcEdit.setCellValueFactory(new PropertyValueFactory<OurCar,Button>("btnEdit"));
            tcDelete.setCellValueFactory(new PropertyValueFactory<OurCar,Button>("btnDelete"));

            ObservableList<OurCar> ls = FXCollections.observableArrayList();
             try {
                Connector cn = Connector.getInstance();
                ResultSet rs = cn.getConn().createStatement().executeQuery("SELECT * FROM ourcar");
                while (rs.next()) {

                    ls.add(new OurCar(
                        rs.getInt("iDCar"),rs.getString("nameCar"),rs.getString("status"),
                            rs.getString("color"),rs.getString("seats"),rs.getString("position"),
                            rs.getInt("Price")
                    ));
                }
//

            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(e.getMessage());
                alert.show();
            }finally {
                tbView.setItems(ls);
            }
        }
        public void goToCreate(ActionEvent actionEvent) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("../../javaFx/HomePage.fxml"));
            Main.rootStage.setScene(new Scene(root,830,600));
        }


    public void goToEditCar(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../javaFx/cars/EditCar.fxml"));
        Main.rootStage.setScene(new Scene(root,830,600));

    }

    public void addOurCar(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../javaFx/cars/AddOurCar.fxml"));
        Main.rootStage.setScene(new Scene(root,830,600));
    }
}

