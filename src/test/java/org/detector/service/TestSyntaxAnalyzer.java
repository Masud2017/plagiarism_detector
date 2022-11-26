package org.detector.service;

import com.google.common.io.Resources;
import org.detector.model.LanguageSyntax;
import org.detector.model.SyntaxFormat;
import org.detector.util.Util;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestSyntaxAnalyzer {
    @Test
    public void testGetExtensionLanguageSyntaxMapper() throws FileNotFoundException {
        DocumentReader reader = new DocumentReader("prog.c");
        SyntaxAnalyzer analyzer = new SyntaxAnalyzer(reader,Util.getSyntaxStructureList());
        Map<SyntaxFormat, LanguageSyntax>  mapper = analyzer.getExtensionLanguageSyntaxMapper();
    }
//    @Test
//    public void testAnalyzeSyntax() throws FileNotFoundException {
//        DocumentReader documentReader = new DocumentReader("prog.c");
//        SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer(documentReader, Util.getSyntaxStructureList());
//
//        SyntaxFormat expectedFormat = SyntaxFormat.C;
//        SyntaxFormat actualFormat = syntaxAnalyzer.analyzeSyntax();
//
//        Assert.assertEquals(expectedFormat,actualFormat);
//
//        DocumentReader documentReaderRegularFile = new DocumentReader("file.txt");
//        SyntaxAnalyzer syntaxAnalyzerRegularFile = new SyntaxAnalyzer(documentReaderRegularFile, Util.getSyntaxStructureList());
//
//        SyntaxFormat expectedFormatRegularFile = SyntaxFormat.NONE;
//        SyntaxFormat actualFormatRegularFile = syntaxAnalyzerRegularFile.analyzeSyntax();
//
//        Assert.assertEquals(expectedFormatRegularFile,actualFormatRegularFile);
//    }

    @Test
    public void testCleanUpTheDoc () throws FileNotFoundException {
        DocumentReader documentReader = new DocumentReader("prog.c");
        SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer(documentReader, Util.getSyntaxStructureList());
        List<String> expectedCleanUpLineList = Arrays.asList("main( argc char** argv) {","data 0;","(data 0) {","pr(\"Yo\");","prf(\"Hello world this is a program file that\");");
        List<String> actualCleanUpLineList = syntaxAnalyzer.cleanUpTheDoc().getCleanedLineList();

        for (String item : actualCleanUpLineList) {
            System.out.println(item);
        }

//        Assert.assertEquals(expectedCleanUpLineList.get(0),actualCleanUpLineList.get(1));
//        Assert.assertEquals(expectedCleanUpLineList.get(1),actualCleanUpLineList.get(2));
        for(int i = 0; i < actualCleanUpLineList.size(); i++) {
            Assert.assertEquals(expectedCleanUpLineList.get(i),actualCleanUpLineList.get(i));
        }

    }
}
