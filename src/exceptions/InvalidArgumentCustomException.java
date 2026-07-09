package exceptions;

public class InvalidArgumentCustomException extends RuntimeException{

    public  InvalidArgumentCustomException(String message){
        super(message);
    }
}
