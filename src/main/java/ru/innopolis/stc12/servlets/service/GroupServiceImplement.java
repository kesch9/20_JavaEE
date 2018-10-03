package ru.innopolis.stc12.servlets.service;

import ru.innopolis.stc12.servlets.pojo.Group;
import ru.innopolis.stc12.servlets.repository.dao.GroupDao;
import ru.innopolis.stc12.servlets.repository.dao.GroupDaoImpl;

import java.util.List;

public class GroupServiceImplement implements GroupService {

    private GroupDao groupDao;

    public GroupServiceImplement() {
        groupDao = new GroupDaoImpl();
    }

    public GroupServiceImplement(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public List<Group> getAllGroup() {
        return groupDao.getAllGroup();
    }
}
