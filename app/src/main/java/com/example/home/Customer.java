package com.example.home;



public class Customer {
    private String CutomerId;
    private String Name , Track , time , Catogres ;
    private String phone ;



    public Customer(String cutomerId, String name, String phone ,  String track  , String time ) {
        CutomerId = cutomerId;
        Name = name;
        Track = track;
        this.time = time;
        this.phone = phone;
    }

    public Customer() {

    }

    public String getCutomerId() {
        return CutomerId;
    }

    public String getName() {
        return Name;
    }



    public String getTrack() {
        return Track;
    }


    public String getPhone() {
        return phone;
    }


    public String getTime() {
        return time;
    }

    public String getCatogres() {
        return Catogres;
    }

    public void setCatogres(String catogres) {
        Catogres = catogres;
    }
}

