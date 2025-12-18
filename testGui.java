import java.awt.*;
import java.awt.event.*;
import javax.swing.Action;
import static javax.swing.JOptionPane.*;

public class testGui {
    Checkbox c2, c3, c4;
    Label l1;

    public void TestGui() {
        Frame f = new Frame("Custom Checkbox application");

        l1 = new Label("Select option");

        l1.setBounds(150, 50, 380, 80);
        f.add(l1);

        c2 = new Checkbox("1");
        c2.setBounds(150, 150, 80, 50);
        f.add(c2);

        c2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    l1.setText("You have selected the first checkbox");
                } else {
                    l1.setText("Seclect Option");
                }
            }
        });

        c3 = new Checkbox("2");
        c3.setBounds(150, 200, 80, 50);
        f.add(c3);

        c3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    l1.setText("You have selected the second checkbox");
                } else {
                    l1.setText("Seclect Option");
                }
            }
        });

        c4 = new Checkbox("3");
        c4.setBounds(150, 250, 80, 50);
        f.add(c4);

        c4.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    l1.setText("You have selected the third checkbox");
                } else {
                    l1.setText("Seclect Option");
                }
            }
        });

        ItemListener sharedListener = new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (c2.getState() && c3.getState() && c4.getState()) {
                    l1.setText("All checkboxes are selected");
                } else if (c2.getState() && c3.getState() && !c4.getState()) {
                    l1.setText("You have selected the first and second checkbox");
                } else if (c2.getState() && !c3.getState() && c4.getState()){
                    l1.setText("You have selected the first and third checkbox");
                } else if (!c2.getState() && c3.getState() && c4.getState()){
                    l1.setText("You have selected the second and third checkbox");
                } else if (c2.getState() && !c3.getState()) {
                    l1.setText("You have selected the first checkbox");
                } else if (!c2.getState() && c3.getState()) {
                    l1.setText("You have selected the second checkbox");
                } else if (c4.getState() && !c3.getState()) {
                    l1.setText("You have selected the third checkbox");
                } else if (!c4.getState() && c3.getState()) {
                    l1.setText("You have selected the second checkbox");
                }


            }
        };
        
        c2.addItemListener(sharedListener);
        c3.addItemListener(sharedListener);
        c4.addItemListener(sharedListener);

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

        Button b1 = new Button("OK");
        b1.setBounds(150, 300, 80, 50);
        f.add(b1);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("You have clicked the button");
            }
        });

        TextArea t1 = new TextArea("", 500, 100, TextArea.SCROLLBARS_VERTICAL_ONLY);
        t1.setBounds(150, 400, 380, 100);
        f.add(t1);
        t1.setSelectionStart(0);
        t1.setSelectionEnd(t1.getText().length());

        Button b2 = new Button("Save Text");
        b2.setBounds(150, 850, 80, 50);
        f.add(b2);

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("You have clicked the button");
            }
        });


        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (showConfirmDialog(f, "Are you sure you want to exit?", "Exiting Application!", YES_NO_OPTION, WARNING_MESSAGE) == YES_OPTION) {
                    System.exit(0);
                }

            }
        });
    }

    public static void main(String ar[]) {
        testGui g = new testGui();
        g.TestGui();
    }

}
