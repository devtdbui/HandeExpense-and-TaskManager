/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandyExpense;

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

    public double getAmount() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("input amount: ");
                double amount = Double.parseDouble(sc.nextLine());
                if (amount > 0) {
                    return amount;
                } else {
                    System.err.println("Amount must be greater 0: ");
                }
            } catch (Exception e) {
                System.err.println("invalid number, please input again: ");
            }

        }
    }

    public String getContent() {
        String content = "";
        while (true) {
            System.out.print("input content: ");
            content = sc.nextLine();
            if (!content.trim().equals("")) {
                return content;
            } else {
                System.out.println("empty content, please input again");
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
}
