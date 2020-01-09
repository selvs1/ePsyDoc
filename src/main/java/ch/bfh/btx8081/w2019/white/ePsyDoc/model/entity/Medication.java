package ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Medication class with all functions.
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
public class Medication {
	// Variables and database settings
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	/**
	 * Empty constructor for Service class.
	 */
	public Medication() {
	}

	/**
	 * Constructor to create a Medication object.
	 */
	public Medication(String activeIngredient, String brandName, String strength, String form, String morning,
			String noon, String evening, String atBedtime, String unit, String instructions, String indication,
			PatientCase patientCase) {
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
		this.patientCase = patientCase;
	}

	/**
	 * Return the medicationID.
	 * 
	 * @return medicationID.
	 */
	public int getMedicationID() {
		return medicationID;
	}

	/**
	 * Set the medicationID
	 * 
	 * @param medicationID get medicationID.
	 */
	public void setMedicationID(int medicationID) {
		this.medicationID = medicationID;
	}

	/**
	 * Return the activeIngredient.
	 * 
	 * @return activeIngredient.
	 */
	public String getActiveIngredient() {
		return activeIngredient;
	}

	/**
	 * Set the activeIngredient
	 * 
	 * @param activeIngredient get activeIngredient.
	 */
	public void setActiveIngredient(String activeIngredient) {
		this.activeIngredient = activeIngredient;
	}

	/**
	 * Return the brandName.
	 * 
	 * @return brandName.
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * Set the brandName
	 * 
	 * @param brandName get brandName.
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * Return the strength.
	 * 
	 * @return strength.
	 */
	public String getStrength() {
		return strength;
	}

	/**
	 * Set the strength
	 * 
	 * @param strength get strength.
	 */
	public void setStrength(String strength) {
		this.strength = strength;
	}

	/**
	 * Return the form.
	 * 
	 * @return form.
	 */
	public String getForm() {
		return form;
	}

	/**
	 * Set the form
	 * 
	 * @param form get form.
	 */
	public void setForm(String form) {
		this.form = form;
	}

	/**
	 * Return the unit.
	 * 
	 * @return unit.
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * Set the unit
	 * 
	 * @param unit get unit.
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * Return the instructions.
	 * 
	 * @return instructions.
	 */
	public String getInstructions() {
		return instructions;
	}

	/**
	 * Set the instructions
	 * 
	 * @param instructions get instructions.
	 */
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	/**
	 * Return the indication.
	 * 
	 * @return indication.
	 */
	public String getIndication() {
		return indication;
	}

	/**
	 * Set the indication
	 * 
	 * @param indication get indication.
	 */
	public void setIndication(String indication) {
		this.indication = indication;
	}

	/**
	 * Return the morning.
	 * 
	 * @return morning.
	 */
	public String getMorning() {
		return morning;
	}

	/**
	 * Set the morning
	 * 
	 * @param morning get morning.
	 */
	public void setMorning(String morning) {
		this.morning = morning;
	}

	/**
	 * Return the noon.
	 * 
	 * @return noon.
	 */
	public String getNoon() {
		return noon;
	}

	/**
	 * Set the noon
	 * 
	 * @param noon get noon.
	 */
	public void setNoon(String noon) {
		this.noon = noon;
	}

	/**
	 * Return the evening.
	 * 
	 * @return evening.
	 */
	public String getEvening() {
		return evening;
	}

	/**
	 * Set the evening
	 * 
	 * @param evening get evening.
	 */
	public void setEvening(String evening) {
		this.evening = evening;
	}

	/**
	 * Return the atBedtime.
	 * 
	 * @return atBedtime.
	 */
	public String getAtBedtime() {
		return atBedtime;
	}

	/**
	 * Set the atBedtime
	 * 
	 * @param atBedtime get atBedtime.
	 */
	public void setAtBedtime(String atBedtime) {
		this.atBedtime = atBedtime;
	}
}