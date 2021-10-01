package com.progmatic.java.backend.University.module;

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
    @Autowired
    WeakList weakList;

    @Test
    void majorsWithWeak() {
        String input = "";
        String input1 = "anglisztika;ANG17-212;A középkor és a reneszánsz angol irodalma;G;2|3|4;3;ANG-101*";
        List<Major> majorList1 = new ArrayList<>();
        majorList1.add(new Major(
                "anglisztika",
                "ANG17-212",
                "A középkor és a reneszánsz angol irodalma",
                "G",
                "2|3|4",
                "3",
                "ANG-101*"
        ));

        String input2 = "anglisztika;ANG17-218;Irodalmi szövegolvasás 1.;K;5|6;3;ANG17-211|ANG17-213|ANG17-215";

        //TODO: naja, ez nem lesz egyenlő, esetleg egy testing file? vagy inkább a bool return érték?
        assertEquals(weakList.majorsWithWeak(), majorList1);

    }



}