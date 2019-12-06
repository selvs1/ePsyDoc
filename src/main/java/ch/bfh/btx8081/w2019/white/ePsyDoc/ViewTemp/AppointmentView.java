package ch.bfh.btx8081.w2019.white.ePsyDoc.ViewTemp;

public interface AppointmentView {
	interface AppointmentViewListener {
	}

	void addListener(AppointmentViewListener listener);
	void showPatientCase();
	void CalenderChange();
}
