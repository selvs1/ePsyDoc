package ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity;

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
public class Doctor  {
    @Id
    @GeneratedValue
    private int doctorID;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments = new ArrayList<>();

    @OneToMany(mappedBy = "doctor")
    private List<PatientCase> patientCaseList; 



    private String firstname;
    private String name;
    private String username; 
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

    
    public Date getBirthdate() {
        return birthdate;
    }

    
    public String getStreet() {
        return street;
    }

    
    public String getZip() {
        return zip;
    }

    
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
        return this.password.equals(password); 
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
