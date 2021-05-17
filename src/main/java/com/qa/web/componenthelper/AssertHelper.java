package com.qa.web.componenthelper;
import org.junit.Assert;

public class AssertHelper {
    public static void areEqual(String expected, String actual) {
        try {
            Assert.assertEquals(expected, actual);
        } catch (Exception e) {
            /* ignore */
        }
    }
}
