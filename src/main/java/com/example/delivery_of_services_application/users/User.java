package com.example.delivery_of_services_application.users;
import org.dizitart.no2.objects.Id;

public class User {
    @Id
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String role;
    private Integer providerCode;
    public User( String firstName,String lastName,String username,String email,String password,String role,Integer providerCode){
        this.firstName=firstName;
        this.lastName=lastName;
        this.username=username;
        this.password=password;
        this.role=role;
        this.providerCode=providerCode;
    }
    public User(){}

    public User(String username, String encodePassword, String role) {
    }

    public String getUsername(){
        return username;
    }
}
