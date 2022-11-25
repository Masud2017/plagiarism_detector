package org.detector.worker;

import org.detector.service.DocumentReader;

import java.io.File;
import java.io.FileNotFoundException;

public class DetectorWorker implements Runnable {
    private DocumentReader documentReader;
    public DetectorWorker(String fileName) throws FileNotFoundException {
        this.documentReader = new DocumentReader(fileName);
    }
    @Override
    public void run() {

    }
}
