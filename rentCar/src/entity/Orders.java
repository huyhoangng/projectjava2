package entity;

import controller.customer.DeleteCustomerController;
import controller.customer.EditCustomerController;
import controller.orders.DeleteOrderController;
import controller.orders.EditOrderController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import rootStage.Main;

import java.time.LocalDate;

public class Orders {
    private String FullName;
    private LocalDate DOB;
    private String Address;
    private Integer IDCar;
    private String NameCar;
    private Integer Days;
    private Integer TotalPrice;
    private Button btnEdit;
    private Button btnDelete;
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

    public Orders(String fullName, LocalDate DOB, String address,Integer idCar, String nameCar, Integer days, Integer price) {
        FullName = fullName;
        this.DOB = DOB;
        Address = address;
        IDCar= idCar;
        NameCar = nameCar;
        Days = days;
        TotalPrice = price;
        this.btnEdit = new Button("Edit");
//            this.btnEdit.setStyle("-fx-background-color: red");
        this.btnEdit.setOnAction(event->{
            try{
                EditOrderController.editOrder = this;
                Parent root = FXMLLoader.load(getClass().getResource("../javaFx/orders/EditOrder.fxml"));
                Main.rootStage.setScene(new Scene(root,830,550));
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        this.btnDelete = new Button("Delete");
        this.btnDelete.setOnAction(event->{
            try{
                DeleteOrderController.deleteOrder = this;
                Parent root = FXMLLoader.load(getClass().getResource("../javaFx/customer/DeleteOrder.fxml"));
                Stage s = new Stage();
                s.setScene(new Scene(root,400,200));
                s.setTitle("DELETE");
                s.show();
            }catch (Exception e){
                e.printStackTrace();

            }
        });
    }

    public void setNameCar(String nameCar) {
        NameCar = nameCar;
    }

    public String getNameCar() {
        return NameCar;
    }

    public Integer getIDCar() {
        return IDCar;
    }

    public void setIDCar(Integer IDCar) {
        this.IDCar = IDCar;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }
    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public void setDays(Integer days) {
        Days = days;
    }
    public void setPrice(Integer price) {
        TotalPrice = price;
    }
    public String getFullName() {
        return FullName;
    }
    public LocalDate getDOB() {
        return DOB;
    }
    public String getAddress() {
        return Address;
    }
    public Integer getDays() {
        return Days;
    }
    public Integer getTotalPrice() {
        return TotalPrice;
    }


}
