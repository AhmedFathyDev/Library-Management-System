package main;

import javax.swing.JOptionPane;
import operations.Operation;

/**
 * @author Fathy & Najm
 */
public class Methods {

    public static void Do(Operation o) {
        o.operation();
    }

    public static short getID() {
        short ID;
        int tests = 0;
        do {
            try {
                if (tests > 0) {
                    ID = Short.parseShort(JOptionPane.showInputDialog(
                            "The input is wrong try again\nEnter the ID"
                    ));
                } else {
                    ID = Short.parseShort(JOptionPane.showInputDialog(
                            "Enter the ID"
                    ));
                }
                break;
            } catch (NumberFormatException exception) {
                tests++;
            }
        } while (true);
        return ID;
    }

    public static String getType() {
        int tests = 0;
        String publicationType;
        do {
            if (tests > 0) {
                publicationType = JOptionPane.showInputDialog(null,
                        "The input is wrong try again\nEnter the Type"
                );
            } else {
                publicationType = JOptionPane.showInputDialog(
                        "Enter the Type"
                );
            }
            if (publicationType.equals(Type.getBOOK().getPublicationType())
                    || publicationType.equals(
                            Type.getBOOKLET().getPublicationType())
                    || publicationType.equals(
                            Type.getMAGAZINE().getPublicationType())) {
                break;
            }
            tests++;
        } while (true);
        return publicationType;
    }

}
