package org.detector.service;

import lombok.Getter;
import org.detector.model.LanguageSyntax;
import org.detector.model.SyntaxFormat;
import org.detector.util.Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyntaxAnalyzer {
    private List<File> syntaxFileList;
    private final DocumentReader documentReader;
    private SyntaxFormat currentFileExtensionType;
    @Getter
    private List<String> cleanedLineList;

    public SyntaxAnalyzer(DocumentReader documentReader, List<File> syntaxFileList) throws FileNotFoundException {
        this.documentReader = documentReader;
        this.syntaxFileList = syntaxFileList;
        this.currentFileExtensionType = SyntaxFormat.NONE;
        this.cleanedLineList = new ArrayList<>();
    }


    public Map<SyntaxFormat,LanguageSyntax> getExtensionLanguageSyntaxMapper() throws FileNotFoundException {
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
        LanguageSyntax languageSyntax = extensionLanguageSyntaxMapper.get(this.analyzeSyntax());


            for (String lineItem : lineList) {
                String cleanedString = "";
                for (int i = 0; i < languageSyntax.getWords().size(); i++) {
                    if (lineItem.contains(languageSyntax.getWords().get(i))) {
                        cleanedString = lineItem.replaceAll(languageSyntax.getWords().get(i),"").trim();
                        System.out.println(languageSyntax.getWords().get(i));
                    }
                    continue;

                }

                if (lineItem.contains(languageSyntax.getImportKeyword())) {
                    cleanedString = lineItem.replaceAll(languageSyntax.getImportKeyword(), "");
                }
                this.cleanedLineList.add(cleanedString);

            }

            // removing some* operators that might cause problem while detection
            for (int iter =  0; iter < this.cleanedLineList.size(); iter++) {

                for (int i = 0; i < languageSyntax.getOperators().size(); i++) {
                    if (this.cleanedLineList.get(iter).contains(languageSyntax.getOperators().get(i))) {
                        this.cleanedLineList.set(iter,this.cleanedLineList.get(iter).replaceAll("\\b\\s?"+languageSyntax.getOperators().get(i)+"\\s?\\b"," "));
                        System.out.println(languageSyntax.getOperators().get(i));
                    }
                }
            }

            for(int i = 0; i < this.cleanedLineList.size(); i++) {
                if (this.cleanedLineList.get(i).equals("")) {
                    this.cleanedLineList.remove(this.cleanedLineList.get(i));
                }
            }
        return this;
    }

    public SyntaxFormat analyzeSyntax() throws FileNotFoundException {
        Map<SyntaxFormat,LanguageSyntax> mapper = this.getExtensionLanguageSyntaxMapper();
        List<String> lineList = this.documentReader.scan().getLineList();

        for (SyntaxFormat key : mapper.keySet()) {
            LanguageSyntax languageSyntax = mapper.get(key);

            for (String lineItem : lineList) {
                if (languageSyntax != null) {
                    Pattern pattern = Pattern.compile(languageSyntax.getImportKeyword(),Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(lineItem);
                    while (matcher.find()) {
                        return key;
                    }
                }
               if (languageSyntax != null) {
                   lineItem.contains(languageSyntax.getImportKeyword());
               }
            }
        }


        return this.currentFileExtensionType;
    }

}
