package com.progmatic.java.backend.University.module;

import com.progmatic.java.backend.University.config.ConfigReader;
import com.progmatic.java.backend.University.model.Major;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

@Service
public class MajorHandler {
    MajorLoader majorLoader;
    @Getter
    Map<String, List<Major>> loadMajor = new HashMap<>();
    ConfigReader configReader;

    @Autowired
    MajorHandler (MajorLoader majorLoader, ConfigReader configReader) {
        this.majorLoader = majorLoader;
        this.configReader = configReader;
        try {
            loadMajor = majorLoader.loadFromFile();
            //System.out.println(loadMajor.size());
        } catch (NoSuchFieldError e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * wrote from void to Map <String, List<Major>> for testing purposes
     * @return
     */
    //moved methods to MajorLoader class

    /*public Map<String, List<Major>> loadFromFile() throws IOException {
        *//*
        Stream<String> lines = Files.lines(configReader.getResource());
        lines.forEach(line ->loadFromLine(line));
        *//*

        //AtomicReference<Map<String, List<Major>>> result = null;

        Map<String, List<Major>> result = new HashMap<>();
        Stream<String> lines = Files.lines(configReader.getResource());
        lines.forEach(line -> {
            result.putAll(loadFromLine(line));
                });
        return result;
    }

    public Map<String, List<Major>> loadFromLine(String line) {
        List<String> splits = Arrays.asList(
                line.split(configReader.getCourseSplitRegex())
        );
        String majorName = splits.get(0);
        loadMajor.putIfAbsent(majorName, new ArrayList<>());
        loadMajor.get(majorName).add(new Major(
                splits.get(0),
                splits.get(1),
                splits.get(2),
                splits.get(3),
                splits.get(4),
                splits.get(5),
                splits.get(6)
        ));
        return loadMajor;
    }*/
}
