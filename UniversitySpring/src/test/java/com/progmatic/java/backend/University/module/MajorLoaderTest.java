package com.progmatic.java.backend.University.module;

import com.progmatic.java.backend.University.config.ConfigReader;
import com.progmatic.java.backend.University.model.Major;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MajorLoaderTest {
    /**
     * @RunWith annotation is not part of Spring Boot starter pack!
     * @SpringBootTest is part of it
     */

    @Mock
    ConfigReader configReader;

    @Autowired
    MajorLoader majorLoader;

    @Test
    void loadFromFile() throws IOException {
        //Mockito.when(configReader.getResource()).thenReturn(Paths.get("src/test/resources/szakok_test.txt"));
        Map<String, List<Major>> expected = new HashMap<>();
        //anglisztika;ANG17-183;Tipográfia;K;2;2;NULL
        //germanisztika;NEM17-211;Az interkulturális kompetencia fejlesztése;G;3;3;NEM17-001*
        //germanisztika;NEM17-223;Frazémák és kötött kifejezések;G;3;3;NEM17-001*

        expected.put("anglisztika", Arrays.asList(
                new Major(
                    "anglisztika",
                    "NG17-183",
                    "Tipográfia",
                        "K",
                        "2",
                        "2",
                        "NULL"
                )
        ));
        expected.put("germanisztika", Arrays.asList(
                new Major(
                        "germanisztika",
                        "NEM17-211",
                        "Az interkulturális kompetencia fejlesztése",
                        "G",
                        "3",
                        "3",
                        "NEM17-001*"
                )
        ));
        expected.put("germanisztika", Arrays.asList(
                new Major(
                        "germanisztika",
                        "NEM17-223",
                        "Frazémák és kötött kifejezések",
                        "G",
                        "3",
                        "3",
                        "NEM17-001*"
                )
        ));

        Map<String, List<Major>> actual = majorLoader.loadFromFile();
        assertEquals(expected, actual);

    }

    @Test
    void loadFromLine() {
        //MajorLoader majorLoader = new MajorLoader();

        //Mockito.when(configReader.getCourseSplitRegex()).thenCallRealMethod();
        Mockito.when(configReader.getCourseSplitRegex()).thenReturn(";");

        String line = "anglisztika;ANG17-217;Kortárs angol nyelvű irodalom;K;5|6;3;ANG17-211|ANG17-213|ANG17-215";

        /*
        Major expected = new Major(
                "anglisztika",
                "ANG17-217",
                "Kortárs angol nyelvű irodalom",
                "K",
                "5|6",
                "3",
                "ANG17-211|ANG17-213|ANG17-215"
        );
        */

        Major expected = new Major();
        expected.setName("anglisztika");
        expected.setCourseCode("ANG17-217");

        Major actual = majorLoader.loadFromLine(line);

        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getCourseCode(), actual.getCourseCode());
    }
}