package com.example.cypher.response;

public class Response {
    String message;
    int status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Response(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
