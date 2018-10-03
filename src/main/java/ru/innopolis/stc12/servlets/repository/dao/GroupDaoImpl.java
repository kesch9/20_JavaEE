package ru.innopolis.stc12.servlets.repository.dao;


import ru.innopolis.stc12.servlets.pojo.Group;
import ru.innopolis.stc12.servlets.repository.connectionManager.ConnectionManager;
import ru.innopolis.stc12.servlets.repository.connectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.stc12.servlets.repository.dao.mappers.GroupMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDaoImpl implements GroupDao {

    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public boolean addGroup(Group group) {
        Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(PrepareSQLQuery.INSERT_INTO_GROUPS_VALUES);
            preparedStatement = GroupMapper.getPreparedStatementFromGroup(preparedStatement, group);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Group getGroupById(int id) {
        Connection connection = connectionManager.getConnection();
        Group group = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    PrepareSQLQuery.SELECT_GROUP_BY_ID);
            preparedStatement = GroupMapper.getPreparedStatementFromGroupId(preparedStatement, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                group = GroupMapper.getGroupFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }
    @Override
    public Group getGroupByNameCourse(String nameCourse) {
        Connection connection = connectionManager.getConnection();
        Group group = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    PrepareSQLQuery.SELECT_GROUP_BY_NAME_COURSE);
            preparedStatement = GroupMapper.getPreparedStatementFromGroupName(preparedStatement, nameCourse);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    group = GroupMapper.getGroupFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    @Override
    public List<Group> getAllGroup() {
        List<Group> result = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(
                PrepareSQLQuery.SELECT_ALL_GROUP);
        ) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(GroupMapper.getGroupFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    @Override
    public boolean updateGroup(Group group) {
        if (group.getId() != 0) {
            Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(
                        PrepareSQLQuery.UPDATE_GROUPS_BY_ID);
                preparedStatement = GroupMapper.getPreparedStatementFromGroup(preparedStatement, group);
                preparedStatement.setInt(3, group.getId());
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
    public boolean deleteGroupById(int id) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        if (studentDao.getStudentsByCity(id).size() == 0) {
            Connection connection = connectionManager.getConnection();
            Group group = null;
            PreparedStatement preparedStatement = null;
            try {
                preparedStatement = connection.prepareStatement(
                        PrepareSQLQuery.DELETE_FROM_GROUPS_BY_ID);
                preparedStatement = GroupMapper.getPreparedStatementFromGroupId(preparedStatement, id);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

}
