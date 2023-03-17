/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.util.ArrayList;
import java.util.HashMap;
import javax.crypto.AEADBadTagException;
import model.Booking;
import model.PadelCourt;
import model.Player;

/**
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public class PadelManagerDB {

    /*
     É un HashMap estático no que se almacenan os xogadores poñendo como chaves 
    os seus Ids. Polo tanto, a chave será de tipo texto e o elemento de clase 
    "Player". Na mesma declaración do atributo asignarase un novo HashMap 
    baleiro.
     */
    private static HashMap<String, Player> players = new HashMap<>();
    private static ArrayList<PadelCourt> courts = new ArrayList<>();
    private static ArrayList<Booking> bookings = new ArrayList<>();

    public static HashMap<String, Player> getPlayers() {
        return players;
    }

    public static ArrayList<PadelCourt> getCourts() {
        return courts;
    }

    public static ArrayList<Booking> getBookings() {
        return bookings;
    }

}
