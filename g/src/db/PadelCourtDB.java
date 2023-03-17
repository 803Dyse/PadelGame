/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.util.ArrayList;
import model.PadelCourt;

/**
 * Esta clase inclúe o método para acceder ás pistas da aplicación
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public class PadelCourtDB {
    public static ArrayList<PadelCourt> getAllCourts(){
    return PadelManagerDB.getCourts();
    }
}