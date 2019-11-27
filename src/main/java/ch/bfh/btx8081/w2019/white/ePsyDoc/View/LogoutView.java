package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import ch.bfh.btx8081.w2019.white.ePsyDoc.View.LoginView.LoginViewListener;

public interface LogoutView {
	String getTextFieldUsername();

	String getTextFieldPassword();

	boolean showLoginStatus();
    interface LoginViewListener {
        void login(String username, String password);
    }
    public void addListener(LoginViewListener listener);
    public void letsGo();
    public void problem(String message);
}
