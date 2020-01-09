package ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Doctor class with all functions.
 * 
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 */
@Entity
public class Doctor {
	// Variables and database settings
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	/**
	 * Empty constructor for Service class.
	 */
	public Doctor() {

	}

	/**
	 * Set the Password
	 * 
	 * @param password get password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Set the Birthdate.
	 * 
	 * @param birthdate get birthdate.
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * Set the street.
	 * 
	 * @param street get street.
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Set the zip.
	 * 
	 * @param zip get zip.
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Set the city.
	 * 
	 * @param city get city.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Return the Doctor ID.
	 * 
	 * @return doctorID.
	 */
	public int getDoctorID() {
		return doctorID;
	}

	/**
	 * Return the name.
	 * 
	 * @return name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return the firstname.
	 * 
	 * @return firstname.
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Return the password.
	 * 
	 * @return password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Return the username.
	 * 
	 * @return username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Return the birthdate.
	 * 
	 * @return birthdate.
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * Return the street.
	 * 
	 * @return street.
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Return the zip.
	 * 
	 * @return zip.
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Return the city.
	 * 
	 * @return city.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set the name.
	 *
	 * @param name get name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Set the firstname.
	 *
	 * @param firstname get firstname.
	 */
	public void setFirstname(String firstName) {
		this.firstname = firstName;
	}

	/**
	 * Set the username.
	 *
	 * @param username get username.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Check whether the password is valid or not.
	 *
	 * @param password the password to check.
	 */
	public boolean validPassword(String password) {
		return this.password.equals(password);
	}

	/**
	 * Set the doctorID.
	 *
	 * @param doctorID get doctorID.
	 */
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	/**
	 * Return the appointments.
	 * 
	 * @return appointments.
	 */
	public List<Appointment> getAppointments() {
		return appointments;
	}

	/**
	 * Set the appointments.
	 *
	 * @param appointments get appointments.
	 */
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	/**
	 * Return the patientCaseList.
	 * 
	 * @return patientCaseList.
	 */
	public List<PatientCase> getPatientCaseList() {
		return patientCaseList;
	}

	/**
	 * Set the patientCaseList.
	 *
	 * @param patientCaseList get patientCaseList.
	 */
	public void setPatientCaseList(List<PatientCase> patientCaseList) {
		this.patientCaseList = patientCaseList;
	}

}
