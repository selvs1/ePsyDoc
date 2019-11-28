package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

public interface LoginView {
	String getTextFieldUsername();

	String getTextFieldPassword();

//	boolean showLoginStatus();

	interface LoginViewListener {
		void clickLogin(String username, String password);
	}

	void addListener(LoginViewListener listener);

	void openSession();

	void notifyProblem(String message);
}
