package persons;

import javax.swing.JOptionPane;
import static main.Password.PASSWORD;

/**
 * @author Fathy & Najm
 */
public class Admin extends Person {

    public Admin() {
    }

    @Override
    public void addPerson() {
        super.addPerson();
        String password;
        int tests = 0;
        do {
            if (tests > 0) {
                password = JOptionPane.showInputDialog(null,
                        "The password is wrong try again\n"
                        + "Enter the password"
                );
            } else {
                password = JOptionPane.showInputDialog("Enter the password");
            }
            if (password.equals(PASSWORD.getPassword())) {
                break;
            }
            tests++;
        } while (true);
    }
}
