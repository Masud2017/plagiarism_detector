package org.detector.service;

import org.detector.exception.EmptyLineListException;
import org.detector.model.ProcessableDoc;
import org.detector.model.SyntaxFormat;

import javax.annotation.Syntax;
import java.util.Iterator;
import java.util.List;

public class DocumentDetector {
    private List<String> lineListFirstFile;
    private List<String> lineListSecondFile;
    private Iterator<String> iteratorFirstFile;
    private Iterator<String> iteratorSecondFile;

    private SyntaxFormat syntaxFormatFirstFile;
    private SyntaxFormat syntaxFormatSecondFile;
    public DocumentDetector(List<String> lineListFirstFile, List<String> lineListSecondFile, SyntaxFormat syntaxFormatFirstFile, SyntaxFormat syntaxFormatSecondFile) {
        this.lineListFirstFile = lineListFirstFile;
        this.lineListSecondFile = lineListSecondFile;
        this.syntaxFormatFirstFile = syntaxFormatFirstFile;
        this.syntaxFormatSecondFile = syntaxFormatSecondFile;
    }

    public DocumentDetector init() throws EmptyLineListException {
        DocumentProcessor documentProcessorFirstFile = DocumentProcessorFactory.getDocumentProcessor(this.lineListFirstFile,this.syntaxFormatFirstFile);
        DocumentProcessor documentProcessorSecondFile = DocumentProcessorFactory.getDocumentProcessor(this.lineListSecondFile,this.syntaxFormatSecondFile);

        ProcessableDoc processableDocFirstFile = documentProcessorFirstFile.getProcessedLineList();
        ProcessableDoc processableDocSecondFile = documentProcessorSecondFile.getProcessedLineList();

        this.iteratorFirstFile = processableDocFirstFile.getLineList().iterator();
        this.iteratorSecondFile = processableDocSecondFile.getLineList().iterator();

        return this;
    }

    public boolean detect() {
        if (this.syntaxFormatFirstFile.equals(this.syntaxFormatSecondFile)) {

        }
        return false;
    }




}
