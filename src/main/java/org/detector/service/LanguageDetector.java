package org.detector.service;

import lombok.NoArgsConstructor;
import org.detector.model.SyntaxFormat;
import org.detector.util.Util;

import java.io.FileNotFoundException;

@NoArgsConstructor
public class LanguageDetector {
    private SyntaxAnalyzer syntaxAnalyzer;

    public LanguageDetector(String fileName) throws FileNotFoundException {
        DocumentReader documentReader = new DocumentReader(fileName);
        this.syntaxAnalyzer = new SyntaxAnalyzer(documentReader, Util.getSyntaxStructureList());
    }

    public SyntaxFormat detectLanguage() {
        return SyntaxFormat.NONE;
    }

}
