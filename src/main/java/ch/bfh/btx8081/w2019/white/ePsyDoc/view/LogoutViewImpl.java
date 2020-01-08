package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.MainView;

/**
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 * 
 *          Setup logout GUI.
 */
@Route("Logout")
@PageTitle("Logout")

public class LogoutViewImpl extends VerticalLayout {

	private VerticalLayout root = new VerticalLayout();
	private Button backB = new Button(new Icon(VaadinIcon.SIGN_IN));
	private H1 title = new H1("ePsyDoc");
	private H2 subtitle = new H2("successfully logged out!");

	/**
	 * Constructor generate the GUI.
	 */
	public LogoutViewImpl() {
		// On click redirect to login.
		backB.addClickListener(e -> UI.getCurrent().navigate(MainView.class));

		// Set settings.
		root.addClassName("logout");
		root.setWidth("225");
		// Add to layout
		root.add(title, subtitle, backB);

		// Add to layout.
		this.add(root);
	}
}