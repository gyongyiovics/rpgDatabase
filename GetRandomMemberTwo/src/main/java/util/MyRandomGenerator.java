package util;

import config.ConfigReader;

import java.util.Random;

public class MyRandomGenerator {
    public static int getRandom(int size) {
        int magicNumber = ConfigReader.getMagicRandomNumber();
        if(magicNumber != -1 && magicNumber < size) {
            System.out.println("Magic number used!");
            return magicNumber;
        }
        Random rnd = new Random();
        return rnd.nextInt(size);
    }
}
