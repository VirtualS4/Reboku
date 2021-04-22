package com.reboku;

import android.os.Parcel;
import android.os.Parcelable;

public class ProgressReboisasiMessages implements Parcelable{

    private String nama_provinsi;
    private String target_penghijauan,realisasi_penghijauan,realisasi_jumlahpohon, target_reboisasi, realisasi_reboisasi, reboisasi_jumlahpohon;

    public ProgressReboisasiMessages() {

    }

    public ProgressReboisasiMessages(String nama_provinsi, String target_penghijauan, String realisasi_penghijauan, String realisasi_jumlahpohon, String target_reboisasi, String realisasi_reboisasi, String reboisasi_jumlahpohon) {
        this.nama_provinsi = nama_provinsi;
        this.target_penghijauan = target_penghijauan;
        this.realisasi_penghijauan = realisasi_penghijauan;
        this.realisasi_jumlahpohon = realisasi_jumlahpohon;
        this.target_reboisasi = target_reboisasi;
        this.realisasi_reboisasi = realisasi_reboisasi;
        this.reboisasi_jumlahpohon = reboisasi_jumlahpohon;
    }

    public String getNama_provinsi() {
        return nama_provinsi;
    }

    public String getTarget_penghijauan() {
        return target_penghijauan;
    }

    public String getRealisasi_penghijauan() {
        return realisasi_penghijauan;
    }

    public String getRealisasi_jumlahpohon() {
        return realisasi_jumlahpohon;
    }

    public String getTarget_reboisasi() {
        return target_reboisasi;
    }

    public String getRealisasi_reboisasi() {
        return realisasi_reboisasi;
    }

    public String getReboisasi_jumlahpohon() {
        return reboisasi_jumlahpohon;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama_provinsi);
        dest.writeString(this.target_penghijauan);
        dest.writeString(this.realisasi_penghijauan);
        dest.writeString(this.realisasi_jumlahpohon);
        dest.writeString(this.target_reboisasi);
        dest.writeString(this.realisasi_reboisasi);
        dest.writeString(this.reboisasi_jumlahpohon);
    }

    public ProgressReboisasiMessages(Parcel in) {
        this.nama_provinsi = in.readString();
        this.target_penghijauan = in.readString();
        this.realisasi_penghijauan = in.readString();
        this.realisasi_jumlahpohon = in.readString();
        this.target_reboisasi = in.readString();
        this.realisasi_reboisasi = in.readString();
        this.reboisasi_jumlahpohon = in.readString();
    }

    public static final Parcelable.Creator<DataReboisasi> CREATOR = new Parcelable.Creator<DataReboisasi>() {
        @Override
        public DataReboisasi createFromParcel(Parcel source) {
            return new DataReboisasi(source);
        }

        @Override
        public DataReboisasi[] newArray(int size) {
            return new DataReboisasi[size];
        }
    };


}