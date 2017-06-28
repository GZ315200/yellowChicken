package org.igeek.exception;

/**
 * Created by Gyges on 2017/6/4.
 */
public class GeneralServiceException extends RuntimeException{
    private String message;

    public GeneralServiceException(String message){
        this.message = message;
    }

    public GeneralServiceException(String message, Throwable s){
       super(message,s);
    }

    public GeneralServiceException(Throwable e){
        super(e);
    }


    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
