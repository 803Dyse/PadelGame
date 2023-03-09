/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public class DoubleBooking extends Booking {

    private Player[][] teams;

    public Player[][] getTeams() {
        return teams;
    }

    public void setTeams(Player[][] teams) {
        this.teams = teams;
    }

    public DoubleBooking(Date date, String hour, PadelCourt court) {
        super(date, hour, court);
        this.teams = new Player[2][2];
    }

    @Override
    protected double getPrice() {
        return 0.0;
    }

    @Override
    protected boolean isCompleted() {
        for (Player[] team : teams) {
            if (team == null) {
                return false;
            }
        }
        return true;
    }

    public boolean containsPlayer(String playerId) {
        for (Player[] team : teams) {
            for (Player player : team) {
                if (team != null && player.getId().equals(playerId)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getDescription() {
        String description = super.getDescription() + " Xogadores: ";
        for (int i = 0; i < teams.length; i++) {
            description = description + " Equipo " + description + ":";
            for (Player player : teams[i]) {
                if (player == null) {
                    description = description + "PENDENTE ";
                } else {
                    description = description + description + " (" + player.getId() + ") ";
                }
            }
        }
        return description;
    }

    public void addPlayer(Player player, int teamNum) {
        for (int i = 0; i < (teams[teamNum].length); i++) {
            if (teams[teamNum][i] == null) {
                teams[teamNum][i] = player;
                return;
            }
        }
    }

}
