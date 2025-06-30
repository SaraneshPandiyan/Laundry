package com.example.demo.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Entity
@Table(name = "laundry")
public class Laundry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(name = "mail_id")
    private String mailId;

    @Column(name = "address")
    private String address;

    @Column(name = "package")
    private String servicePackage;

    @Column(name = "pickup_date")
    private LocalDate pickupDate;

    @Column(name = "pickup_time")
    private LocalTime pickupTime;

    public Laundry() {
    }

    public Laundry(String name, String mobileNo, String mailId, String address,
                   String servicePackage, LocalDate pickupDate, LocalTime pickupTime) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.mailId = mailId;
        this.address = address;
        this.servicePackage = servicePackage;
        this.pickupDate = pickupDate;
        this.pickupTime = pickupTime;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getMailId() {
        return mailId;
    }

    public String getAddress() {
        return address;
    }

    public String getServicePackage() {
        return servicePackage;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public LocalTime getPickupTime() {
        return pickupTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setServicePackage(String servicePackage) {
        this.servicePackage = servicePackage;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public void setPickupTime(LocalTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public static Optional<Laundry> findById(int id2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
}
