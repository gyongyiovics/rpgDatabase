package module;

import config.ConfigReader;
import model.Device;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class DeviceManagerTest {
    @Test
    public void loadDevicesFromFileTest() {
        //@Cleanup -> from lombok!!!
        MockedStatic<ConfigReader> configMock = Mockito.mockStatic(ConfigReader.class);
        configMock.when(ConfigReader::getDevicesPath).thenReturn("src/test/resources/test_regexExample.txt");

        List<Device> expectedDevices = Arrays.asList(
                new Device("SM-J510FN"),
                new Device("Moto G Play"),
                new Device("SM-A505FN"),
                new Device("Mi MIX 3")
        );

        Assert.assertTrue(compareLists(expectedDevices, DeviceManager.loadDevicesFromFile()));
        configMock.close();
        //because of the deregistration...
    }

    @Test
    public void findDeviceInLineTest() {
        String line = "User-Agent: Pushwize/2.8.0 Dutch+News/9.14.0 Dalvik/2.1.0 (Linux; U; Android 7.1.1; SM-J510FN Build/NMF26X)";
        Assert.assertEquals("SM-J510FN", DeviceManager.findDeviceInLine(line).getName());
    }

    private boolean compareLists(List<Device> expected, List<Device> actual) {
        if (!(actual != null && expected.size() == actual.size()))
            return false;
        for (int i = 0; i < expected.size(); i++) {
            if (!expected.get(i).getName().equals(actual.get(i).getName()))
                return false;
        }
        return true;
    }

}
