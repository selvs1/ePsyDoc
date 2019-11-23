package ch.bfh.btx8081.w2019.white.ePsyDoc;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.Route;

@Route("Alain")
public class AlainView {
	 public AlainView() {

	        LoginOverlay component = new LoginOverlay();

	        component.addLoginListener(e ->component.close());
	        Button open = new Button("Open login overlay",
	                e -> component.setOpened(true));
	        LoginI18n i18n = LoginI18n.createDefault();

	        i18n.setAdditionalInformation("To close the login form submit non-empty username and password");

	        component.setI18n(i18n);
	    }
}
