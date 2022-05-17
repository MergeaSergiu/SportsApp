package com.example.tema1;

import java.sql.Time;
import java.util.Date;

public class Reservations {

 private int IDReservation;
 private String Name;
 private Date Date;
 private String Time_Schedule;
 private boolean Heat;
 private String Court;

 public Reservations(int IDReservation, String Name, Date Date, String Time_Schedule,boolean Heat, String Court){
     this.IDReservation = IDReservation;
     this.Name = Name;
     this.Date = Date;
     this.Time_Schedule = Time_Schedule;
     this.Heat = Heat;
     this.Court = Court;
 }

}
