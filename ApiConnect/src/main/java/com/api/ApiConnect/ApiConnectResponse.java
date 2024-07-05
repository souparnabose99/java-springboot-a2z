package com.api.ApiConnect;

public class ApiConnectResponse {

    private String message;

    public ApiConnectResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
