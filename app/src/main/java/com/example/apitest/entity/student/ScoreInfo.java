package com.example.apitest.entity.student;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ScoreInfo {

    private Integer code;
    private String message;
    private List<Score> ScoreList;

    @NoArgsConstructor
    @Data
    public static class Score {
        private String studentId;
        private String studentName;
        private String courseName;
        private Integer term;
        private String score;
        private String point;

        public String getStudentId() {
            return studentId;
        }

        public String getStudentName() {
            return studentName;
        }

        public String getCourseName() {
            return courseName;
        }

        public Integer getTerm() {
            return term;
        }

        public String getScore() {
            return score;
        }

        public String getPoint() {
            return point;
        }
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<Score> getScoreList() {
        return ScoreList;
    }
}
