package org.example.filecounter.repository.formatFabric;


import org.example.filecounter.repository.formatFabric.DocumentFabric.DocumentFabricImpl.DocxFabricImpl;
import org.example.filecounter.repository.formatFabric.DocumentFabric.DocumentFabricImpl.PdfFabricImpl;
import org.example.filecounter.repository.formatFabric.DocumentFabric.DocumentFabric;

import java.util.HashMap;
import java.util.Map;

public class DocumentProcessorFabric {
    public static final Map<String, DocumentFabric> PROCESSORS = new HashMap<>();

    static {
        PROCESSORS.put("pdf", new PdfFabricImpl());
        PROCESSORS.put("docx", new DocxFabricImpl());
    }

    public static DocumentFabric getProcessor(String format) {
        return PROCESSORS.get(format);
    }

}
