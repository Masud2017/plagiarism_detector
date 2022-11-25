package org.detector.service;

import org.detector.model.DocType;

import java.util.List;

public class DocumentProcessorFactory {
    private DocumentProcessorFactory() {}

    public static DocumentProcessor getDocumentProcessor(List<String> lineList, DocType docType) {
        if (docType == DocType.DOCUMENT) {
            return new TextDocumentProcessor(lineList);
        } else if (docType == DocType.LANGUAGE) {
            return new LanguageDocumentProcessor(lineList);
        }

        return null;
    }
}
