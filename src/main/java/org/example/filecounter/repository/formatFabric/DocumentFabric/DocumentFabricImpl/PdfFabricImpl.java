package org.example.filecounter.repository.formatFabric.DocumentFabric.DocumentFabricImpl;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.example.filecounter.repository.formatFabric.DocumentFabric.DocumentFabric;

import java.io.File;
import java.io.IOException;

public class PdfFabricImpl implements DocumentFabric {
    @Override
    public int countPages(File file) {
        if (file.length() == 0) {
            return 0;
        }

        try (PDDocument document = PDDocument.load(file)) {
            return document.getNumberOfPages();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
