package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

public interface AppointmentView {
	interface AppointmentViewListener {

	}

	void addListener(AppointmentViewListener listener);
	void showPatientCase();
	void CalenderChange();
}
