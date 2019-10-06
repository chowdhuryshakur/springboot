package com.managemeeting.managemeetin.CustomizeException;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String resource) {
        super(resource + " not found!");
    }
}