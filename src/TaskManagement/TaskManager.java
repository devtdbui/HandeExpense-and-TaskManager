/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaskManagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Bui Dat
 */
public class TaskManager {

    public void menu() {
        System.out.println("========= Task program =========");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. Display Task");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>();
        CheckInput ci = new CheckInput();
        Option op = new Option();
        list.add(new Task(1, "Review Program", 1, "20 - 03 - 2020", 8, 17, "Dev", "Lead"));
        list.add(new Task(2, "Design Program", 2, "25 - 06 - 2020", 10, 17, "Desgin", "Lead"));
        list.add(new Task(3, "Test Program", 3, "30 - 02 - 2020", 9, 16, "Test", "Lead"));
        list.add(new Task(4, "Dev Program", 4, "10 - 01 - 2020", 11, 17, "Dev", "Lead"));
        while (true) {
            tm.menu();
            int choice = ci.getChoice();
            switch (choice) {
                case 1:
                    //add
                    int index = list.size() - 1;
                    int newId = list.get(index).getId() + 1;
                    String name = ci.getName();
                    int typeID = ci.getTypeID();
                    String date = ci.getDate();
                    double from = ci.getFrom();
                    double to = ci.getTo(from);
                    String assign = ci.getAssign();
                    String reviewer = ci.getReviewer();
                    op.add(list, newId, name, typeID, date, from, to, assign, reviewer);
                    break;
                case 2:
                    System.out.println("input remove id: ");
                    int idRemove = Integer.parseInt(sc.nextLine());
                    op.remove(list, idRemove);
                    break;
                case 3:
                    op.display(list);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
