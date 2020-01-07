package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.LoginModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.LoginView;

public class LoginPresenter implements LoginView.LoginViewListener {

    private LoginModel model;
    private LoginView view;

    public LoginPresenter(LoginModel model, LoginView view) {
        this.model = model;
        this.view = view;
        view.addListener(this);
    }

    @Override
    public void onLoginBtnClicked(String username, String password) {
        try {
            model.login(username, password);
            view.openSession(); 
        } catch (Exception e) {
            view.notifyProblem(e.getMessage());
        }

    }
}