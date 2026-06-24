package com.salon2.salon2.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBooking;

    private String tanggalBooking;

    private String jamBooking;

    private Integer jumlahBooking;

    private String statusBooking;

    private String jenisHaircut;

    @ManyToOne
    @JoinColumn(name = "id_pelanggan")
    private Pelanggan pelanggan;

    @ManyToOne
    @JoinColumn(name = "id_layanan")
    private Layanan layanan;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;

    // GETTER & SETTER

    public Integer getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Integer idBooking) {
        this.idBooking = idBooking;
    }

    public String getTanggalBooking() {
        return tanggalBooking;
    }

    public void setTanggalBooking(String tanggalBooking) {
        this.tanggalBooking = tanggalBooking;
    }

    public String getJamBooking() {
        return jamBooking;
    }

    public void setJamBooking(String jamBooking) {
        this.jamBooking = jamBooking;
    }

    public Integer getJumlahBooking() {
        return jumlahBooking;
    }

    public void setJumlahBooking(Integer jumlahBooking) {
        this.jumlahBooking = jumlahBooking;
    }

    public String getStatusBooking() {
        return statusBooking;
    }

    public void setStatusBooking(String statusBooking) {
        this.statusBooking = statusBooking;
    }

    public String getJenisHaircut() {
        return jenisHaircut;
    }

    public void setJenisHaircut(String jenisHaircut) {
        this.jenisHaircut = jenisHaircut;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Layanan getLayanan() {
        return layanan;
    }

    public void setLayanan(Layanan layanan) {
        this.layanan = layanan;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}