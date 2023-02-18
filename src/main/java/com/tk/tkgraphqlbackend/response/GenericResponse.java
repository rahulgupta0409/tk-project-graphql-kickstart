package com.tk.tkgraphqlbackend.response;

import java.sql.Timestamp;


public class GenericResponse {
    private String status;
    private String message;
    private String updatedBy;
    private Timestamp updatedOn;

    public GenericResponse(){

    }

    public GenericResponse(String status, String message, String updatedBy, Timestamp updatedOn){
        this.status = status;
        this.message = message;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
    }

    public GenericResponse(String status, String message, String updatedBy){
        this.status = status;
        this.message = message;
        this.updatedBy = updatedBy;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getUpdatedBy(){
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy){
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedOn(){
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn){
        this.updatedOn = updatedOn;
    }
}
