package com.example.revisionmobileexam.Data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ParcelData implements Parcelable {

    private String val1;

    private int val2;

    public ParcelData() {
    }

    public ParcelData(String val1, int val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    protected ParcelData(Parcel in) {
        val1 = in.readString();
        val2 = in.readInt();
    }

    public static final Creator<ParcelData> CREATOR = new Creator<ParcelData>() {
        @Override
        public ParcelData createFromParcel(Parcel in) {
            return new ParcelData(in);
        }

        @Override
        public ParcelData[] newArray(int size) {
            return new ParcelData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(val1);
        dest.writeInt(val2);
    }

    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        this.val1 = val1;
    }

    public int getVal2() {
        return val2;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }

    @Override
    public String toString() {
        return "ParcelData{" +
                "val1='" + val1 + '\'' +
                ", val2=" + val2 +
                '}';
    }
}
