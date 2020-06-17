/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0070;

import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author devtd
 */
public class main {

    public static void menu() {
        System.out.println("-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.println("Please choice one optione: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TpBank tp = new TpBank();
        ResourceBundle bundle;
        String capcha = "";
        while (true) {
            menu();
            int choice = tp.getChoice();

            switch (choice) {
                case 1:
                    bundle = ResourceBundle.getBundle("J1.S.P0070.vi");
                    tp.checkAccount(bundle);
                    tp.checkPassword(bundle);
                    capcha = tp.randomCapcha();
                    tp.checkCapchar(capcha, bundle);
                    break;
                case 2:

                    bundle = ResourceBundle.getBundle("J1.S.P0070.en");
                    tp.checkAccount(bundle);
                    tp.checkPassword(bundle);
                    capcha = tp.randomCapcha();
                    tp.checkCapchar(capcha, bundle);
                    break;
                case 3:
                    System.exit(0);
            }
        }

    }

}
