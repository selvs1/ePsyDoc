package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * This class handles the login procedure. I got inspired by this link:
 * https://github.com/vaadin-learning-center/spring-secured-vaadin/blob/login-overlay-form/src/main/java/org/vaadin/paul/spring/ui/views/LoginView.java
 *
 * @author Sugeelan Selvasingham, Alain Nippel
 */

@Route(value = LoginViewImpl.ROUTE)
@PageTitle("Login")

public class LoginViewImpl extends VerticalLayout implements LoginView {
	public static final String ROUTE = "login";

	private VerticalLayout root = new VerticalLayout();
	private TextField tfUsername = new TextField();
	private PasswordField tfPassword = new PasswordField();
	private Button btnSubmit = new Button("Submit");
	private H1 title = new H1("ePsyDoc");

	private List<LoginViewListener> listeners = new ArrayList<>();

	private FormLayout login = new FormLayout();
	public LoginViewImpl() {
//        login.setAction("Homepage");
//        login.setOpened(true);
//        login.setTitle("ePsyDoc");
//        login.setDescription("Secure Authentication");
//        login.setForgotPasswordButtonVisible(false); // we won't implement this
//        getElement().appendChild(login.getElement());
		LoginOverlay component = new LoginOverlay();
		component.addLoginListener(e -> component.close());
		btnSubmit.addClickListener((x) -> {
			for (LoginViewListener listener : listeners) {
				listener.login(tfUsername.getValue(), tfPassword.getValue());
			}
		});

		
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

	@Override
	public boolean showLoginStatus() {
		return false;
	}

	@Override
	public void addListener(LoginViewListener listener) {
		listeners.add(listener);
	}

	public void letsGo() {
		this.addClickListener(e -> UI.getCurrent().navigate(AppointmentViewImpl.class));
	}
	

	public void problem(String message) {
		Notification.show("Login not possible for user: " + message);
	}

}
