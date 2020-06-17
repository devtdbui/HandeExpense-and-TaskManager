/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskManagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author devtd
 */
public class CheckInput {

    Scanner sc = new Scanner(System.in);

    public int getChoice() {
        while (true) {
            System.out.print("Selection of users: ");
            String input = sc.nextLine();
            Pattern p = Pattern.compile("^[1-4]$");
            if (p.matcher(input).find()) {
                int choice = Integer.parseInt(input);
                return choice;
            } else {
                System.out.print("invalid choice, pls re-enter");
            }
        }
    }

    public String getDate() {
        SimpleDateFormat dfOutput = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat dfInput = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        while (true) {
            try {
                System.out.print("input date: ");
                date = dfInput.parse(sc.nextLine());
                return dfOutput.format(date);
            } catch (Exception e) {
                System.out.print("invalid date, please input again");
            }
        }
    }

    public double getFrom() {
        double result = 0;
        while (true) {
            System.out.println("input from: ");
            String from = sc.nextLine();
            Pattern p1 = Pattern.compile("^[0-9]+$");
            Pattern p2 = Pattern.compile("^[0-9]+.[05][0]*$");
            if (p1.matcher(from).find() || p2.matcher(from).find()) {
                result = Double.parseDouble(from);
                if (result >= 8 && result <= 17.5) {
                    break;
                } else {
                    System.out.println("number within 8-17.5");
                }
            } else {
                System.out.println("invalid number, please input again");
            }
        }
        return result;
    }

    public double getTo(double from) {
        double result = 0;
        while (true) {
            System.out.println("input to: ");
            String to = sc.nextLine();
            Pattern p1 = Pattern.compile("^[0-9]+$");
            Pattern p2 = Pattern.compile("^[0-9]+.[05][0]*$");
            if (p1.matcher(to).find() || p2.matcher(to).find()) {
                result = Double.parseDouble(to);
                if (result >= 8 && result <= 17.5) {
                    break;
                } else {
                    System.out.println("number within 8-17.5");
                }
            } else {
                System.out.println("invalid number, please input again");
            }
        }
        return result;
    }

    public String getName() {
        String name = "";
        while (true) {
            System.out.print("input name: ");
            name = sc.nextLine();
            if (!name.trim().equals("")) {
                return name;
            } else {
                System.out.print("empty name, please input again");
            }
        }
    }

    public int getTypeID() {
        int typeID = 0;
        while (true) {
            try {
                System.out.print("input type id: ");
                typeID = Integer.parseInt(sc.nextLine());
                if (typeID >= 1 && typeID <= 4) {
                    break;
                }
            } catch (Exception e) {
                System.out.print("invalid type id, please input again");
            }
        }
        return typeID;
    }

    public String getAssign() {
        String assign = "";
        while (true) {
            System.out.print("input assign: ");
            assign = sc.nextLine();
            if (!assign.trim().equals("")) {
                return assign;
            } else {
                System.out.print("empty assign, please input again");
            }
        }
    }

    public String getReviewer() {
        String reviewer = "";
        while (true) {
            System.out.print("input reviewer: ");
            reviewer = sc.nextLine();
            if (!reviewer.trim().equals("")) {
                return reviewer;
            } else {
                System.out.print("empty reviewer, please input again");
            }
        }
    }
}
