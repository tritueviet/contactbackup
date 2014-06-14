/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import Control.Controller;
import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import models.Var;

/**
 *
 * @author TRITUEVIET
 */
public class ViewHome extends Form implements ActionListener{
    private Button backup= new Button(Var.backUp);
    private Button restore= new Button(Var.restore);
    private Command about= new Command(Var.about);
    private Command help= new Command(Var.help);
    private Command exit= new Command(Var.exit);
    
    
    public ViewHome() {
        
        setBackCommand(exit);
        addCommand(about);
        addCommand(help);
        addCommand(exit);
        
        addCommandListener(this);
        
        addComponent(backup);
        addComponent(restore);
        backup.addActionListener(this);
        restore.addActionListener(this);
        
    }
    
    
    
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getCommand()== exit){
            Controller.getInstance().main.destroyApp(true);
        }else if(ae.getCommand()== about){
            Controller.getInstance().showAbout();
        }else if(ae.getCommand()== help){
            Controller.getInstance().showHelp();
        }else if(ae.getSource()== backup){
            Controller.getInstance().backUp();
        }else if(ae.getSource()==restore){
            Controller.getInstance().storeFile();
        }
    }
}
