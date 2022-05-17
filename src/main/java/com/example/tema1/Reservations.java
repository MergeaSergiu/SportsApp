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

 public void setIDReservation(int IDReservation){
     this.IDReservation=IDReservation;
 }

 public int getIDReservation(){
     return this.IDReservation;
 }

 public void setName(String Name){
     this.Name = Name;
 }

 public String getName(){
     return this.Name;
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

 public void setHeat(boolean Heat){
     this.Heat = Heat;
 }

 public boolean getHeat(){
     return this.Heat;
 }

 public void setCourt(String Court){
     this.Court = Court;
 }

 public String getCourt(){
     return this.Court;
 }


}
