package org.eddi.shoppingList.GUI;

import javax.swing.*;

public class OptionPanes {

    String name;

    public String namingPane(){
        name = JOptionPane.showInputDialog("Benenne die Einkaufsliste");
        return name;
    }

    public String searchingPane(){
        name = JOptionPane.showInputDialog("Name des zuladenen Datei");
        return name;
    }

    public String generatePane(){
        name = JOptionPane.showInputDialog("Welche Datei soll erstellt werden");
        return name;
    }

    public void duplicateName(){
        JOptionPane.showMessageDialog(null, "Name existiert schon", "Fehlermeldung", JOptionPane.ERROR_MESSAGE);
    }

    public void showErrorMessage(String message){
        JOptionPane.showMessageDialog(null, message, "Fehlermeldung", JOptionPane.ERROR_MESSAGE);
    }

    public void notExistingFile(){
        JOptionPane.showMessageDialog(null, "Einkaufsliste existiert nicht", "Fehlermeldung", JOptionPane.ERROR_MESSAGE);
    }
}
