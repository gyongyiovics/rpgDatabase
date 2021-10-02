package config;

public class ConfigReader {
    private static String membersPath = "src/main/resources/members.txt";
    private static String commentPrefix = "#";
    private static String presentedPrefix = "!";
    private static int magicRandomNumber = -1;
    private static String devicesPath = "src/main/resources/regexExample.txt";

    public static String getMembersPath() {
        return membersPath;
    }

    public static String getCommentPrefix() {
        return commentPrefix;
    }

    public static String getPresentedPrefix() {
        return presentedPrefix;
    }

    public static int getMagicRandomNumber() {
        return magicRandomNumber;
    }

    public static String getDevicesPath() {
        return devicesPath;
    }
}
