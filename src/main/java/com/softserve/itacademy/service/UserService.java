package com.softserve.itacademy.service;

import com.softserve.itacademy.model.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User readById(long id);
    User update(User user);
    void delete(long id);
    List<User> getAll();
    List<User> searchUsersByName(String userName);
    void removeCollaborator(long todoId, long collaboratorId);
    void addCollaborator(long todoId, long collaboratorId);
}
