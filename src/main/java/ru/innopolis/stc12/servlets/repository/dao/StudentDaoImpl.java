package ru.innopolis.stc12.servlets.repository.dao;

import ru.innopolis.stc12.servlets.pojo.Student;
import ru.innopolis.stc12.servlets.repository.connectionManager.ConnectionManager;
import ru.innopolis.stc12.servlets.repository.connectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc12.servlets.repository.dao.mappers.StudentMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();
    @Override
    public boolean addStudent(Student student) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            GroupDaoImpl groupDao = new GroupDaoImpl();
            if (groupDao.getGroupById(student.getGroup().getId()) == null) groupDao.addGroup(student.getGroup());
            preparedStatement = connection.prepareStatement(PrepareSQLQuery.INSERT_INTO_STUDENTS_VALUES);
            preparedStatement = StudentMapper.getPreparedStatementFromStudent(preparedStatement, student);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }

    @Override
    public Student getStudentById(int id) {
        Connection connection = connectionManager.getConnection();
        Student student = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    PrepareSQLQuery.SELECT_STUDENT_BY_ID);
            preparedStatement = StudentMapper.getPreparedStatementFromStudentId(preparedStatement, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                student = StudentMapper.getStudentFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public List<Student> getStudentsByCity(int groupId) {
        Connection connection = connectionManager.getConnection();
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    PrepareSQLQuery.SELECT_STUDENTS_BY_CITY);
            preparedStatement = StudentMapper.getPreparedStatementFromStudentId(preparedStatement, groupId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    students.add(StudentMapper.getStudentFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }


    @Override
    public boolean updateStudent(Student student) {
        GroupDaoImpl groupDao = new GroupDaoImpl();
        if (groupDao.getGroupById(student.getGroup().getId()) == null) groupDao.addGroup(student.getGroup());
        if (student.getId() != 0) {
            Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(
                        PrepareSQLQuery.UPDATE_STUDENTS_BY_ID);
                preparedStatement = StudentMapper.getPreparedStatementFromStudent(preparedStatement, student);
                preparedStatement.setInt(7, student.getId());
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteStudentById(int id) {
        Connection connection = connectionManager.getConnection();
        Student student = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    PrepareSQLQuery.DELETE_FROM_STUDENTS_BY_ID);
            preparedStatement = StudentMapper.getPreparedStatementFromStudentId(preparedStatement, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> result = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(
                PrepareSQLQuery.SELECT_ALL_STUDENT);
        ) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println("*****************");
                    result.add(StudentMapper.getStudentFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }
}
