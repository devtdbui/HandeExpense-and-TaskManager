/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0055;

import static J1.S.P0055.functionCheck.checkInputIntLimit;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DevBui
 */
class Controler {

    ArrayList<Doctor> listDoctors = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addDoctors() {
        System.out.println("Enter Code: ");
        String code = functionCheck.checkInputString();
        if (functionCheck.checkCodeExist(listDoctors, code) == false) {
            System.err.println("Code Exist!");
            return;
        }
        System.out.println("Enter Name: ");
        String name = functionCheck.checkInputString();
        System.out.println("Enter specialization: ");
        String specialization = functionCheck.checkInputString();
        System.out.println("Enter availability: ");
        int availability = functionCheck.checkInputInt();
        listDoctors.add(new Doctor(code, name, specialization, availability));
    }

    public void updateDoctors() {
        System.out.println("Enter Code: ");
        String code = functionCheck.checkInputString();
        if (functionCheck.checkCodeExist(listDoctors, code) == true) {
            System.err.println("Not Found Doctor!");
            return;
        }
        System.out.println("Enter Code: ");
        String codeUpdate = functionCheck.checkInputString();
        Doctor doctor = getDoctorFromCode(listDoctors, code);
        System.out.println("Enter Name: ");
        String nameUpdate = functionCheck.checkInputString();
        System.out.println("Enter specialization: ");
        String specializationUpdate = functionCheck.checkInputString();
        System.out.println("Enter availability: ");
        int availabilityUpdate = functionCheck.checkInputInt();
        listDoctors.add(new Doctor(code, nameUpdate, specializationUpdate, availabilityUpdate));

        doctor.setCode(codeUpdate);
        doctor.setName(nameUpdate);
        doctor.setSspecialization(specializationUpdate);
        doctor.setAvailability(availabilityUpdate);
        System.out.println("Update Successful");

    }

    public Doctor getDoctorFromCode(ArrayList<Doctor> listDoctors, String code) {
        for (Doctor doctor : listDoctors) {
            if (code.equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    public void deleteDoctors() {
        System.out.println("Enter Code: ");
        String code = functionCheck.checkInputString();
        Doctor doctor = getDoctorFromCode(listDoctors, code);
        if (doctor == null) {
            System.err.println("Not found doctor.");
            return;
        } else {
            listDoctors.remove(doctor);
        }
        System.err.println("Delete successful.");
    }

    public static ArrayList<Doctor> listFoundByName(ArrayList<Doctor> listDoctors, String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : listDoctors) {
            if (doctor.getName().contains(name)) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }

    public void searchDoctor() {
        System.out.print("Enter name: ");
        String nameSearch = functionCheck.checkInputString();
        ArrayList<Doctor> listFoundByName = listFoundByName(listDoctors, nameSearch);
        if (listFoundByName.isEmpty()) {
            System.err.println("List empty.");
        } else {
            System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                    "Specialization", "Availability");
            for (Doctor doctor : listFoundByName) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", doctor.getCode(),
                        doctor.getName(), doctor.getSspecialization(),
                        doctor.getAvailability());
            }
        }
    }

    public static int menu() {
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
        System.out.println("Enter your choice: ");
        int choice = checkInputIntLimit(1, 5);
        return choice;
    }
}
