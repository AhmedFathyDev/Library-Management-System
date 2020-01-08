/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operations;

import javax.swing.JOptionPane;
import main.Data;

/**
 * @author Fathy & Najm
 */
public class DisplayAvaliableCopiesForSpecificPublication implements Operation {

    private short ID;

    private Search search;

    public DisplayAvaliableCopiesForSpecificPublication(short ID) {
        this.ID = ID;
        this.search = new Search(ID);
        this.search.operation();
    }

    @Override
    public void operation() {
        if (this.search.isExist()) {
            JOptionPane.showConfirmDialog(null, "The number of avaliable copies is: "
                    + Data.publications.get(this.search.getPublicationIndex()
                    ).getNumberOfAvaliableCopies());
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
