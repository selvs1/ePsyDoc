package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

/**
 * This class handles the login procedure.
 * I was impressed by this link: https://github.com/vaadin-learning-center/spring-secured-vaadin/blob/login-overlay-form/src/main/java/org/vaadin/paul/spring/ui/views/LoginView.java
 *
 *
 * @author Sugeelan Selvasingham
 */

@Route(value = LoginViewImpl.ROUTE)
@PageTitle("Login")

public class LoginViewImpl extends VerticalLayout {
    public static final String ROUTE = "login";

    private LoginOverlay login = new LoginOverlay();

    public LoginViewImpl() {
        login.setAction("Homepage");
        login.setOpened(true);
        login.setTitle("ePsyDoc");
        login.setDescription("Secure Authentication");
        login.setForgotPasswordButtonVisible(false); // we won't implement this

        getElement().appendChild(login.getElement());
    }

    private boolean checkAuthentication() {

        return true;
    }

}

