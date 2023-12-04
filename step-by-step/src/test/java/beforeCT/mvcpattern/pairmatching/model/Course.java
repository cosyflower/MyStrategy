package beforeCT.mvcpattern.pairmatching.model;

import java.util.Arrays;

public enum Course {
    FRONTEND("프론트엔드"),
    BACKEND("백엔드");

    private final String courseName;

    Course(String courseName) {
        this.courseName = courseName;
    }

    public static Course findByName(String findingCourse) {
        return Arrays.stream(Course.values())
                .filter(course -> course.getCourseName().equals(findingCourse))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getCourseName() {
        return courseName;
    }
}
