package com.example.tema1;

//import java.util.Date;
import java.sql.Date;
public class Reservation {
    private int idReservation;
    private String name;
    private Date date;
    private String timeSchedule;
    private boolean heat;
    private String court;

    public void setIdReservation(int idReservation){
        this.idReservation=idReservation;
    }

    public int getIdReservation(){
        return idReservation;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setDate(Date date){
        this.date=date;
    }

    public Date getDate(){
        return date;
    }

    public void getTimeSchedule(String timeSchedule){
        this.timeSchedule=timeSchedule;
    }

    public String getTimeSchedule(){
        return timeSchedule;
    }

    public void setHeat(boolean heat){
        this.heat=heat;
    }

    public boolean getHeat(){
        return heat;
    }

    public void setCourt(String court){
        this.court=court;
    }

    public String getCourt(){
        return court;
    }

}