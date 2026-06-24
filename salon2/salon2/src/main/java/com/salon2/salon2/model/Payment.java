package com.salon2.salon2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPayment;

    private String metodePayment;

    private String tanggalPayment;

    private Double jumlahBayar;

    private String statusPayment;

    @OneToOne
    @JoinColumn(name = "id_booking")
    private Booking booking;

    // GETTER & SETTER

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public String getMetodePayment() {
        return metodePayment;
    }

    public void setMetodePayment(String metodePayment) {
        this.metodePayment = metodePayment;
    }

    public String getTanggalPayment() {
        return tanggalPayment;
    }

    public void setTanggalPayment(String tanggalPayment) {
        this.tanggalPayment = tanggalPayment;
    }

    public Double getJumlahBayar() {
        return jumlahBayar;
    }

    public void setJumlahBayar(Double jumlahBayar) {
        this.jumlahBayar = jumlahBayar;
    }

    public String getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(String statusPayment) {
        this.statusPayment = statusPayment;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}