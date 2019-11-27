package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

public class PatientModel {

	private int patientID;
	private String lastname;
	private String firstname;
	private String gender;
	private String date;
	private String adress;
	private String zip;

	public PatientModel(int patientID, String lastname, String firstname, String gender, String date, String adress,
			String zip) {

		this.patientID = patientID;
		this.lastname = lastname;
		this.firstname = firstname;
		this.gender = gender;
		this.date = date;
		this.adress = adress;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getZIP() {
		return zip;
	}

	public void setZIP(String zip) {
		this.zip = zip;
	}

}
