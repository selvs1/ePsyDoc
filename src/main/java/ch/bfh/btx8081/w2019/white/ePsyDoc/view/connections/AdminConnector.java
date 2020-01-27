package ch.bfh.btx8081.w2019.white.ePsyDoc.view.connections;

import ch.bfh.btx8081.w2019.white.ePsyDoc.model.AdminModel;
import ch.bfh.btx8081.w2019.white.ePsyDoc.presenter.AdminPresenter;
import ch.bfh.btx8081.w2019.white.ePsyDoc.view.AdminViewImpl;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("admin")
public class AdminConnector extends VerticalLayout {


    public AdminConnector() {
        AdminModel model = new AdminModel();
        AdminViewImpl view = new AdminViewImpl();
        new AdminPresenter(model, view);

        add(view);

    }

}
