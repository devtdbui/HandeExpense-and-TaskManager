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
public class TpBank {

    //ham check account
    //ham check password
    //ham random capcha
    //ham check capcha
    public static int getChoice() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String txt = sc.nextLine();
            Pattern p = Pattern.compile("^[123]$");
            if (p.matcher(txt).find()) {
                int choice = Integer.parseInt(txt);
                return choice;
            } else {
                System.out.println("Invalid choice, please input again: ");
            }
        }
    }

    public void checkAccount(ResourceBundle bundle) {
        Scanner scanner = new Scanner(System.in);

        //dung while true de neu nguoi dung nhap sai thi nhap lai
        while (true) {
            System.out.print(bundle.getString("account"));
            String account = scanner.nextLine();
            //dung patten dung de check chi duoc nhap tu 0-9 va co 10 so
            Pattern p = Pattern.compile("^[0-9]{10}$");
            if (p.matcher(account).find()) {
                break;
            } else {
                System.out.println(bundle.getString("check.account"));
            }
        }

    }

    public void checkPassword(ResourceBundle bundle) {
        Scanner scanner = new Scanner(System.in);

        //dung while true de neu nguoi dung nhap sai thi nhap lai
        while (true) {
            System.out.print(bundle.getString("password"));
            String account = scanner.nextLine();
            //dung patten dung de check chi duoc nhap tu 0-9 va co 10 so
            //check tu 8-31
            Pattern p1 = Pattern.compile("^[0-9a-zA-Z]{8,31}$");
            //check xem co it nhat la 1 so
            //nhap 1 so bat ki va co it nhat la 1 so
            //* it nhat la 0 co cung duoc ko co cung duoc
            //+ it nhat la 1 hoac nhieu so 
            //abc123abc123 - dung
            //abcdf10 -dung
            //abcxyz - sai
            //123213123-dung
            //5 - dung
            //a5b -dung
            Pattern p2 = Pattern.compile("^[A-Za-z0-9]*[0-9]+[A-Za-z0-9]*$");
            Pattern p3 = Pattern.compile("^[A-Za-z0-9]*[A-Za-z]+[A-Za-z0-9]*$");
            if (p1.matcher(account).find() && p2.matcher(account).find() && p3.matcher(account).find()) {
                break;
            } else {
                System.out.println(bundle.getString("wrong.password"));
            }
        }
    }

    public String randomCapcha() {
        //do dai =5
        //chu hoa, chu thuong, so
        String root = "0123456789qwertyuiopasdfghjklzxcvbnmQƯERTYUIOPASDFGHJKLZXCVBNM";
        String capcha = "";
        //dung ham random ra 5 lan 
        int length = root.length();
        for (int i = 0; i < 5; i++) {
            Random r = new Random();
            int index = r.nextInt(length); //tra ve cac so bat ki tu 0-> length-1 la index
            capcha = capcha + root.charAt(index);
        }
        System.out.println("Capcha: " + capcha);
        return capcha;
    }

    public boolean checkCapchar(String capcha, ResourceBundle bundle) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        System.out.print(bundle.getString("capcha"));
        input = sc.nextLine();
        if (input.equals(capcha)) {
            System.out.println(bundle.getString("right.capcha"));
            return true;
        } else {
            System.out.println(bundle.getString("wrong.capcha"));
            return false;
        }
    }
}
