package com.project.coches.exception;

public class EmailValidationException extends RuntimeException {

    public EmailValidationException(){
        super("el email no tiene el formato correcto. Ex: example@mail.com ");
    }
}
