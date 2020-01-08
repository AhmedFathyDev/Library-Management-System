package operations;

import javax.swing.JOptionPane;
import main.Data;
import main.Type;
import publications.Book;
import publications.Booklet;
import publications.Magazine;

/**
 * @author Fathy & Najm
 */
public class Add implements Operation {

    private String publicationType;

    private Book book;
    private Booklet booklet;
    private Magazine magazine;

    public Add(String publicationType) {
        this.publicationType = publicationType;
    }

    @Override
    public void operation() {
        int tests = 0;
        do {
            if (tests > 0) {
                JOptionPane.showMessageDialog(null,
                        "The input is wrong try again"
                );
            }
            try {
                if (this.publicationType.equals(
                        Type.getBOOK().getPublicationType()
                )) {
                    this.book = new Book();
                    this.book.addPublication();
                } else if (this.publicationType.equals(
                        Type.getBOOKLET().getPublicationType()
                )) {
                    this.booklet = new Booklet();
                    this.booklet.addPublication();
                } else {
                    this.magazine = new Magazine();
                    this.magazine.addPublication();
                }
                break;
            } catch (NumberFormatException | AssertionError exception) {
                tests++;
            }
        } while (true);
    }

    public void addToArray() {
        if (this.publicationType.equals(Type.getBOOK().getPublicationType())) {
            Data.publications.add(book);
        } else if (this.publicationType.equals(
                Type.getBOOKLET().getPublicationType()
        )) {
            Data.publications.add(booklet);
        } else {
            Data.publications.add(magazine);
        }
        JOptionPane.showConfirmDialog(null, "Done");
    }

    public void setPublicationType(String publicationType) {
        this.publicationType = publicationType;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setBooklet(Booklet booklet) {
        this.booklet = booklet;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    public String getPublicationType() {
        return publicationType;
    }

    public Book getBook() {
        return book;
    }

    public Booklet getBooklet() {
        return booklet;
    }

    public Magazine getMagazine() {
        return magazine;
    }

}
