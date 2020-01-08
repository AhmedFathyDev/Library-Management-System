package main;

/**
 * @author Fathy & Najm
 */
public enum Password {

    PASSWORD("asd");

    private String password;

    private Password(String password) {
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Password getPASSWORD() {
        return PASSWORD;
    }

    public String getPassword() {
        return password;
    }

}
