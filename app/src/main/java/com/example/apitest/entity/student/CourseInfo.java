package com.example.apitest.entity.student;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CourseInfo {

    private Integer code;
    private String message;
    private List<courseInfo> courseInfoList;

    @NoArgsConstructor
    @Data
    public static class courseInfo {
        private Integer id;
        private String courseName;
        private String teacher;
        private String teacherId;
        private String point;
        private String studentId;
        private Integer term;

        public Integer getId() {
            return id;
        }

        public String getCourseName() {
            return courseName;
        }

        public String getTeacher() {
            return teacher;
        }

        public String getTeacherId() {
            return teacherId;
        }

        public String getPoint() {
            return point;
        }

        public String getStudentId() {
            return studentId;
        }

        public Integer getTerm() {
            return term;
        }
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<courseInfo> getCourseInfoList() {
        return courseInfoList;
    }
}
