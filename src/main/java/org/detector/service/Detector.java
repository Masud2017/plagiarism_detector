package org.detector.service;

import org.detector.util.Util;

import java.io.FileNotFoundException;

public class Detector {

    public Detector () {
    }

    public boolean startDetect (String firstFileName, String secondFileName) throws FileNotFoundException {
        DocumentReader documentReaderFirstFile = new DocumentReader(firstFileName);
        DocumentReader documentReaderSecondFile = new DocumentReader(secondFileName);

        SyntaxAnalyzer syntaxAnalyzerFirstFile = new SyntaxAnalyzer(documentReaderFirstFile, Util.getSyntaxStructureList());
        SyntaxAnalyzer syntaxAnalyzerSecondFile = new SyntaxAnalyzer(documentReaderSecondFile, Util.getSyntaxStructureList());

        DocumentDetector documentDetector = new DocumentDetector(syntaxAnalyzerFirstFile.getCleanedLineList()
                                                ,syntaxAnalyzerSecondFile.getCleanedLineList()
                                                ,syntaxAnalyzerFirstFile.analyzeSyntax()
                                                ,syntaxAnalyzerSecondFile.analyzeSyntax());



        return true;
    }

}
