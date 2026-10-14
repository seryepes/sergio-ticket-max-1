package app.repository;

import app.domain.User;
import app.service.outputports.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImplCollection implements UserRepository {

    private final List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    // COMPLETADO: recorre la lista y devuelve el usuario con ese id
    @Override
    public User selectById(int id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null; // si no lo encuentra, el service decide qué hacer
    }

    // CAMBIO: ya no imprime aquí. El repositorio solo guarda y entrega datos;
    // imprimir es trabajo de la vista (UserView)
    @Override
    public List<User> selectAll() {
        return new ArrayList<>(users);
    }

    // COMPLETADO: busca la posición del usuario y lo reemplaza por la versión nueva
    @Override
    public User updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(user.getId())) {
                users.set(i, user);
                return user;
            }
        }
        return null;
    }

    // COMPLETADO: borra de la lista el usuario que tenga ese id
    @Override
    public void deleteById(int id) {
        users.removeIf(user -> user.getId().equals(id));
    }

    // NUEVO (adicional): size() dice cuántos elementos tiene la lista
    @Override
    public int countUsers() {
        return users.size();
    }
}
