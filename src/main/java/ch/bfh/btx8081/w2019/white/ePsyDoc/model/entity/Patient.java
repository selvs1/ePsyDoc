package ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Patient {
	@Id
	@GeneratedValue
	private int patientID;

	@OneToMany(mappedBy = "patient")
	private List<Appointment> appointments = new ArrayList<>();

	// todo: diese Verbindung ist gemäss ER nicht vorgesehen. Noch mit Gruppe anschauen.
	@OneToMany(mappedBy = "patient")
	private List<PatientCase> patientCaseList; //todo: evtl. in patientCases unbenennen


	private String lastname;
	private String firstname;
	private String gender;
	private Date date;
	private String adress;
	private String zip;



	public Patient() {

	}

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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}



	public void createPatientCase(String patientCaseID, int patientID) {
		PatientCase patientCase = new PatientCase(patientCaseID, patientID);
		patientCaseList.add(patientCase);
	}

	public List<PatientCase> getPatientCaseList() {
		return patientCaseList;
	}

	public void setPatientCaseList(List<PatientCase> patientCaseList) {
		this.patientCaseList = patientCaseList;
	}

	public PatientCase getPatientCase(String patientCaseID) {
		PatientCase returnPatientCase = null;
		for (PatientCase patientCase : patientCaseList) {
			if (patientCase.getPatientcaseID().equalsIgnoreCase(patientCaseID)) {
				returnPatientCase = patientCase;
			}
		}
		return returnPatientCase;
	}

	public PatientCase getPatientCaseAtIndex(int index) {
		return patientCaseList.get(index);

	}

	public PatientCase getLastPatientCase() {
		return getPatientCaseAtIndex(patientCaseList.size()-1);
	}

	public PatientCase getPatientCaseFromPatientCaseID(String patientCaseID) {
		PatientCase p = null;
		for (PatientCase patientCase : patientCaseList) {
			if (patientCase.getPatientcaseID().equalsIgnoreCase(patientCaseID)) {
				p = patientCase;
			}
		}
		return p;

	}

	public void addPatientCase(String patientCaseID) {
		patientCaseList.add(new PatientCase(patientCaseID, this.patientID));
	}

	public void removePatientCase(String patientCaseID) {
		patientCaseList.remove(getPatientCaseFromPatientCaseID(patientCaseID));
	}

}
