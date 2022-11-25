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
        this.lineList = new ArrayList<>();

        while(scanner.hasNext()) {
            this.lineList.add(scanner.nextLine());
        }
    }

    public Integer detect() throws EmptyLineListException {
        DocumentProcessor documentProcessor = DocumentProcessorFactory.getDocumentProcessor(this.lineList,this.docType);
        if (documentProcessor == null) {
            return 0;
        }
        ProcessableDoc processableDoc = documentProcessor.getProcessedLineList();

        Iterator<String> iter = processableDoc.getLineList().iterator();


        return 0;
    }
}
