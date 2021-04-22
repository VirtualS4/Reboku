package com.reboku;

import android.os.Parcelable;
import android.os.Parcel;

public class DataReboisasi implements Parcelable {
    private String nama_provinsi;
    private int target_penghijauan,realisasi_penghijauan,realisasi_jumlahpohon, target_reboisasi, realisasi_reboisasi, reboisasi_jumlahpohon;

    public DataReboisasi() {

    }

    public DataReboisasi(String nama_provinsi, int target_penghijauan, int realisasi_penghijauan, int realisasi_jumlahpohon, int target_reboisasi, int realisasi_reboisasi, int reboisasi_jumlahpohon) {
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

    public int getTarget_penghijauan() {
        return target_penghijauan;
    }

    public int getRealisasi_penghijauan() {
        return realisasi_penghijauan;
    }

    public int getRealisasi_jumlahpohon() {
        return realisasi_jumlahpohon;
    }

    public int getTarget_reboisasi() {
        return target_reboisasi;
    }

    public int getRealisasi_reboisasi() {
        return realisasi_reboisasi;
    }

    public int getReboisasi_jumlahpohon() {
        return reboisasi_jumlahpohon;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama_provinsi);
        dest.writeInt(this.target_penghijauan);
        dest.writeInt(this.realisasi_penghijauan);
        dest.writeInt(this.realisasi_jumlahpohon);
        dest.writeInt(this.target_reboisasi);
        dest.writeInt(this.realisasi_reboisasi);
        dest.writeInt(this.reboisasi_jumlahpohon);
    }

    public DataReboisasi(Parcel in) {
        this.nama_provinsi = in.readString();
        this.target_penghijauan = in.readInt();
        this.realisasi_penghijauan = in.readInt();
        this.realisasi_jumlahpohon = in.readInt();
        this.target_reboisasi = in.readInt();
        this.realisasi_reboisasi = in.readInt();
        this.reboisasi_jumlahpohon = in.readInt();
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
