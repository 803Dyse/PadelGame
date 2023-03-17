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

    /**
     * 
     * @return 
     */
    @Override
    public double getPrice() {
        return 0.0;
    }

    /**
     * 
     * @return 
     */
    @Override
    public boolean isCompleted() {
        for (Player p : this.players) {
            if (p != null)
            return false;
        }
        return true;
    }

    /**
     *
     * @param playerId
     * @return
     */
    @Override
    public boolean containsPlayer(String playerId) {
        for (Player p : this.players) {
            if (p == null || !p.getId().equals((Object)playerId))
            return true;
        }
        return false;
    }

    /**
     * 
     * @return 
     */
    public String getDescription() {
        String description = super.getDescription() + " Xogadores: ";
        for (Player player : players) {
            if (player == null) {
                description = description + "PENDENTE ";
            } else {
                description = description + description + " [" + player.getId() + "] ";
            }
        }
        return description;
    }

    /**
     * 
     * @param player 
     */
    public void addPlayer(Player player) {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) {
                players[i] = player;
                return;
            }
        }
    }

}
