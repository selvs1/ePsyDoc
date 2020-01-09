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
 * Patient class with all functions.
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
public class Patient {
	// Variables and database settings
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientID;
	@OneToMany(mappedBy = "patient")
	private List<Appointment> appointments = new ArrayList<>();
	@OneToMany(mappedBy = "patient")
	private List<PatientCase> patientCaseList;
	private String lastname;
	private String firstname;
	private String gender;
	private Date date;
	private String adress;
	private String zip;

	/**
	 * Empty constructor for Service class.
	 */
	public Patient() {
	}

	/**
	 * Constructor for patients.
	 * 
	 * @param patientID get patient ID.
	 * @param lastname  get last name.
	 * @param firstname get first name.
	 * @param gender    get gender.
	 * @param date      get date.
	 * @param adress    get address.
	 * @param zip       get ZIP.
	 */
	public Patient(int patientID, String lastname, String firstname, String gender, Date date, String adress,
			String zip) {
		this.patientID = patientID;
		this.lastname = lastname;
		this.firstname = firstname;
		this.gender = gender.toUpperCase();
		this.date = date;
		this.adress = adress;
		this.zip = zip;
		patientCaseList = new ArrayList<PatientCase>();
	}

	/**
	 * Return ZIP.
	 * 
	 * @return ZIP.
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Set ZIP.
	 * 
	 * @param zip get ZIP.
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Return patient ID.
	 * 
	 * @return Patient ID.
	 */
	public int getPatientID() {
		return patientID;
	}

	/**
	 * Set patient ID.
	 * 
	 * @param patientID get patient ID.
	 */
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	/**
	 * Return last name.
	 * 
	 * @return Last name.
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Set last name.
	 * 
	 * @param lastname get last name.
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Return first name.
	 * 
	 * @return First name.
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Set first name.
	 * 
	 * @param firstname get first name.
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Return gender.
	 * 
	 * @return Gender.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Set gender.
	 * 
	 * @param gender get gender.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Return date.
	 * 
	 * @return Date.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Set date.
	 * 
	 * @param date get date.
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Return address.
	 * 
	 * @return Address.
	 */
	public String getAdress() {
		return adress;
	}

	/**
	 * Set address.
	 * 
	 * @param adress get address.
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}

	/**
	 * Return patient case list.
	 * 
	 * @return Patient case List.
	 */
	public List<PatientCase> getPatientCaseList() {
		return patientCaseList;
	}

	/**
	 * set patient case list.
	 * 
	 * @param patientCaseList get patient case list.
	 */
	public void setPatientCaseList(List<PatientCase> patientCaseList) {
		this.patientCaseList = patientCaseList;
	}
}