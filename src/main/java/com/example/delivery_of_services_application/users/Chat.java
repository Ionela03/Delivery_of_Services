package com.example.delivery_of_services_application.users;

import org.dizitart.no2.objects.Id;

public class Chat {
    @Id
    public String expeditor;
    public String destinatar;
    public String message;

    public String ad;
    public String status;

    public Chat (String expeditor, String destinatar, String message, String status,String ad) {
        this.expeditor = expeditor;
        this.destinatar = destinatar;
        this.message = message;
        this.status = status;
        this.ad=ad;
    }
    public Chat(){

    }

}
