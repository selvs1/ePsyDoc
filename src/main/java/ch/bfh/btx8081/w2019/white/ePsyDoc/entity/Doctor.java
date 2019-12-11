package ch.bfh.btx8081.w2019.white.ePsyDoc.entity;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.Appointment;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * This is a concret class for a doctor.
 *
 * @author Sugeelan Selvasingham
 */
@Entity
public class Doctor implements Person {
    @Id
    @GeneratedValue
    private int doctorID;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments = new ArrayList<>();


    // todo: diese Verbindung ist gemäss ER nicht vorgesehen. Noch mit Gruppe anschauen.
    @OneToMany(mappedBy = "doctor")
    private List<PatientCase> patientCaseList; //todo: evtl. in patientCases unbenennen



    private String firstname;
    private String name;
    private String username; //todo: change name to username and firstname and birthdate
    private String password;

    private Date birthdate;
    private String street;
    private String zip;
    private String city;



    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setCity(String city) {
        this.city = city;
    }


    /**
     * Create a Doctor object either with or without (see below) id.
     *
     * @param id This is the id which is relevant for the database.
     */
//    public Doctor(int id, String firstName, String name, String userName, String password) {
//        this(firstName, name, userName, password);
//        this.emplId = id;
//    }

    /**
     * Without id information a random generator creates an id.
     */
//    public Doctor(String firstName, String name, String userName, String password) {
//
//        this.emplId = new Random().nextInt(100);
//        this.firstName = firstName;
//        this.name = name;
//        this.userName = userName;
//        this.password = password;
//    }

//    public Doctor(int id, String firstName, String name, String userName, String password, Date birthDate, String street, String zip, String city) {
//        this(id, firstName, name, userName, password);
//        this.birthDate = birthDate;
//        this.street = street;
//        this.zip = zip;
//        this.city = city;
//    }
    public int getDoctorID() {
        return doctorID;
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
        return birthdate;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstname(String firstName) {
        this.firstname = firstName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean validPassword(String password) {
        return this.password.equals(password); //todo: build a encryption mechanism to prevent plaintext password in db
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<PatientCase> getPatientCaseList() {
        return patientCaseList;
    }

    public void setPatientCaseList(List<PatientCase> patientCaseList) {
        this.patientCaseList = patientCaseList;
    }


}
