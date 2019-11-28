package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import java.util.Date;
import java.util.Random;

/**
 * This is a concret class for a doctor.
 *
 * @author Sugeelan Selvasingham
 * */
public class Doctor implements Person {

    private int emplId;
    private String firstName;
    private String name;
    private String userName;
    private String password;

    private Date birthDate;
    private String street;
    private String zip;
    private String city;


    /**
     * Create a Doctor object either with or without (see below) id.
     * @param id This is the id which is relevant for the database.
     * */
    public Doctor(int id, String firstName, String name, String userName, String password) {
        this(firstName, name, userName, password);
        this.emplId = id;
    }

    /**
     * Without id information a random generator creates an id.
     *
     */
    public Doctor(String firstName, String name, String userName, String password) {

        this.emplId = new Random().nextInt(100);
        this.firstName = firstName;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public Doctor(int id, String firstName, String name, String userName, String password, Date birthDate, String street, String zip, String city) {
        this(id, firstName, name, userName, password);
        this.birthDate = birthDate;
        this.street = street;
        this.zip = zip;
        this.city = city;
    }



    public int getEmplId() {
        return emplId;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public String getZip() {
        return zip;
    }

    @Override
    public String getCity() {
        return city;
    }
}
