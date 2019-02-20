package com.microhard.plutus.BankApi.get.url.builder.exceptions;

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
