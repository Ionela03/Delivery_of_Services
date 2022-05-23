package com.example.delivery_of_services_application.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import com.example.delivery_of_services_application.exceptions.UsernameAlreadyExistsException;
import com.example.delivery_of_services_application.users.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static com.example.delivery_of_services_application.services.FileSystemService.getPathToFile;

public class UserService {

    public static ObjectRepository<User> userRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("DSA.db").toFile())
                .openOrCreate("test", "test");
        userRepository = database.getRepository(User.class);
    }

    public static void addUser(String username, String password, String role) throws UsernameAlreadyExistsException {
        checkUserDoesNotAlreadyExist(username);
        userRepository.insert(new User(username, encodePassword(username, password), role));
    }

    private static void checkUserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.username))
                throw new UsernameAlreadyExistsException(username);
        }
    }
    public static int validateLogin(String username, String password) {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.username)) {
                String pass = encodePassword(username, password);
                if (Objects.equals(user.password, pass)) {
                    if (Objects.equals(user.role, "Provider")) {
                        return 1;
                    }
                    if (Objects.equals(user.role, "Customer")) {
                        return 2;
                    }
                }
            }
        }
        return 0;

    }
    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }


    public static User returnCurrentUser(String username, String password) {
        for (User user : userRepository.find()) {
            if(username.equals(user.getUsername()))
            {   String encodedPassword=encodePassword(username,password);
                if (encodedPassword.equals(user.getPassword())) {
                    return user;
                }
            }
        }
        return null;
    }
    public static boolean updateProfile(String username, String password){
        for(User user: userRepository.find())
        {
            if(Objects.equals(username,user.getUsername()))
            {
                String encodedPassword=encodePassword(username,password);
                if(Objects.equals(encodedPassword,user.getPassword())){
                    user.setUsername(username);
                    user.setPassword(encodedPassword);
                    userRepository.update(user);
                    return true;

                }
            }
        }
        return false;
    }


}
