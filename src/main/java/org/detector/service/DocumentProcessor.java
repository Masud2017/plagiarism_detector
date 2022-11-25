package org.detector.service;

import org.detector.exception.EmptyLineListException;
import org.detector.model.ProcessableDoc;

public interface DocumentProcessor {
    ProcessableDoc getProcessedLineList() throws EmptyLineListException;
}
