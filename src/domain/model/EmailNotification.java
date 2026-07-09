package domain.model;

import exceptions.InvalidArgumentCustomException;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  record EmailNotification(
        String emailAddress,
        String message,
        LocalDateTime timeStamp
) implements  Notification
{

    public boolean validateEmail (String email) {
        String regex = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public EmailNotification{

        if(!validateEmail(emailAddress))
            throw new InvalidArgumentCustomException("Ingrese una dirección de correo electrónico válida");

        if(message == null ){
            throw new InvalidArgumentCustomException("Ingrese un mensaje por favor");
        }

        message = message.trim();

        if(message.isEmpty())
            throw new InvalidArgumentCustomException("Ingrese un mensaje por favor");
    }

    public static Notification setData(Scanner sc){

        IO.println("Ingrese la dirección de correo electrónico del destinatario: ");
        String emailAddress = sc.nextLine();
        IO.println("Ingrese la mensaje por favor: ");
        String message = sc.nextLine();

        LocalDateTime timeStamp = LocalDateTime.now();
        sc.close();
        return new EmailNotification(emailAddress, message, timeStamp);
    }

    @Override
    public LocalDateTime timeStamp() {
        return timeStamp;
    }

    @Override
    public String getSummary() {
        return "El correo para: " + emailAddress + " es: " + message+
                "\n timestamp"+this.getFormattedDate();
    }


}
