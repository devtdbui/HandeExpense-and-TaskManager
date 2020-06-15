/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0055;

import java.util.ArrayList;

/**
 *
 * @author DevBui
 */
public class main {

    public static void main(String[] args) {
        Controler manager = new Controler();
        //loop until user want to exit
        while (true) {
            int choice = Controler.menu();
            switch (choice) {
                case 1:
                    manager.addDoctors();
                    break;
                case 2:
                    manager.updateDoctors();
                    break;
                case 3:
                    manager.deleteDoctors();
                    break;
                case 4:
                    manager.searchDoctor();
                    break;
                case 5:
                    return;
            }
        }
    }

}
