package com.bruno.senigalha.curriculum.services.exceptions;

public class InvalidDateException extends RuntimeException{
    public InvalidDateException(String msg){
        super(msg);
    }
}
