package com.verlockt.models.response;


public class LogoutResponse {

    private boolean success;
    private String message;
    private String data; // assuming it's a message like "logout successful"

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }
}
