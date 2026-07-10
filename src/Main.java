import constants.NotificationEnum;
import domain.model.Notification;
import domain.model.NotificationEngine;
import service.MatchStrategyService;

import java.util.Scanner;

void main() {

    Scanner sc = new Scanner(System.in);

    IO.println("¿Cuántas notificaciones máximo desea poder registrar?");
    int size = Integer.parseInt(sc.nextLine());

    Notification[] notifications = new Notification[size];
    NotificationEngine engine = new NotificationEngine(notifications);
    MatchStrategyService service = new MatchStrategyService(engine);

    int op = 0;

    do {
        IO.println("Bienvenido al sistema de notificaciones");
        IO.println("¿Qué desea hacer?");
        IO.println("1) Enviar notificación por Correo Electrónico");
        IO.println("2) Enviar notificación por SMS");
        IO.println("3) Enviar notificación PUSH");
        IO.println("4) Ver resumen");
        IO.println("5) Salir");

        op = Integer.parseInt(sc.nextLine());

        switch (op) {
            case 1 -> tryCreate(service, NotificationEnum.EMAIL, sc);
            case 2 -> tryCreate(service, NotificationEnum.SMS, sc);
            case 3 -> tryCreate(service, NotificationEnum.PUSH, sc);
            case 4 -> IO.println(service.getSummary());
            case 5 -> IO.println("Saliendo del sistema...");
            default -> IO.println("Opción inválida");
        }

    } while (op != 5);

    sc.close();
}

void tryCreate(MatchStrategyService service, NotificationEnum type, Scanner sc) {
    try {
        IO.println(service.createNotification(type, sc));
    } catch (RuntimeException e) {
        IO.println("Error: " + e.getMessage());
        IO.println("Presione ENTER para continuar...");
        sc.nextLine();
    }
}