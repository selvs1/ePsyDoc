package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import java.util.ArrayList;
import java.util.List;

public class PatientModel {
	
	private int patientID;
	private String name;
	private String vorname;
	private String geschlecht;
	private String date;
	private String adresse;
	private String plz;

	
	
	
	public PatientModel(int patientID, String name, String vorname,String geschlecht, String date, String adresse, String plz ) {
		
		this.patientID =patientID;
		this.name = name;
		this.vorname = vorname;
		this.geschlecht = geschlecht;
		this.date = date;
		this.adresse =adresse;
		this.plz = plz;
		
		
		
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}
	
	

}
