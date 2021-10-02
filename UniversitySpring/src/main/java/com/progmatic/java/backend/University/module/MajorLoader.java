package com.progmatic.java.backend.University.module;

import com.progmatic.java.backend.University.config.ConfigReader;
import com.progmatic.java.backend.University.model.Major;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Stream;

@Component
public class MajorLoader {
    @Getter
    Map<String, List<Major>> loadMajor = new HashMap<>();

    ConfigReader configReader;

    @Autowired
    public MajorLoader(@Autowired ConfigReader configReader) {
        this.configReader = configReader;
    }

    public Map<String, List<Major>> loadFromFile() throws IOException {
        /*
        Stream<String> lines = Files.lines(configReader.getResource());
        lines.forEach(line ->loadFromLine(line));
        */
        //AtomicReference<Map<String, List<Major>>> result = null;

        Map<String, List<Major>> result = new HashMap<>();
        try (Stream<String> lines = Files.lines(configReader.getResource())) {
            lines.forEach(line -> {
                //refactored this! -> Major instead of Map<String, List<Major>>
                Major major = loadFromLine(line);
                //System.out.println(major.getCourseName());
                loadMajor.putIfAbsent(major.getName(), new ArrayList<>());
                loadMajor.get(major.getName()).add(major);
                //result.putAll(loadFromLine(line));
            });
        }
        //check: ok
        //System.out.println(loadMajor.size());
        return loadMajor;
    }

    public Major loadFromLine(String line) {
        List<String> splits = Arrays.asList(
                line.split(configReader.getCourseSplitRegex())
        );
        //check: ok
        //System.out.println(splits.get(0));
        return new Major(
                splits.get(0),
                splits.get(1),
                splits.get(2),
                splits.get(3),
                splits.get(4),
                splits.get(5),
                splits.get(6)
        );
    }

}
