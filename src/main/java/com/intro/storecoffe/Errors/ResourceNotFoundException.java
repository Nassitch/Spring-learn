package com.intro.storecoffe.Errors;

public class ResourceNotFoundException extends RuntimeException {

    private Long id;

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public Long getId() {
        return this.id;
    }
}
