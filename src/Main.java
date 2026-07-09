import domain.model.Notification;
import domain.model.SmsNotification;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    int op = 0;

    Scanner sc = new Scanner(System.in);
    do{
        IO.println("Bienvenido al sistema de notificaciones");
        IO.println("¿Qué desea hacer?");
        IO.println("1) Enviar notificación por Correo Electrónico");
        IO.println("2) Enviar notificación por SMS");
        IO.println("3) Enviar notificación PUSH");
        IO.println("4) Ver resumen");
        IO.println("5) Salir");
        sc.nextLine();

    }while( op != 5);

}
