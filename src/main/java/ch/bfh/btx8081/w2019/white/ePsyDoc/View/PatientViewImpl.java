package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("Patient")
@PageTitle("Patient")
public class PatientViewImpl extends MainLayoutView implements MedicationView{

	public PatientViewImpl() {
		super.content.add(new Button("PatientViewImpl"));
	}
}
