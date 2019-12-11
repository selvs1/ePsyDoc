package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import java.util.ArrayList;
import java.util.List;

public class DiagnosisList {
	//todo: nicht mehr notwendig mit jpa oder? - lg sugi
	private List<Diagnosis> diagnosisList;
	
	public DiagnosisList() {
		diagnosisList = new ArrayList<>();
	}

	public List<Diagnosis> getDiagnosisList() {
		return diagnosisList;
	}

	public void setDiagnosisList(List<Diagnosis> diagnosisList) {
		this.diagnosisList = diagnosisList;
	}
	
	public void addToDiagnosisList(Diagnosis diagnosis) {
		diagnosisList.add(diagnosis);
	}
	
	public void RemoveFromDiagnosisList(Diagnosis diagnosis) {
		diagnosisList.remove(diagnosis);
	}
}
