package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import ch.bfh.btx8081.w2019.white.ePsyDoc.database.Service;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.exceptions.DoctorException;
import com.vaadin.flow.server.VaadinSession;

/**
 * This class is responsible for credential check. Later with database.
 *
 * @author Sugeelan Selvasingham
 */


public class LoginModel {

//    private LoginService loginService = new LoginService(new Doctor());
//    private Service<Doctor> loginService = new Service<>(new Doctor());


    public static void login(String username, String password) throws DoctorException {
        Service<Doctor> ls = new Service<>(new Doctor());

        Doctor doctor = ls.findByAttributeFirstElem("username", username);

        if (doctor.validPassword(password)) {
            LoginModel.login(doctor);
//            String lastpage = (String) VaadinSession.getCurrent().getAttribute("lastPage"); // What was my last page visit?
//            if (lastpage != null) {
//
//            }
        } else {
            throw new DoctorException("invalid password");
        }

    }

    public static void login(Doctor d) {
        VaadinSession.getCurrent().setAttribute("doctorID", d.getDoctorID());
        VaadinSession.getCurrent().setAttribute("doctorFirstname", d.getFirstname());
        VaadinSession.getCurrent().setAttribute("doctorName", d.getName().substring(0,1));
//        UI.getCurrent().navigate(AppointmentViewImpl.class);

    }


//    List<Doctor> dataBaseDoctors = new ArrayList<>();

    //    private String username;
//    private String password;
//    private Doctor selectedDoctor;
//    private boolean isLogged; // multiple user is not available


//    public boolean isLogged() {
//        return isLogged;
//    }

//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

//    private int findDoctorInDataBase(String username) {
//
//        for (int i = 0; i < dataBaseDoctors.size(); i++) {
//            if (dataBaseDoctors.get(i).getUserName().equals(username)) {
//                return i; //todo: what if there are persons with same name?
//            }
//        }
//        return -1; //TODO: Exception necessary
//    }

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

//    public boolean checkPassword(int arrIndex, String password) {
//        return (dataBaseDoctors.get(arrIndex).getPassword().equals(password));
//    }

//    public void search() {
//        selectedDoctor = getDoctor(username, password);
//    }


//    public boolean checkCredential(String username, String password) {
//
//        int arrIndex = findDoctorInDataBase(username);
//
//        if (arrIndex != -1) {
//            if (checkPassword(arrIndex, password)) {
//                isLogged = true; // to mark this user as logged session
//                return true;
//            }
//        }
//        return false;
//    }


}
