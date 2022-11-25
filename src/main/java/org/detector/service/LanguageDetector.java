package org.detector.service;

import lombok.NoArgsConstructor;
import org.detector.model.SyntaxFormat;
import org.detector.util.Util;

import java.io.FileNotFoundException;
import java.util.List;

@NoArgsConstructor
public class LanguageDetector {
    private SyntaxAnalyzer syntaxAnalyzerFirstFile;
    private SyntaxAnalyzer syntaxAnalyzerSecondFile;

    public LanguageDetector(DocumentReader documentReaderFirstFile,DocumentReader documentReaderSecondFile) throws FileNotFoundException {
        this.syntaxAnalyzerFirstFile = new SyntaxAnalyzer(documentReaderFirstFile, Util.getSyntaxStructureList());
        this.syntaxAnalyzerSecondFile = new SyntaxAnalyzer(documentReaderSecondFile, Util.getSyntaxStructureList());
    }

    public SyntaxFormat detectLanguage() {
        return SyntaxFormat.NONE;
    }
}
