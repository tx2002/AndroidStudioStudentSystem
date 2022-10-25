package com.example.apitest.entity.student;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ChooseCourseInfo {

    private Integer code;
    private String message;
    private List<ChooseCourse> ChooseCourseList;

    @NoArgsConstructor
    @Data
    public static class ChooseCourse {
        private String className;
        private Integer term;
        private String point;
        private String courseName;
        private String teacher;

        public String getClassName() {
            return className;
        }

        public Integer getTerm() {
            return term;
        }

        public String getPoint() {
            return point;
        }

        public String getCourseName() {
            return courseName;
        }

        public String getTeacher() {
            return teacher;
        }
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<ChooseCourse> getChooseCourseList() {
        return ChooseCourseList;
    }
}
