package Control;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.lwuit.Display;
import javax.microedition.midlet.*;

/**
 * @author TRITUEVIET
 */
public class Main extends MIDlet {

    public Main() {
        
    }

    
    public void startApp() {
       Display.init(this);
       Controller.getInstance().chay(this);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }
}
