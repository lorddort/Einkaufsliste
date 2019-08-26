package org.eddi.shoppingList.Options;

import org.eddi.shoppingList.GUI.FileChooser;
import org.eddi.shoppingList.GUI.OptionPanes;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoadFiles {

    OptionPanes optionPane = new OptionPanes();

    public JTextPane load(JTextPane textPane) throws IOException {
        String name;
        name = optionPane.searchingPane();
        String direction = "src/main/resources/" + name + ".txt";
        boolean einzeiler = true;
        //FileChooser chooseFile = new FileChooser();

        File file = new File(direction);
        if (!file.canRead() || !file.isFile()) {
            optionPane.notExistingFile();
            throw new IOException();
        }

        BufferedReader read = new BufferedReader(new FileReader(file));
        String newLine;
        String oldLines = null;
        while ((newLine = read.readLine()) != null) {
            if(einzeiler){
                textPane.setText(newLine);
                oldLines = newLine;
                einzeiler = false;
            } else {
                textPane.setText(oldLines + System.getProperty("line.separator") + newLine);
                oldLines = textPane.getText();
            }
        }
        read.close();
        return textPane;
    }
}
