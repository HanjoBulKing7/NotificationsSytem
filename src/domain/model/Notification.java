package domain.model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public sealed interface Notification permits EmailNotification, SmsNotification, PushNotification {


    LocalDateTime timeStamp();
    String getSummary();

    default String getFormattedDate() {
        return timeStamp().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}
