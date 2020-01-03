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
			String noon, String evening, String atBedtime, String unit, String instructions, String indication) {
		
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