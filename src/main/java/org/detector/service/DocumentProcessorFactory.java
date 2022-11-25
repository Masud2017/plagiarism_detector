package org.detector.service;

import org.detector.model.SyntaxFormat;

import java.util.List;

public class DocumentProcessorFactory {
    private DocumentProcessorFactory() {}

    public static DocumentProcessor getDocumentProcessor(List<String> lineList, SyntaxFormat syntaxFormat) {
        if (syntaxFormat == SyntaxFormat.NONE) {
            return new TextDocumentProcessor(lineList);
        } else {
            return new LanguageDocumentProcessor(lineList);
        }
    }
}
