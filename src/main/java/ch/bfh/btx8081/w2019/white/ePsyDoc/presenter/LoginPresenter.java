package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.entity.DoctorException;
import ch.bfh.btx8081.w2019.white.ePsyDoc.model.LoginModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.AppointmentViewImpl;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.LoginView;
import com.vaadin.flow.component.UI;

/**
 * Responsible to responding to user interaction and updating the view
 *
 * @author Sugeelan Selvasingham
 */
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
    public void onLoginBtnClicked(String username, String password) {
//        model.setUsername(username);
//        model.setPassword(password);
//        if (model.checkCredential(username, password) == true) {
//            view.openSession(username);
//        } else {
//            view.notifyProblem(username);
//        }

        try {
            LoginModel.login(username, password);
            view.openSession(); // enter to the main page
        } catch (Exception e) {
            view.notifyProblem(e.getMessage());
        }

    }
}
