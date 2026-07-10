package domain.model;


import java.lang.IllegalArgumentException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;


public final record PushNotification(
    String token,
    String message,
    LocalDateTime timeStamp
) implements Notification {

    public PushNotification {

        if( token == null )
            throw new NullPointerException("El token debe de tener contenido");

        token = token.trim();

        if ( token.isEmpty())
            throw new NullPointerException("El token debe de tener contenido");

        if(message == null ){
            throw new NullPointerException("Ingrese un mensaje por favor");
        }
        message = message.trim();

        if(message.isEmpty())
            throw new IllegalArgumentException("Ingrese un mensaje por favor");

        if(timeStamp == null)
            throw new NullPointerException("Timestamp must not be null"); /// Programmer exceptions so they can be in english

        if(timeStamp.isAfter(LocalDateTime.now()))
            throw new IllegalArgumentException("Timestamp cannot occur in the future");/// Programmer exceptions so they can be in english
    }

    @Override
    public LocalDateTime timeStamp() {
        return timeStamp;
    }

    @Override
    public String getSummary() {
        return "Token del dispositivo: " + token + " es: " + message+
                "\ntimestamp: "+this.getFormattedDate();
    }


    public static Notification setData(Scanner sc){

        IO.println("¿Quiere que el sistema genere el token = Y, ó quiere ingresar uno personalizado = N? ( Y / N ))");
        char letter = sc.nextLine().charAt(0);

        String token;
        if( Character.toUpperCase(letter) == 'Y'){
            token = UUID.randomUUID().toString();
        }else {
            IO.println("Ingrese el token personalizado:");
            token = sc.nextLine();
        }
        IO.println("Ingrese la mensaje por favor: ");
        String message = sc.nextLine();

        LocalDateTime timeStamp = LocalDateTime.now();
        return new PushNotification(token, message, timeStamp);
    }
}
