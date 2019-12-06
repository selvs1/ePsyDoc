package ch.bfh.btx8081.w2019.white.ePsyDoc.PresenterTemp;

import ch.bfh.btx8081.w2019.white.ePsyDoc.ModelTemp.LoginModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.LoginView;

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
            view.openSession(username);
        } else {
            view.notifyProblem(username);
        }

    }
}
