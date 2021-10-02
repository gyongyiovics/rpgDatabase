package com.progmatic.java.backend.University.module;

import com.progmatic.java.backend.University.config.ConfigReader;
import com.progmatic.java.backend.University.model.CourseType;
import com.progmatic.java.backend.University.model.Major;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WeakListTest {
    /**
     * positive test: whether true
     * negative test: whether false
     */
    /*@Autowired
    WeakList weakList;*/
    ConfigReader configReader = new ConfigReader();
    MajorLoader majorLoader = new MajorLoader(configReader);
    MajorHandler majorHandler = new MajorHandler(majorLoader, configReader);

    WeakList weakList = new WeakList(majorHandler);

    @Test
    void majorsWithWeak() {
        //assertEquals(weakList.majorsWithWeak(), isWeak());
        assertTrue(isWeak());
    }

    boolean isWeak() {
        String input1 = "anglisztika;ANG17-212;A középkor és a reneszánsz angol irodalma;G;2|3|4;3;ANG-101*";
        List<Major> majorList1 = new ArrayList<>();

        Major major = new Major();
        List<String> requirements = new ArrayList<>();
        requirements.add("ANG-101*");

        major.setName("anglisztika");
        major.setCourseCode("ANG17-212");
        major.setCourseType(CourseType.G);
        major.setRequirements(requirements);

        majorList1.add(new Major(
                "anglisztika",
                "ANG17-212",
                "A középkor és a reneszánsz angol irodalma",
                "G",
                "2|3|4",
                "3",
                "ANG-101*"
        ));

        for (int i = 0; i < majorList1.size(); i++) {
            if (majorList1.get(i).getRequirements().equals(major.getRequirements())) {
                return true;
            }
        }

        String input2 = "anglisztika;ANG17-218;Irodalmi szövegolvasás 1.;K;5|6;3;ANG17-211|ANG17-213|ANG17-215";
        String input = "";
        return false;
    }



}