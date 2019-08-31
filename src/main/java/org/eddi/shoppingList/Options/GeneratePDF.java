package org.eddi.shoppingList.Options;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Generiert eine PDF Datei, die sofort geöffnet wird
 */
public class GeneratePDF {
    public void createPDF(JTextPane text) throws Exception {
        String name = "IMG732871_364762";
        Document document = new Document();
        File file = new File(name + ".pdf");
        Desktop desktop = Desktop.getDesktop();

        if(file.exists()){
            file.delete();
        }
        PdfWriter.getInstance(document, new FileOutputStream(name + ".pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        String content = text.getText();
        String[] splitting = content.split("\n");
        for(int i = 0; i < splitting.length; i++){
            Chunk chunk;
            if(i == 0){
                chunk = new Chunk(splitting[i], font);
            } else{
                chunk = new Chunk(", " + splitting[i], font);
            }
            document.add(chunk);
        }
        document.close();

        if(file.exists()) {
            desktop.open(file);
        }
    }
}
