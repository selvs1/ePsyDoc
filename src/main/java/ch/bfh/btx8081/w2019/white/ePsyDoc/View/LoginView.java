package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

public interface LoginView {


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
