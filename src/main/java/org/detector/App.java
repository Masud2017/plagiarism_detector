package org.detector;

import org.detector.service.Detector;

import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {
        Detector detector = new Detector();
        detector.startDetect(args[0],args[1]);
    }
}
