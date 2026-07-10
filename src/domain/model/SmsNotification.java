package domain.model;

import exceptions.InvalidArgumentCustomException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public record SmsNotification (
        String phoneNumber,
        String message,
        LocalDateTime timeStamp
) implements Notification {


    public SmsNotification{

        if(phoneNumber.length() != 10){
            throw new  InvalidArgumentCustomException("El número de teléfono debe de tener 10 dígitos");
        }
        if(message == null ){
            throw new NullPointerException("Ingrese un mensaje por favor");
        }
        message = message.trim();

        if(message.isEmpty())
            throw new InvalidArgumentCustomException("Ingrese un mensaje por favor");

        if(timeStamp == null)
            throw new NullPointerException("Timestamp must not be null"); /// Programmer exceptions so they can be in english

        if(timeStamp.isAfter(LocalDateTime.now()))
            throw new InvalidArgumentCustomException("Timestamp cannot occur in the future");/// Programmer exceptions so they can be in english
    }

    @Override
    public String getSummary() {
        return "El mensaje para el número: " + phoneNumber + " es: " + message+
                "\n timestamp "+this.getFormattedDate();
    }

    @Override
    public LocalDateTime timeStamp(){
        return timeStamp;
    }

    public static Notification setData(Scanner sc) {

        IO.println("Enter the phone number (10 digits length please)");
        String phoneNumber = sc.nextLine();
        IO.println("Enter the message ");
        String message = sc.nextLine();

        LocalDateTime timeNow = LocalDateTime.now();
        return new SmsNotification(phoneNumber, message, timeNow);
    }
}

