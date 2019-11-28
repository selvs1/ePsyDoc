package ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.LoginModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.LoginView;

public class LoginPresenter implements LoginView.LoginViewListener {

    private LoginModel model;
    private LoginView view;

//    private String username;
//    private String password;


    public LoginPresenter(LoginModel model, LoginView view) {
        this.model = model;
        this.view = view;
        view.addListener(this);
    }


    @Override
    public void clickLogin(String username, String password) {
//        model.setUsername(username);
//        model.setPassword(password);
        if (model.checkCredential(username, password) == true) {
            view.openSession();
        } else {
            view.notifyProblem(username);
        }

    }
}
