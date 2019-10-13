package com.example.student;

public class LocationClass {
    Double latitude;
    Double longitude;
    Boolean online;
    boolean latitude_flag;
    boolean longitude_flag;

    public LocationClass() {
        latitude_flag = false;
        longitude_flag = false;
        latitude=0.0;
        longitude=0.0;
        online=false;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double Longitude) {
        this.longitude = Longitude;
        longitude_flag = true;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean Online) {
        this.online = Online;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double Latitude) {
        this.latitude = Latitude;
        latitude_flag = true;
    }

    public boolean isLatitude_flag() {
        return latitude_flag;
    }

    public boolean isLongitude_flag() {
        return longitude_flag;
    }
}
