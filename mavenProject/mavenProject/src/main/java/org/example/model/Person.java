package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.file.PathUtils;


public class Person {
    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    String age;

    @Getter
    @Setter
    PathUtils pathUtils;

}
