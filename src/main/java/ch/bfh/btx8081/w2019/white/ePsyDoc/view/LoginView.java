package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

/**
 * Designshape for implementation class.
 *
 * @author Sugeelan Selvasingham
 */
public interface LoginView {
    String getTextFieldUsername();

    String getTextFieldPassword();

//	boolean showLoginStatus();

    /**
     * Provides methods to notify on user interaction
     */
    interface LoginViewListener {
        void onLoginBtnClicked(String username, String password);
    }

    void addListener(LoginViewListener listener);

    //    void openSession(String name);
    void openSession();
//	void openSession();

    void notifyProblem(String message);
}
