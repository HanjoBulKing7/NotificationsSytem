package service;

import constants.NotificationEnum;
import domain.model.*;

import java.util.Scanner;

public class MatchStrategyService {

    private final NotificationEngine notificationEngine;

    public MatchStrategyService(NotificationEngine e){
        this.notificationEngine = e;
    }

    private Notification matchNotification(NotificationEnum n, Scanner sc){
        return switch (n) {
            case NotificationEnum.SMS -> SmsNotification.setData(sc);
            case NotificationEnum.PUSH -> PushNotification.setData(sc);
            case NotificationEnum.EMAIL -> EmailNotification.setData(sc);
            default -> throw new IllegalArgumentException("Invalid kind of notification");
        };
    }

    // Nuevo: orquesta crear + guardar, esto es lo que llama el main
    public String createNotification(NotificationEnum type, Scanner sc) {
        Notification n = matchNotification(type, sc);
        return notificationEngine.addNotification(n);
    }

    private int[] countNotifications(Notification[] arr) {
        int n1 = 0, n2 = 0, n3 = 0;
        for (Notification n : arr) {
            if (n == null) continue; // ojo: si el array no está lleno, hay huecos null
            switch (n) {
                case SmsNotification s  -> n1++;
                case EmailNotification e -> n2++;
                case PushNotification p  -> n3++;
            }
        }
        return new int[]{n1, n2, n3};
    }

    // Nuevo: expone el resumen ya armado, esto es lo que llama el main
    public String getSummary() {
        int[] stats = countNotifications(notificationEngine.getNotifications());
        return notificationEngine.printStats(stats);
    }
}