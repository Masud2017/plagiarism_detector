package org.detector.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>Lexer</h1>
 * This class analyses the lexemes of the code/doc.
 * */
@NoArgsConstructor
public class Lexer {
    private Scanner scanner;

    @Getter
    private List<String> scannedDoc;

    public Lexer(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        this.scanner = new Scanner(new FileInputStream(file));
        this.scannedDoc = new ArrayList<>();
    }

    public Lexer scan() {
        try {
            while(this.scanner.hasNext()) {
                this.scannedDoc.add(this.scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return this;
    }
}
