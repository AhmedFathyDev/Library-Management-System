package operations;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import main.Data;
import main.Type;
import publications.Book;
import publications.Booklet;

/**
 * @author Fathy & Najm
 */
public class ReturnIssued implements Operation {

    private short ID;

    public ReturnIssued(short ID) {
        this.ID = ID;
    }

    @Override
    public void operation() {
        for (Issue issue : Data.publicationsIssued) {
            if (issue.getSearch().getID() == this.ID) {
                Data.publicationsIssued.remove(
                        issue.getSearch().getPublicationIndex());
                if (Data.publications.get(
                        issue.getSearch().getPublicationIndex()
                ).getClass().getSimpleName().equals(Type.getBOOK().getPublicationType())) {
                    if (System.currentTimeMillis() - issue.getIssueDate() > Book.getBorrowPeriod()) {
                        JFrame F = new JFrame();
                        JOptionPane.showConfirmDialog(F, "You have to pay", "Done", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showConfirmDialog(null, "Done");
                    }
                } else {
                    if (System.currentTimeMillis() - issue.getIssueDate() > Booklet.getBorrowPeriod()) {
                        JFrame F = new JFrame();
                        JOptionPane.showConfirmDialog(F, "You have to pay", "Done", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showConfirmDialog(null, "Done");
                    }
                }
                break;
            }
        }
    }

    public void setID(short ID) {
        this.ID = ID;
    }

    public short getID() {
        return ID;
    }

}
