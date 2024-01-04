package entity;
import java.time.LocalDate;
import java.util.Objects;
public class Customer {

        private Integer id;
        private String fullName;
        private LocalDate dob;
        private String address;


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

