package ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Drug class with all functions.
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
public class Drug {
	// Variables and database settings
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	/**
	 * Empty constructor for Service class.
	 */
	public Drug() {
	}

	/**
	 * Constructor to create a Drug object.
	 */
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

	/**
	 * Return the activeIngridient.
	 * 
	 * @return activeIngridient.
	 */
	public String getactiveIngridient() {
		return activeIngridient;
	}

	/**
	 * Set the active Ingridient
	 * 
	 * @param activeIngridient get activeIngridient.
	 */
	public void setactiveIngridient(String activeIngridient) {
		this.activeIngridient = activeIngridient;
	}

	/**
	 * Return the brandName.
	 * 
	 * @return brandName.
	 */
	public String getbrandName() {
		return brandName;
	}

	/**
	 * Set the brandName.
	 * 
	 * @param brandName get brandName.
	 */
	public void setbrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * Return the strength.
	 * 
	 * @return strength.
	 */
	public String getstrength() {
		return strength;
	}

	/**
	 * Set the strength.
	 * 
	 * @param strength get strength.
	 */
	public void setstrength(String strength) {
		this.strength = strength;
	}

	/**
	 * Return the form.
	 * 
	 * @return form.
	 */
	public String getform() {
		return form;
	}

	/**
	 * Set the form.
	 * 
	 * @param form get form.
	 */
	public void setform(String form) {
		this.form = form;
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
	 * Set the indication.
	 * 
	 * @param indication get indication.
	 */
	public void setIndication(String indication) {
		this.indication = indication;
	}

	/**
	 * Return the instruction.
	 * 
	 * @return instruction.
	 */
	public String getInstruction() {
		return instruction;
	}

	/**
	 * Set the instruction.
	 * 
	 * @param instruction get instruction.
	 */
	public void setInstruction(String instruction) {
		this.instruction = instruction;
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
	 * Set the unit.
	 * 
	 * @param unit get unit.
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
}