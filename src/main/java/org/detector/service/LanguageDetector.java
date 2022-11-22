package org.detector.service;

import lombok.NoArgsConstructor;
import org.detector.model.SyntaxFormat;
import org.detector.util.Util;

import java.io.FileNotFoundException;
import java.util.List;

@NoArgsConstructor
public class LanguageDetector {
    private SyntaxAnalyzer syntaxAnalyzer;

    public LanguageDetector(String fileName) throws FileNotFoundException {
        Lexer lexer = new Lexer(fileName);
        this.syntaxAnalyzer = new SyntaxAnalyzer(lexer, Util.getSyntaxStructureList());
    }

    public SyntaxFormat detectLanguage() {
        return SyntaxFormat.NONE;
    }

}
