package entity;
import javafx.scene.control.Button;

import java.time.LocalDate;
public class EditCar {

        private String Name;
        private String Position;
        private LocalDate Date;
        private Button Submit;

        public EditCar(String Name, String Position, LocalDate Date ){
            this.Name = Name;
            this.Position = Position;
            this.Date = Date;

            this.Submit = new Button("Submit");

//        this.Submit.setOnAction();
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            this.Name = name;
        }

        public String getPosition() {
            return Position;
        }

        public void setPosition(String position) {
            this.Position = position;
        }

        public LocalDate getDate() {
            return Date;
        }

        public void setDate(LocalDate date) {
            this.Date = date;
        }

        public Button getSubmit() {
            return Submit;
        }

        public void setSubmit(Button submit) {
            this.Submit = submit;
        }
    }


