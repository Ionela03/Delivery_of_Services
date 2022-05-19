package com.example.delivery_of_services_application.exceptions;

public class AnnouncementAlreadyExistsException  extends Exception {
    private String noAnnouncement;

    public AnnouncementAlreadyExistsException(String noAnnouncement){
        super("An announcement already exists with no: "+ noAnnouncement + "!");
        this.noAnnouncement = noAnnouncement;
    }

    public String getNoAnnouncement(){
        return noAnnouncement;
    }
}
