package org.eddi.shoppingList.GUI;

import org.eddi.shoppingList.Options.GeneratePDF;
import org.eddi.shoppingList.Options.LoadFiles;
import org.eddi.shoppingList.Options.SaveFiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.*;

public class ListGUI {
    private JPanel pane;
    private JButton hinzufügenButton;
    private JButton speichernButton;
    private JButton beendenButton;
    private JButton ladenButton;
    private JButton leerenButton;
    private JButton PDFErstellenButton;
    private JTextField textField1;
    private JTextPane textPane1;

    private boolean ausgabeIstLeer = true;
    private String eingabe;
    private String ausgabe;
    private int gespeicherteDateien = 0;

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
            }
        });

        PDFErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GeneratePDF generate = new GeneratePDF();
                generate.createPDF();
            }
        });

        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SaveFiles saving = new SaveFiles();
                try {
                    saving.save(textPane1);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        hinzufügenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe = textField1.getText();
                ausgabe = textPane1.getText();

                if(eingabe.matches("")){
                    OptionPanes optionPane = new OptionPanes();
                    optionPane.showErrorMessage();
                    return;
                }

                if(ausgabeIstLeer){
                    textPane1.setText(eingabe);
                    ausgabeIstLeer = false;
                } else {
                    textPane1.setText(ausgabe + System.getProperty("line.separator") + eingabe);
                }
            }
        });
    }

    public JPanel getPane() {
        return pane;
    }
}
