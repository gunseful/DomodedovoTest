package ru.dme;

import org.junit.Assert;
import org.junit.Test;

public class InspectorTest {

    @Test
    public void checkOneRequest() {

        String expected = "3 3664069397";

        Inspector inspector = new Inspector();

        String actual = inspector.check("3664069397").trim();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkFewRequests() {

        String expected = "3 3664069397\r\n" +
                "5 1234567890";

        Inspector inspector = new Inspector();

        String actual = inspector.check("3664069397\n1234567890").trim();

        Assert.assertEquals(expected, actual);
    }
}
