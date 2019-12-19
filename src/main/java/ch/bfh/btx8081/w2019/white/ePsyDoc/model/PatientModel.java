package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ch.bfh.btx8081.w2019.white.ePsyDoc.database.Database;
import ch.bfh.btx8081.w2019.white.ePsyDoc.database.Service;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.*;
import com.vaadin.flow.server.VaadinSession;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class PatientModel {
//    private EntityManager em;
//    private EntityTransaction transaction;

    private List<Patient> patientList = new ArrayList<Patient>();

    Service<Patient> patientService = new Service<>(new Patient());

    public PatientModel() {

    }

    public List<Patient> getPatientList() {
        return patientList;
    }



    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public Patient getPatient(int patientID) {
//        Patient returnPatient = null;
//        for (Patient patient : patientList) {
//            if (patient.getPatientID() == patientID) {
//                returnPatient = patient;
//            }
//        }
//        return returnPatient;

        return patientService.findByAttributeFirstElem("patientid", patientID);
    }


    public void init() {

//        patientService = new Service<>(new Patient());
        setPatientList(patientService.getEntityTable());

        //This code was replaced by code above
       /* em = Database.createEntityManager();
        transaction = em.getTransaction();
        transaction.begin();
        Query q = em.createQuery("select p from Patient p");
        setPatientList(q.getResultList());
        transaction.commit();
        em.close();*/
        // bis hier oben funktioniert


        Patient p = new Patient(1, "Muster", "Max", "M", new Date(2019, 4, 9), "Musterstrasse 34", "3333");
        patientList.add(p);
        p.createPatientCase("1.1", 1);
        PatientCase pc = p.getPatientCase("1.1");

        VaadinSession.getCurrent().setAttribute("patientID", "1");
        VaadinSession.getCurrent().setAttribute("patientFirstname", "Max");
        VaadinSession.getCurrent().setAttribute("patientName", "Muster");
        VaadinSession.getCurrent().setAttribute("patientCaseID", "1.1");
        VaadinSession.getCurrent().setAttribute("doctorID", "1");
        VaadinSession.getCurrent().setAttribute("doctorFirstname", "Doctor");
        VaadinSession.getCurrent().setAttribute("doctorName", "D");

        MedicationPlan mp = new MedicationPlan();
        Report r = pc.getReport();
        List<Diagnosis> d = r.getDiagnosisList();
        d.add(new Diagnosis("Keine psychische Störungen. Er darf sein Beruf als Pilot weiterhin ausüben"));
//		d.addToDiagnosisList(new Diagnosis("safsdfg"));


//		mp.addToMedicationPlan(new Medication("Ibuprofen 600mg", "IBUPROFEN AL akut 600mg Film-coated-tablet","","","","","600mg",
//							"Film-coated-tablet","Pcs","Take with a glas of water","Pain"));

        mp.getMedications().add(new Medication(
                        "Ibuprofen 600mg",
                        "IBUPROFEN AL akut 600mg Film-coated-tablet",
                        "",
                        "",
                        "",
                        "",
                        "600mg",
                        "Film-coated-tablet",
                        "Pcs",
                        "Take with a glas of water",
                        "Pain"
                )
        );

        pc.setMedicationplan(mp);
        HospIndex drugList = new HospIndex();


    }
}
