package persons;

import javax.swing.JOptionPane;

/**
 * @author Fathy & Najm
 */
public abstract class Person {

    private static short personID = 0;

    private String name;

    private short ID;

    public Person() {
        Person.personID++;
    }

    public void addPerson() {
        this.name = JOptionPane.showInputDialog("Enter the name");
        this.ID = Person.personID;
    }

    public static void setPersonID(short personID) {
        Person.personID = personID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(short ID) {
        this.ID = ID;
    }

    public static short getPersonID() {
        return personID;
    }

    public String getName() {
        return name;
    }

    public short getID() {
        return ID;
    }

}
