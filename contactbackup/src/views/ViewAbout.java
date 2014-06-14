package views;

import Control.Controller;
import com.nokia.lwuit.components.HeaderBar;
import com.sun.lwuit.Command;
import com.sun.lwuit.Container;
import com.sun.lwuit.Display;
import com.sun.lwuit.Font;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.html.HTMLComponent;
import com.sun.lwuit.layouts.BoxLayout;
import models.Var;

public class ViewAbout extends Form implements ActionListener {

    Command back = new Command(Var.back);
    private static final String CONTENT_TEXT =""
            + "\n"
            + "Application: Contact Backup\n"
            + "Version: 1.0\n"
            + "Deverloper: Vu Van Tuong\n"
            + "Email:tritueviet01@yahoo.com\n\n"
            + "Copyfight @2013 WALL. All rights reversed";
   
    public ViewAbout() {
        TextArea about = new TextArea();
        about.setUIID("Label");
        about.setEditable(false);
        about.setFocusable(false);
        about.setEnabled(false);
        about.setRows(2);
        about.setGrowByContent(true);
        Font createSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
        about.getStyle().setFont(createSystemFont);
        about.setText(CONTENT_TEXT);
        addComponent(about);
        setBackCommand(back);
        addCommandListener(this);
        addCommand(back);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getCommand() == back) {
            Controller.getInstance().showHome();
            
        }
    }
}
