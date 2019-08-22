package org.eddi.shoppingList.GUI;

import javax.swing.*;

public class ListGUI {
    private JTextField textField1;
    private JButton suchenButton;
    private JList list1;
    private JButton speichernButton;
    private JButton dateiErstellenButton;
    private JButton beendenButton;
    private JButton ladenButton;
    private JPanel pane;
    private JButton leerenButton;

    public void startListFrame(){
        JFrame frame = new JFrame("Einkaufsliste");
        frame.setContentPane(new ListGUI().pane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
