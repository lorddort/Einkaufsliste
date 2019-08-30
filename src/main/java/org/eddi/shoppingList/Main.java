package org.eddi.shoppingList;

import org.eddi.shoppingList.GUI.ListGUI;
import javax.swing.*;

public class Main {
    private static JFrame frame;

    public static JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args){
        frame = new JFrame("Einkaufsliste");
        frame.setContentPane(new ListGUI().getPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(700,300);
        frame.setResizable(false);
        frame.setLocation(400,300);
        frame.setVisible(true);
    }
}
