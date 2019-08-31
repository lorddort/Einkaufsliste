package org.eddi.shoppingList.Options;

import org.eddi.shoppingList.GUI.OptionPanes;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFiles {

    private OptionPanes optionPane = new OptionPanes();

    /**
     * Speichert die Einkaufsliste, damit der Benutzer später noch darauf zugreifen kann. Der Speicherort kann frei gewählt werden.
     *
     * @param textPane
     *          Der Bereich, wo die Einkaufsliste steht
     * @param fileChooser
     *          Das Fenster, wo der Benutzer den Speicherort freiwählen kann
     * @throws IOException
     *          wirft eine IOException
     */
    public void save(JTextPane textPane, JFileChooser fileChooser) throws IOException {
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
        writer = new FileWriter(fileChooser.getSelectedFile() + ".txt", true);
        writer.write(textPane.getText());
        writer.write(System.getProperty("line.separator"));
        writer.flush();
        writer.close();
    }
}
