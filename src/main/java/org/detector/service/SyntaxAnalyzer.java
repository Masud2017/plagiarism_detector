package org.detector.service;

import org.detector.model.LanguageSyntax;
import org.detector.model.SyntaxFormat;
import org.detector.util.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SyntaxAnalyzer {
    private List<File> syntaxFileList;
    private final DocumentReader documentReader;
    private SyntaxFormat currentFileExtensionType;

    public SyntaxAnalyzer(DocumentReader documentReader, List<File> syntaxFileList) throws FileNotFoundException {
        this.documentReader = documentReader;
        this.syntaxFileList = syntaxFileList;
        this.currentFileExtensionType = SyntaxFormat.NONE;
    }


    private Map<SyntaxFormat,LanguageSyntax> getExtensionLanguageSyntaxMapper() throws FileNotFoundException {
        Map<SyntaxFormat,LanguageSyntax> extensionLanguageSyntaxMapper = new HashMap<>();

        Iterator<File> iter = this.syntaxFileList.iterator();

        while(iter.hasNext()) {
            File file = iter.next();
            extensionLanguageSyntaxMapper.put(Util.getLanguageExtension(file), Util.serializeJsonContent(Util.readFileContent(file)));
        }

        return extensionLanguageSyntaxMapper;
    }

    public SyntaxAnalyzer cleanUpTheDoc () throws FileNotFoundException {
        Map<SyntaxFormat,LanguageSyntax> extensionLanguageSyntaxMapper = this.getExtensionLanguageSyntaxMapper();
        List<String> lineList = this.documentReader.scan().getLineList();

        for (SyntaxFormat key : extensionLanguageSyntaxMapper.keySet()) {
            LanguageSyntax languageSyntax = extensionLanguageSyntaxMapper.get(key);

            for (String lineItem : lineList) {

            }
        }
        return this;
    }

    public SyntaxFormat analyzeSyntax() {




        return this.currentFileExtensionType;
    }

}
