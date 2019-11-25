package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("Appointment")
@PageTitle("Appointment")
public class AppointmentViewImpl extends MainLayoutView implements MedicationView {

	public AppointmentViewImpl() {
		super.content.add(new Button("AppointmentViewImpl"));
		
	}
}
