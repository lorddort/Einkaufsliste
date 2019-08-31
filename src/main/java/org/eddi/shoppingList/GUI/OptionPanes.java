package org.eddi.shoppingList.GUI;

import javax.swing.*;

public class OptionPanes {

    private String name;

    /**
     * Gibt Fehlermeldungen aus
     *
     * @param message
     *          Die Nachricht, die in der Fehlermeldung steht
     */
    public void showErrorMessage(String message){
        JOptionPane.showMessageDialog(null, message, "Fehlermeldung", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Gibt ein neues Produkt zur Liste hinzu, für das passende Produkt
     *
     * @return
     *          Gibt den Namen zurück
     */
    public String addProductsToList(){
        name = JOptionPane.showInputDialog("Füge ein neues Produkt hinzu");
        return name;
    }
}
