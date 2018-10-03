package ru.innopolis.stc12.servlets.pojo;

public class Group {

    private int id;
    private String nameCourse;
    private int numberStream;

    public Group(int id, String nameCourse, int numberStream) {
        this.id = id;
        this.nameCourse = nameCourse;
        this.numberStream = numberStream;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public int getNumberStream() {
        return numberStream;
    }

    public void setNumberStream(int numberStream) {
        this.numberStream = numberStream;
    }
}
