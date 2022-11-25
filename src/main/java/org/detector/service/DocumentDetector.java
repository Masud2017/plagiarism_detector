package org.detector.service;

import lombok.NoArgsConstructor;
import org.detector.exception.EmptyLineListException;
import org.detector.model.DocType;
import org.detector.model.ProcessableDoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
public class DocumentDetector {
    private List<String> lineList;
    private DocType docType;

    public DocumentDetector(List<String> lineList,DocType docType) {
        this.lineList = lineList;
        this.docType = docType;
    }

    public DocumentDetector(File file,DocType docType) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        this.docType = docType;

        while(scanner.hasNext()) {
            this.lineList.add(scanner.nextLine());
        }
    }

    public Integer detect() throws EmptyLineListException {
        DocumentProcessor documentProcessor = DocumentProcessorFactory.getDocumentProcessor(this.lineList,this.docType);
        ProcessableDoc processableDoc = documentProcessor.getProcessedLineList(); // return either sentenceList or line
        // List

        Iterator itter = processableDoc.getLineList().iterator();

        while(itter.hasNext()) {

        }

        return 0;
    }
}
