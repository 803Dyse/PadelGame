/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import db.BookingDB;
import db.PadelCourtDB;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.Booking;
import model.DoubleBooking;
import model.PadelCourt;
import model.Player;
import model.SingleBooking;
import view.SessionView;

/**
 *
 * @author bmargon
 */
public class SessionController {

    private SessionView view;
    private Player SessionPlayer;

    public SessionController(Player SessionPlayer) {
        this.view = new SessionView(this);
        this.SessionPlayer = SessionPlayer;
    }

    public Player getSessionPlayer() {
        return SessionPlayer;
    }

    public void setSessionPlayer(Player SessionPlayer) {
        this.SessionPlayer = SessionPlayer;
    }

    /**
     * Este método non recibe parámetros nin devolve nada. Obterá as reservas
     * dende o día actual nas que o usuario estea inscrito e chama ao método
     * "showSessionMenu" da vista para mostrar o menú da sesión. Para obter as
     * reservas chamará ao método "findByUserAndDate" de BookingDB, pasándolle
     * como parámetro a data actual (que se pode obter con
     * "Calendar.getInstance()", poñendo a hora a cero para que aparezan tamén
     * todas as reservas do día actual).
     */
    public void loadSession() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        ArrayList<Booking> bookings = BookingDB.findByUserAndDate(SessionPlayer.getId(), calendar.getTime());
        view.showSessionMenu(bookings);
    }

    /**
     * Método que permite crear unha nova reserva, para unha data que se recibe
     * como parámetro. O método non debe devolver nada, e o que fará e obter
     * todas as pistas e as reservas para a data recibida, para invocar o método
     * "selectCourtAndHour" da vista para que o usuario seleccione a pista e
     * hora que quere reservar.
     *
     * @param date
     */
    public void createBooking(Date date) {
        ArrayList<Booking> bookings = BookingDB.findByDate(date);
        ArrayList<PadelCourt> courts = PadelCourtDB.getAllCourts();
        view.selectCourtAndHour(date, courts, bookings);
    }

    /**
     * Este método recibe como parámetros a data dunha reserva, a hora e a
     * pista, crea o obxecto correspondente para a reserva (dobre ou invidual,
     * dependendo do tipo da pista recibida), engade o xogador da sesión á
     * reserva e a garda. Para finalizar carga de novo o menú da sesión chamando
     * ao método "loadSession".
     *
     * @param date
     */
    public void completeBooking(Date bookingDate, PadelCourt court, String hour) {
        Booking booking;
        if (court.getType() == 1) {
            booking = new SingleBooking(bookingDate, hour, court);
            ((SingleBooking) booking).addPlayer(this.SessionPlayer);
        } else {
            booking = new DoubleBooking(bookingDate, hour, court);
            ((DoubleBooking) booking).addPlayer(this.SessionPlayer, 0);
        }
        BookingDB.save(booking);
        this.loadSession();
    }

    /**
     * Este método permite engadir o xogador da sesión a unha reserva, para unha
     * data que se recibe como parámetro. De momento non implementamos esta
     * funcionalidade, así que o método simplemente chamará a "loadSession" para
     * cargar de novo o menú da sesión.
     */
    public void addPlayerToBooking(Date bookingDate) {
        loadSession();
    }

}
