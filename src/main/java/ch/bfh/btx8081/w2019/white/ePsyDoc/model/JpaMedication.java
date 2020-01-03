package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Medication;

public class JpaMedication {

    private static final String PERSISTENCE_UNIT_NAME = "ePsyDoc";
    private EntityManager em;

    public JpaMedication() {
        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }

    @SuppressWarnings("unchecked")
    public void setUp() {
        // Begin a new local transaction so that we can persist a new entity
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // Read the existing entries
        Query qMedication = em.createQuery("select m from Medication m");

        // Do we have entries?
        boolean createNewMedicationEntries = (qMedication.getResultList().size() == 0);

        // No? so lets create new entries
        if (createNewMedicationEntries) {
            	
        	
        		Medication med1 = new Medication();
//        		med1.setbrandName("ALGIFOR-L Filmtabl 200 mg");
//        		med1.setactiveIngredient("Ibuprofen");
//        		med1.setstrength("200mg");
//        		med1.setform("Brausetablette");
//        		med1.setunit("3 Tage");
        		med1.setmorning("0");
        		med1.setevening("0");
//        		med1.setindication("Schmerz, Fieber");
        		med1.setnoon("0");
//        		med1.setinstructions("ohne ärtzliche Verschreibung: in 1 Glas kaltem oder warmen Wasser lösen");
        		em.persist(med1);
            }
        em.flush();
        transaction.commit();
    }

    public void checkDoctor() {
        Query q = em.createQuery("select m from Medication m");

        System.out.println("1 Medication, right? " + q.getResultList().size());
    }

    public void close() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.flush();
        transaction.commit();
        em.close();
    }

    public static void main(String[] args) {
        JpaMedication jpaMed = new JpaMedication();
        jpaMed.setUp();
        jpaMed.checkDoctor();
        jpaMed.close();
    }





}

