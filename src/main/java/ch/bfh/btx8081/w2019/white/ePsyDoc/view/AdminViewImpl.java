package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;


public class AdminViewImpl extends VerticalLayout implements AdminView {


    VerticalLayout root = new VerticalLayout();

    HorizontalLayout header = new HorizontalLayout();
    Label lblInfo = new Label("Backdoor");

    VerticalLayout body = new VerticalLayout();
    TextField tfUsername = new TextField("Username");
    TextField tfPassword = new TextField("Password");
    Button btnCreate = new Button("Create");

    VerticalLayout footer = new VerticalLayout();
    Label lblCopyRight = new Label("Copyright by Pundemohan");

    List<AdminViewListener> listeners = new ArrayList<>();




    public AdminViewImpl() {

        //Konfiguration
        lblInfo.getStyle().set("color", "white");
        lblInfo.getStyle().set("font-weight", "bold");
        header.getStyle().set("background-color", "blue");
        footer.getStyle().set("background-color", "blue");
        lblCopyRight.getStyle().set("color", "white");
        lblCopyRight.getStyle().set("font-weight", "bold");
        btnCreate.addClickListener(event -> {
            onCreateBtnClicked();
        });
        //Module einbauen
        header.add(lblInfo);
        body.add(tfUsername, tfPassword, btnCreate);
        footer.add(lblCopyRight);

        root.add(header, body, footer);


        add(root);
    }

    private void onCreateBtnClicked() {
        for (AdminViewListener listener : listeners) {
            listener.onCreateBtnClicked(tfUsername.getValue(), tfPassword.getValue());
            System.out.println("ViewImpl: ich wurde geklickt.");
        }

    }


    @Override
    public void addListener(AdminViewListener listener) {
        listeners.add(listener);
    }

    @Override
    public void notification(String text) {
        Notification.show(text);
    }

}
