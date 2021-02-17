package operations;

import javax.swing.JOptionPane;
import main.Data;
import main.Methods;
import persons.Student;

/**
 * @author Fathy & Najm
 */
public class AdminActions implements Operation {

    @Override
    public void operation() {

        short choice = 0;
        int tests = 0;

        System.out.println("\tIf you want to add publication enter 1: -");
        System.out.println("\tIf you want to delete publication enter 2: -");
        System.out.println("\tIf you want to modify publication enter 3: -");
        System.out.println("\tIf you want to search for specific publication enter 4: -");
        System.out.println("\tIf you want to display avaliable copies for specific publication enter 5: -");
        System.out.println("\tIf you want to display borrowed publications enter 6: -");
        System.out.println("\tIf you want to display over_period borrowed publication enter 7: -");
        System.out.println("\tIf you want to display avaliable publications enter 8: -");
        System.out.println("\tIf you want to reenter as a student enter 9: -\n");

        do {
            try {
                if (tests > 0) {
                    choice = Short.parseShort(JOptionPane.showInputDialog(
                            "The input is wrong try again\nEnter your choice"));
                } else {
                    choice = Short.parseShort(JOptionPane.showInputDialog(
                            "Enter your choice"));
                }
                assert choice > 0 && choice < 10;
                break;
            } catch (NumberFormatException | AssertionError exception) {
                tests++;
            }
        } while (true);

        switch (choice) {
            case 1:
                Add add = new Add(Methods.getType());
                Methods.Do(add);
                add.addToArray();
                break;
            case 2:
                Methods.Do(new Delete(Methods.getID()));
                break;
            case 3:
                Methods.Do(new Modify(Methods.getID()));
                break;
            case 4:
                Methods.Do(new Search(Methods.getID()));
                break;
            case 5:
                Methods.Do(new DisplayAvaliableCopiesForSpecificPublication(Methods.getID()));
                break;
            case 6:
                Methods.Do(new DisplayBorrowedPublications());
                break;
            case 7:
                Methods.Do(new DisplayOver_PeriodBorrowedPublications());
                break;
            case 8:
                Methods.Do(new DisplayAvaliablePublications());
                break;
            default:
                Student student = new Student();
                student.addPerson();
                Data.people.add(student);
                Methods.Do(new StudentActions());
        }

        choice = 0;
        tests = 0;

        System.out.println("\tIf you want to do another operation enter 1: -");
        System.out.println("\tIf you want to reenter as a student enter 2: -");
        System.out.println("\tIf you want to exit enter 3: -\n");

        do {
            try {
                if (tests > 0) {
                    choice = Short.parseShort(JOptionPane.showInputDialog(
                            "The input is wrong try again\nEnter your choice"));
                } else {
                    choice = Short.parseShort(JOptionPane.showInputDialog(
                            "Enter your choice"));
                }
                assert choice > 0 && choice < 4;
                break;
            } catch (NumberFormatException | AssertionError exception) {
                tests++;
            }
        } while (true);

        switch (choice) {
            case 1:
                Methods.Do(new AdminActions());
                break;
            case 2:
                Student student = new Student();
                student.addPerson();
                Data.people.add(student);
                Methods.Do(new StudentActions());
        }
    }

}
