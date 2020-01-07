package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import java.sql.Date;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.AppointmentModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.AppointmentView;

public class AppointmentPresenter implements AppointmentView.AppointmentViewListener {
	private AppointmentModel model;
	private AppointmentView view;

	public AppointmentPresenter(AppointmentModel model, AppointmentView view) {
	        this.model = model;
	        this.view = view;
	        view.addListener(this);
	    }

	@Override
	public void loadAppointmentData(Date date) {
		model.setAppointmentList(date);
		view.displayAppointmentList(model.getAppointmentList());	
	}

	@Override
	public void setPatientCaseList(int patientID) {
		model.setPatientCaseList(patientID);
		view.displayPatientCaseList(model.getPatientCaseList());
	}
	@Override
	public void getPatientObject(int patientID) {
		model.setPatient(patientID);
		view.setPatient(model.getPatient());
		
	}

	@Override
	public void getDoctorObject(int doctorID) {
		model.setDoctor(doctorID);
		view.setDoctor(model.getDoctor());
	}

	@Override
	public void addPatientCase(PatientCase patientCase,int patientID) {
		model.addPatientCase(patientCase);
		model.setPatientCaseList(patientID);
		view.displayPatientCaseList(model.getPatientCaseList());
		
	}


}