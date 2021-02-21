package main;

/**
 * @author Fathy & Najm
 */
public enum Type {

    BOOK("Book"), BOOKLET("Booklet"), MAGAZINE("Magazine");

    private String publicationType;

    private Type(String publicationType) {
        this.publicationType = publicationType;
    }

    public void setPublicationType(String publicationType) {
        this.publicationType = publicationType;
    }

    public static Type getBOOK() {
        return BOOK;
    }

    public static Type getBOOKLET() {
        return BOOKLET;
    }

    public static Type getMAGAZINE() {
        return MAGAZINE;
    }

    public String getPublicationType() {
        return publicationType;
    }

}
