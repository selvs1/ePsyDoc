package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

public class Diagnosis {
	private String diagnosis;
	
	public Diagnosis(String diagnosis){
	this.diagnosis = diagnosis;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	@Override
	public String toString() {
	return diagnosis;
	}

}
