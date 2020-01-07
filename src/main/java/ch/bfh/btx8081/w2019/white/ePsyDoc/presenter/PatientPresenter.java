package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.PatientModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.PatientView;

public class PatientPresenter implements PatientView.PatientViewListener {
    private PatientModel model;
    private PatientView view;

    public PatientPresenter(PatientModel model, PatientView view) {
        this.model = model;
        this.view = view;
        view.addListener(this);
    }

    @Override
    public void loadPatientList() {
        view.displayPatientList(model.getPatientList());
    }

	@Override
	public void setPatientCaseList(int patientID) {
		model.setPatientCaseList(patientID);
		view.displayPatientCaseList(model.getPatientCaseList());
	}


	@Override
	public void loadPatientCaseList() {
		view.displayPatientList(model.getPatientList());
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
