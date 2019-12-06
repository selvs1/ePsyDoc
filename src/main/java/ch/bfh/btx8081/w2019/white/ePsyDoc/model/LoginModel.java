package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import ch.bfh.btx8081.w2019.white.ePsyDoc.entity.Doctor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for credential check. Later with database.
 *
 * @author Sugeelan Selvasingham
 */


public class LoginModel {
    private static final String PERSISTENCE_UNIT_NAME = "ePsyDoc";
    private EntityManager em;

    public LoginModel() {
        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    }

    List<Doctor> dataBaseDoctors = new ArrayList<>();

    //    private String username;
//    private String password;
//    private Doctor selectedDoctor;
    private boolean isLogged; // multiple user is not available


    public boolean isLogged() {
        return isLogged;
    }

//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    private int findDoctorInDataBase(String username) {

        for (int i = 0; i < dataBaseDoctors.size(); i++) {
            if (dataBaseDoctors.get(i).getUserName().equals(username)) {
                return i; //todo: what if there are persons with same name?
            }
        }
        return -1; //TODO: Exception necessary
    }

//    public Doctor getDoctor(String username, String password) {
//
//        int arrIndex = findDoctorInDataBase(username);
//
//        if (arrIndex != -1) {
//            if (checkPassword(arrIndex, password)) {
//                isLogged = true;
//                return dataBaseDoctors.get(findDoctorInDataBase(username));
//            }
//        }
//        return null; //todo: exception handling
//    }

    public boolean checkPassword(int arrIndex, String password) {
        return (dataBaseDoctors.get(arrIndex).getPassword().equals(password));
    }

//    public void search() {
//        selectedDoctor = getDoctor(username, password);
//    }


    public boolean checkCredential(String username, String password) {

        int arrIndex = findDoctorInDataBase(username);

        if (arrIndex != -1) {
            if (checkPassword(arrIndex, password)) {
                isLogged = true; // to mark this user as logged session
                return true;
            }
        }
        return false;
    }


    public void init() {
        //String firstname, String name, String username, String password
/*
        dataBaseDoctors.add(new Doctor("Sugeelan", "Selva", "selvs1", "gibbiX12345"));
        dataBaseDoctors.add(new Doctor("Janahan", "Sellathurai", "sellj1", "Sommer50"));
        dataBaseDoctors.add(new Doctor("Sugeelan", "Selva", "selvs1", "0000"));

*/


        // Begin a new local transaction so that we can persist a new entity
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

//        Query qDoctor = em.createQuery("select d from Doctor d");
//        boolean createNewDoctorEntries = (qDoctor.getResultList().size() == 0);
        if (2 == 2) {

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
                doctor.setFirstName(dataFeed[i][1]);
                doctor.setUserName(dataFeed[i][2]);
                doctor.setPassword("0000");
//                doctor.setBirthDate(new Date(""));
                doctor.setCity("Bern");
                doctor.setStreet("Hoehenweg");
                doctor.setZip("3000");

                em.persist(doctor);
            }


        }


        // Commit the transaction, which will cause the entity to be stored in the
        // database
        em.flush();
        transaction.commit();


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
        LoginModel test = new LoginModel();
        test.init();
        test.close();
    }


}
