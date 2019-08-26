package org.eddi.shoppingList.GUI;

import javax.swing.*;

public class FileChooser {

    public FileChooser(){
        JFileChooser fileChooser = new JFileChooser();
        JFrame fileChooserFrame = new JFrame("Dateiauswahl");

        fileChooserFrame.setSize(450, 300);
        fileChooserFrame.getContentPane().add(fileChooser);
        fileChooserFrame.setResizable(false);
        fileChooserFrame.setVisible(true);
    }
}
