/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public abstract class Booking {

    public Booking(Date date, String hour, PadelCourt court) {
        this.date = date;
        this.hour = hour;
        this.court = court;
    }

    protected Date date;
    protected String hour; //de texto, que indica a hora da reserva en formato "hh:mm") 
    protected PadelCourt court;

    /**
     * Método abstracto, que non recibe parámetros e devolve un número decimal
     * que será o que ten que pagar cada xogador que se inscriba na reserva.
     *
     * @return
     */
    protected abstract double getPrice();

    /**
     * Método abstracto, que non recibe parámetros e devolve un booleano que
     * indica que a reserva xa está completa (porque están inscritos todos os
     * xogadores posibles) ou non.
     *
     * @return
     */
    protected abstract boolean isCompleted();

    /**
     * Método abstracto, que recibe o id dun xogador (de tipo texto) e devolve
     * un booleano indicando se ese xogador está inscrito na reserva ou non.
     *
     * @param paramString
     * @return
     */
    public abstract boolean containsPlayer(String paramString);

    /**
     * Este método non recibe parámetros e devolve un texto cos datos da
     * reserva.En primeiro lugar se indicará se a reserva está completa ou non,
     * logo virá un salto de liña seguido da data, hora e número de pista da
     * reserva (para mostrar a data en formato "dd/MM/yyyy" podes usar en Java o
     * seguinte código: "new SimpleDateFormat("dd/MM/yyyy").format(date)"). A
     * continuación móstrase un exemplo do texto que podería devolver este
     * método para unha reserva:
     *
     * @return
     */
    public String getDescription() {
        String description;
        if (isCompleted()) {
            description = "Reserva completa:\n";
        } else {
            description = "Reserva pendente:\n";
        }
        description = description + " Data: " + description + " Hora: " + (new SimpleDateFormat("dd/MM/yyyy")).format(this.date);
        description = description + " Pista: " + description + "\n";
        return description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public PadelCourt getCourt() {
        return court;
    }

    public void setCourt(PadelCourt court) {
        this.court = court;
    }

}
