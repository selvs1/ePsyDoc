package ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity;

import java.util.List;

import javax.persistence.*;

@Entity
public class Medication {
	@Id
	@GeneratedValue
	private int medicationID;

	@ManyToOne
	private PatientCase patientCase;
	@OneToOne
	private Drug drug;

	private String activeIngredient;
	private String brandName;
	private String strength;
	private String form;
	private String morning;
	private String noon;
	private String evening;
	private String atBedtime;
	private String unit;
	private String instructions;
	private String indication;

	public Medication() {

	}

	public Medication(String activeIngredient, String brandName, String strength, String form, String morning,
			String noon, String evening, String atBedtime, String unit, String instructions, String indication,PatientCase patientCase) {
		
		this.activeIngredient = activeIngredient;
		this.brandName = brandName;
		this.strength = strength;
		this.form = form;
		this.morning = morning;
		this.noon = noon;
		this.evening = evening;
		this.atBedtime = atBedtime;
		this.unit = unit;
		this.instructions = instructions;
		this.indication = indication;
		this.patientCase=patientCase;
	}	

	public int getMedicationID() {
		return medicationID;
	}

	public void setMedicationID(int medicationID) {
		this.medicationID = medicationID;
	}

	public String getActiveIngredient() {
		return activeIngredient;
	}

	public void setActiveIngredient(String activeIngredient) {
		this.activeIngredient = activeIngredient;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getIndication() {
		return indication;
	}

	public void setIndication(String indication) {
		this.indication = indication;
	}

	public String getmorning() {
		return morning;
	}

	public void setmorning(String morning) {
		this.morning = morning;
	}

	public String getnoon() {
		return noon;
	}

	public void setnoon(String noon) {
		this.noon = noon;
	}

	public String getevening() {
		return evening;
	}

	public void setevening(String evening) {
		this.evening = evening;
	}

	public String getatBedtime() {
		return atBedtime;
	}

	public void setatBedtime(String atBedtime) {
		this.atBedtime = atBedtime;
	}

}