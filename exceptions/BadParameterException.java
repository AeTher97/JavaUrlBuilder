package com.microhard.plutus.BankApi.get.url.builder.exceptions;

public class BadParameterException extends GetUrlCreatorException{
    private String message = "Parameters are invalid";

    public BadParameterException(String message){
        this.message = message;
    }

    public BadParameterException(){ }

    @Override
    public String getMessage(){
        return message;
    }
}
