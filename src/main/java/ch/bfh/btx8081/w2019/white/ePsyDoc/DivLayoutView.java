package ch.bfh.btx8081.w2019.white.ePsyDoc;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("div")
@CssImport("frontend://styles/div-layout-styles.css")
//@StyleSheet("frontend://styles/div-layout-styles.css")
public class DivLayoutView extends Div {

    public DivLayoutView() {
        // Instantiate layouts
        HorizontalLayout header = new HorizontalLayout();
        VerticalLayout navBar = new VerticalLayout();
        VerticalLayout content = new VerticalLayout();
        Div center = new Div();
        HorizontalLayout footer = new HorizontalLayout();
        footer.add(new H1("dini muetter"));

        Button btn = new Button();
        btn.addClassName("btn");

        // Configure layouts
        setSizeFull();
        header.setPadding(true);
        footer.setPadding(true);
        addClassName("main-view");
        header.addClassName("header");
        navBar.addClassName("navbar");
        center.addClassName("center");
        content.addClassName("content");
        footer.addClassName("footer");

        // Compose layout
        center.add(navBar, content);
        add(btn, header, center, footer);
    }
}