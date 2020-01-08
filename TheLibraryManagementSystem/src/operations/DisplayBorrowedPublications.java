package operations;

import main.Data;

/**
 * @author Fathy & Najm
 */
public class DisplayBorrowedPublications implements Operation {

    public DisplayBorrowedPublications() {

    }

    @Override
    public void operation() {
        for (Issue issued : Data.publicationsIssued) {
            System.out.print(Data.publications.get(
                    issued.getSearch().getPublicationIndex()).getClass().getSimpleName());
            System.out.print(" : ");
            System.out.println(Data.publications.get(
                    issued.getSearch().getPublicationIndex()).getName());
        }
    }

}
