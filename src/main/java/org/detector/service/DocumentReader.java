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
public class DocumentReader {
    private Scanner scanner;

    @Getter
    private List<String> lineList;

    public DocumentReader(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        this.scanner = new Scanner(new FileInputStream(file));
        this.lineList = new ArrayList<>();
    }

    public void scan() {
        try {
            while(this.scanner.hasNext()) {
                this.lineList.add(this.scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
