package domain.model;

public class NotificationEngine{

    private Notification[] notifications;
    private int currentIndex = 0;

    public NotificationEngine(Notification[] notifications) {
        this.notifications = notifications;
    }


    public String addNotification(Notification lastNotification){
        if(currentIndex >= notifications.length )
            throw new
                    IndexOutOfBoundsException("Se excedió la capacidad del sistema ya no se pueden enviar más notificaciones");

        notifications[currentIndex] = lastNotification;

        currentIndex++;
        return "Notification saved successfully";
    }

    public String printStats(int[] currentStats){
        int total = 0;
        for(int c: currentStats ){
            total+=c;
        }

        return "========= RESUMEN =========\n" +
                "Correos enviados: " + currentStats[1] + "\n" +
                "SMS enviados: " + currentStats[0] + "\n" +
                "Push enviados: " + currentStats[2] + "\n" +
                "Total: " + total;
    }

    public Notification[] getNotifications() {
        return notifications;
    }

    public void setNotifications(Notification[] notifications) {
        this.notifications = notifications;
    }

    public Integer getCurrentIndex() {
        return currentIndex;
    }

    public  void setCurrentIndex(Integer currentIndex) {
        this.currentIndex = currentIndex;
    }
}