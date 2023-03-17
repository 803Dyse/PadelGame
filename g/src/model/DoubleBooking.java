
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
         Player[][] pTeam = this.teams;
        int n = pTeam.length;
        for (int i = 0; i < n; ++i) {
            Player[] team;
            for (Player p : team = pTeam[i]) {
                if (p != null) continue;
                return false;
            }
        }
        return true;
    }

    public boolean containsPlayer(String playerId) {
        Player[][] playerArray = this.teams;
        int n = playerArray.length;
        for (int i = 0; i < n; ++i) {
            Player[] team;
            for (Player p : team = playerArray[i]) {
                if (p == null || !p.getId().equals((Object)playerId)) continue;
                return true;
            }
        }
        return false;
    }

    public String getDescription() {
         String description = super.getDescription() + "  Xogadores: ";
        for (int i = 0; i < this.teams.length; ++i) {
            description = description + "Equipo " + (i + 1) + ": ";
            for (Player p : this.teams[i]) {
                description = p == null ? description + "PENDENTE " : description + p.getId() + " (" + p.getScore() + ") ";
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
