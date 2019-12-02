package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("Logout")
@PageTitle("Logout")
public class LogoutViewImpl extends VerticalLayout implements LogoutView  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VerticalLayout root = new VerticalLayout();
	private Button backButton = new Button("Back to Login");
	private H1 title = new H1("ePsyDoc");
	private H2 subtitle = new H2("successfully logged out!");

	public LogoutViewImpl() {
		// Set settings
		root.addClassName("login");
		root.setWidth("225");
		root.add(title, subtitle,backButton);
		
		// Add to Layout
		this.add(root);
	}

	@Override
	public void addListener(LogoutViewListener listener) {
		
	}	
}
