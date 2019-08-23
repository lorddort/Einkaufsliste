package org.eddi.shoppingList.GUI;

import javax.swing.*;

public class Main {
    private static JFrame frame;

    public static JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args){
        frame = new JFrame("Einkaufsliste");
        frame.setContentPane(new ListGUI().getPane());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
