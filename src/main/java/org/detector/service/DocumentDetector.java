package org.detector.service;

import org.detector.exception.EmptyLineListException;
import org.detector.model.ProcessableDoc;
import org.detector.model.SyntaxFormat;

import java.util.Iterator;
import java.util.List;

public class DocumentDetector {
    private List<String> lineListFirstFile;
    private List<String> lineListSecondFile;
    private Iterator<String> iteratorFirstFile;
    private Iterator<String> iteratorSecondFile;

    private SyntaxFormat syntaxFormat;
    public DocumentDetector(List<String> lineListFirstFile,List<String> lineListSecondFile,SyntaxFormat syntaxFormat) {
        this.lineListFirstFile = lineListFirstFile;
        this.lineListSecondFile = lineListSecondFile;
        this.syntaxFormat = syntaxFormat;
    }

    public DocumentDetector init() throws EmptyLineListException {
        DocumentProcessor documentProcessorFirstFile = DocumentProcessorFactory.getDocumentProcessor(this.lineListFirstFile,this.syntaxFormat);
        DocumentProcessor documentProcessorSecondFile = DocumentProcessorFactory.getDocumentProcessor(this.lineListSecondFile,this.syntaxFormat);

        ProcessableDoc processableDocFirstFile = documentProcessorFirstFile.getProcessedLineList();
        ProcessableDoc processableDocSecondFile = documentProcessorSecondFile.getProcessedLineList();

        this.iteratorFirstFile = processableDocFirstFile.getLineList().iterator();
        this.iteratorSecondFile = processableDocSecondFile.getLineList().iterator();

        return this;
    }
}
