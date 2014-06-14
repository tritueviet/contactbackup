package views;

import Control.Controller;
import com.sun.lwuit.Command;
import com.sun.lwuit.Font;
import com.sun.lwuit.Form;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import models.Var;

public class ViewHelp extends Form implements ActionListener {

    //private String title = "Giúp đỡ";
    Command back = new Command(Var.back);
    private int vt;
    private static String text = "Helps you backup your phonebook and save the file in the memory card. File backupContact.bak located in the images directory.\n"
            + "\n" + "Functions: \n"
            + " • Backup contact\n"
            + " • Restore contact\n"
            +"\n";
    public ViewHelp() {
        
        TextArea help = new TextArea();
        help.setUIID("Label");
        help.setEditable(false);
        help.setFocusable(false);
        help.setEnabled(false);
        help.setRows(2);
        help.setGrowByContent(true);
        Font createSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
        help.getStyle().setFont(createSystemFont);
        help.setText(text);
        addComponent(help);
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

    