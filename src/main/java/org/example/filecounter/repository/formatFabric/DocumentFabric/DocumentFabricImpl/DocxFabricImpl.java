package org.example.filecounter.repository.formatFabric.DocumentFabric.DocumentFabricImpl;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.example.filecounter.repository.formatFabric.DocumentFabric.DocumentFabric;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DocxFabricImpl implements DocumentFabric {
    @Override
    public int countPages(File file) {
        if (file == null || !file.exists() || file.length() == 0) {
            return 0;
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            XWPFDocument document = new XWPFDocument(fis);
            int pageCount = document.getProperties().getExtendedProperties().getPages();
            return pageCount;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
