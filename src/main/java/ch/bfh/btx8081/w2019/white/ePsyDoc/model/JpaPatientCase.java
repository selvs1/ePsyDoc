package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Report;


//in progress
public class JpaPatientCase {

    private static final String PERSISTENCE_UNIT_NAME = "ePsyDoc";
    private EntityManager em;

    public JpaPatientCase() {
        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }

    @SuppressWarnings("unchecked")
    public void setUp() {
        // Begin a new local transaction so that we can persist a new entity
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // Read the existing entries
        Query qPatientCase = em.createQuery("select p from PatientCase p");

        // Do we have entries?
        boolean createNewPatientCaseEntries = (qPatientCase.getResultList().size() == 0);

        // No? so lets create new entries
        if (createNewPatientCaseEntries) {
            
        	PatientCase patc1 = new PatientCase();
        	
        	List patientCaseList = new ArrayList<PatientCase>();
        	PatientCase patientCase = new PatientCase();
        Patient patient = new Patient();
        patient.setLastname("Kouassi");
    	patient.setFirstname("Xavier");
    	patient.setAdress("Dorfmattweg 8z");
    	patient.setDate(new Date(2000, 1,1));
    	patient.setGender("m");
    	patient.setZip("3110");
    	
   
    	Doctor doctor = new Doctor();
        doctor.setName("Nippel");
        doctor.setFirstname("Alain");
        doctor.setUsername("nippa1");
        doctor.setPassword("0000");
        doctor.setCity("Bern");
        doctor.setStreet("Hoehenweg");
        doctor.setZip("3000");
    	patientCase.setDoctor(doctor);
    	patientCase.setDiagnosis(new Report());
//    	patientCase.setPatient(patient);
    	patientCase.setPatientID(55);
    	
   
        	patientCaseList.add(patientCase);
        	em.persist(patientCaseList);
            }
        em.flush();
        transaction.commit();
    }

    public void checkDoctor() {
    	
        Query q = em.createQuery("select p from PatientCase p");

        System.out.println("1 PatientCases, right? " + q.getResultList().size());
    }

    public void close() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.flush();
        transaction.commit();
        em.close();
    }

    public static void main(String[] args) {
        JpaPatientCase jpaMed = new JpaPatientCase();
        jpaMed.setUp();
        jpaMed.checkDoctor();
        jpaMed.close();
    }





}

