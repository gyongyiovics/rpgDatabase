package util;

import org.junit.Assert;
import org.junit.Test;

public class RegexUtilTest {
    @Test
    public void findMatchTest() {
        String line = "User-Agent: TestAgent 1";

        String result = RegexUtil.findMatch(line, "TestAgent");
        Assert.assertEquals("TestAgent", result);
        String negResult = RegexUtil.findMatch(line, "NA");
        Assert.assertEquals(null, negResult);
    }
}
