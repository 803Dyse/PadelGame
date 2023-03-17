/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.SessionController;
import db.BookingDB;
import db.PadelManagerDB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import model.Booking;
import model.PadelCourt;

/**
 * Esta clase, que estará dentro do paquete "view", terá un atributo
 * "controller" de tipo SessionController para poder comunicarse co obxecto que
 * implementa o controlador da sesión (non é necesario agregar métodos de acceso
 * para este atributo). No construtor da clase, que recibe como parámetro un
 * obxecto de tipo SessionController, deberemos asignar ese valor ao atributo
 * "controller".
 *
 * @author Bilo Alejandro Martins Gonzalez
 */
public class SessionView {
    
    private SessionController controller;
    
    public SessionView(SessionController controller) {
        this.controller = controller;
    }

    /**
     * Este método recibe como parámetro un ArrayList de reservas que contén as
     * reservas nas que está inscrito o xogador da sesión a partir da data
     * actual. En primeiro lugar mostrará a mensaxe de benvida incluíndo o nome
     * do usuario, o seu saldo e a lista de reservas recibidas (usando o método
     * "getDescription" das reservas). A continuación mostrará as opcións do
     * menú, que serán crear unha reserva (1), apuntarse a un partido (2) e
     * pechar a sesión (3). Se a opción seleccionada é 1 ou 2, debe pedirlle ao
     * usuario que introduza a data do partido. Esta data debe lerse como un
     * texto e transformarse a data co código "new
     * SimpleDateFormat("dd/MM/yyyy").parse(scan.nextLine())". O método "parse"
     * arroxará unha "ParseException" se o valor introducido non é unha data,
     * que haberá que capturar para informar do erro e que pedir a data
     * novamente, as veces que sexa necesario. Para finalizar, o método actuará
     * en función da opción seleccionada: Se é 1, chamará ao método
     * "createBooking" do controlador; se é 2 chamará ao método
     * "addPlayerToBooking" do controlador; se é 3 mostrará a mensaxe "Ata a
     * vista!"; e se é outro valor calquera mostrará a mensaxe "Opcion non
     * permitida". O menú volverá a mostrarse novamente ata que a opción
     * introducida sexa correcta (é dicir, que estea entre 1 e 3).
     *
     * @param bookings
     */
    public void showSessionMenu(ArrayList<Booking> bookings) {
        int option;
        Date bookingDate = null;
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("Benvid@, " + this.controller.getSessionPlayer().getName());
            System.out.println("Saldo actual: " + this.controller.getSessionPlayer().getBalance());
            System.out.println("As tuas reservas:");
            for (Booking booking : bookings) {
                System.out.println(booking.getDescription());
            }
            System.out.println();
            System.out.println("Que queres facer?");
            System.out.println("1. Hacer una reserva para un partido");
            System.out.println("2. Pariticipar de un partido");
            System.out.println("3. Cerrar sesión");
            option = sc.nextInt();
            sc.nextLine();
            if (option == 1 || option == 2) {
                boolean validDate;
                do {
                    validDate = true;
                    try {
                        System.out.println("Introduce la fecha para el partido, siguiendo este formato: dd/MM/yyyy");
                        bookingDate = (new SimpleDateFormat("dd/MM/yyyy")).parse(sc.nextLine());
                    } catch (ParseException e) {
                        System.out.println("Esta fecha no es correcta.");
                        validDate = false;
                    }
                } while (!validDate);
            }
            switch (option) {
                case 1:
                    this.controller.createBooking(bookingDate);
                    break;
                case 2:
                    this.controller.addPlayerToBooking(bookingDate);
                    break;
                case 3:
                    System.out.println("Adios!");
                    break;
                default:
                    System.out.println("Esta accion no está permitida.");
                    break;
            }
        } while (option < 1 && option > 3);
    }

    /**
     * Este método recibe como parámetros unha data na que se quere facer unha
     * reserva, un ArrayList con todas as pistas e outro coas reservas
     * rexistradas para esa data. Debe mostrar ao xogador as pistas (indicando
     * se a pista é individual) e as horas dipoñibles (aquelas para as que non
     * haxa reservas na lista recibida de parámetro). A continuación pedirá que
     * se indique un número de pista e unha hora para chamar ao método
     * "completeBooking" co controlador para completar a reserva. Non é
     * necesario comprobar que o xogador introduce realmente unha hora das que
     * se lle indicou que estaba libre, suporemos que o fai así. A continuación
     * inclúese un exemplo do que debe mostrar este método:
     */
    public void selectCourtAndHour(Date bookingDate, ArrayList<PadelCourt> courts, ArrayList<Booking> bookings) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Horas disponibles para la fecha indicada:");
        for (PadelCourt court : courts) {
            System.out.print("Pista " + court.getNumber());
            if (court.getType() == 1) {
                System.out.println("[INDIVIDUAL]");
            } else {
                System.out.println("...");
            }
            System.out.print("Horas disponibles: ");
            for (String string : court.getBookingHours()) {
                boolean isReserved = false;
                for (Booking booking : bookings) {
                    if (booking.getCourt().getNumber() == court.getNumber() && booking.getHour().equals(string)) {
                        isReserved = true;
                    }
                }
                if (!isReserved) {
                    System.out.print(string + " ");
                }
            }
        }
        System.out.println("Indica el numero de la pista:");
        int courtNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Indica la hora del partido:");
        String hour = sc.nextLine();
        PadelCourt selectedCourt = null;
        for (PadelCourt court : courts) {
            if (court.getNumber() == courtNumber) {
                selectedCourt = court;
            }
            controller.completeBooking(bookingDate, court, hour);
        }
    }
}
