/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandyExpense;

import java.util.ArrayList;

/**
 *
 * @author devtd
 */
public class Option {

    public void add(ArrayList<Expense> list, int newId, String date, double amount, String content) {
        list.add(new Expense(newId, date, amount, content));
    }

    public void display(ArrayList<Expense> list) {
        System.out.printf("%s%20s%20s%20s", "ID", "Date", "Amount of Money", "Content\n");
        for (Expense o : list) {
            System.out.println(o);
        }
    }

    public void remove(ArrayList<Expense> list, int id) {
        boolean check = true;
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
                list.remove(i);
                check = false;
                System.out.println("Delete an expense succesfully");
                break;
            }
        }
        if (check == true) {
            System.out.println("Delete an expense fail");
        }
    }
}
