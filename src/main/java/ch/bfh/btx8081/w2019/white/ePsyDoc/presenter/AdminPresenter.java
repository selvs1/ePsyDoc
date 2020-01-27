package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.AdminModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.AdminView;

public class AdminPresenter implements AdminView.AdminViewListener {

    private AdminModel model;
    private AdminView view;

    public AdminPresenter(AdminModel model, AdminView view) {
        this.model = model;
        this.view = view;
        view.addListener(this);
    }




    @Override
    public void onCreateBtnClicked(String benutzername, String passwort) {
        System.out.println("AdminPresenter: Username: " + benutzername + "\nPassword: " + passwort);

        model.createUser(benutzername, passwort); // Model bitte mach etwas damit
        view.notification("Benutzer wurde erstellt");
    }
}

