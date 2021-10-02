package util;

import config.ConfigReader;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class MyRandomGeneratorTest {
    /*@Mock
    ConfigReader configReaderMock;*/

    /**
     *         1.1 Check index interval (0 - size-1)
     *             1 - size - felső határérték
     *             2 - -1 - alsó határérték
     */
    @Test
    public void getRandomIntervalTest() {
        /*int oneMemberExpected = 1;
        int oneMemberActual = MyRandomGenerator.getRandom(oneMemberExpected);  // 0
        int sizeExpected = 3;
        int sizeActual = MyRandomGenerator.getRandom(sizeExpected);  // 0,1,2 */

        Assert.assertEquals(0, MyRandomGenerator.getRandom(1));
        int actual = MyRandomGenerator.getRandom(3);
        Assert.assertTrue(0 <= actual && actual < 3 );
    }

    @Test
    public void getRandomMagicNumberTest() {
        // ConfigReader.getMagicRandomNumber()
        // when(configReaderMock.getMagicRandomNumber()).thenReturn(3);  // objektum, nem static
        try (MockedStatic<ConfigReader> configMock = Mockito.mockStatic(ConfigReader.class)) {
            configMock.when(ConfigReader::getMagicRandomNumber).thenReturn(3);
            Assert.assertEquals(3, MyRandomGenerator.getRandom(10));
        }
    }
}
