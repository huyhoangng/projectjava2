package entity;

import controller.customer.DeleteCustomerController;
import controller.customer.EditCustomerController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import rootStage.Main;
import java.time.LocalDate;
import java.util.Objects;
public class Customer {

        private Integer id;
        private String fullName;
        private LocalDate dob;
        private String address;
       private Button btnEdit;
       private Button btnDelete;
       private Button btnOrder= new Button("Order");

       public static Customer customer;
    public Button getBtnOrder() {
        return btnOrder;
    }


    public void setBtnOrder(Button btnOrder) {
        this.btnOrder = btnOrder;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(Button btnDelete) {
        this.btnDelete = btnDelete;
    }

    public Button getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(Button btnEdit) {
        this.btnEdit = btnEdit;
    }

    public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public LocalDate getDob() {
            return dob;
        }

        public void setDob(LocalDate dob) {
            this.dob = dob;
        }


        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return Objects.equals(id, customer.id) && Objects.equals(fullName, customer.fullName) && Objects.equals(dob, customer.dob) && Objects.equals(address, customer.address);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, fullName, dob, address);
        }


        public Customer(Integer id, String fullName, LocalDate dob, String address) {
            this.id = id;
            this.fullName = fullName;
            this.dob = dob;
            this.address = address;

            this.btnEdit = new Button("Edit");
//            this.btnEdit.setStyle("-fx-background-color: red");
            this.btnEdit.setOnAction(event->{
                try{
                    EditCustomerController.editOurCustomer = this;
                    Parent root = FXMLLoader.load(getClass().getResource("../javaFx/customer/EditCustomer.fxml"));
                    Main.rootStage.setScene(new Scene(root,830,550));
                }catch (Exception e){

                }
            });

            this.btnOrder.setOnAction(event->{
                try{
                    Customer.customer = this;
                    Parent root = FXMLLoader.load(getClass().getResource("../javaFx/orders/AddOrder.fxml"));
                    Stage s = new Stage();
                    s.setScene(new Scene(root,830,550));
                    s.setTitle("Order");
                    s.show();

                }catch (Exception e){
                    e.printStackTrace();
                }
            });

            this.btnDelete = new Button("Delete");
            this.btnDelete.setOnAction(event->{
                try{
                    DeleteCustomerController.deleteCustomer = this;
                    Parent root = FXMLLoader.load(getClass().getResource("../javaFx/customer/DeleteCustomer.fxml"));
                    Stage s = new Stage();
                    s.setScene(new Scene(root,400,200));
                    s.setTitle("DELETE");
                    s.show();
                }catch (Exception e){

                }
            });
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "id=" + id +
                    ", fullName='" + fullName + '\'' +
                    ", dob=" + dob + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

