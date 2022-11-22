package org.detector.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.detector.model.Token;

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
    private List<String> scannedDoc;
    @Getter
    private List<Token> tokenList;

    public Lexer(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        this.scanner = new Scanner(new FileInputStream(file));
        this.scannedDoc = new ArrayList<>();
        this.tokenList = new ArrayList<>();
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

    /**
     * This method cleanup all the comments from the code.
     * Remove all the white spaces and then convert them to special structure.
     * */
    public Lexer cleanUp() {
        //optional for now
        return this;
    }

    public Lexer tokenize() {
        for(String line : scannedDoc) {
            String[] lineArr = line.split(" "); // splitting the words based on spaces
            Token tempToken = new Token();
            List<String> spaceSepratedStringList = new ArrayList<>();

            for (String lineItem : lineArr) {
                spaceSepratedStringList.add(lineItem);
            }

            tempToken.setWordListSeparatedBySpace(spaceSepratedStringList);

            this.tokenList.add(tempToken);
        }
        return this;
    }
}
