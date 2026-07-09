package domain.model;

import java.util.Scanner;

public sealed interface Notification permits EmailNotification, SmsNotification, PushNotification {

    String getSummary();
}
