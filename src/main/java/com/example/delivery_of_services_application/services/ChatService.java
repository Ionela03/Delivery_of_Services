package com.example.delivery_of_services_application.services;

import com.example.delivery_of_services_application.users.Chat;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import static com.example.delivery_of_services_application.services.FileSystemService.getPathToFile;

public class ChatService {

    public static ObjectRepository<Chat> chatRepository;

    public static void initChatDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("chat_Database.db").toFile())
                .openOrCreate("test", "test");

        chatRepository = database.getRepository(Chat.class);
    }

    public static void initiateChat(String expeditor, String destinatar, String message, String status,String ad)  {

        chatRepository.insert(new Chat(expeditor, destinatar,message,status,ad));
    }
}
