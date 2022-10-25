package com.example.apitest.entity.student;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StudentInfo {

    private Integer code;
    private String message;
    private DataDTO studentInfo;

    @NoArgsConstructor
    @Data
    public static class DataDTO {
        private Integer id;
        private String studentName;
        private String studentId;
        private String className;

        public Integer getId() {
            return id;
        }

        public String getStudentName() {
            return studentName;
        }

        public String getStudentId() {
            return studentId;
        }

        public String getClassName() {
            return className;
        }
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public DataDTO getStudentInfo() {
        return studentInfo;
    }
}
