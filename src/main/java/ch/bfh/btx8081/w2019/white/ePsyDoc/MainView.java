package ch.bfh.btx8081.w2019.white.ePsyDoc;
//package feuht
// itze nümme


import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;


@Route("dini")
public class MainView extends VerticalLayout {
    public MainView() {
/*	
// Create the model and the Vaadin view implementation
        CalculatorModel model = new CalculatorModel();
        CalculatorViewImpl view = new CalculatorViewImpl();
// The presenter connects the model and view
        new CalculatorPresenter(model, view);
// The view implementation is a Vaadin component
        add(view);
*/  
	
	// HEADER
		Icon drawer = VaadinIcon.MENU.create();
		Span title = new Span("ePsyDoc");
		Icon help = VaadinIcon.QUESTION_CIRCLE.create();
		HorizontalLayout header = new HorizontalLayout(title, drawer, help);
		header.expand(title);
		header.setPadding(true);
		header.setWidth("100%");
		
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
			HorizontalLayout footer = new HorizontalLayout(buttonBar);
			footer.setJustifyContentMode(JustifyContentMode.CENTER);
			footer.setWidth("100%");

			// MAIN CONTAINER
			setSizeFull();
			setMargin(false);
			setSpacing(false);
			setPadding(false);
			add(header, workspace, footer);
	}
}

