package com.spring.userdept.service;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id){
        super("Recurso não encontrado. ID: " + id);
    }
}

