package ch.bfh.btx8081.w2019.white.ePsyDoc.Model;

public class Drug {

	private String activeIngridient;
	private String brandName;
	private String strength;
	private String form;

	public Drug(String activeIngridient, String brandName, String strength, String form) {
		setbrandName(brandName);
		setactiveIngridient(activeIngridient);
		setstrength(strength);
		setform(form);

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

	@Override
	public String toString() {
		return "drug [activeIngridient=" + activeIngridient + ", brandName=" + brandName + ", strength=" + strength
				+ ", form=" + form + "]";
	}

	public String activeIngridientToString() {
		return this.getactiveIngridient();
	}

}
