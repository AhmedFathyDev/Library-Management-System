package operations;

import javax.swing.JOptionPane;
import main.Data;
import main.Type;

public class Modify implements Operation {

    private short ID;

    private Search search;

    public Modify(short ID) {
        this.ID = ID;
        this.search = new Search(ID);
        this.search.operation();
    }

    @Override
    public void operation() {
        if (this.search.isExist()) {
            try {
                String type = Data.publications.get(
                        this.search.getPublicationIndex()
                ).getClass().getSimpleName();
                if (type.equals(Type.getBOOK().getPublicationType())) {
                    Data.publications.set(
                            this.search.getPublicationIndex(),
                            new Add(type).getBook()
                    );
                } else if (type.equals(Type.getBOOK().getPublicationType())) {
                    Data.publications.set(
                            this.search.getPublicationIndex(),
                            new Add(type).getBooklet()
                    );
                } else {
                    Data.publications.set(
                            this.search.getPublicationIndex(),
                            new Add(type).getMagazine()
                    );
                }
            } catch (NumberFormatException | AssertionError exception) {
                JOptionPane.showMessageDialog(null,
                        "The input is wrong try again"
                );
                this.operation();
            }
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
