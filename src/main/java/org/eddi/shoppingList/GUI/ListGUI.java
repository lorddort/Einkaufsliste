package org.eddi.shoppingList.GUI;

import org.eddi.shoppingList.Main;
import org.eddi.shoppingList.Options.GeneratePDF;
import org.eddi.shoppingList.Options.LoadFiles;
import org.eddi.shoppingList.Options.SaveFiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;

public class ListGUI {
    private JPanel panel;
    private JButton hinzufügenButton;
    private JButton speichernButton;
    private JButton beendenButton;
    private JButton ladenButton;
    private JButton leerenButton;
    private JButton PDFErstellenButton;
    private JTextPane textPane1;
    private JComboBox comboBox1;

    private boolean ausgabeIstLeer = true;
    private String eingabe;
    private String ausgabe;
    private String name;

    OptionPanes optionPane = new OptionPanes();
    FileChooser chooseFile = new FileChooser();

    public ListGUI() {

        beendenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getFrame().dispatchEvent(new WindowEvent(Main.getFrame(), WindowEvent.WINDOW_CLOSING));
            }
        });

        leerenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ausgabeIstLeer != true){
                    textPane1.setText(null);
                    ausgabeIstLeer = true;
                }
            }
        });

        ladenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoadFiles loading = new LoadFiles();
                try {
                    textPane1 = loading.load(textPane1);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                name = loading.getName();
            }
        });

        PDFErstellenButton.addActionListener(new ActionListener() {
            //TODO PDF ordentlich Liste erstellen
            @Override
            public void actionPerformed(ActionEvent e) {
                GeneratePDF generate = new GeneratePDF();
                try {
                    generate.createPDF(textPane1, name);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    name = chooseFile.fileSavingLocation(textPane1);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        hinzufügenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe = comboBox1.getSelectedItem().toString();
                ausgabe = textPane1.getText();

                if(eingabe.matches("")){
                    optionPane.showErrorMessage("Keine Eingaben");
                    return;
                }

                if(ausgabeIstLeer){
                    textPane1.setText(eingabe);
                    ausgabeIstLeer = false;
                } else {
                    textPane1.setText(ausgabe + System.getProperty("line.separator") + eingabe);
                }

                comboBox1.removeAllItems();
            }
        });
    }

    private void createUIComponents() {
        panel = new JPanel();
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextPane getTextPane1() {
        return textPane1;
    }

    public String getName() {
        return name;
    }
}
