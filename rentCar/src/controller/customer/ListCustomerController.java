package controller.customer;

import database.Connector;
import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
public class ListCustomerController implements Initializable {

        @FXML
        private AnchorPane homePage;

        @FXML
        private Hyperlink customerInfoHyperlink;

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


        private List<Customer> FetchCustomerFromDatabase() throws SQLException, ClassNotFoundException {
            List<Customer> customerList = new ArrayList<Customer>();
            Connector connector = Connector.getInstance();
            Connection connection = connector.getConn();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from customerlist");
            while (rs.next()) {
                // Get each field fromt the result set
                Integer id = rs.getInt(1);
                String fullname = rs.getString(2);
                LocalDate DOB = rs.getDate(3).toLocalDate();
                String address = rs.getString(4);

                // Create new customer
                Customer customer = new Customer(id, fullname, DOB, address);
                customerList.add(customer);
            }
            return customerList;
        }


        @Override
        public void initialize(URL location, ResourceBundle resources) {
            tcID.setCellValueFactory(new PropertyValueFactory<Customer, String>("id"));
            tcName.setCellValueFactory(new PropertyValueFactory<Customer, String>("fullName"));
            tcDOB.setCellValueFactory(new PropertyValueFactory<Customer, LocalDate>("dob"));
            tcAddress.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));


            List<Customer> listCustomer = null;
            try {
                listCustomer = FetchCustomerFromDatabase();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            ObservableList<Customer> data = FXCollections.observableArrayList(listCustomer);
            tbView.setItems(data);
//        customerInfoHyperlink.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                // Display the customer table when the hyperlink is clicked
//                ShowCustomer();
//            }
//
//            private void ShowCustomer() {
//            }
//        });
        }

        public void closeCustomerForm(ActionEvent actionEvent) {
            Stage parentStage = (Stage) ((javafx.scene.Node) actionEvent.getSource()).getScene().getWindow();
            parentStage.close();
        }
    }


