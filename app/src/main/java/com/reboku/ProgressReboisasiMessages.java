package com.reboku;

public class ProgressReboisasiMessages {


    //model class
    String jumlah;
    String tempat;

    public ProgressReboisasiMessages() {
    }
    public ProgressReboisasiMessages(String jumlah, String tempat) {
        this.jumlah = jumlah;
        this.tempat = tempat;
    }

    //constructor
    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }


}