package com.example.ApiClassRoom.helpers;

public enum APIMessages {

    ATTENDANCE_NOT_FOUND("The attendance you are looking for isn't on the DB"),
    COURSE_NOT_FOUND("The course you are looking for isn't on the DB"),
    GRADES_NOT_FOUND("The grade you are looking for isn't on the DB"),
    SUBJECT_NOT_FOUND("The subject you are looking for isn't on the DB"),
    USER_NOT_FOUND("The user you are looking for isn't on the DB"),
    REGISTRATION_NOT_FOUND("The registration you are looking for isn't on the DB"),
    STUDENT_NOT_FOUND("The student you are looking for isn't on the DB"),
    TEACHER_NOT_FOUND("The teacher you are looking for isn't on the DB");

    private String text;

    APIMessages(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
