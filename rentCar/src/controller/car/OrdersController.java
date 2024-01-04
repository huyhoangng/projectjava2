package controller.car;

import database.Connector;
import entity.Orders;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import rootStage.Main;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class OrdersController implements Initializable {

    public TableView<Orders> tbView;
    public TableColumn<Orders,String> tcFullName;
    public TableColumn<Orders, LocalDate> tcDOB;
    public TableColumn<Orders, String> tcAddress;
    public TableColumn<Orders, String> tcCar;
    public TableColumn<Orders, Integer> tcDays;
    public TableColumn <Orders, Integer> tcPrice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcFullName.setCellValueFactory(new PropertyValueFactory<Orders,String>("FullName"));
        tcDOB.setCellValueFactory(new PropertyValueFactory<Orders,LocalDate>("DOB"));
        tcAddress.setCellValueFactory(new PropertyValueFactory<Orders,String>("Address"));
        tcCar.setCellValueFactory(new PropertyValueFactory<Orders,String>("Car"));
        tcDays.setCellValueFactory(new PropertyValueFactory<Orders, Integer>("Days"));
        tcPrice.setCellValueFactory(new PropertyValueFactory<Orders, Integer>("Price"));

        ObservableList<Orders> ls = FXCollections.observableArrayList();
        try {
            Connector cn = Connector.getInstance();
            ResultSet rs = cn.getConn().createStatement().executeQuery("select c.FullName,c.DOB,c.Address,oc.nameCar,c.Days,SUM(oc.Price * c.Days) as Price from customerlist as c Join ourcar as oc ON c.iDCar = oc.iDCar GROUP By c.FullName,c.DOB,c.Address,oc.nameCar,c.Days,oc.Price;");
            System.out.println(rs);
            while (rs.next()){
                ls.add(new Orders(rs.getString("FullName"),LocalDate.parse(rs.getString("DOB")),
                        rs.getString("Address"),rs.getString("nameCar"),rs.getInt("Days"),rs.getInt("Price")));
            }
//            PreparedStatement pp = cn.getConn().prepareStatement("insert uỏcar (fullName,...) value (?,?,?...)");
//            pp.setString(1,fullNameFxid.getTe)
        }catch (Exception e) {
            e.getMessage();
        }finally {
            tbView.setItems(ls);
        }
    }

    public void backtoOrders(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../javaFx/cars/Orders.fxml"));
        Main.rootStage.setScene(new Scene(root,830,550));
    }
}
