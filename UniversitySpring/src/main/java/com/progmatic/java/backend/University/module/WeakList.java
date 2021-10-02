package com.progmatic.java.backend.University.module;

import com.progmatic.java.backend.University.model.Major;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class WeakList {
    /**
     * Írj metódust, amely visszaadja (adatszerkezetben) azoknak a tanegységeket,
     * amelyeknek van gyenge előfeltétele.
     *
     * TODO: REFACTOR these methods in order to give them a String parameter
     * and fuse the rest dictionary reading in another method - as it is already tested
     *
     */

    MajorHandler majorHandler;

    @Autowired
    public WeakList(MajorHandler majorHandler) {
        this.majorHandler = majorHandler;
    }

    public boolean majorsWithWeak() {
        Map<String, List<Major>> majorMap = majorHandler.getLoadMajor();
        List<Major> majorsList = new ArrayList<>();
        for(List<Major> majors : majorMap.values()) {
            for(Major major : majors) {
                //STRING
                if(major.getRequirements().contains("*")) {
                    majorsList.add(major);
                    return true;
                }
            }
        }
        return false;
    }

}
