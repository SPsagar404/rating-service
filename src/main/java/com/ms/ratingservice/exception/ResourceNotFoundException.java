package com.ms.ratingservice.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(){
        super("Rating not found with given id ....");
    }

    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
