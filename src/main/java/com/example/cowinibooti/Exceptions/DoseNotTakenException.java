package com.example.cowinibooti.Exceptions;

public class DoseNotTakenException extends RuntimeException{
    public DoseNotTakenException(String message){
        super(message);
    }
}
