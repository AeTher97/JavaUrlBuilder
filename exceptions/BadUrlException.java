package com.Aether97.JavaUrlBuilder.exceptions;

public class BadUrlException extends GetUrlCreatorException {
    private String message = "Url is invalid";

    public BadUrlException(String message){
        this.message = message;
    }

    public BadUrlException(){}

    @Override
    public String getMessage(){
        return message;
    }
}
