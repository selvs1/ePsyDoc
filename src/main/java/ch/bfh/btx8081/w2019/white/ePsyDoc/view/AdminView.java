package ch.bfh.btx8081.w2019.white.ePsyDoc.view;

public interface AdminView {

    interface AdminViewListener {
        void onCreateBtnClicked(String benutzername, String passwort);

    }

    void addListener(AdminViewListener listener);
    void notification(String text);


}
