package ch.bfh.btx8081.w2019.white.ePsyDoc.View;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.ThemableLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import ch.bfh.btx8081.w2019.white.ePsyDoc.MainView;

@CssImport("frontend://styles/mainlayoutview.css")
public class MainLayoutView extends Div {
   
Div header;
VerticalLayout navBar;
VerticalLayout content;
Div center;
HorizontalLayout footer;
Button btnReturn;
HorizontalLayout subHeader1;
HorizontalLayout subHeader2;

    public MainLayoutView() {
        // Instantiate layouts
        header = new Div();
        navBar = new VerticalLayout();
        content = new VerticalLayout();
        center = new Div();
        footer = new HorizontalLayout();
        subHeader1 = new HorizontalLayout();
        subHeader1.addClassName("subHeader1");
        subHeader2 = new HorizontalLayout();
        subHeader2.addClassName("subHeader2");
        subHeader1.add(new H1("ePsyDoc"));
        btnReturn = new Button(new Icon(VaadinIcon.HOME));	
		btnReturn.addClickListener( e -> UI.getCurrent().navigate(MainView.class));
		subHeader2.add(btnReturn);
		
        header.add(subHeader1, subHeader2);
        
        // Configure layouts
        setSizeFull();
        footer.setPadding(true);
        addClassName("main-view");
        header.addClassName("header");
        navBar.addClassName("navbar");
        center.addClassName("center");
        content.addClassName("content");
        footer.addClassName("footer");
               
        // Compose layout
        center.add(navBar, content);
        add(header, center, footer);
    }
    


}
