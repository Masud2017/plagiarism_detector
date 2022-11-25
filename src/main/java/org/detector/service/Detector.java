package org.detector.service;

import org.detector.model.SyntaxFormat;

import java.io.FileNotFoundException;

public class Detector {

    public Detector () {
    }

    public boolean startDetect (String firstFileName, String secondFileName) throws FileNotFoundException {
        DocumentReader documentReaderFirstFile = new DocumentReader(firstFileName);
        DocumentReader documentReaderSecondFile = new DocumentReader(secondFileName);

        LanguageDetector languageDetector = new LanguageDetector(documentReaderFirstFile,documentReaderSecondFile);

        SyntaxFormat syntaxFormat = languageDetector.detectLanguage();



        return true;
    }

}
