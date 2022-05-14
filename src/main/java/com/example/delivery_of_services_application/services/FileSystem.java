package com.example.delivery_of_services_application.services;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSystem {
    private static String APPLICATION_FOLDER = ".Delivery of Services Application";
    private static String USER_FOLDER = System.getProperty("user.home");
    public static  Path APPLICATION_HOME_PATH = Paths.get(USER_FOLDER, APPLICATION_FOLDER);

    public static Path getApplicationHomeFolder(){
        return Paths.get(USER_FOLDER, APPLICATION_FOLDER);
    }

    public static Path getPathToFile(String... path) {

        return APPLICATION_HOME_PATH.resolve(Paths.get(".", path));
    }

}
