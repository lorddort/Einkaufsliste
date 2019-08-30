package org.eddi.shoppingList.GUI;

import org.eddi.shoppingList.Options.LoadFiles;
import org.eddi.shoppingList.Options.SaveFiles;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class FileChooser {

    SaveFiles saving = new SaveFiles();
    LoadFiles loading = new LoadFiles();
    JFileChooser fileChooser;

    public FileChooser(){
        fileChooser = new JFileChooser();
        JFrame fileChooserFrame = new JFrame("Dateiauswahl");

        fileChooserFrame.setSize(450, 300);
        fileChooserFrame.getContentPane().add(fileChooser);
        fileChooserFrame.setResizable(false);
        fileChooserFrame.setVisible(false);
    }

    public String fileSavingLocation(JTextPane textpane) throws IOException {
        String name = "";
        int i = fileChooser.showSaveDialog(null);
        if(i == JFileChooser.APPROVE_OPTION) {
            saving.save(textpane, fileChooser);
        }
        fileChooser.setVisible(true);
        return name;
    }

    public JTextPane fileOpeningLocation(JTextPane textpane) throws IOException {
        JTextPane textpane1 = null;
        int i = fileChooser.showOpenDialog(null);
        if(i == JFileChooser.APPROVE_OPTION) {
            loading.load(textpane);
        }
        fileChooser.setVisible(true);
        return textpane1;
    }
}
