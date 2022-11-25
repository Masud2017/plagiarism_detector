package org.detector.service;

import org.detector.model.SyntaxFormat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class SyntaxAnalyzer {
    List<File> syntaxFileList;
    private DocumentReader documentReader;
    private List<Scanner> scannerList;
    private SyntaxFormat syntaxFormat;

    public SyntaxAnalyzer(DocumentReader documentReader, List<File> syntaxFileList) throws FileNotFoundException {
        this.documentReader = documentReader;
        this.syntaxFileList = syntaxFileList;

        for(File fileItem : this.syntaxFileList) {
            this.scannerList.add(new Scanner(fileItem)); // getting scanner for all the files
        }
    }

    public SyntaxFormat analyzeSyntax() {

        return SyntaxFormat.NONE;
    }

}
