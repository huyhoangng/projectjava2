package controller.orders;

import database.Connector;
import entity.Bill;
import entity.Customer;
import entity.Orders;
import entity.OurCar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.util.StringConverter;
import rootStage.Main;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class AddOrderController implements Initializable {



    public static Orders addOrder;
    public TextField ipDOB;
    public TextField ipFullName;
    public TextArea ipAddress;
    public TextField ipDays;
    public ComboBox<OurCar> ipNameCar;
    public TextField ipIDCar;




    public void submit(ActionEvent actionEvent) throws Exception {
        Connector cn = Connector.getInstance();
        try {
            // Lấy thông tin tên xe và khách hàng

            String customerFullName = Customer.customer.getFullName();
            String customerDob = Customer.customer.getDob().toString();
            String customerAddress = Customer.customer.getAddress();
            OurCar selectedCar = ipNameCar.getSelectionModel().getSelectedItem();
            Integer days = Integer.valueOf(ipDays.getText());
            Integer carId = selectedCar.getIdCar();
            Integer customerId = Customer.customer.getId();


            // Chuyển sang màn hình bill với thông tin tên xe và khách hàng
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../javaFx/orders/bill.fxml"));
            Parent root = loader.load();
            BillController billController = loader.getController();
            billController.setOrderAndCustomerInfo(customerFullName, customerDob, customerAddress,selectedCar.getNameCar(),selectedCar.getPrice(),days,carId,customerId);

            Main.rootStage.setScene(new Scene(root, 830, 600));

            // Lưu đơn đặt hàng vào cơ sở dữ liệu sau khi chuyển scene
            PreparedStatement pp = cn.getConn().prepareStatement("INSERT INTO orders (customerID, carID, days) VALUES (?, ? , ?)");
            pp.setInt(1, Customer.customer.getId());
            pp.setInt(2, selectedCar.getIdCar());
            pp.setInt(3, Integer.parseInt(ipDays.getText()));
            pp.executeUpdate();

            // Sau khi đã chuyển scene và lưu vào cơ sở dữ liệu, bạn có thể thực hiện các thao tác khác tại đây nếu cần

            // Ví dụ: quay lại màn hình danh sách đơn đặt hàng
//            backToListOrder(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        private void showAlert(String message){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(message);
            alert.show();

        }


        @Override
        public void initialize(URL location, ResourceBundle resources) {
            ObservableList<OurCar> ob = FXCollections.observableArrayList();
            try {
                Connector cn = Connector.getInstance();
                ResultSet rs = cn.getConn().createStatement().executeQuery("select * from ourcar");
                while (rs.next()) {
                    ob.add(new OurCar(rs.getInt("iDCar"), rs.getString("nameCar"), rs.getString("status"),
                            rs.getString("color"), rs.getString("seats"), rs.getString("position"), rs.getInt("Price")));
                }

                ipNameCar.setItems(ob);
                ipNameCar.setConverter(new StringConverter<OurCar>() {
                    @Override
                    public String toString(OurCar object) {
                        return object == null ? null : object.getNameCar();
                    }

                    @Override
                    public OurCar fromString(String string) {
                        // You can implement this if needed, but for displaying purposes, you can leave it as is.
                        return null;
                    }
                });
                ipAddress.setText(Customer.customer.getAddress());
                ipDOB.setText(Customer.customer.getDob().toString());
//                ipDays.setText(String.valueOf(addOrder.getDays()));
                ipFullName.setText(Customer.customer.getFullName());






            } catch (Exception e) {
                e.getMessage();
            }
        }


        public int getIdCar (String idCar) {
            return Integer.parseInt(idCar);
        }



        public void backToListOrder(ActionEvent actionEvent) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("../../javaFx/customer/ListCustomer.fxml"));
            Main.rootStage.setScene(new Scene(root,830,600));
        }

}
