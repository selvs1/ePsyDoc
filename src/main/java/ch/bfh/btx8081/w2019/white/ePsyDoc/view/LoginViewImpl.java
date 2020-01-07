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
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 * 
 *          Setup login GUI
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

    public LoginViewImpl() {

        btnSubmit.addClickListener((x) -> {
			notifyListenersOnLoginBtnClicked();
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

    public void notifyListenersOnLoginBtnClicked() {
        for (LoginViewListener listener : listeners) {
            listener.onLoginBtnClicked(tfUsername.getValue(), tfPassword.getValue());
        }
    }


    public void notifyProblem(String message) {
        Notification.show("Login not possible for user: " + message);
    }

    public void openSession() {
        UI.getCurrent().navigate(AppointmentConnector.class);
    }

    @Override
    public void addListener(LoginViewListener listener) {
        listeners.add(listener);
    }
}