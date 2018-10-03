package ru.innopolis.stc12.servlets.repository.dao.mappers;

import ru.innopolis.stc12.servlets.pojo.Group;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupMapper {
    private GroupMapper() {
    }

    public static Group getGroupFromResultSet(ResultSet resultSet) {
        Group group = null;
        try {
                group = new Group(resultSet.getInt("id"),
                        resultSet.getString("namecourse"),
                        resultSet.getInt("numberstream"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

    public static PreparedStatement getPreparedStatementFromGroup(PreparedStatement preparedStatement, Group group) {
        try {
            preparedStatement.setString(1, group.getNameCourse());
            preparedStatement.setInt(2, group.getNumberStream());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static PreparedStatement getPreparedStatementFromGroupId(PreparedStatement preparedStatement, int id) {
        try {
            preparedStatement.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }
    public static PreparedStatement getPreparedStatementFromGroupName(PreparedStatement preparedStatement, String name) {
        try {
            preparedStatement.setString(1, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }
}
