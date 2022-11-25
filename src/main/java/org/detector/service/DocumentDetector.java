package org.detector.service;

import lombok.NoArgsConstructor;
import org.detector.exception.EmptyLineListException;
import org.detector.model.ProcessableDoc;
import org.detector.model.SyntaxFormat;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
public class DocumentDetector {
    private List<String> lineList;
    private SyntaxFormat syntaxFormat;
    public DocumentDetector(List<String> lineList,SyntaxFormat syntaxFormat) {
        this.lineList = lineList;
        this.syntaxFormat = syntaxFormat;
    }

    public DocumentDetector(File file, SyntaxFormat syntaxFormat) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        this.syntaxFormat = syntaxFormat;
        this.lineList = new ArrayList<>();

        while(scanner.hasNext()) {
            this.lineList.add(scanner.nextLine());
        }
    }

    public Integer detect() throws EmptyLineListException {
        DocumentProcessor documentProcessor = DocumentProcessorFactory.getDocumentProcessor(this.lineList,this.syntaxFormat);
        if (documentProcessor == null) {
            return 0;
        }
        ProcessableDoc processableDoc = documentProcessor.getProcessedLineList();

        Iterator<String> iter = processableDoc.getLineList().iterator();


        return 0;
    }
}
