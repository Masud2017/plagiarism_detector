package org.detector.service;

import org.detector.exception.EmptyLineListException;
import org.detector.model.ProcessableDoc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextDocumentProcessor implements  DocumentProcessor {
    private List<String> lineList;

    public TextDocumentProcessor (List<String> lineList) {
        this.lineList = lineList;
    }

    @Override
    public ProcessableDoc getProcessedLineList() throws EmptyLineListException {
        Iterator itter = this.lineList.iterator();
        ProcessableDoc processableDoc = new ProcessableDoc();

        if (this.lineList.size() == 0) {
            throw new EmptyLineListException("Line list is empty please make sure that you have the list gets populated properly");
        }

        while(itter.hasNext()) {
            String line = (String) itter.next();
            List<String> sentenceList = new ArrayList<>();

            String[] sentenceArr = line.split(".");

            for (String sentenceItem : sentenceArr) {
                sentenceList.add(sentenceItem);
            }
            processableDoc.setLineList(sentenceList);

        }
        return processableDoc;
    }
}
