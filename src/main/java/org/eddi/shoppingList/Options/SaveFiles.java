package org.eddi.shoppingList.Options;

import org.eddi.shoppingList.GUI.OptionPanes;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFiles {

    OptionPanes optionPane = new OptionPanes();

    public void save(JTextPane textPane) throws IOException {
        String name;
        FileWriter writer;
        File file;

        name = optionPane.namingPane();
        file = new File("src/main/resources/" + name +".txt");
        writer = new FileWriter(file, true);
        writer.write(textPane.getText());
        writer.write(System.getProperty("line.separator"));
        writer.flush();
        writer.close();
    }
}
