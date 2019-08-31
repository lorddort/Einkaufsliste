package org.eddi.shoppingList.GUI;

import org.eddi.shoppingList.Main;
import org.eddi.shoppingList.Options.GeneratePDF;
import org.eddi.shoppingList.Products.SavingProducts;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class ListGUI {
    private JPanel panel;
    private JButton hinzufuegenButton;
    private JButton speichernButton;
    private JButton beendenButton;
    private JButton ladenButton;
    private JButton leerenButton;
    private JButton PDFErstellenButton;
    private JTextPane textPane1;
    private JButton neuesProduktButton;
    private JTextField textField1;

    private boolean ausgabeIstLeer = true;
    private String eingabe;
    private String ausgabe;

    private OptionPanes optionPane = new OptionPanes();
    private FileChooser chooseFile = new FileChooser();
    private SavingProducts product = new SavingProducts();

    /**
     * Ein Konstruktor, der viele Listener enthält
     */
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
                if(!ausgabeIstLeer){
                    textPane1.setText(null);
                    ausgabeIstLeer = true;
                }
            }
        });

        ladenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textPane1 = chooseFile.fileOpeningLocation(textPane1);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        PDFErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GeneratePDF generate = new GeneratePDF();
                try {
                    generate.createPDF(textPane1);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    chooseFile.fileSavingLocation(textPane1);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        hinzufuegenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eingabe = textField1.getText();
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

                textField1.setText("");
            }
        });

        neuesProduktButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    product.savingProduct();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    try {
                        eingabe = product.loadListToTextField(textField1.getText());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    textField1.setText(eingabe);
                } else {
                    eingabe = eingabe + Integer.toString(key);
                }
            }
        });
    }

    /**
     * Initializiert ein JPanel
     */
    private void createUIComponents() {
        panel = new JPanel();
    }

    /**
     * Ein Getter für JPanel
     *
     * @return
     *          Gibt JPanel zurück
     */
    public JPanel getPanel() {
        return panel;
    }
}
