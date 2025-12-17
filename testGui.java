import java.awt.*;
import java.awt.event.*;

import static javax.swing.JOptionPane.*;

public class testGui {
    
    public static void main(String ar[]) {
        Frame f = new Frame("Custom Checkbox application");

        Label l1 = new Label("Select option");

        l1.setBounds(150, 50, 120, 80);
        f.add(l1);

        Checkbox c2 = new Checkbox("1");
        c2.setBounds(150, 150, 80, 50);
        f.add(c2);

        Checkbox c3 = new Checkbox("2");
        c3.setBounds(150, 200, 80, 50);
        f.add(c3);

        Checkbox c4 = new Checkbox("3");
        c4.setBounds(150, 250, 80, 50);
        f.add(c4);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (showConfirmDialog(f, "Are you sure you want to exit?", "Exiting Application!", YES_NO_OPTION, WARNING_MESSAGE) == YES_OPTION) {
                    f.dispose();
                }

            }
        });

        PopupMenu pm = new PopupMenu("Select an option");
        pm.add("Option 1");
        pm.add("Option 2");
        pm.add("Option 3");
        pm.add("Option 4");
        pm.add("Option 5");
        f.add(pm); 

        f.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                }
            }
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    pm.show(f, e.getX(), e.getY());
                }
           }

        });

    }
}
