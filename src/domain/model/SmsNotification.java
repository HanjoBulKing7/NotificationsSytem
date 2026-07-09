package domain.model;

import java.util.Scanner;

public final record SmsNotification (
        String phoneNumber,
        String message
) implements Notification {


    public SmsNotification{
//        if(phoneNumber.length() != 10){
//            throw new  InvalidArgumentCustomException("Phone number must be 10 digits");
//        }
//        if(message == null || message.isEmpty()){
//            throw new InvalidArgumentCustomException("Enter a valid message please");
//        }
        message = message.trim();
    }

            @Override
            public String getSummary() {
                return "The message for: "+phoneNumber+ " is: "+message;
            }


            public static Notification getData(Scanner sc) {

                IO.println("Enter the phone number (10 digits length please)");
                String phoneNumber = sc.nextLine();
                IO.println("Enter the message ");
                String message = sc.nextLine();

                return new SmsNotification(phoneNumber, message);
            }
        }

