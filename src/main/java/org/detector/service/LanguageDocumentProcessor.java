package org.detector.service;

import org.detector.exception.EmptyLineListException;
import org.detector.model.ProcessableDoc;

import java.util.List;

public class LanguageDocumentProcessor implements  DocumentProcessor {
    private List<String> lineList;

    public LanguageDocumentProcessor(List<String> lineList) {
        this.lineList = lineList;
    }

    @Override
    public ProcessableDoc getProcessedLineList() throws EmptyLineListException {

        return null;
    }
}
