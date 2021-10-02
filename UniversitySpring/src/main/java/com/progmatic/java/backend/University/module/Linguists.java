package com.progmatic.java.backend.University.module;

import com.progmatic.java.backend.University.model.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class Linguists {
    /**
     * Írj metódust, amely visszaadja az összes olyan tanegységet,
     * amelynek megnevezésében szerepel a “nyelv” szó!
     * (Akár szóelemként is. Tehát a metódus keresi és megtalálja a tanegységet,
     * amelynek megnevezésében akár a “nyelv”, akár a “nyelvismeret”, akár a “nyelvtudomány” stb. szerepel.)
     */

    //dangerous use! simpler: put it in a constructor
    //@Autowired
    MajorHandler majorHandler;

    @Autowired
    public Linguists(MajorHandler majorHandler) {
        this.majorHandler = majorHandler;
    }

    public List<Major> majorsWithLinguistics() {
        /*Map<String, List<Major>> majorMap1 = majorHandler.getLoadMajor();
        List<Major> majorsList = new ArrayList<>();
        for(List<Major> majors : majorMap1.values()) {
            for(Major major : majors) {
                //STRING
                if(major.getCourseName().contains("nyelv")) {
                    majorsList.add(major);
                }
            }
        }
        return majorsList;*/
        List<Major> majorsList = new ArrayList<>();
        Major major = getMajor();
        if (major.getCourseName().contains("nyelv")) {
            majorsList.add(major);
            //TODO: check
            System.out.println(majorsList.get(1).getName());
        } else {
            System.out.println("no majors added");
            majorsList.add(null);
        }
        return majorsList;
    }

    private Major getMajor() {
        Map<String, List<Major>> majorMap1 = majorHandler.getLoadMajor();
        for(List<Major> majors : majorMap1.values()) {
            for(Major major : majors) {
                if (!major.equals(null))
                    //TODO: check
                    System.out.println(major.getName());
                    return major;
            }
        }
        System.out.println("No major here!");
        return null;
    }

}
