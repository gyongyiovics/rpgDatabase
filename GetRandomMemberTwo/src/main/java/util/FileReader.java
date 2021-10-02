package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public static String read() {
        List<String> devices = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new java.io.FileReader("src/main/resources/regexExample.txt"))) {
            for(String line; (line = br.readLine()) != null; ) {
                return line;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
