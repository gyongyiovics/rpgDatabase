package com.progmatic.java.backend.University.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileHandler {
    private final String path;
    private File file;

    /***
     * burnt-in path!
     * good practice: adding the values as parameters in @Value in the constructor - the data from the
     * application.properties
     * can resolve otherwise with @Autowired
     * @param path
     */

    public FileHandler(@Value("${custom.courses.resource}") String path) {
        this.path = path;
        load();
    }

    private boolean load() {
        if(new File(getPath()).exists()) {
            this.file = new File(getPath());
            return true;
        } else {
            System.out.println(getPath() + " does not exist!");
            return false;
        }
    }

    public String getPath() {
        return path;
    }

    public File getFile() {
        return file;
    }
}
