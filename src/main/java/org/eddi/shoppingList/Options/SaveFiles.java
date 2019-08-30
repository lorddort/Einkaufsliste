package org.eddi.shoppingList.Options;

import org.eddi.shoppingList.GUI.OptionPanes;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFiles {

    OptionPanes optionPane = new OptionPanes();
    String name;

    public String save(JTextPane textPane, JFileChooser fileChooser) throws IOException {
        FileWriter writer;
        File file;

        file = new File(fileChooser.getSelectedFile() + ".txt");
        if(file.exists()){
            optionPane.showErrorMessage("Datei existiert schon");
            throw new IOException();
        }
        String[] splitName = file.getName().split(".txt");
        if(splitName.length > 1){
            optionPane.showErrorMessage("Ungültige Eingabe");
            throw new IOException();
        }
        name = splitName[0];
        writer = new FileWriter(fileChooser.getSelectedFile() + ".txt", true);
        writer.write(textPane.getText());
        writer.write(System.getProperty("line.separator"));
        writer.flush();
        writer.close();
        return name;
    }
}
