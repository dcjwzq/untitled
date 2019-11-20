package com.dcj;

public class Student  extends Person{
    private String major;

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    public Student() {
    }

    @Override
    public String getDescription() {
        return "a student majoring in" + this.major;
    }

    @Override
    public String toString() {
        return "Student{" +this.getClass()+
                "major='" + major + '\'' +
                '}';
    }
}
