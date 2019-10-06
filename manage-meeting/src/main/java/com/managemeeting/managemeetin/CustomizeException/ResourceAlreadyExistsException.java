package com.managemeeting.managemeetin.CustomizeException;

public class ResourceAlreadyExistsException extends Exception {
    public ResourceAlreadyExistsException(String resource) {
        super(resource + " already exists!");
    }
}
