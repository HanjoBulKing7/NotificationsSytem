package domain.model;

public final record PushNotification() implements Notification {
    @Override
    public String getSummary() {
        return "";
    }
}
