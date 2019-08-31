package org.eddi.shoppingList.Options;

import org.eddi.shoppingList.GUI.OptionPanes;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoadFiles {

    private OptionPanes optionPane = new OptionPanes();

    /**
     * Lädt die ausgewählte Datei in die Einkaufsliste
     *
     * @param textPane
     *          Der Bereich, wo die Einkaufsliste steht
     * @param fileChooser
     *          Das Fenster, wo der Benutzer den Speicherort freiwählen kann
     * @return
     *          Gibt den ausgewählten Namen zurück
     * @throws IOException
     *          wirft eine IOException
     */
    public JTextPane load(JTextPane textPane, JFileChooser fileChooser) throws IOException {
        boolean einzeiler = true;

        File file = fileChooser.getSelectedFile();
        if (!file.exists()) {
            optionPane.showErrorMessage("Datei existiert nicht");
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
