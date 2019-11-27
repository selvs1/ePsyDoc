package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.w2019.white.ePsyDoc.View.LoginView.LoginViewListener;

@Route("Logout")
@PageTitle("Logout")
public class LogoutViewImpl extends VerticalLayout implements LogoutView  {
	private VerticalLayout root = new VerticalLayout();
	private Button backButton = new Button("Back to Login");
	private H1 title = new H1("ePsyDoc");
	private H2 subtitle = new H2("successfully logged out!");

	private List<LoginViewListener> listeners = new ArrayList<>();

	private LoginOverlay login = new LoginOverlay();

	public LogoutViewImpl() {


		backButton.addClickListener((x) -> {
			for (LoginViewListener listener : listeners) {
			
			}
		});

		root.addClassName("login");
		root.setWidth("225");
		
		
		root.add(title, subtitle,backButton);
		this.add(root);
	}	
}
