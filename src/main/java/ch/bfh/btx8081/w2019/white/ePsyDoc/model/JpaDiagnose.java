package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaDiagnose {

    private static final String PERSISTENCE_UNIT_NAME = "ePsyDoc";
    private EntityManager em;

    public JpaDiagnose() {
        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }

    @SuppressWarnings("unchecked")
    public void setUp() {
        // Begin a new local transaction so that we can persist a new entity
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // Read the existing entries
        Query qDiagnose = em.createQuery("select d from Diagnose d");

        // Do we have entries?
        boolean createNewDiagnoseEntries = (qDiagnose.getResultList().size() == 0);

        // No? so lets create new entries
        if (createNewDiagnoseEntries) {
            
        	Diagnosis dia1 = new Diagnosis("Refluxoesophagitis");
        	Diagnosis dia2 = new Diagnosis("Diabetes Mellitus Typ 2");
        	Diagnosis dia3 = new Diagnosis("Ikterus");
        	DiagnosisList dialist = new DiagnosisList();
        	dialist.addToDiagnosisList(dia1);
        	dialist.addToDiagnosisList(dia2);
        	dialist.addToDiagnosisList(dia3);
        	em.persist(dialist);
            }
        em.flush();
        transaction.commit();
    }

    public void checkDoctor() {
        Query q = em.createQuery("select d from diagnose d");

        System.out.println("3 Diagnoses, right? " + q.getResultList().size());
    }

    public void close() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.flush();
        transaction.commit();
        em.close();
    }

    public static void main(String[] args) {
        JpaDiagnose jpaMed = new JpaDiagnose();
        jpaMed.setUp();
        jpaMed.checkDoctor();
        jpaMed.close();
    }





}

