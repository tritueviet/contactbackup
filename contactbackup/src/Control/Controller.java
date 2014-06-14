/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import com.sun.lwuit.Container;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.TextArea;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;
import event.Event;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.pim.Contact;
import javax.microedition.pim.ContactList;
import javax.microedition.pim.PIM;
import javax.microedition.pim.PIMException;
import javax.microedition.pim.PIMItem;
import models.Var;
import views.LoadScreen;
import views.ViewAbout;
import views.ViewHelp;
import views.ViewHome;

/**
 *
 * @author TRITUEVIET
 */
public class Controller {

    private static Controller instance = null;
    //public CategoryBar categoryBar;
    public Main main;
    public static Resources theme = null;
    public static int size = 401;
    public ViewHome viewHome;
    public ViewAbout viewAbout;
    public ViewHelp viewHelp;
    private PIM pim1 = null;
    private String[] pimListNames1 = null;
    private ContactList contactList = null;

    private Controller() {
    }

    public static void loadTheme() {
        System.out.println(" size: " + size);
        try {
            if (size > 350) {
                theme = Resources.open("/themes/full_touch_theme.res");
                System.out.println(" chay");
            } else {
                theme = Resources.open("/themes/asha2013_theme.res");
            }
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
        } catch (Throwable ex) {
            System.out.println("loi load theme");
        }
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void chay(Main main) {
        this.main = main;
        if (0 == 0) {
            LoadScreen load = new LoadScreen(main);
            javax.microedition.lcdui.Display.getDisplay(main).setCurrent(load);
            load.start();
            load = null;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        loadTheme();

        //  show in here
        showHome();
    }

    public void handleEvent(int eventType, Event evt) {
        switch (eventType) {

        }
    }

    public void exit() {
        //   saveConfig();
        main.destroyApp(true);
    }

    public void showAbout() {
        // hiển thị giới thiệu
        viewAbout = new ViewAbout();
        viewAbout.show();
    }

    public void showHelp() {
        // hiển thị giới thiệu
        viewHelp = new ViewHelp();
        viewHelp.show();
    }

    public void showHome() {
        viewHome = new ViewHome();
        viewHome.show();
    }

    public void backUp() {
        javax.microedition.lcdui.Alert retrieve = new javax.microedition.lcdui.Alert("Please wait....");
        retrieve.setType(AlertType.WARNING);
        retrieve.setTimeout(Alert.FOREVER);
        
        javax.microedition.lcdui.Display.getDisplay(main).setCurrent(retrieve);
        new Thread(new Runnable() {

            public void run() {

                Enumeration contacts = null;
                pim1 = PIM.getInstance();

                pimListNames1 = pim1.listPIMLists(PIM.CONTACT_LIST);

                try {
                    contactList = (ContactList) pim1.openPIMList(
                            PIM.CONTACT_LIST, PIM.READ_ONLY);
                } catch (PIMException ex) {
                    ex.printStackTrace();
                }
                try {
                    contacts = contactList.items();
//            Contact c = (Contact) contacts.nextElement();
//            System.out.println("--- "+c.getString(Contact.NAME, 0));
                } catch (PIMException ex) {
                    ex.printStackTrace();
                }
                releaseContactList();

                for (int i = 0; i < pimListNames1.length; i++) {
                    System.out.println("  - " + pimListNames1[i]);
                }

                if (!contacts.hasMoreElements()) {
                    showAlert("Contact list is empty!", "");

                } else {

                    try {
                        for (int i = 0; i < pimListNames1.length; i++) {
                            //System.out.println(" chay 1 ....");
                            ContactList cl = (ContactList) PIM.getInstance().openPIMList(
                                    PIM.CONTACT_LIST, PIM.READ_WRITE, pimListNames1[i]);

                            Enumeration items = cl.items();

                            while (items.hasMoreElements()) {
                                Contact c = (Contact) items.nextElement();
                                String[] nameArray = c.getStringArray(Contact.NAME, 0);
                                String phone = "";
                                String name = "";

                                phone = c.getString(Contact.TEL, 0);

                                for (int j = 0; j < nameArray.length; j++) {
                                    if (nameArray[j] != null) {
                                        name += nameArray[j];
                                    }
                                }
                                System.out.println("  " + phone + "   " + name);
                                Var.name.addElement(name);
                                Var.phone.addElement(phone);
                            }
                        }
                    } catch (Exception e) {
                    } finally {
                        saveFile();
                    }
                }
            }
        }).start();

    }

    public void storeFile() {
       javax.microedition.lcdui.Alert retrieve = new javax.microedition.lcdui.Alert("Please wait....");
        retrieve.setType(AlertType.WARNING);
        retrieve.setTimeout(Alert.FOREVER);
        javax.microedition.lcdui.Display.getDisplay(main).setCurrent(retrieve);
        new Thread(new Runnable() {

            public void run() {

                FileConnection fconn = null;
                DataInputStream in = null;
                try {
                    fconn = (FileConnection) Connector.open(System.getProperty("fileconn.dir.photos") + "backupContact.bak");
                    if (!fconn.exists()) {
                        showAlert("messenger", "Not found file! " + System.getProperty("fileconn.dir.photos") + "backupContact.bak" );
                    } else {
                        in = fconn.openDataInputStream();
                        Var.name.removeAllElements();
                        Var.phone.removeAllElements();

                        int k = in.readInt();
                        int kt = 0;
                        for (int i = 0; i < k; i++) {
                            Var.name.addElement(in.readUTF());
                            Var.phone.addElement(in.readUTF());

                            System.out.println(" - " + Var.name.elementAt(i) + " - " + Var.phone.elementAt(i));

                            if (SaveContact(Var.name.elementAt(i).toString(), Var.phone.elementAt(i).toString()) == 1) {
                                kt = 1;
                            }

                        }
                        if (kt == 1) {
                            showAlert("messenger", "Error!");
                        } else {
                            showAlert("messenger", "Successful!");
                        }
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }).start();
    }

    public void saveFile() {
        FileConnection fconn = null;
        DataOutputStream dos = null;
        try {
            fconn = (FileConnection) Connector.open(System.getProperty("fileconn.dir.photos") + "backupContact.bak");
            if (!fconn.exists()) {
                fconn.create();
            }

            dos = new DataOutputStream(fconn.openOutputStream());
            dos.writeInt(Var.name.size());

            for (int i = 0; i < Var.name.size(); i++) {
                dos.writeUTF(Var.name.elementAt(i).toString());
                dos.writeUTF(Var.phone.elementAt(i).toString());
            }

            dos.close();
            fconn.close();
        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            showAlert("messenger", "Successful!");
        }

    }

    public void showAlert(String tittle0, String tittle1) {

        Dialog diag = new Dialog(tittle1);
        diag.setHeight(320);
        Container con1 = new Container();
        TextArea ta = new TextArea("", 2, 10);
        ta.getStyle().setFgColor(0xffffff);
        con1.addComponent(ta);
        com.sun.lwuit.Command cv = new com.sun.lwuit.Command(Var.back);
        diag.setBackCommand(cv);
        diag.addCommand(cv);
        diag.setTimeout(2000);
        diag.show();
    }

    private void releaseContactList() {
        if (contactList != null) {
            try {

                contactList.close();
            } catch (PIMException ex) {
            }
        }
        contactList = null;
    }
    //   tra ve 0 la okie 1 là k thanh cong 2 la trung ten

    public int SaveContact(String nameContact, String phoneNo ) {
        System.out.println("" + phoneNo + "..." + nameContact);
        int ok = 0;
        ContactList clist = null;
        try {
            clist = (ContactList) PIM.getInstance().openPIMList(PIM.CONTACT_LIST, PIM.READ_WRITE);
        } catch (PIMException e) {
            e.printStackTrace();
            System.out.println("loi doc");
            ok = 1;
        }
        Enumeration itemsEnum = null;
        InputStream is = null;

        Contact searchPattern = null;
        if (clist == null) {
            System.out.println("list trống");
            ok = 1;
        }
        Contact result = null;
        try {
            result = clist.createContact();
            searchPattern = clist.createContact();
            searchPattern.addString(Contact.TEL, Contact.ATTR_NONE, phoneNo);
            // tìm kiếm contact xem có trùng k
            itemsEnum = clist.items(searchPattern);
            boolean wasFound = false;
            if (itemsEnum != null && itemsEnum.hasMoreElements()) {
                //  controller.showAlert(Var.NULL[0],Var.NULL[1]);//
                wasFound = true;
                result = (Contact) itemsEnum.nextElement();
                ok = 2;
            }
            if (!wasFound) {
                // contact chưa tồn tại tạo mới nó
                String[] name = new String[clist.stringArraySize(Contact.NAME)];
                if (clist.isSupportedArrayElement(Contact.NAME, Contact.NAME_GIVEN)) {
                    name[Contact.NAME_GIVEN] = nameContact;
                    //name[Contact.NAME_FAMILY] = nameContact;
                }
                result.addStringArray(Contact.NAME, PIMItem.ATTR_NONE, name);

                if (clist.isSupportedField(Contact.TEL)) {
                    result.addString(Contact.TEL, Contact.ATTR_MOBILE, phoneNo);
                    // result.addString(Contact.TEL, Contact.ATTR_FAX, phoneNo);

                }

//                if (clist.isSupportedField(Contact.EMAIL)) {
//                    result.addString(Contact.EMAIL, Contact.ATTR_NONE, email);
//                }
//
//                if (clist.isSupportedField(Contact.ORG)) {
//                    result.addString(Contact.ORG, Contact.ATTR_NONE, TestCorporation);
//                }
//
//                if (clist.isSupportedField(Contact.BIRTHDAY)) {
//                    //result.addDate(Contact.BIRTHDAY, Contact.ATTR_NONE, Long.parseLong(date));
//                }
            }
            try {
                result.commit();
            } catch (PIMException f) {
                //     Dialog.show("Exception", Var.error[Var.language].toString(), "OK", null);
                ok = 1;
            }
        } catch (Exception e) {
            //  Dialog.show("Exception", Var.error[Var.language].toString(), "OK", null);
            e.printStackTrace();
        } finally {
            searchPattern = null;
            result = null;
            itemsEnum = null;
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    //        Dialog.show("Exception", Var.error[Var.language].toString(), "OK", null);
                    ok = 1;
                }
                is = null;
            }
            if (clist != null) {
                try {
                    clist.close();
                } catch (PIMException e) {
                    //        Dialog.show("Exception", Var.error[Var.language].toString(), "OK", null);
                    ok = 1;
                }
                clist = null;
            }
        }
        return ok;

    }
}