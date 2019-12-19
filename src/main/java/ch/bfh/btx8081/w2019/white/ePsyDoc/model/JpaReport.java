package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Diagnosis;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaReport {

    private static final String PERSISTENCE_UNIT_NAME = "ePsyDoc";
    private EntityManager em;

    public JpaReport() {
        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }

    @SuppressWarnings("unchecked")
    public void setUp() {
        // Begin a new local transaction so that we can persist a new entity
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // Read the existing entries
        Query qReport = em.createQuery("select r from Report r");

        // Do we have entries?
        boolean createNewReportEntries = (qReport.getResultList().size() == 0);

        // No? so lets create new entries
        if (createNewReportEntries) {
            	
        	DiagnosisList diagnosen = new DiagnosisList();
        	diagnosen.addToDiagnosisList(new Diagnosis("Refluxoesophagitis"));
        	diagnosen.addToDiagnosisList(new Diagnosis("Kammerfilmmer"));
			Report report = new Report();
    		report.setDoctorID(42);
//    		report.setDiagnosisList(diagnosen);
    		report.setReport("Dies dient als Test");
        	em.persist(report);
            }
        em.flush();
        transaction.commit();
    }

    public void checkDoctor() {
        Query q = em.createQuery("select r from Report r");

        System.out.println("1 Report, right? " + q.getResultList().size());
    }

    public void close() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.flush();
        transaction.commit();
        em.close();
    }

    public static void main(String[] args) {
        JpaReport jpaMed = new JpaReport();
        jpaMed.setUp();
        jpaMed.checkDoctor();
        jpaMed.close();
    }





}

