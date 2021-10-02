package module;

import config.ConfigReader;
import model.Device;
import util.RegexUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DeviceManager {
    //TODO olvassuk be a fájlt a ConfigReader.getDevicesPath() helyről
    //TODO minden sorát ellenőrizzük, hogy kell-e és ha igen akkor vegyük ki az adatot
    //TODO csináljunk egy devices listát ezekből

    public static List<Device> loadDevicesFromFile() {
        List<Device> devices = new ArrayList<>();
        try {
            Stream<String> lines = Files.lines(Paths.get(ConfigReader.getDevicesPath()));
            lines.forEach(line -> {
                Device device = findDeviceInLine(line);
                if (device != null) {
                    devices.add(device);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return devices;
    }

    public static Device findDeviceInLine(String line) {
        String regex = "(?<=Android [7-9].{0,10}; )(.*?)(?= MIUI| Build)";
        String name = RegexUtil.findMatch(line, regex);

        if (name != null)
            return new Device(name);

        return null;
    }
}
