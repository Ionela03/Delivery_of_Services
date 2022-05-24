package com.example.delivery_of_services_application.users;

import javafx.fxml.FXML;
import org.dizitart.no2.objects.Id;

public class Announcement {

    @Id
    public String noAnnouncement;

    public String county;

    public String domain;

    public String deplHome;

    public String price;

    public String negociablePrice;

    public String provider;

    public String description;


    public Announcement(String noAnnouncement, String county, String domain, String deplHome, String price, String negociablePrice, String provider, String description) {

        this.noAnnouncement = noAnnouncement;
        this.county = county;
        this.domain = domain;
        this.deplHome=deplHome;
        this.price = price;
        this.negociablePrice = negociablePrice;
        this.provider = provider;
        this.description = description;
    }

    public Announcement(){

    }
    public String getNoAnnouncement(){
        return noAnnouncement;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Announcement)
            return(((Announcement)o).noAnnouncement.equals(noAnnouncement));
        else
            return false;
    }

    public void setNoAnnouncement(String s) {
        this.noAnnouncement = s;
    }
}
