package org.eddi.shoppingList.GUI;

import org.eddi.shoppingList.Options.LoadFiles;
import org.eddi.shoppingList.Options.SaveFiles;

import javax.swing.*;
import java.io.IOException;

public class FileChooser {

    private SaveFiles saving = new SaveFiles();
    private LoadFiles loading = new LoadFiles();
    private JFileChooser fileChooser;

    /**
     * Konstruktor, der das Fenster setzt
     */
    public FileChooser(){
        fileChooser = new JFileChooser();
        JFrame fileChooserFrame = new JFrame("Dateiauswahl");

        fileChooserFrame.setSize(450, 300);
        fileChooserFrame.getContentPane().add(fileChooser);
        fileChooserFrame.setResizable(false);
        fileChooserFrame.setVisible(false);
    }

    /**
     * Datei, welche an einen beliebigen Ort gespeichert werden soll
     *
     * @param textpane
     *          Der Bereich, wo die Einkaufsliste steht
     * @return
     *          Gibt den Namen der Datei zurück
     * @throws IOException
     *          wirft eine IOException
     */
    public String fileSavingLocation(JTextPane textpane) throws IOException {
        String name = "";
        int i = fileChooser.showSaveDialog(null);
        if(i == JFileChooser.APPROVE_OPTION) {
            saving.save(textpane, fileChooser);
        }
        fileChooser.setVisible(true);
        return name;
    }

    /**
     * Datei, welches geladen werden soll
     *
     * @param textpane
     *          Der Bereich, wo die Einkaufsliste steht
     * @return
     *          Gibt den Namen der Datei zurück
     * @throws IOException
     *          wirft eine IOException
     */
    public JTextPane fileOpeningLocation(JTextPane textpane) throws IOException {
        JTextPane textpane1 = new JTextPane();
        int i = fileChooser.showOpenDialog(null);
        if(i == JFileChooser.APPROVE_OPTION) {
            textpane1 = loading.load(textpane, fileChooser);
            return textpane1;
        }
        fileChooser.setVisible(true);
        return textpane1;//TODO
    }
}
