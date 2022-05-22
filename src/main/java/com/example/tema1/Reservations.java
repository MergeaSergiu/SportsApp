package com.example.tema1;

import java.sql.Time;
import java.util.Date;

public class Reservations {

 private int IDReservation;
 private String username;
 private Date Date;
 private String Time_Schedule;
 private String Heat;
 private String Court;

 public Reservations( String username, Date Date, String Time_Schedule,String Heat, String Court){

     this.username = username;
     this.Date = Date;
     this.Time_Schedule = Time_Schedule;
     this.Heat = Heat;
     this.Court = Court;
 }


 public void setName(String Name){
     this.username = Name;
 }

 public String getName(){
     return this.username;
 }

 public void setDate(Date Date){
     this.Date = Date;
 }

 public Date getDate(){
     return this.Date;
 }

 public void setTime_Schedule(String Time_Schedule){
     this.Time_Schedule=Time_Schedule;
 }

 public String getTime_Schedule(){
     return this.Time_Schedule;
 }

 public void setHeat(String Heat){
     this.Heat = Heat;
 }

 public String getHeat(){
     return this.Heat;
 }

 public void setCourt(String Court){
     this.Court = Court;
 }

 public String getCourt(){
     return this.Court;
 }


}
