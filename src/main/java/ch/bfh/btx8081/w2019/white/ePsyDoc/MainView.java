package ch.bfh.btx8081.w2019.white.ePsyDoc;
//package feuht
// itze nümme


import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;


@Route("Homepage")
public class MainView extends VerticalLayout {
	Header header;
	Footer footer;
    public MainView() {
    	header = new Header();
    	footer = new Footer();

    	header.add(new H1("ePsyDoc"));
		Span title = new Span("ePsyDoc");
		Icon help = VaadinIcon.QUESTION_CIRCLE.create();
		
		
		// WORKSPACE
		
		MenuBar menuBar = new MenuBar();
		Text selected = new Text("");
		Div message = new Div(new Text("Selected: "), selected);

		MenuItem patientView = menuBar.addItem("PatientView");
		MenuItem medicationView = menuBar.addItem("MedicationView");
		MenuItem reportView = menuBar.addItem("reportView");
		MenuItem appointmentView = menuBar.addItem("appointmentView");
		menuBar.addItem("Sign Out", e -> selected.setText("Sign Out"));

		//SubMenu projectSubMenu = project.getSubMenu();
		//MenuItem users = projectSubMenu.addItem("Users");
		//MenuItem billing = projectSubMenu.addItem("Billing");
		
			VerticalLayout workspace = new VerticalLayout();
			workspace.setSizeFull();

		// FOOTER
			Tab actionButton1 = new Tab(VaadinIcon.HOME.create(), new Span("Home"));
			Tab actionButton2 = new Tab(VaadinIcon.USERS.create(), new Span("Back"));
			Tab actionButton3 = new Tab(VaadinIcon.PACKAGE.create(), new Span("More"));
			Tabs buttonBar = new Tabs(actionButton1, actionButton2, actionButton3);
			

			// MAIN CONTAINER
			setSizeFull();
			setMargin(false);
			setSpacing(false);
			setPadding(false);
			add(header, workspace, footer);
	}
}

