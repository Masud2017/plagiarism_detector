package org.detector.service;

import org.detector.model.SyntaxFormat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class SyntaxAnalyzer {
    List<File> syntaxFileList;
    private Lexer lexer;
    private List<Scanner> scannerList;
    private SyntaxFormat syntaxFormat;

    public SyntaxAnalyzer(Lexer lexer,List<File> syntaxFileList) throws FileNotFoundException {
        this.lexer = lexer;
        this.syntaxFileList = syntaxFileList;

        for(File fileItem : this.syntaxFileList) {
            this.scannerList.add(new Scanner(fileItem)); // getting scanner for all the files
        }
    }

}
