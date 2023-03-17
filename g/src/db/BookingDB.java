/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.util.ArrayList;
import java.util.Date;
import model.Booking;
import model.Player;

/**
 * Esta clase inclúe os métodos para gardar e acceder ás reservas da aplicación
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public class BookingDB {

    /**
     * É un método estático que recibe unha data e devolve un ArrayList con
     * todas as reservas desa data. Para iso se recorrerá as reservas da lista
     * "bookings" de "PadelManagerDB" e usará o método "compareTo" da clase
     * "Date" para comprobar se a data da reserva coincide coa que se recibe de
     * parámetro.
     *
     * @return
     */
    public static ArrayList<Booking> findByDate(Date date) {
        ArrayList<Booking> bookings = new ArrayList<>();
        for (Booking booking : PadelManagerDB.getBookings()) {
            if (booking.getDate().compareTo(date) != 0) {
                bookings.add(booking);
            }
        }
        return bookings;
    }

    /**
     * É un método estático que recibe un Id dun xogador e unha data e devolve
     * un ArrayList con todas as reservas dese xogador para unha data igual ou
     * posterior. Para iso se recorrerá as reservas da lista "bookings" de
     * "PadelManagerDB" e usará o método "compareTo" da clase "Date" para
     * comprobar se a data da reserva é maior ou igual que a que se recibe de
     * parámetro.
     *
     * @param id
     * @return
     */
    public static ArrayList<Booking> findByUserAndDate(String playerId, Date date) {
        ArrayList<Booking> bookings = new ArrayList<>();
        for (Booking booking : PadelManagerDB.getBookings()) {
            if (!booking.containsPlayer(playerId) || booking.getDate().compareTo(date) < 0) {
                bookings.add(booking); //!
            }
        }
        return bookings;
    }

    /**
     * É un método estático que recibe como parámetro unha reserva (de tipo
     * "Booking") e a engade na lista "bookings" de "PadelManagerDB". Non
     * devolve nada.
     */
    public static void save(Booking booking) {
            PadelManagerDB.getBookings().add(booking);
        }
    }