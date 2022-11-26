package org.detector.util;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import org.detector.model.LanguageSyntax;
import org.detector.model.SyntaxFormat;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util {
    public static SyntaxFormat getLanguageExtension(File file) {
        String ext = null;
        String s = file.getName();
        if (s.length() > 0) {
            ext = s.replaceAll(".json","");
        }

        switch (ext) {
            case "c":
                return SyntaxFormat.C;
            case "cpp":
                return SyntaxFormat.CPP;
            case "java":
                return SyntaxFormat.JAVA;
            case "js":
                return SyntaxFormat.JS;
            case "python":
                return SyntaxFormat.PYTHON;
            case "go":
                return SyntaxFormat.GO;
            case "php":
                return SyntaxFormat.PHP;
            case "kotlin":
                return SyntaxFormat.KOTLIN;
            case "haskell":
                return SyntaxFormat.HASKELL;
            default:
                return SyntaxFormat.NONE;
        }

    }

    public static List<File> getSyntaxStructureList() {
        List<File> fileList = new ArrayList<>();

        File directory = new File(Resources.getResource("syntax_structure").getPath());
        if (directory.isDirectory()) {
            String[] fileArr  = directory.list();
            for (String fileNameItem : fileArr) {
                System.out.println(fileNameItem);
                fileList.add(new File(fileNameItem));
            }
        }
        return fileList;
    }

    public static String readFileContent(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String content = "";

        while (scanner.hasNext()) {
            content += scanner.nextLine();
        }

        return content.trim().replaceAll("\\s", "");
    }

    public static LanguageSyntax serializeJsonContent(String jsonStr) {
        Gson gson = new Gson();
        LanguageSyntax languageSyntax = gson.fromJson(jsonStr,LanguageSyntax.class);
        return languageSyntax;
    }

    public static String removeTheWord(String sentence,String word) {
        if (sentence.contains(word)) {
            return sentence.replaceAll(word,"").replaceAll("\\s\\s"," ");

        }
        return null;
    }
}
