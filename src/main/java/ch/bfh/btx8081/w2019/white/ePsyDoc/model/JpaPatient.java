package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class JpaPatient {

	   private static final String PERSISTENCE_UNIT_NAME = "ePsyDoc";
	    private EntityManager em;

	    public JpaPatient() {
	        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
	    }

	    @SuppressWarnings("unchecked")
	    public void setUp() {
	        // Begin a new local transaction so that we can persist a new entity
	        EntityTransaction transaction = em.getTransaction();
	        transaction.begin();

	        // Read the existing entries
	        Query pPatient = em.createQuery("select p from Patient p");

	        // Do we have entries?
	        boolean createNewDoctorEntries = (pPatient.getResultList().size() == 0);

	        // No? so lets create new entries
	        if (createNewDoctorEntries) {
	            String[][] dataFeed = {
	                    {"Figo", "Luis", "Dorfmattweg 8z","05.09.1990","m","3110"},
	                    {"Roy", "Gelmi", "Musterstrasse 74","02.02.1990","m","4545"},
	                    {"Luca", "Toni", "Dorfmattweg 8z","01.05.1984","m","3110"},
	                    {"Kustrimovic", "Nemanja", "Alpenstrasse 74","05.05.1880","m","7895"},
	                    {"Kouassi", "Xavier", "Dorfmattweg 8z","01.01.2000","m","3110"},
	                    {"Mustermann", "Max", "Zürcherstrasse 44","03.01.1987","m","3110"},
	                    {"Weist", "Jennifer", "Dorfstrasse 8","01.01.1991","w","3110"},
	                    {"Mohadas", "Prathas", "Zentralstrasse 75","14.09.1980","m","3110"},
	                    {"Bracher", "Laura", "Zentralstrasse 74","30.08.1984","w","3110"},
	            };
	            
	           
	            
	            

	            for (int i = 0; i < dataFeed.length; i++) {
	            	Patient patient = new Patient();
	            	patient.setLastname(dataFeed[i][0]);
	            	patient.setFirstname(dataFeed[i][1]);
	            	patient.setAdress(dataFeed[i][2]);
	            	patient.setDate(new Date(Integer.parseInt(dataFeed[i][3].substring(6)), Integer.parseInt(dataFeed[i][3].substring(3, 5)),Integer.parseInt(dataFeed[i][3].substring(0, 2))));
	            	patient.setGender(dataFeed[i][4]);
	            	patient.setZip(dataFeed[i][5]);
	            
	                em.persist(patient);
	            }


	        }
	        em.flush();
	        transaction.commit();
	    }

	    public void checkPatient() {
	        // Go through each of the entities and print out each of their
	        // messages, as well as the date on which it was created
	        Query q = em.createQuery("select p from Patient p");

	        System.out.println("8 Patient, right? " + q.getResultList().size());
	    }

	    public void close() {
	        // It is always good practice to close the EntityManager so that resources
	        // are conserved.
	        EntityTransaction transaction = em.getTransaction();
	        transaction.begin();
//		Query q = em.createNativeQuery("SHUTDOWN COMPACT");
//		q.executeUpdate();
	        em.flush();
	        transaction.commit();
	        em.close();
	    }

	    public static void main(String[] args) {
	    	JpaPatient jpaPatient = new JpaPatient();
	    	jpaPatient.setUp();
	    	jpaPatient.checkPatient();
	    	jpaPatient.close();
	    }





	}


