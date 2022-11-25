package org.detector.service;


import org.detector.exception.EmptyLineListException;
import org.detector.model.ProcessableDoc;

import java.util.List;

public interface DocumentProcessor {
    ProcessableDoc getProcessedLineList() throws EmptyLineListException;
}
