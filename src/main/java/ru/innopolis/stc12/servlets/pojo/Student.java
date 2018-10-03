package ru.innopolis.stc12.servlets.pojo;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String contact;
    private String city;
    private Group group;



    public Student(int id, String name, String lastName, int age, String contact, String city, Group group) {
        this.id = id;
        this.firstName = name;
        this.lastName = lastName;
        this.age = age;
        this.contact = contact;
        this.city = city;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName ='" + firstName + '\'' +
                ", lastName ='" + lastName + '\'' +
                ", age =" + age +
                ", contact ='" + contact + '\'' +
                ", city =" + city +
                '}';
    }
}
