package com.example.delivery_of_services_application.users;

public class Announcement {

    public String noAnnouncement;
    public String county;
    public String domain;
    public String deplHome;
    public String price;
    public String negociablePrice;
    public String phone;
    public String description;


    public Announcement(String noAnnouncement, String county, String domain, String deplHome, String price, String negociablePrice, String phone, String description) {

        this.noAnnouncement = noAnnouncement;
        this.county = county;
        this.domain = domain;
        this.deplHome=deplHome;
        this.price = price;
        this.negociablePrice = negociablePrice;
        this.phone = phone;
        this.description = description;
    }

    public Announcement(){

    }
    public String getNoAnnouncement() {
        return noAnnouncement;
    }

    public String getCounty(){
        return county;
    }

    public String getDomain(){
        return domain;
    }

    public String getDeplHome(){
        return deplHome;
    }

    public String getPrice(){
        return price;
    }

    public String getNegociablePrice(){
        return negociablePrice;
    }

    public String getPhone(){
        return phone;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Announcement)
            return(((Announcement)o).noAnnouncement.equals(noAnnouncement));
        else
            return false;
    }
}