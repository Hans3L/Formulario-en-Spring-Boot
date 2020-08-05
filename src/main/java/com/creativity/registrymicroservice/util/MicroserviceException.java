package com.creativity.registrymicroservice.util;

import com.creativity.registrymicroservice.enums.EResponses;

public class MicroserviceException extends Exception {

    private EResponses responses;

    public MicroserviceException(String message){
        super(message);
    }

    public MicroserviceException(EResponses responses){
        super("[Error] codigo: " + responses.getCode() + ", mensaje: " + responses.getKeyMessage());
        this.responses= responses;
    }

    public EResponses getCode(){
        return responses;
    }
}
