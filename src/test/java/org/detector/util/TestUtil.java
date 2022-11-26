package org.detector.util;

import com.google.common.io.Resources;
import org.detector.model.LanguageSyntax;
import org.detector.model.SyntaxFormat;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;


public class TestUtil {
    @Test
    public void testGetLanguageExtension() {
        File file = new File(Resources.getResource("prog.c").getPath());

        Assert.assertEquals(SyntaxFormat.C,Util.getLanguageExtension(file));

        File file2 = new File(Resources.getResource("file.txt").getPath());

        Assert.assertEquals(SyntaxFormat.NONE,Util.getLanguageExtension(file2));

    }

    @Test
    public void testSyntaxStructureList() {
        Util.getSyntaxStructureList();
    }

    @Test
    public void testReadFileContent() throws FileNotFoundException {
        String expected = "{\"name\":\"c\",\"words\":[\"auto\",\"break\",\"case\",\"char\",\"const\",\"continue\",\"default\",\"do\",\"double\",\"else\",\"enum\",\"extern\",\"float\",\"for\",\"goto\",\"if\",\"int\",\"long\",\"register\",\"return\",\"short\",\"signed\",\"sizeof\",\"static\",\"struct\",\"switch\",\"typedef\",\"union\",\"unsigned\",\"void\",\"volatile\",\"while\",\"_Bool\",\"_Complex\",\"_Imaginary\",\"inline\",\"restrict\",\"_Alignas\",\"_Alignof\",\"_Atomic\",\"_Generic\",\"_Noreturn\",\"_Static_assert\",\"_Thread_local\"],\"operators\":[\"+\",\"-\",\"*\",\"/\",\"%\",\"=\",\"+=\",\"-=\",\"*=\",\"/=\",\"%=\",\"&=\",\"|=\",\"^=\",\"<<=\",\">>=\",\"~\",\"&\",\"|\",\"^\",\"<<\",\">>\",\"!\",\"&&\",\"||\",\"?any:\",\"==\",\"!=\",\"(\",\")\",\"++\",\"--\",\".\",\"->\",\"sizeof\",\"<\",\"<=\",\">\",\">=\",\"&\",\"*\",\"[\",\"]\",\",\",\"(\",\")\"],\"importKeyword\":\"#include\\\\s?<\\\\s?.*\\\\s?>\"}";
        File file = new File(Resources.getResource("syntax_structure/c.json").getPath());
        String actualData = Util.readFileContent(file);

        Assert.assertEquals(expected,actualData);
    }

    @Test
    public void testSerializeJsonContent() throws FileNotFoundException {
        File file = new File(Resources.getResource("syntax_structure/c.json").getPath());
        String givenData = Util.readFileContent(file);

        LanguageSyntax expectedLanguageSyntax = new LanguageSyntax();

        List<String> words = Arrays.asList("auto", "break", "case", "char", "const", "continue", "default", "do", "double", "else", "enum", "extern", "float", "for", "goto", "if", "int", "long", "register", "return", "short", "signed", "sizeof", "static", "struct", "switch", "typedef", "union", "unsigned", "void", "volatile", "while", "_Bool", "_Complex", "_Imaginary", "inline", "restrict", "_Alignas", "_Alignof", "_Atomic", "_Generic", "_Noreturn", "_Static_assert", "_Thread_local");
        List<String> operators = Arrays.asList("+", "-", "*", "/", "%", "=", "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=", "<<=", ">>=", "~", "&", "|", "^", "<<", ">>", "!", "&&", "||", "?any:", "==", "!=", "(",")", "++", "--", ".", "->", "sizeof", "<", "<=", ">", ">=", "&", "*", "[","]", ",", "(",")");
        expectedLanguageSyntax.setName("c");
        expectedLanguageSyntax.setWords(words);
        expectedLanguageSyntax.setOperators(operators);
        expectedLanguageSyntax.setImportKeyword("#include\\s?<\\s?.*\\s?>");

        LanguageSyntax actualLanguageSyntax = Util.serializeJsonContent(givenData);

        Assert.assertEquals(expectedLanguageSyntax.getName(),actualLanguageSyntax.getName());
        Assert.assertEquals(expectedLanguageSyntax.getWords(),actualLanguageSyntax.getWords());
        Assert.assertEquals(expectedLanguageSyntax.getOperators(),actualLanguageSyntax.getOperators());
        Assert.assertEquals(expectedLanguageSyntax.getImportKeyword(),actualLanguageSyntax.getImportKeyword());

    }

    @Test
    public void testRemoveTheWord() {
        String given = "Hello world this is a test text";
        String expected = "Hello world this is a text";
        String actual = Util.removeTheWord(given,"test");

        Assert.assertEquals(expected,actual);
    }
}
