package by.htp.demo.persist;

import javax.persistence.*;

@Entity
@Table(name = "workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45)
    private String surname;

    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String lastname;

    @Column(length = 45)
    private String address;
    @Column(length = 45)
    private String payment;
    @Column(length = 45)
    private String paymentdata;
    @Column(length = 45)
    private String price;
    @Column(length = 45)
    private String quantity;
    @Column(length = 45)
    private String sum;

    public Worker() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getPaymentdata() {
        return paymentdata;
    }

    public void setPaymentdata(String paymentdata) {
        this.paymentdata = paymentdata;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }
}
