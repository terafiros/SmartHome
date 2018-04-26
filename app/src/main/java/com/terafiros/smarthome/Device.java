package com.terafiros.smarthome;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Eduardo Oliveira on 26/04/2018.
 */

public class Device implements Parcelable{

    private boolean state;
    private String name;
    private String serialNumber;


    public Device(String serialNumber, String name) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.state = false;
    }

    protected Device(Parcel in) {
        state = in.readByte() != 0;
        name = in.readString();
        serialNumber = in.readString();
    }

    public static final Creator<Device> CREATOR = new Creator<Device>() {
        @Override
        public Device createFromParcel(Parcel in) {
            return new Device(in);
        }

        @Override
        public Device[] newArray(int size) {
            return new Device[size];
        }
    };

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Device(String serialNumber, String name, boolean state) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Device{" +
                "state=" + state +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (state ? 1 : 0));
        dest.writeString(name);
        dest.writeString(serialNumber);
    }
}
