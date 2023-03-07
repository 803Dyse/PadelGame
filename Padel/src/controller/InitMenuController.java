/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import db.PlayerDB;
import model.PadelCourt;
import model.Player;
import view.InitMenuView;
/**
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public class InitMenuController {
    
private InitMenuView view = new InitMenuView(this);
    
    public InitMenuController(InitMenuView view) {
        this.view = view;
    }
    
    
    
//    public void initApp(){
//        boolean exit;
//        do {
//            exit = view.showLoginMenu();
//        } while (!exit);
//        
//    }
    
    private void login(Player id, Player password){
    }
    
    public static void main(String[] args) {
        Player player1 = new Player("luisf", "abc", "Luis Fdez", 2.5, 25.90);
        Player player2 = new Player("maria", "abc", "Maria Insua", 2.83, 70);
        PadelCourt court1 = new PadelCourt(1, PadelCourt.DOUBLE, new String[]{"9:00", "11:00", "13:00", "16:00"});
        PadelCourt court2 = new PadelCourt(2, PadelCourt.SINGLE, new String[]{"9:00", "11:00", "13:00", "16:00"});
        PadelCourt court3 = new PadelCourt(3, PadelCourt.DOUBLE, new String[]{"9:00", "11:00"});

    }

   
    
    
}
