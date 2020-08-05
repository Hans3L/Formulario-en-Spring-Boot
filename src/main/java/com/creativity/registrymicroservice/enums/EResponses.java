package com.creativity.registrymicroservice.enums;

public enum EResponses {

    SUCCESS(200,"success.message"),
    ERROR_CONNECTION_DB(1001,"Problemas en la base de datos");

    private final int code;
    private final String keyMessage;

    EResponses(int code, String keyMessage){
        this.code=code;
        this.keyMessage=keyMessage;
    }

    public int getCode() {
        return code;
    }

    public String getKeyMessage(){
        return keyMessage;
    }
}
