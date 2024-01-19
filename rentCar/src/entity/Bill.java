package entity;

public class Bill {
            private String fullName;
            private String dob;
            private String address;
            private String nameCar;
            private Integer Price;
            private Integer days;
            private Integer totalPrice;

            public static Bill bill;

    public Bill(String fullName, String dob, String address, String nameCar, Integer price, Integer days, Integer totalPrice) {
        this.fullName = fullName;
        this.dob = dob;
        this.address = address;
        this.nameCar = nameCar;
        Price = price;
        this.days = days;
        this.totalPrice = totalPrice;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
