package publications;

import javax.swing.JOptionPane;

/**
 * @author Fathy & Najm
 */
public abstract class Publication {

    private static short publicationsID = 0;
    private short ID;

    private short publishTime;
    private short numberOfCopies;
    private short numberOfIssuedCopies;

    private String name;
    private String publisher;

    public Publication() {
        Publication.publicationsID++;
    }

    public abstract void showPublicationInformation();

    public void addPublication() throws NumberFormatException {
        this.ID = Publication.publicationsID;
        this.name = JOptionPane.showInputDialog("Enter the name");
        this.publisher = JOptionPane.showInputDialog("Enter the publisher");
        this.numberOfCopies = Short.parseShort(JOptionPane.showInputDialog(
                "Enter the number of copies"
        ));
        this.numberOfIssuedCopies = 0;
    }

    public static void setPublicationsID(short publicationsID) {
        Publication.publicationsID = publicationsID;
    }

    public void setPublishTime(short publishTime) {
        this.publishTime = publishTime;
    }

    public void setID(short ID) {
        this.ID = ID;
    }

    public void setNumberOfCopies(short numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public void setNumberOfIssuedCopies(short numberOfIssuedCopies) {
        this.numberOfIssuedCopies += numberOfIssuedCopies;
        this.numberOfCopies = (short) (this.numberOfCopies - this.numberOfIssuedCopies);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public static short getPublicationsID() {
        return publicationsID;
    }

    public short getID() {
        return ID;
    }

    public short getNumberOfCopies() {
        return numberOfCopies;
    }

    public short getNumberOfIssuedCopies() {
        return numberOfIssuedCopies;
    }

    public String getName() {
        return name;
    }

    public String getPublisher() {
        return publisher;
    }

    public short getPublishTime() {
        return publishTime;
    }

    public short getNumberOfAvaliableCopies() {
        return (short) (this.numberOfCopies - this.numberOfIssuedCopies);
    }

}
