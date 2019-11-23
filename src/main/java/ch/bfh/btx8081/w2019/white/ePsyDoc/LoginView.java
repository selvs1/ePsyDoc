package ch.bfh.btx8081.w2019.white.ePsyDoc;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.awt.*;

@Route("login")
@PageTitle("Login")
@CssImport("frontend://styles/login.css")
public class LoginView extends VerticalLayout {

    public LoginView() {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setSizeFull();
        addClassName("login-view");

        H1 header = new H1("ePsyDoc");
        header.getElement().getThemeList().add("dark");
        add(header);

        askUsername();

    }

    private void askUsername() {
        HorizontalLayout usernameLayout = new HorizontalLayout();

        TextField usernameTextfield = new TextField();
        Button startButton = new Button("Start chatting");
        usernameLayout.add(usernameTextfield, startButton);

        startButton.addClickListener(click -> {
            String username = usernameTextfield.getValue();
            remove(usernameLayout);
            showChat();
        });

        add(usernameLayout);
    }

    private void showChat() {
        MessageList messageList = new MessageList();

        add(messageList, createInputLayout());
        expand(messageList);
    }

    private Component createInputLayout() {
        HorizontalLayout inputLayout = new HorizontalLayout();
        inputLayout.setWidth("100%");

        TextField messageField = new TextField();
        Button sendButton = new Button("Send");
        sendButton.getElement().getThemeList().add("primary"); // für den Hauptbutton

        inputLayout.add(messageField, sendButton);
        inputLayout.expand(messageField);

        return inputLayout;
    }




/*    private final LoginService loginService;

    private LoginOverlay loginOverlay = new LoginOverlay();

    public LoginView(LoginService loginService) {
        this.loginService = loginService;

        this.loginOverlay.setOpened(true);
        this.loginOverlay.setForgotPasswordButtonVisible(false);
        this.loginOverlay.setDescription(null);
        this.loginOverlay.setEnabled(true);

        this.loginOverlay.addLoginListener(e -> {
            if (this.loginService.authenticateUser(e.getUsername(), e.getPassword())) {

				?

            } else {
                this.loginOverlay.setError(true);
            }
        });

        this.add(loginOverlay);
    }*/




}