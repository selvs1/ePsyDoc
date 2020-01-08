package ch.bfh.btx8081.w2019.white.ePsyDoc.model;

import ch.bfh.btx8081.w2019.white.ePsyDoc.database.Service;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Doctor;
import ch.bfh.btx8081.w2019.white.ePsyDoc.exceptions.DoctorException;
import com.vaadin.flow.server.VaadinSession;

/**
 * Model of Login. Connect to database.
 * 
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 */
public class LoginModel {
	/**
	 * Check if login works.
	 * 
	 * @param username get username from presenter.
	 * @param password get password from presenter.
	 * @throws DoctorException Throw invalid password exception.
	 */
	public void login(String username, String password) throws DoctorException {
		Service<Doctor> ls = new Service<>(new Doctor());
		Doctor doctor = ls.findByAttributeFirstElem("username", username);
		if (doctor.validPassword(password)) {
			setSession(doctor);
		} else {
			throw new DoctorException("invalid password");
		}
	}

	/**
	 * Set Session data.
	 * 
	 * @param doctor get doctor from presenter.
	 */
	private void setSession(Doctor doctor) {
		System.out.println(doctor.getDoctorID());
		System.out.println(doctor.getFirstname());
		System.out.println(doctor.getName());
		VaadinSession.getCurrent().setAttribute("doctorID", doctor.getDoctorID());
		VaadinSession.getCurrent().setAttribute("doctorFirstname", doctor.getFirstname());
		VaadinSession.getCurrent().setAttribute("doctorName", doctor.getName());
	}
}
