package com.example.CRUD_springBoot.exception;

public class ResourceNotFindException extends RuntimeException {
    
    public ResourceNotFindException(String message) {
        super(message);
    }
}
