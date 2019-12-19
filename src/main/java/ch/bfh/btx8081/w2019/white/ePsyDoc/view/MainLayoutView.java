package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.server.VaadinSession;

import ch.bfh.btx8081.w2019.white.ePsyDoc.MainView;

@PreserveOnRefresh
@CssImport("frontend://styles/mainlayoutview.css")
public class MainLayoutView extends Div {
	private static final long serialVersionUID = 1L;
	private Header header = new Header();
	private MenuBar menuBar = new MenuBar();
	protected VerticalLayout content = new VerticalLayout();
	private Div body = new Div();
	private Footer footer = new Footer();
	private VerticalLayout information = new VerticalLayout();
	private MenuItem appointment = new MenuItem(null, null);
	private MenuItem patient = new MenuItem(null, null);
	private MenuItem report = new MenuItem(null, null);
	private MenuItem logout = new MenuItem(null, null);
	private H3 errorT = new H3("Your not Authorized!");
	private Button loginB = new Button(new Icon(VaadinIcon.SIGN_IN));
	private Div error = new Div();
	Accordion accordion = new Accordion();

	public MainLayoutView() {
		// Navigation
		appointment.add(new Icon(VaadinIcon.CALENDAR_USER));
		appointment.add(" Appointments");
		appointment.addClickListener(e -> UI.getCurrent().navigate("Appointment"));
		patient.add(new Icon(VaadinIcon.USER));
		patient.add(" Patients");
		patient.addClickListener(e -> UI.getCurrent().navigate("Patient"));
		report.add(new Icon(VaadinIcon.CLIPBOARD_CROSS));
		report.add(" Report");
		report.addClickListener(e -> UI.getCurrent().navigate("Report"));
		logout.add(new Icon(VaadinIcon.SIGN_OUT));
		logout.add(" Logout");
		logout.addClickListener(e -> logout());

		// Add to menubar
		menuBar.addItem(appointment);
		menuBar.addItem(patient);
		menuBar.addItem(report);
		menuBar.addItem(logout);

		// Header
		header.add(menuBar);

		addClassName("main-view");

		// Show active patient
		information.setWidth("180");
		information.add(new Icon(VaadinIcon.USER));
		information.add(new Label(String.valueOf(VaadinSession.getCurrent().getAttribute("patientFirstname")) + " "
				+ String.valueOf(VaadinSession.getCurrent().getAttribute("patientName"))));
		information.add(new Icon(VaadinIcon.FILE));
		information.add(new Label(String.valueOf(VaadinSession.getCurrent().getAttribute("patientCaseID"))));

		information.addClassName("patient");

		accordion.add("Information", information);

		menuBar.addClassName("navbar");
		body.addClassName("body");
		content.addClassName("content");

		// Footer
		footer.add("Ⓒ by ePsyDoc");

		// Add to layout
		body.add(accordion, content);

		// Error button
		loginB.addClickListener(e -> UI.getCurrent().navigate(MainView.class));
		error.add(errorT, loginB);
		error.addClassName("sessionError");

		if (VaadinSession.getCurrent().getAttribute("name") != null) {
			add(error);
		} else {
			add(header, body, footer);
		}
	}

	private void logout() {
		VaadinSession.getCurrent().close();
		UI.getCurrent().navigate(LogoutViewImpl.class);
	}
}
