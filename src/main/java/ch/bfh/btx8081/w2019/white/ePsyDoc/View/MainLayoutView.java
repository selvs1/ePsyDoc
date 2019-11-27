package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import java.util.stream.Stream;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.ThemableLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.timepicker.osgi.TimePickerResource;
import com.vaadin.flow.server.Command;
import com.vaadin.flow.server.VaadinSession;

import ch.bfh.btx8081.w2019.white.ePsyDoc.MainView;

@CssImport("frontend://styles/mainlayoutview.css")
public class MainLayoutView extends Div {

    Header header;
    MenuBar menuBar;
    VerticalLayout content;
    Div body;
    Footer footer;
    Button btnReturn;
    HorizontalLayout information;

    public MainLayoutView() {
        // Instantiate layouts
        String patientName = "Max Muster";
        String patientCase = "2019-11-10 12394";
        header = new Header();
        footer = new Footer();
        menuBar = new MenuBar();
        MenuItem appointment = new MenuItem(null, null);
        MenuItem patient = new MenuItem(null, null);
        MenuItem report = new MenuItem(null, null);
        MenuItem logout = new MenuItem(null, null);
        appointment.add(new Icon(VaadinIcon.CALENDAR_USER));
        appointment.add(" Appointment");
        appointment.addClickListener(e -> UI.getCurrent().navigate(AppointmentViewImpl.class));
        patient.add(new Icon(VaadinIcon.USER));
        patient.add(" Patient");
        patient.addClickListener(e -> UI.getCurrent().navigate(PatientViewImpl.class));
        report.add(new Icon(VaadinIcon.CLIPBOARD_CROSS));
        report.add(" Report");
        report.addClickListener(e -> UI.getCurrent().navigate(ReportViewImpl.class));

        logout.add(new Icon(VaadinIcon.SIGN_OUT));
        logout.add(" Logout");
        logout.addClickListener(e -> VaadinSession.getCurrent().close());

        menuBar.addItem(appointment);
        menuBar.addItem(patient);
        menuBar.addItem(report);
        menuBar.addItem(logout);
        header.add(menuBar);
        content = new VerticalLayout();
        body = new Div();
        addClassName("main-view");
        information = new HorizontalLayout();
        information.add(new Label("Patient:"));
        information.add(new Label(patientName));
        information.add(new Label("| Case:"));
        information.add(new Label(patientCase));

        information.addClassName("patient");
        menuBar.addClassName("navbar");
        body.addClassName("body");
        content.addClassName("content");

        footer.add("Ⓒ by ePsyDoc");

        // Compose layout
        body.add(information, content);
        add(header, body, footer);

    }
   


}
