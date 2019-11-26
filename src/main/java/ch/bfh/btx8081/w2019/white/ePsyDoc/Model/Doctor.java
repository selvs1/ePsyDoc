package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import java.util.Date;

public class Doctor implements Person {

    private String name;
    private String username;
    private String password;



    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
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
