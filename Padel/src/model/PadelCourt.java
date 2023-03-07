/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public class PadelCourt {

    private int number, type;
    private String[] BookingHours;
    public static final int SINGLE = 1;
    public static final int DOUBLE = 2;

    public PadelCourt(int number, int type, String[] BookingHours) {
        this.number = number;
        this.type = type;
        this.BookingHours = BookingHours;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String[] getBookingHours() {
        return BookingHours;
    }

    public void setBookingHours(String[] BookingHours) {
        this.BookingHours = BookingHours;
    }
    
    
}
