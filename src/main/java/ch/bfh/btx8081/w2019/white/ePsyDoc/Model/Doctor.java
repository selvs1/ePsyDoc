package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import java.util.Date;

public class Doctor implements Person {

    private String firstname;
    private String name;
    private String username;
    private String password;


    public Doctor(String firstname, String name, String username, String password) {
        this.firstname = firstname;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public Date getBirthdate() {
        return null;
    }

    @Override
    public String getStreet() {
        return null;
    }

    @Override
    public String getZip() {
        return null;
    }

    @Override
    public String getCity() {
        return null;
    }
}
