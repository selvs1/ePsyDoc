package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

/**
 * LoginView interface contains all functions which are adopted in the
 * LoginViewListener class. The Interface LoginViewListener contains all
 * functions which are adopted in the LoginModel class.
 * 
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 */
public interface LoginView {
	String getTextFieldUsername();

	String getTextFieldPassword();

	interface LoginViewListener {
		void onLoginBtnClicked(String username, String password);
	}

	void addListener(LoginViewListener listener);

	void openSession();

	void notifyProblem(String message);
}
