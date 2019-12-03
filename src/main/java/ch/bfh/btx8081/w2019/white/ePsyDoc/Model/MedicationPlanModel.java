package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

import java.util.ArrayList;

public class MedicationPlanModel {
	
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
	
	ArrayList<MedicationPlanModel> mediplan = new ArrayList<MedicationPlanModel>();
	
	public MedicationPlanModel(String activeIngredient, String brandName, String strength, String form, String morning,
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

	public String getactiveIngredient() {
		return activeIngredient;
	}

	public void setactiveIngredient(String activeIngredient) {
		this.activeIngredient = activeIngredient;
	}

	public String getbrandName() {
		return brandName;
	}

	public void setbrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getstrength() {
		return strength;
	}

	public void setstrength(String strength) {
		this.strength = strength;
	}

	public String getform() {
		return form;
	}

	public void setform(String form) {
		this.form = form;
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

	public String getunit() {
		return unit;
	}

	public void setunit(String unit) {
		this.unit = unit;
	}

	public String getinstructions() {
		return instructions;
	}

	public void setinstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getindication() {
		return indication;
	}

	public void setindication(String indication) {
		this.indication = indication;
	}
	
	

}
