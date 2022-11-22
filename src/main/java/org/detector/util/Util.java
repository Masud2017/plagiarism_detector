package org.detector.util;

import com.google.common.io.Resources;
import org.detector.model.SyntaxFormat;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static SyntaxFormat getLanguageExtension(File file) {
        String ext = null;
        String s = file.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }

        System.out.println("Extension of the program ; "+ext);

        switch (ext) {
            case "c":
                return SyntaxFormat.C;
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
}
