/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.InitMenuController;
import db.BookingDB;
import db.PadelManagerDB;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Esta clase, que estará dentro do paquete "view", terá un atributo
 * "controller" de tipo InitMenuController para poder comunicarse co obxecto que
 * implementa o controlador do menú (non é necesario agregar métodos de acceso
 * para este atributo). No construtor da clase, que recibe como parámetro un
 * obxecto de tipo InitMenuController, deberemos asignar ese valor ao atributo
 * "controller"
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public class InitMenuView {

    private InitMenuController controller;

    public InitMenuView(InitMenuController controller) {
        this.controller = controller;
    }

    public void showInvalidUser() {
        System.out.println("Credenciais incorrectas.");
    }

    /**
     * 
     */
    public boolean showLoginMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Benvid@ ao xestor de reservas. Identificate para usar a aplicación.");
        System.out.println("Nome de usuario (en branco para saír):");
        String id;
        id = sc.nextLine();
        if (!id.isBlank()) {
            System.out.println("Constraseña:");
            String pw = sc.nextLine();
            controller.login(id, pw);
            return false;
        }
        return true;
    }
}
