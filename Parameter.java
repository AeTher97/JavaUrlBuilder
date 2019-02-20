package com.microhard.plutus.BankApi.get.url.builder;

import javax.validation.constraints.NotNull;

public class Parameter {
    private String key;
    private String value;

    public Parameter(@NotNull String key,@NotNull String value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue(){
        return value;
    }
}
