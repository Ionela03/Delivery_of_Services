package com.example.delivery_of_services_application.exceptions;

public class AnnouncementAlreadyExistsException  extends Throwable {
    private String noAnnouncement;

    public AnnouncementAlreadyExistsException(String noAnnouncement){
        super(String.format("An announcement  with the no %s already exists!", noAnnouncement));
        this.noAnnouncement = noAnnouncement;
    }

    public String getNoAnnouncement(){

        return noAnnouncement;
    }
}
