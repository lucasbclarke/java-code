import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    
    public static void main(String ar[]) {
        Frame f = new Frame();

        Label l1 = new Label("Select option");

        l1.setBounds(150, 50, 120, 80);
        f.add(l1);

        // CheckBox created
        Checkbox c2 = new Checkbox("1");
        c2.setBounds(150, 150, 80, 50);
        f.add(c2);

        // CheckBox created
        Checkbox c3 = new Checkbox("2");
        c3.setBounds(150, 200, 80, 50);
        f.add(c3);

        // CheckBox created
        Checkbox c4 = new Checkbox("3");
        c4.setBounds(150, 250, 80, 50);
        f.add(c4);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });

    }
}
