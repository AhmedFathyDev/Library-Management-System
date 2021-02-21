package operations;

import javax.swing.JOptionPane;
import main.Data;
import main.Methods;
import persons.Admin;

/**
 * @author Fathy & Najm
 */
public class StudentActions implements Operation {

    @Override
    public void operation() {

        short choice = 0;
        int tests = 0;

        System.out.println("\tIf you want to issue publication enter 1: -");
        System.out.println("\tIf you want to search for specific publication enter 2: -");
        System.out.println("\tIf you want to return issued publication enter 3: -");
        System.out.println("\tIf you want to display avaliable copies for specific publication enter 4: -");
        System.out.println("\tIf you want to reenter as a admin enter 5: -\n");

        do {
            try {
                if (tests > 0) {
                    choice = Short.parseShort(JOptionPane.showInputDialog(
                            "The input is wrong try again\nEnter your choice"));
                } else {
                    choice = Short.parseShort(JOptionPane.showInputDialog(
                            "Enter your choice"));
                }
                assert choice > 0 && choice < 6;
                break;
            } catch (NumberFormatException | AssertionError exception) {
                tests++;
            }
        } while (true);

        switch (choice) {
            case 1:
                Issue issue = new Issue(Methods.getID());
                issue.setStudentID(Methods.getID());
                Methods.Do(issue);
                Data.publicationsIssued.add(issue);
                break;
            case 2:
                Methods.Do(new Search(Methods.getID()));
                break;
            case 3:
                Methods.Do(new ReturnIssued(Methods.getID()));
                break;
            case 4:
                Methods.Do(new DisplayAvaliableCopiesForSpecificPublication(Methods.getID()));
                break;
            default:
                Admin admin = new Admin();
                admin.addPerson();
                Data.people.add(admin);
                Methods.Do(new AdminActions());
        }

        choice = 0;
        tests = 0;

        System.out.println("\tIf you want to do another operation enter 1: -");
        System.out.println("\tIf you want to reenter as a admin enter 2: -");
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
                Methods.Do(new StudentActions());
                break;
            case 2:
                Admin admin = new Admin();
                admin.addPerson();
                Data.people.add(admin);
                Methods.Do(new AdminActions());
        }
    }

}
