package app.service;

import app.domain.User;
import app.service.exceptions.DuplicateEntityException;
import app.service.exceptions.EntityNotFoundException;
import app.service.inputports.UserService;
import app.service.outputports.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User create(Integer id, String name, String lastName, String email, String phone, String password, String state, String city, String preferences) {

        // NUEVO: ahora que selectById funciona, evitamos ids repetidos
        if (userRepository.selectById(id) != null) {
            throw new DuplicateEntityException("un usuario", id);
        }

        User user = new User(id, name, lastName, email, phone, password, state, city, preferences);

        return userRepository.save(user);
    }

    // COMPLETADO
    @Override
    public User selectUserById(int id) {
        User user = userRepository.selectById(id);
        if (user == null) {
            throw new EntityNotFoundException("un usuario", id);
        }
        return user;
    }

    // COMPLETADO
    @Override
    public User updateUser(Integer id, String name, String lastName, String email, String phone, String password, String state, String city, String preferences) {
        selectUserById(id); // si no existe, lanza la excepción y no sigue
        User user = new User(id, name, lastName, email, phone, password, state, city, preferences);
        return userRepository.updateUser(user);
    }

    @Override
    public List<User> selectUsers() {

        return userRepository.selectAll();
    }

    // COMPLETADO
    @Override
    public void deleteUser(int id) {
        selectUserById(id);
        userRepository.deleteById(id);
    }

    // NUEVO (adicional)
    @Override
    public int countUsers() {
        return userRepository.countUsers();
    }
}
