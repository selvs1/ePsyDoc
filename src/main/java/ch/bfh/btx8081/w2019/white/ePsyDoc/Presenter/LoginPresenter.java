package ch.bfh.btx8081.w2019.white.ePsyDoc.Presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.Model.LoginModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.View.LoginView;

public class LoginPresenter implements LoginView.LoginViewListener {

    private LoginModel model;
    private LoginView view;

    private String username;
    private String password;



    public LoginPresenter(LoginModel model, LoginView view) {
        this.model = model;
        this.view = view;
        view.addListener(this);
    }




    @Override
    public void login(String username, String password) {
        model.setUsername(username);
        model.setPassword(password);
        model.search();
        if (model.getLoginSucess() == true) {
            view.letsGo();
       

        } else {
            view.problem(username);
        }

    }
}
