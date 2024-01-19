package controller.customer;

import database.Connector;
import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import rootStage.Main;
import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;
public class ListCustomerController implements Initializable {


        @FXML
        public TableView<Customer> tbView;
        @FXML
        public TableColumn<Customer, String> tcID;
        @FXML
        public TableColumn<Customer, String> tcName;
        @FXML
        public TableColumn<Customer, LocalDate> tcDOB;
        @FXML
        public TableColumn<Customer, String> tcAddress;
        public TableColumn<Customer, Button> tcEdit;
        public TableColumn<Customer, Button> tcDelete;
    public TableColumn<Customer,Button> tcOrder;


//    private List<Customer> FetchCustomerFromDatabase() throws SQLException, ClassNotFoundException {
//            List<Customer> customerList = new ArrayList<Customer>();
//            Connector connector = Connector.getInstance();
//            Connection connection = connector.getConn();
//            Statement st = connection.createStatement();
//            ResultSet rs = st.executeQuery("select * from customerlist");
//            while (rs.next()) {
//                // Get each field fromt the result set
//                Integer id = rs.getInt(1);
//                String fullname = rs.getString(2);
//                LocalDate DOB = rs.getDate(3).toLocalDate();
//                String address = rs.getString(4);
//
//                // Create new customer
//                Customer customer = new Customer(id, fullname, DOB, address);
//                customerList.add(customer);
//            }
//            return customerList;
//        }


        @Override
        public void initialize(URL location, ResourceBundle resources) {
            tcID.setCellValueFactory(new PropertyValueFactory<Customer, String>("id"));
            tcName.setCellValueFactory(new PropertyValueFactory<Customer, String>("fullName"));
            tcDOB.setCellValueFactory(new PropertyValueFactory<Customer,LocalDate>("dob"));
            tcAddress.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
            tcEdit.setCellValueFactory(new PropertyValueFactory<Customer,Button>("btnEdit"));
            tcDelete.setCellValueFactory(new PropertyValueFactory<Customer,Button>("btnDelete"));
            tcOrder.setCellValueFactory(new PropertyValueFactory<Customer,Button>("btnOrder"));

            ObservableList<Customer> ls = FXCollections.observableArrayList();
            try {
                Connector cn = Connector.getInstance();
                ResultSet rs = cn.getConn().createStatement().executeQuery("SELECT * FROM customerlist");
                while (rs.next()) {
                    ls.add(new Customer(
                            rs.getInt("ID"),rs.getString("fullName"), rs.getDate("dob").toLocalDate(),rs.getString("address")
                    ));
                }

            }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(e.getMessage());
                alert.show();
            }finally {
                tbView.setItems(ls);
            }


        }

        public void closeCustomerForm(ActionEvent actionEvent) {
            Stage parentStage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            parentStage.close();
        }

    public void backtoHomePage(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../javafx/HomePage.fxml"));
        Main.rootStage.setScene(new Scene(root, 830, 550));
    }

    public void gotoAddCustomer(ActionEvent actionEvent) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../../javafx/customer/AddCustomer.fxml"));
        Main.rootStage.setScene(new Scene(root, 830, 550));
    }
}


