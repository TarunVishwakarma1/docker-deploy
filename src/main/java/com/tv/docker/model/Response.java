package com.tv.docker.model;

public class Response {
    private String status;
    private int errorCode;
    private String description;

    private Response(){}

    public Response(String status, int errorCode, String description) {
        this.status = status;
        this.errorCode = errorCode;
        this.description = description;
    }
    

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status='" + status + '\'' +
                ", errorCode=" + errorCode +
                ", description='" + description + '\'' +
                '}';
    }
}
