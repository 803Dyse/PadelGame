package model;

import java.util.Date;

/**
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public class SingleBooking extends Booking {

    private Player[] players;

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public SingleBooking(Date date, String hour, PadelCourt court) {
        super(date, hour, court);
        this.players = new Player[2];
    }

    @Override
    public double getPrice() {
        return 0.0;
    }

    @Override
    public boolean isCompleted() {
        for (Player player : players) {
            if (player == null) {
                return false;
            }
        }
        return true;
    }


    public boolean containsPlayer(String playerId) {
        for (Player player : players) {
            if (player != null && player.getId().equals(playerId)) {
                return true;
            }
        }
        return false;
    }

    public String getDescription() {
        String description = super.getDescription() + " Xogadores: ";
        for (Player player : players) {
            if (player == null) {
                description = description + "PENDENTE ";
            } else {
                description = description + description + " (" + player.getId() + ") ";
            }
        }
        return description;
    }

    public void addPlayer(Player player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                players[i] = player;
                return;
            }
        }
    }

}
