package ru.innopolis.stc12.servlets.repository.dao;


import ru.innopolis.stc12.servlets.pojo.Group;

import java.util.List;

public interface GroupDao {
    boolean addGroup(Group city);

    Group getGroupById(int id);

    boolean updateGroup(Group group);

    boolean deleteGroupById(int id);

    Group getGroupByNameCourse(String nameCourse);

    List<Group> getAllGroup();
}
