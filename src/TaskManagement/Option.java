/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskManagement;

import HandyExpense.Expense;
import java.util.ArrayList;

/**
 *
 * @author Bui Dat
 */
public class Option {

    public void display(ArrayList<Task> list) {
        System.out.printf("%s%20s%20s%20s%20s%20s%20s", "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer\n");
        for (Task o : list) {
            System.out.println(o);
            
        }
    }

    public void add(ArrayList<Task> list, int id, String name, int typeID, String date, double from, double to, String assignee, String reviewer) {
        list.add(new Task(id, name, typeID, date, from, to, assignee, reviewer));
    }

    public void remove(ArrayList<Task> list, int id) {
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
