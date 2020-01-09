package ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Diagnosis class with all functions.
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
public class Diagnosis {
	// Variables and database settings
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int diagnosisID;
	@ManyToOne
	private PatientCase patientCase;
	private String diagnosis;

	/**
	 * Empty constructor for Service class.
	 */
	public Diagnosis() {

	}

	/**
	 * Constructor of diagnosis.
	 * 
	 * @param patientCase get patient case.
	 * @param diagnosis   get diagnosis.
	 */
	public Diagnosis(PatientCase patientCase, String diagnosis) {
		this.patientCase = patientCase;
		this.diagnosis = diagnosis;
	}

	/**
	 * Return diagnosis.
	 * 
	 * @return Diagnosis.
	 */
	public String getDiagnosis() {
		return diagnosis;
	}

	/**
	 * Set diagnosis.
	 * 
	 * @param diagnosis get diagnosis.
	 */
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	/**
	 * Return diagnosis ID.
	 * 
	 * @return diagnosis ID.
	 */
	public int getDiagnosisID() {
		return diagnosisID;
	}

	/**
	 * Set diagnosis ID.
	 * 
	 * @param diagnosisID get diagnosis ID.
	 */
	public void setDiagnosisID(int diagnosisID) {
		this.diagnosisID = diagnosisID;
	}

	/**
	 * Return patient case.
	 * 
	 * @return Patient case.
	 */
	public PatientCase getPatientCase() {
		return patientCase;
	}

	/**
	 * Set patient case.
	 * 
	 * @param patientCase get patient case.
	 */
	public void setPatientCase(PatientCase patientCase) {
		this.patientCase = patientCase;
	}
}
