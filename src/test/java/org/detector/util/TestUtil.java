package org.detector.util;

import com.google.common.io.Resources;
import org.detector.model.SyntaxFormat;
import org.detector.util.Util;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class TestUtil {
    private String fileString = Resources.getResource("file.txt").getPath();



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
}
