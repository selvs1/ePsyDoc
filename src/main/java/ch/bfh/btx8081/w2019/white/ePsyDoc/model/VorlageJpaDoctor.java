package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VorlageJpaDoctor {

    private static final String PERSISTENCE_UNIT_NAME = "ePsyDoc";
    private EntityManager em;

    public VorlageJpaDoctor() {
        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }

    @SuppressWarnings("unchecked")
    public void setUp() {
        // Begin a new local transaction so that we can persist a new entity
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // Read the existing entries
        Query qDoctor = em.createQuery("select d from Doctor d");

        // Do we have entries?
        boolean createNewDoctorEntries = (qDoctor.getResultList().size() == 0);

        // No? so lets create new entries
        if (createNewDoctorEntries) {
            String[][] dataFeed = {
                    {"Gaupp", "David", "gaupa1"},
                    {"Miletic", "Marko", "milem2"},
                    {"Selvasingham", "Sugeelan", "selvs1"},
                    {"Velkov", "Viktor", "velkv1"},
                    {"Janahan", "Sellathurai", "sellj1"},
                    {"Alain", "Nippel", "nippa1"},
            };

            for (int i = 0; i < dataFeed.length; i++) {

                Doctor doctor = new Doctor();
                doctor.setName(dataFeed[i][0]);
                doctor.setFirstname(dataFeed[i][1]);
                doctor.setUsername(dataFeed[i][2]);
                doctor.setPassword("0000");
//                doctor.setBirthDate(new Date(""));
                doctor.setCity("Bern");
                doctor.setStreet("Hoehenweg");
                doctor.setZip("3000");

                em.persist(doctor);
            }

/* Klasse Person hat mehrere Jobs
  @OneToMany
  private List<Job> jobList = new ArrayList<Job>();
  Bei der Persistierung aus einer anderen Query

      if (createNewEntries) {
            Family family = new Family();
            em.persist(family);
            family.setDescription("Family for the Knopfs");
            for (int i = 0; i < 40; i++) {
                ch.bfh.btx8081.w2019.white.jpaTests.Person person = new Person();
                person.setFirstName("Jim_" + i);
                person.setLastName("Knopf_" + i);
                em.persist(person);
                person.setFamily(family);
                // Now persists the family person relationship
                family.getMembers().add(person);
                em.persist(person);
                em.persist(family);
                person.setJobList(qJob.getResultList());
                em.persist(person);
            }
        }*/

            // Commit the transaction, which will cause the entity to be stored in the
            // database
        }
        em.flush();
        transaction.commit();
    }

    public void checkDoctor() {
        // Go through each of the entities and print out each of their
        // messages, as well as the date on which it was created
        Query q = em.createQuery("select d from Doctor d");

        System.out.println("6 Doctors, right? " + q.getResultList().size());
    }

    public void close() {
        // It is always good practice to close the EntityManager so that resources
        // are conserved.
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
//	Query q = em.createNativeQuery("SHUTDOWN COMPACT");
//	q.executeUpdate();
        em.flush();
        transaction.commit();
        em.close();
    }

    public static void main(String[] args) {
        VorlageJpaDoctor vorlage = new VorlageJpaDoctor();
        vorlage.setUp();
        vorlage.checkDoctor();
        vorlage.close();
    }





}

