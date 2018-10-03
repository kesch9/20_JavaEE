package ru.innopolis.stc12.servlets.repository.dao;

public class PrepareSQLQuery {

    static final String INSERT_INTO_STUDENTS_VALUES = "INSERT  into students values(DEFAULT , ?, ?, ?, ?, ?, ?)";
    static final String SELECT_STUDENT_BY_ID = "SELECT * from students WHERE id = ?";
    static final String SELECT_ALL_STUDENT = "SELECT * from students";
    static final String SELECT_STUDENTS_BY_CITY = "SELECT * from students WHERE city = ?";
    static final String UPDATE_STUDENTS_BY_ID = "UPDATE students SET firstname=?, lastname=?, age=?, contact=?, city=?, group WHERE id=?";
    static final String DELETE_FROM_STUDENTS_BY_ID = "DELETE FROM students WHERE id=?";


    static final String INSERT_INTO_GROUPS_VALUES = "INSERT  into groups values(DEFAULT , ?, ?)";
    static final String SELECT_GROUP_BY_ID = "SELECT * from groups WHERE id = ?";
    static final String UPDATE_GROUPS_BY_ID = "UPDATE groups SET name=?, population=? WHERE id=?";
    static final String DELETE_FROM_GROUPS_BY_ID = "DELETE FROM groups WHERE id=?";
    static final String SELECT_GROUP_BY_NAME_COURSE = "SELECT * from groups WHERE namecourse = ?";
    static final String SELECT_ALL_GROUP = "SELECT * from groups";

}
