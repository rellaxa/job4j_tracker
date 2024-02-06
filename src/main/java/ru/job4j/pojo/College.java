package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Student Relaxa");
        student.setGroup("34_325_SSP");
        student.setDate("11.11.11");
        System.out.println(student.getFio() + " joined the group: " + student.getGroup() + " " + student.getDate());
    }
}