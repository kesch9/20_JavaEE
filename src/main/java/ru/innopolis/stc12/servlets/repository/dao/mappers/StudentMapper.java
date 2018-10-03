package ru.innopolis.stc12.servlets.repository.dao.mappers;

import ru.innopolis.stc12.servlets.pojo.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper {

    private StudentMapper() {
    }

    public static Student getStudentFromResultSet(ResultSet resultSet) {
        Student student = null;
        try {
                student = new Student(resultSet.getInt("id"),
                        resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("age"),
                        resultSet.getString("contact"),
                        resultSet.getString("city"),
                        GroupMapper.getGroupFromResultSet(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public static PreparedStatement getPreparedStatementFromStudent(PreparedStatement preparedStatement, Student student) {
        try {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setString(4, student.getContact());
            preparedStatement.setString(5, student.getCity());
            preparedStatement.setInt(6, student.getGroup().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static PreparedStatement getPreparedStatementFromStudentId(PreparedStatement preparedStatement, int id) {
        try {
            preparedStatement.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }
}
