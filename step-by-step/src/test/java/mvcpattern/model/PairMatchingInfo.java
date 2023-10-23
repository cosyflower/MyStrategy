package mvcpattern.model;

public class PairMatchingInfo {
    private final Course course;
    private final Mission mission;

    public PairMatchingInfo(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
    }
}
