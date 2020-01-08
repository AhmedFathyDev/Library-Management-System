package operations;

import main.Data;
import publications.Publication;

/**
 * @author Fathy & Najm
 */
public class DisplayAvaliablePublications implements Operation {

    public DisplayAvaliablePublications() {
    }

    @Override
    public void operation() {
        for (Publication publication : Data.publications) {
            if (publication.getNumberOfAvaliableCopies() > 0) {
                System.out.print(publication.getClass().getSimpleName());
                System.out.print(" : ");
                System.out.println(publication.getName());
            }
        }
    }
}
