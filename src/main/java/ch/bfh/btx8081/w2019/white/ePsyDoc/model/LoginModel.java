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

	public void login(String username, String password) throws DoctorException {
		Service<Doctor> ls = new Service<>(new Doctor());

		Doctor doctor = ls.findByAttributeFirstElem("username", username);

		if (doctor.validPassword(password)) {
			setSession(doctor);

		} else {
			throw new DoctorException("invalid password");
		}

	}

	private void setSession(Doctor d) {
		System.out.println(d.getDoctorID());
		System.out.println(d.getFirstname());
		System.out.println(d.getName());
		VaadinSession.getCurrent().setAttribute("doctorID", d.getDoctorID());
		VaadinSession.getCurrent().setAttribute("doctorFirstname", d.getFirstname());
		VaadinSession.getCurrent().setAttribute("doctorName", d.getName());
	}
}
