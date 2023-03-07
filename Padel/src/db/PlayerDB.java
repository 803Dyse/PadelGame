/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import model.Player;

/**
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public class PlayerDB {

    /**
     * É un método estático que recibe o Id dun xogador e un contrasinal, os
     * dous de tipo texto, e devolve o xogador que se corresponde con esas
     * credenciais do HashMap "players" de "PadelManagerDB", ou null se non hai
     * ningún xogador con eses datos.
     */
    public static Player findByIdAndPassword(String pId, String password) {
        Player player = PadelManagerDB.getPlayers().get(pId);
        if (player != null && player.getPassword().equals(password)) {
            return player;
        }
        return null;
    }

}
