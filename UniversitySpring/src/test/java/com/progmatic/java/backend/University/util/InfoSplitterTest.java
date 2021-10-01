package com.progmatic.java.backend.University.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InfoSplitterTest {
    public static String nullString = "NULL";

    @Test
    void splitRequirements() {
        String input = "ANG-102";
        List<String> expected = Arrays.asList("ANG-102");
        String input1 = "ANG17-211|ANG17-213|ANG17-215";
        List<String> expected1 = Arrays.asList("ANG17-211","ANG17-213","ANG17-215");
        String input2 = nullString;
        List<String> expected2 = new ArrayList<>();

        Assertions.assertTrue(compareLists(expected, InfoSplitter.splitRequirements(input)));
        Assertions.assertTrue(compareLists(expected1, InfoSplitter.splitRequirements(input1)));
        Assertions.assertTrue(compareLists(expected2, InfoSplitter.splitRequirements(input2)));

    }

    @Test
    void splitSemesterOneInput() {
        String input = "1";
        List<Integer> expected = Arrays.asList(1);
        assertTrue(compareLists(expected, InfoSplitter.splitSemester(input)));
    }

    @Test
    void splitSemesterMoreInput() {
        String input1 = "1|2|3";
        List<Integer> expected1 = Arrays.asList(1,2,3);
        assertTrue(compareLists(expected1, InfoSplitter.splitSemester(input1)));
    }

    private <T> boolean compareLists(List<T> expected, List<T> actual) {
        if(!(expected.size() == actual.size())) {
            return false;
        }
        for (int i = 0; i < expected.size(); i++) {
            if(!(expected.get(i).equals(actual.get(i)))) {
                return false;
            }
        }
        return true;
    }
}