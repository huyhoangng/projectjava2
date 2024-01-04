package entity;


import controller.car.DeleteCarController;
import controller.car.EditCarController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import rootStage.Main;


public class OurCar {

        private Integer idCar;
        private String nameCar;
        private String status;
        private String color;

        private String seats;
        private String position;
        private Integer price;
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

    public OurCar(Integer idCar, String nameCar, String status, String color, String seats, String position, Integer price) {
            this.idCar = idCar;
            this.nameCar = nameCar;
            this.status = status;
            this.color = color;
            this.seats = seats;
            this.position = position;
            this.price = price;


            this.btnEdit = new Button("Edit");
//            this.btnEdit.setStyle("-fx-background-color: red");
            this.btnEdit.setOnAction(event->{
                try{
                    EditCarController.editOurCar = this;
                    Parent root = FXMLLoader.load(getClass().getResource("../javaFx/cars/EditCar.fxml"));
                    Main.rootStage.setScene(new Scene(root,830,550));
                }catch (Exception e){

                }
            });

            this.btnDelete = new Button("Delete");
            this.btnDelete.setOnAction(event->{
                try{
                    DeleteCarController.deleteOurCar = this;
                    Parent root = FXMLLoader.load(getClass().getResource("../javaFx/cars/DeleteCar.fxml"));
                    Stage s = new Stage();
                    s.setScene(new Scene(root,400,200));
                    s.setTitle("DELETE");
                    s.show();
                }catch (Exception e){

                }
            });
        }

        public Integer getIdCar() {
            return idCar;
        }

        public String getNameCar() {
            return nameCar;
        }

        public void setIdCar(Integer idCar) {
            this.idCar = idCar;
        }

        public void setNameCar(String nameCar) {
            this.nameCar = nameCar;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getColor() {
            return color;
        }

        public void setSeats(String seats) {
            this.seats = seats;
        }

        public String getSeats() {
            return seats;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getPosition() {
            return position;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getPrice() {
            return price;
        }

        public String toString(){
            return nameCar+"\n"+status+"\n"+color+"\n"+position
                    +"\n"+price;
        }


    }


