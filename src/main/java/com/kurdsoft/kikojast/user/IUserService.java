package com.kurdsoft.kikojast.user;


import java.util.List;

public interface IUserService {
    User save(User user);
    User update(User user);
    void delete(Long id);
    User getById(Long id);
    List<User> getAll();
}
