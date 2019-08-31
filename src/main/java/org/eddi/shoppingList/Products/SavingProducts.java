package org.eddi.shoppingList.Products;

import org.eddi.shoppingList.GUI.OptionPanes;

import java.io.*;

public class SavingProducts {

    private OptionPanes optionPane = new OptionPanes();
    private String path = "src/main/resources/Produktliste.txt";
    private File file = new File(path);
    private int needKey = 1;

    /**
     * Speichert das Produkt, welches der Benutzer später weiterbenutzen kann um das passende Produkt vorzuschlagen
     *
     * @throws IOException
     *          wirft eine IOException
     */
    public void savingProduct() throws IOException {
        String productName = optionPane.addProductsToList();
        FileWriter writer = new FileWriter(path, true);
        writer.write(productName);
        writer.write(System.getProperty("line.separator"));
        writer.flush();
        writer.close();
    }

    /**
     * Lädt das passende Produkt in das Eingabefeld
     *
     * @param product
     *          die Eingabe, die der Benutzer eingegeben hat
     * @return
     *          gibt das passende Produkt zurück, welches in das Eingabefeld kommt
     * @throws IOException
     *          wirft eine IOException
     */
    public String loadListToTextField(String product) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(file));
        String newLine;
        int currentKey = 0;
        while ((newLine = read.readLine()) != null && currentKey != needKey) {
            if(newLine.toLowerCase().contains(product)){
                product = newLine;
                currentKey++;
            }
        }
        return product;
    }
}
