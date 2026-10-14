package app.service.inputports;

import app.domain.User;

import java.util.List;

public interface UserService {

    User create(Integer id, String name, String lastName, String email, String phone, String password, String state, String city, String preferences);
    User selectUserById(int id);
    User updateUser(Integer id, String name, String lastName, String email, String phone, String password, String state, String city, String preferences);
    List<User> selectUsers();
    void deleteUser(int id);
    int countUsers();
}
