package service;

import constants.NotificationEnum;
import domain.model.*;
import exceptions.InvalidArgumentCustomException;

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
             default -> throw new InvalidArgumentCustomException("Invalid kind of notification");
         };
    }

    private int[] countNotifications(Notification[] arr) {
        int n1 = 0, n2 = 0, n3 = 0;

        for (Notification n : arr) {
            switch (n) {
                case SmsNotification s  -> n1++;
                case EmailNotification e -> n2++;
                case PushNotification p  -> n3++;
            }
        }

        return new int[]{n1, n2, n3};
    }


}
