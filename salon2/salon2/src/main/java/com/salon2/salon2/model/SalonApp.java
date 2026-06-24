package com.salon2.salon2.model;

import java.util.ArrayList;

public class SalonApp {

    private Admin admin;
    private ArrayList<Pelanggan> daftarPelanggan;
    private ArrayList<Booking> daftarBooking;
    private ArrayList<Payment> daftarPayment;
    private Layanan layananHaircut;

    public SalonApp() {
        daftarPelanggan = new ArrayList<>();
        daftarBooking = new ArrayList<>();
        daftarPayment = new ArrayList<>();
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public ArrayList<Pelanggan> getDaftarPelanggan() {
        return daftarPelanggan;
    }

    public void setDaftarPelanggan(ArrayList<Pelanggan> daftarPelanggan) {
        this.daftarPelanggan = daftarPelanggan;
    }

    public ArrayList<Booking> getDaftarBooking() {
        return daftarBooking;
    }

    public void setDaftarBooking(ArrayList<Booking> daftarBooking) {
        this.daftarBooking = daftarBooking;
    }

    public ArrayList<Payment> getDaftarPayment() {
        return daftarPayment;
    }

    public void setDaftarPayment(ArrayList<Payment> daftarPayment) {
        this.daftarPayment = daftarPayment;
    }

    public Layanan getLayananHaircut() {
        return layananHaircut;
    }

    public void setLayananHaircut(Layanan layananHaircut) {
        this.layananHaircut = layananHaircut;
    }
}