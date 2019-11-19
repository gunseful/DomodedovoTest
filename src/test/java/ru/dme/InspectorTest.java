package ru.dme;

import org.junit.Assert;
import org.junit.Test;

public class InspectorTest {

    @Test
    public void check() {
        String expected = "3 3664069397";
        Inspector inspector = new Inspector();
        String actual = inspector.check("3664069397").trim();
        Assert.assertEquals(expected, actual);
    }
}
