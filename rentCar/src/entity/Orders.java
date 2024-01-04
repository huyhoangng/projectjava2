package entity;

import java.time.LocalDate;

public class Orders {
    private String FullName;
    private LocalDate DOB;
    private String Address;
    private String Car;
    private Integer Days;
    private Integer Price;

    public Orders(String fullName, LocalDate DOB, String address, String car, Integer days, Integer price) {
        FullName = fullName;
        this.DOB = DOB;
        Address = address;
        Car = car;
        Days = days;
        Price = price;
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

    public void setCar(String car) {
        Car = car;
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

    public String getCar() {
        return Car;
    }

    public Integer getDays() {
        return Days;
    }

    public Integer getPrice() {
        return Price;
    }
}
