package ch.bfh.btx8081.w2019.white.ePsyDoc.presenter;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.LoginModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.LoginView;

/**
 * Connects model and view.
 * 
 * @author Alain Nippel
 * @author Apiwat-David Gaupp
 * @author Janahan Sellathurai
 * @author Marko Miletic
 * @author Sugeelan Selvasingham
 * @author Viktor Velkov
 * 
 * @version 1.0
 * 
 * 
 */

public class LoginPresenter implements LoginView.LoginViewListener {

	private LoginModel model;
	private LoginView view;

	/**
	 * Set model, set view and add the presenter class to the view.
	 * 
	 * @param model get model from connector.
	 * @param view  get view from connector.
	 * 
	 * 
	 */
	public LoginPresenter(LoginModel model, LoginView view) {
		this.model = model;
		this.view = view;
		view.addListener(this);
	}

	/**
	 * Try to login in model class and create session in the view class. On failure
	 * throw exception.
	 * 
	 * @param username get username from view.
	 * @param password get password from view.
	 */
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