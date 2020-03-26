package main;

import javax.swing.JOptionPane;
import operations.AdminActions;
import operations.StudentActions;
import persons.Admin;
import persons.Student;

/**
 * @author Fathy & Najm
 */
public class Main {

    public static void main(String[] args) {
        Start.people();
        Start.publications();
        Start.publicationsIssued();

        System.out.println("##############################"
                + "\tThe Library Management System\t##############################\n\n");
        short choice = 0;
        int tests = 0;

        System.out.println("\tIf you want to enter as a admin enter 1: -");
        System.out.println("\tIf you want to enter as a student enter 2: -\n");

        do {
            try {
                if (tests > 0) {
                    choice = Short.parseShort(JOptionPane.showInputDialog(
                            "The input is wrong try again\nEnter your choice"));
                } else {
                    choice = Short.parseShort(JOptionPane.showInputDialog(
                            "Enter your choice"));
                }
                assert choice < 3 && choice > 0;
                break;
            } catch (NumberFormatException | AssertionError exception) {
                tests++;
            }
        } while (true);

        switch (choice) {
            case 1:
                Admin admin = new Admin();
                admin.addPerson();
                Data.people.add(admin);
                Methods.Do(new AdminActions());
                break;
            default:
                Student student = new Student();
                student.addPerson();
                Data.people.add(student);
                Methods.Do(new StudentActions());
        }

        Close.people();
        Close.publications();
        Close.publicationsIssued();
    }

}
