package org.detector.service;

import org.detector.exception.EmptyLineListException;
import org.detector.model.ProcessableDoc;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TextDocumentProcessor implements  DocumentProcessor {
    private List<String> lineList;

    public TextDocumentProcessor (List<String> lineList) {
        this.lineList = lineList;
    }

    @Override
    public ProcessableDoc getProcessedLineList() throws EmptyLineListException {
        Iterator<String> iter = this.lineList.iterator();
        ProcessableDoc processableDoc = new ProcessableDoc();

        if (this.lineList.size() == 0) {
            throw new EmptyLineListException("Line list is empty please make sure that you have the list gets populated properly");
        }

        while(iter.hasNext()) {
            String line = iter.next();
            List<String> sentenceList = Arrays.asList(line.split("."));

            processableDoc.setLineList(sentenceList);

        }
        return processableDoc;
    }
}
