package domain.model;

public class NotificationEngine{

    private Notification[] notifications;
    private Integer currentIndex;

    public NotificationEngine(Notification[] notifications) {
        this.notifications = notifications;
    }


    private String fillArray(Notification lastNotification){
        if(currentIndex >= notifications.length )
            throw new
                    IndexOutOfBoundsException("Se excedió la capacidad del sistema ya no se pueden enviar más notificaciones");

        currentIndex++;
        return "Notification saved successfully";
    }

    public String printStats(int[] currentStats){
        StringBuilder sb = new StringBuilder();
        sb.append("========= RESUMEN =========\n");
        sb.append("Correos enviados: "+ currentStats[1] + "\n");
        sb.append("SMS enviados: "+ currentStats[0] + "\n");
        sb.append("Push enviados: "+ currentStats[2] + "\n");

        return sb.toString();
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