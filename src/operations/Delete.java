package operations;

import javax.swing.JOptionPane;
import main.Data;

/**
 * @author Fathy & Najm
 */
public class Delete implements Operation {

    private short ID;

    private Search search;

    public Delete(short ID) {
        this.ID = ID;
        this.search = new Search(ID);
        this.search.operation();
    }

    @Override
    public void operation() {
        if (this.search.isExist()) {
            Data.publications.remove(this.search.getPublicationIndex()
            ).showPublicationInformation();
            JOptionPane.showConfirmDialog(null, "Done");
        } else {
            JOptionPane.showConfirmDialog(null, "The publication is not exist");
        }
    }

    public void setID(short ID) {
        this.ID = ID;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    public short getID() {
        return ID;
    }

    public Search getSearch() {
        return search;
    }

}
