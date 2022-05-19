package com.example.delivery_of_services_application.services;

import com.example.delivery_of_services_application.exceptions.AnnouncementAlreadyExistsException;
import com.example.delivery_of_services_application.users.Announcement;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import static com.example.delivery_of_services_application.services.FileSystemService.getPathToFile;

public class AnnouncementService {

    private static ObjectRepository<Announcement> announcementRepository;

    public static void initAnnouncementsDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("announcement-database.db").toFile())
                .openOrCreate("test", "test");

        announcementRepository = database.getRepository(Announcement.class);
    }


    public static void addAnnouncement(String noAnnouncement,String county, String domain, String deplHome, String price, String negociablePrice, String phone, String description) throws AnnouncementAlreadyExistsException{
        announcementRepository.insert(new Announcement(noAnnouncement, county, domain,deplHome,price,negociablePrice,phone,description ));
    }

    private static void checkAnnouncementDoesNotExist(String noAnnouncement) throws AnnouncementAlreadyExistsException {
        for (Announcement ticket : announcementRepository.find()) {
            if (noAnnouncement.equals(ticket.getNoAnnouncement())) {}
                throw new AnnouncementAlreadyExistsException(noAnnouncement);
        }
    }

    public static Announcement returnAnnouncement(String noAnnouncement){
        for (Announcement announcement : announcementRepository.find()){
            if (noAnnouncement.equals(announcement.getNoAnnouncement()))
                return announcement;
        }
        return null;
    }



}
