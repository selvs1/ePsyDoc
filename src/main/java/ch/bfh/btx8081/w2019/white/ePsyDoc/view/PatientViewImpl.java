package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.server.PageConfigurator;
import org.apache.commons.lang3.StringUtils;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.server.VaadinSession;

import ch.bfh.btx8081.w2019.white.ePsyDoc.MainView;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.Patient;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.entity.PatientCase;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.PatientModel;



//@Route(value = "t")
public class PatientViewImpl extends MainLayoutView implements PatientView {
    private static final long serialVersionUID = 1L;
    private List<Patient> patientlist = new ArrayList<>();
    private VerticalLayout root = new VerticalLayout();
    private List<Patient> personList = new ArrayList<>();
    private Grid<Patient> grid = new Grid<>();
    private Grid<PatientCase> patientCase = new Grid<>();
    private List<PatientCase> patientCaseList = new ArrayList<>();


    // A list of listeners subscribed to this view
    private List<PatientViewListener> listeners = new ArrayList<>();


    public PatientViewImpl(List<Patient> patientList) {
        if (VaadinSession.getCurrent().getAttribute("name") == null) {
            UI.getCurrent().navigate(MainView.class);

        }

        this.patientlist = patientList;

        //todo: to delete after debugging - sugi
        System.out.println("### start h @@@@@@@@@@@@@@@");
        for (Patient p : patientlist) {
            System.out.println(p.getFirstname());
        }

//		refreshPatientList();


        // Test Data

        // Column set and description
        grid.addColumn(Patient::getPatientID).setHeader("Patient ID");
        Grid.Column<Patient> firstNameColumn = grid.addColumn(Patient::getFirstname).setHeader("Firstname");
        Grid.Column<Patient> lastNameColumn = grid.addColumn(Patient::getLastname).setHeader("Lastname");
        grid.addColumn(Patient::getGender).setHeader("Gender");
        grid.addColumn(Patient::getDate).setHeader("Birthdate");
        grid.addColumn(Patient::getAdress).setHeader("Address");
        grid.addColumn(Patient::getZip).setHeader("ZIP");
        grid.addItemClickListener(event -> {

            System.out.println(event.getItem().getFirstname() + "wurde geklickt");
//            System.out.println("ich wurde geklickt");
            VaadinSession.getCurrent().setAttribute("patientID", event.getItem().getPatientID());
            VaadinSession.getCurrent().setAttribute("patientFirstname", event.getItem().getFirstname());
            VaadinSession.getCurrent().setAttribute("patientName", event.getItem().getLastname());
            VaadinSession.getCurrent().setAttribute("patientCaseID", "NULL");
            VaadinSession.getCurrent().setAttribute("doctorID", VaadinSession.getCurrent().getAttribute("doctorID"));
            VaadinSession.getCurrent().setAttribute("doctorFirstname", VaadinSession.getCurrent().getAttribute("doctorFirstname"));
            VaadinSession.getCurrent().setAttribute("doctorName", VaadinSession.getCurrent().getAttribute("doctorName"));

            for (PatientViewListener listener : listeners) {
            	int patientID = event.getItem().getPatientID();
               listener.setPatientCaseList(patientID);
                listener.onLoadPatientList();
            }
            patientCase.setVisible(true);
            notifyListenersOnPatientItemClicked(event.getItem());


        });


        // Data provider
        ListDataProvider<Patient> dataProvider = new ListDataProvider<>(patientlist);
        grid.setDataProvider(dataProvider);
        HeaderRow filterRow = grid.appendHeaderRow();

        // Firstname filter
        TextField firstNameField = new TextField();
        firstNameField.addValueChangeListener(event -> dataProvider.addFilter(
                patient -> StringUtils.containsIgnoreCase(patient.getFirstname(), firstNameField.getValue())));
        firstNameField.setValueChangeMode(ValueChangeMode.EAGER);
        filterRow.getCell(firstNameColumn).setComponent(firstNameField);
        firstNameField.setSizeFull();
        firstNameField.setPlaceholder("Filter");

        // Lastname filter
        TextField lastNameField = new TextField();
        lastNameField.addValueChangeListener(event -> dataProvider
                .addFilter(patient -> StringUtils.containsIgnoreCase(patient.getLastname(), lastNameField.getValue())));
        lastNameField.setValueChangeMode(ValueChangeMode.EAGER);
        filterRow.getCell(lastNameColumn).setComponent(lastNameField);
        lastNameField.setSizeFull();
        lastNameField.setPlaceholder("Filter");


        // Column set, description and settings
        //patientCase.addColumn(PatientCase::getFid).setHeader("FID");
        patientCase.setVisible(false);
        patientCase.setItems(patientCaseList);



        // Add elements to root VerticalLayout
        root.add(grid, patientCase);

        // Add to layout
        super.content.add(root);
    }

    private void notifyListenersOnPatientItemClicked(Patient choosedPatient) {
        for (PatientViewListener listener : listeners) {
            listener.onPatientItemClicked(choosedPatient);
        }
    }


    // Iterate through the list, notifying or du some actions to each listner individualy

    /**
     * Reload this page with new patientList data.
     *
     * @deprecated I think this methode is not useful anymore.
     */
    public void refreshPatientList() {
        System.out.println("starte refreshPatientList");
        for (PatientViewListener listener : listeners) {
            System.out.println("#listener.onLoadPatientList()");
            listener.onLoadPatientList();
        }
        System.out.println("ende hier");
    }


    @Override
    public void addListener(PatientViewListener listener) {
        listeners.add(listener);
    }

    @Override
    public void displayPatientData(PatientModel patientModel) {
        // TODO Auto-generated method stub

    }

    @Override
    public void displayPatientCaseData(PatientModel patientModel) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setPatientList(List<Patient> patientList) {
        this.patientlist = patientList;
        System.out.println("Patienten Liste wurde gesetzt");

        for (Patient p : patientList) {
            System.out.println(p.getFirstname());
        }
    }

	@Override
	public void setPatientCaseList(List<PatientCase> patientCaseList) {
		this.patientCaseList = patientCaseList;
		 System.out.println("______________");
        this.patientCase.setItems(this.patientCaseList);
		
	}


}
