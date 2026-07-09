package domain.model;

import java.time.LocalDateTime;

public final record PushNotification(

) implements Notification {

    public PushNotification {


    }

    @Override
    public LocalDateTime timeStamp() {
        return null;
    }

    @Override
    public String getSummary() {
        return "";
    }

    @Override
    public String getFormattedDate() {
        return Notification.super.getFormattedDate();
    }
}
