package mvcpattern.model;

public enum Course {
    FRONTEND("프론트엔드"),
    BACKEND("백엔드");

    private final String courseName;

    Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
}
