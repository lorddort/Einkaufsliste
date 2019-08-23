package org.eddi.shoppingList.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ListGUI {
    private JPanel pane;
    private JButton hinzufügenButton;
    private JButton speichernButton;
    private JButton dateiErstellenButton;
    private JButton beendenButton;
    private JButton ladenButton;
    private JButton leerenButton;
    private JTextField textField1;
    private JTextPane textPane1;
    private boolean ausgabeIstLeer = true;
    private String eingabe;
    private String ausgabe;

    public ListGUI() {
        beendenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.getFrame().dispatchEvent(new WindowEvent(Main.getFrame(), WindowEvent.WINDOW_CLOSING));
            }
        });
        dateiErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

            }
        });
        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        hinzufügenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe = textField1.getText();
                ausgabe = textPane1.getText();
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
