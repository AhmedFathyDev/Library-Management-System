package publications;

import javax.swing.JOptionPane;

/**
 * @author Fathy & Najm
 */
public class Book extends Publication {

    private static final long borrowPeriod = 1728000000;

    public Book() {
    }

    @Override
    public void showPublicationInformation() {
        System.out.println("The name is: " + this.getName());
        System.out.println("The ID is: " + this.getID());
        System.out.println("The publisher is: " + this.getPublisher());
        System.out.println("The publish year is: " + this.getPublishTime());
        System.out.println(
                "The number of avaliable copies is: "
                + this.getNumberOfAvaliableCopies()
        );
        System.out.println(
                "The number of issued copies is: "
                + this.getNumberOfIssuedCopies()
        );
        System.out.println();
    }

    @Override
    public void addPublication() throws NumberFormatException, AssertionError {
        super.addPublication();
        this.setPublishTime(Short.parseShort(JOptionPane.showInputDialog(
                "Enter the publish year"
        )));
        assert this.getPublishTime() > 0 && this.getPublishTime() < 2021;
    }

    public static long getBorrowPeriod() {
        return borrowPeriod;
    }

}
