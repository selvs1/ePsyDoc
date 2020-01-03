package ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Drug {
	@Id
	@GeneratedValue
	private int drugID;

	@OneToOne(mappedBy = "drug")
	private Medication medication;

	private String activeIngridient;
	private String brandName;
	private String strength;
	private String form;
	private String indication;
	private String instruction;
	private String unit;

	public Drug() {

	}

	public Drug(String activeIngridient, String brandName, String strength, String form, String unit,
			String instruction, String indication) {
		this.activeIngridient = activeIngridient;
		this.brandName = brandName;
		this.strength = strength;
		this.form = form;
		this.indication = indication;
		this.instruction = instruction;
		this.unit = unit;
	}

	public String getactiveIngridient() {
		return activeIngridient;
	}

	public void setactiveIngridient(String activeIngridient) {
		this.activeIngridient = activeIngridient;
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

	public String getIndication() {
		return indication;
	}

	public void setIndication(String indication) {
		this.indication = indication;
	}

	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "drug [activeIngridient=" + activeIngridient + ", brandName=" + brandName + ", strength=" + strength
				+ ", form=" + form + "]";
	}

	public String activeIngridientToString() {
		return this.getactiveIngridient();
	}

}