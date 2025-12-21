import java.awt.*;
import java.awt.event.*;

import static javax.swing.JOptionPane.*;


public class testGui {
    Checkbox c2, c3, c4;
    Label l1;
    String SavedText;
    Color DefaultButtonColour;

    public void TestGui() {
        Frame f = new Frame("Custom GUI testing application");

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
            public void actionPerformed(ActionEvent event) {
                l1.setText("You have clicked the button");
            }
        });

        TextArea t1 = new TextArea("", 500, 100, TextArea.SCROLLBARS_VERTICAL_ONLY);
        t1.setBounds(150, 400, 380, 100);
        f.add(t1);
        t1.setSelectionStart(0);
        t1.setSelectionEnd(t1.getText().length());
        
        t1.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A && e.isControlDown()) {
                    t1.selectAll();
                }
            }
        });


        Button b2 = new Button("Click to save text");
        b2.setBounds(150, 500, 150, 50);
        f.add(b2);
        DefaultButtonColour = b2.getBackground();

         b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                SavedText = t1.getText();
                b2.setBackground(Color.green);
                b2.setLabel("Text Saved");
                try {
                    Thread.sleep(700); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b2.setBackground(DefaultButtonColour);
                b2.setLabel("Click to save text");

            }
        });

        Button b3 = new Button("Click to recall saved text");
        b3.setBounds(300, 500, 200, 50);
        f.add(b3);

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                l1.setText(SavedText);
                b3.setBackground(Color.green);
                b3.setLabel("Text Recalled");
                try {
                    Thread.sleep(700); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                b3.setBackground(DefaultButtonColour);
                b3.setLabel("Click to recall saved text");
            }
        });


        List list1 = new List(5);
        list1.setBounds(150, 600, 380, 100);
        f.add(list1);

        list1.add("Item 1");
        list1.add("Item 2");
        list1.add("Item 3");
        list1.add("Item 4");
        list1.add("Item 5");
        
        list1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                l1.setText("You have selected " + list1.getSelectedItem());
            }
        });


        Choice c = new Choice();
        c.add("Option 1");
        c.add("Option 2");
        c.add("Option 3");
        c.add("Option 4");
        c.add("Option 5");
        c.setBounds(150, 700, 100, 20);
        f.add(c);

        c.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                l1.setText("You have selected " + c.getSelectedItem());
            }
        });
        
        f.setSize(800, 800);
        f.setLayout(null);
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
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
