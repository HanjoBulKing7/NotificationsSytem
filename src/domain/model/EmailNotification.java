package domain.model;

public final record EmailNotification() implements  Notification{
    @Override
    public String getSummary() {
        return "";
    }
}
