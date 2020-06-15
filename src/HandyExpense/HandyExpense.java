/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandyExpense;

import J1.S.P0070.main;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author devtd
 */
public class HandyExpense {

    public void menu() {
        System.out.println("1. Add an expense");
        System.out.println("2. Display all expenses");
        System.out.println("3. Remove an expense");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HandyExpense he = new HandyExpense();
        Option op = new Option();
        CheckInput ci = new CheckInput();
        ArrayList<Expense> list = new ArrayList<>();
        list.add(new Expense(1, "20-Jul-2020", 100, "house"));
        list.add(new Expense(2, "21-Feb-2020", 100, "food"));
        list.add(new Expense(3, "22-Apr-2020", 120, "phone"));

        while (true) {
            he.menu();
            int choice = ci.getChoice();
            switch (choice) {
                case 1: //add
//                    int newId = 0;
//                    if (list.isEmpty()) {
//                        newId = 1;
//                    } else {
//                        int index = list.size() - 1;
//                        newId = list.get(index).getId() + 1;
//                    }
                    int index = list.size() - 1;
                    int newId = list.get(index).getId() + 1;
                    String date = ci.getDate();
                    double amount = ci.getAmount();
                    String content = ci.getContent();
                    op.add(list, newId, date, amount, content);
                    break;
                case 2: //display
                    op.display(list);
                    break;
                case 3: //remove
                    System.out.println("input remove id: ");
                    int idRemove = Integer.parseInt(sc.nextLine());
                    op.remove(list, idRemove);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
