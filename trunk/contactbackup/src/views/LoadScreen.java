package views;

import Control.Controller;
import Control.Lib_png;
import Control.Main;
import java.io.*;
import java.util.Random;
import javax.microedition.lcdui.*;
import javax.microedition.lcdui.game.GameCanvas;

/**
 * @WAll
 */
public class LoadScreen extends GameCanvas {

    private Graphics g;
    Main main;
    Image img;

    public LoadScreen(Main main) {
        super(false);
        
        try {
            img = Image.createImage("/images/conga.png");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        this.g = this.getGraphics();
        this.main = main;
        Controller.getInstance().size = getHeight();
        setFullScreenMode(true);
    }

    public void paint() {
        g.setColor(0xffffff);
        g.fillRect(0, 0, getWidth(), getHeight());
        try {
            g.drawImage(img, getWidth() / 2, getHeight() / 2, Graphics.VCENTER | Graphics.HCENTER);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.flushGraphics();

    }

    public void start() {

        paint();

    }
}
