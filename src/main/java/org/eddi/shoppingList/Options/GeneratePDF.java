package org.eddi.shoppingList.Options;

import org.eddi.shoppingList.GUI.OptionPanes;

import javax.swing.text.Document;

public class GeneratePDF {

    OptionPanes optionPane = new OptionPanes();

    public void createPDF(){
        String name;
        name = optionPane.generatePane();

        //Document document = new Document();

    }
}
