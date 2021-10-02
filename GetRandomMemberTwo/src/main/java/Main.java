import exceptions.MyException;
import model.Device;
import module.DeviceManager;
import module.RandomMemberGenerator;

import java.util.List;

public class Main {
    public static void main(String[] args) throws MyException {
        //System.out.println("Hello world!");
        RandomMemberGenerator.run();
        List<Device> deviceList = DeviceManager.loadDevicesFromFile();
        for (Device device : deviceList) {
            System.out.println(device.getName());
        }
    }
}
