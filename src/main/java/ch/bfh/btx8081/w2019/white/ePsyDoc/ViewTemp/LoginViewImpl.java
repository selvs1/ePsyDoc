/**
 * This class handles the login procedure. I got inspired by this link:
 * https://github.com/vaadin-learning-center/spring-secured-vaadin/blob/login-overlay-form/src/main/java/org/vaadin/paul/spring/ui/views/LoginView.java
 *
 * @author Sugeelan Selvasingham, Alain Nippel
 */
package ch.bfh.btx8081.w2019.white.ePsyDoc.ViewTemp;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route(value = LoginViewImpl.ROUTE)
@PageTitle("Login")

public class LoginViewImpl extends VerticalLayout implements LoginView {
	private static final long serialVersionUID = 1L;
	public static final String ROUTE = "login";
	private VerticalLayout root = new VerticalLayout();
	private TextField tfUsername = new TextField();
	private PasswordField tfPassword = new PasswordField();
	private Button btnSubmit = new Button("Submit");
	private H1 title = new H1("ePsyDoc");
	private List<LoginViewListener> listeners = new ArrayList<>();
	private FormLayout login = new FormLayout();
//	private LoginOverlay component = new LoginOverlay();

	public LoginViewImpl() {

//		component.addLoginListener(e -> component.close());
		btnSubmit.addClickListener((x) -> {
			for (LoginViewListener listener : listeners) {
				listener.clickLogin(tfUsername.getValue(), tfPassword.getValue());
			}
		});


		// Input field settings
		root.addClassName("login");
		root.setWidth("300");
		tfUsername.setPlaceholder("Username");
		tfUsername.setLabel("Username");
		tfUsername.setRequired(true);
		tfUsername.setAutoselect(true);
		tfUsername.setClearButtonVisible(true);

		tfPassword.setPlaceholder("Password");
		tfPassword.setLabel("Password");
		tfPassword.setRequired(true);
		tfPassword.setAutoselect(true);
		tfPassword.setClearButtonVisible(true);

		// Add to Layout
		login.add(tfUsername, tfPassword, btnSubmit);
		root.add(title, login);
		this.add(root);
	}

	@Override
	public String getTextFieldUsername() {
		return tfUsername.getValue();
	}

	@Override
	public String getTextFieldPassword() {
		return tfPassword.getValue();
	}

//	@Override
//	public boolean showLoginStatus() {
//		return false;
//	}

	@Override
	public void addListener(LoginViewListener listener) {
		listeners.add(listener);
	}

	public void openSession(String name) {
		VaadinSession.getCurrent().setAttribute("name", name);



		this.addClickListener(e -> UI.getCurrent().navigate(AppointmentViewImpl.class));
	}

	public void notifyProblem(String message) {
		Notification.show("Login not possible for user: " + message);
	}
}