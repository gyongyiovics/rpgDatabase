package com.progmatic.java.backend.University.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InfoSplitter {
    public static String nullString = "NULL";
    public static String separator = "\\|";

    public static List<String> splitRequirements(String requirements) {
        if(requirements.equals(nullString)) {
            return new ArrayList<>();
        }
        String[] splits = requirements.split(separator);
        List<String> stringList = new ArrayList<>(Arrays.asList(splits));
        return stringList;
    }

    public static List<Integer> splitSemester(String semesters) {
        String[] splits = semesters.split(separator);
        List<Integer> integerList = new ArrayList<>();

        for (String str : splits) {
            integerList.add(Integer.parseInt(str));
        }
        return integerList;
    }
}
