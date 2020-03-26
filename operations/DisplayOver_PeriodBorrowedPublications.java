package operations;

import main.Data;
import main.Type;
import publications.Book;
import publications.Booklet;

/**
 * @author Fathy & Najm
 */
public class DisplayOver_PeriodBorrowedPublications implements Operation {

    public DisplayOver_PeriodBorrowedPublications() {
    }

    @Override
    public void operation() {
        for (Issue issued : Data.publicationsIssued) {
            String type = Data.publicationsIssued.get(
                    issued.getSearch().getPublicationIndex()
            ).getClass().getSimpleName();
            long borrowPeriod;
            if (type.equals(Type.getBOOK().getPublicationType())) {
                borrowPeriod = Book.getBorrowPeriod();
            } else {
                borrowPeriod = Booklet.getBorrowPeriod();
            }
            if (System.currentTimeMillis() - issued.getIssueDate() > borrowPeriod) {
                System.out.print(type);
                System.out.print(" : ");
                System.out.println(Data.publications.get(
                        issued.getSearch().getPublicationIndex()).getName());
            }
        }
    }
}
