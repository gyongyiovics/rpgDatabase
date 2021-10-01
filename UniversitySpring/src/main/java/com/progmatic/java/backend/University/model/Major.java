package com.progmatic.java.backend.University.model;

import com.progmatic.java.backend.University.util.InfoSplitter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Major {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String courseCode;
    @Getter
    @Setter
    private String courseName;
    @Getter
    @Setter
    private CourseType courseType;
    @Getter
    @Setter
    private List<Integer> semesters;
    @Getter
    @Setter
    private int credit;
    @Getter
    @Setter
    private List<String> requirements;

    public Major() {}

    public Major(String name,
                 String courseCode,
                 String courseName,
                 String courseType,
                 String semesters,
                 String credit,
                 String requirements) {
        this.name = name;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseType = CourseType.valueOf(courseType);
        this.semesters = InfoSplitter.splitSemester(semesters);
        this.credit = Integer.parseInt(credit);
        this.requirements = InfoSplitter.splitRequirements(requirements);
    }
}
