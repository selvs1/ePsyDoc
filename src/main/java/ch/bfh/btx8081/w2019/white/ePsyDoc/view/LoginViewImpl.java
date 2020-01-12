package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

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

import ch.bfh.btx8081.w2019.white.ePsyDoc.connections.AppointmentConnector;

/**
 * Setup login GUI.
 * 
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 */
public class LoginViewImpl extends VerticalLayout implements LoginView {
	private static final long serialVersionUID = 1L;
	public static final String ROUTE = "login";
	private VerticalLayout root = new VerticalLayout();
	private TextField tfUsername = new TextField();
	private PasswordField tfPassword = new PasswordField();
	private Button btnSubmit = new Button("Submit");
	private H1 title = new H1("ePsyDoc");
	private FormLayout login = new FormLayout();

	private List<LoginViewListener> listeners = new ArrayList<>();

	/**
	 * Constructor generate the GUI.
	 */
	public LoginViewImpl() {

		// On click login.
		btnSubmit.addClickListener((x) -> {
			notifyListenersOnLoginBtnClicked();
		});

		// Setup root.
		root.addClassName("login");
		root.setWidth("300");

		// Setup username field.
		tfUsername.setPlaceholder("Username");
		tfUsername.setLabel("Username");
		tfUsername.setRequired(true);
		tfUsername.setAutoselect(true);
		tfUsername.setClearButtonVisible(true);

		// Setup password field.
		tfPassword.setPlaceholder("Password");
		tfPassword.setLabel("Password");
		tfPassword.setRequired(true);
		tfPassword.setAutoselect(true);
		tfPassword.setClearButtonVisible(true);

		// Add to layout.
		login.add(tfUsername, tfPassword, btnSubmit);
		// Add to layout.
		root.add(title, login);
		// Add to GUI.
		this.add(root);
	}

	/**
	 * Return the value of username field.
	 * 
	 * @return the username.
	 */
	@Override
	public String getTextFieldUsername() {
		return tfUsername.getValue();
	}

	/**
	 * Return the value of password field.
	 * 
	 * @return the password.
	 */
	@Override
	public String getTextFieldPassword() {
		return tfPassword.getValue();
	}

	/**
	 * On click login with function onLoginBtnClicked in presenter class.
	 */
	public void notifyListenersOnLoginBtnClicked() {
		for (LoginViewListener listener : listeners) {
			listener.onLoginBtnClicked(tfUsername.getValue(), tfPassword.getValue());
		}
	}

	/**
	 * Show error notification.
	 * 
	 * @param message error message on login fail.
	 */
	public void notifyProblem(String message) {
		Notification.show("Login not possible for user: " + message);
	}

	/**
	 * redirect to appointment class.
	 */
	public void openSession() {
		UI.getCurrent().navigate(AppointmentConnector.class);
	}

	/**
	 * Add listeners.
	 * 
	 * @param listener add listeners.
	 */
	@Override
	public void addListener(LoginViewListener listener) {
		listeners.add(listener);
	}
}