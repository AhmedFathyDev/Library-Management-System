package operations;

import javax.swing.JOptionPane;
import main.Data;

/**
 * @author Fathy & Najm
 */
public class Search implements Operation {

    private int publicationIndex;

    private short ID;

    private boolean exist = false;

    public Search(short ID) {
        this.ID = ID;
    }

    @Override
    public void operation() {
        for (int i = 0; i < Data.publications.size(); i++) {
            if (Data.publications.get(i).getID() == this.ID) {
                this.exist = true;
                this.publicationIndex = i;
                JOptionPane.showConfirmDialog(null, "The publication is exist");
                return;
            }
        }
        JOptionPane.showConfirmDialog(null, "The publication is not exist");
    }

    public void setID(short ID) {
        this.ID = ID;
    }

    public int getPublicationIndex() {
        return publicationIndex;
    }

    public short getID() {
        return ID;
    }

    public boolean isExist() {
        return exist;
    }

}
