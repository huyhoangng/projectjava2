package entity;

import java.time.LocalDate;

public class Orders {
    private String FullName;
    private LocalDate DOB;
    private String Address;
    private Integer IDCar;
    private String NameCar;
    private Integer Days;
    private Integer Price;

    public Orders(String fullName, LocalDate DOB, String address,Integer idCar, String nameCar, Integer days, Integer price) {
        FullName = fullName;
        this.DOB = DOB;
        Address = address;
        IDCar= idCar;
        NameCar = nameCar;
        Days = days;
        Price = price;
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
        Price = price;
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

    public Integer getPrice() {
        return Price;
    }
}
