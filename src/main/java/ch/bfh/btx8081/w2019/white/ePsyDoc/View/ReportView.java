package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.PatientModel;

public interface ReportView {
	
	interface ReportViewListener {
		void clickNewReport(Doctor doctor, PatientModel patient);

	}

	void addListener(ReportViewListener listener);

}
