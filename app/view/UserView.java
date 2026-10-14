package app.view;

import app.domain.User;
import app.domain.enums.SelectPreferencesEnum;
import app.service.helpers.SetUserState;
import app.service.inputports.UserService;
import app.service.validators.DataTypeValidator;

import java.util.List;

public class UserView {


    private final UserService userService;

    public UserView(UserService userService){
        this.userService = userService;
    }

    public void createUser() {
        fillForm(false);
    }

    // COMPLETADO
    public void selectUserById(int id) {
        User user = userService.selectUserById(id);
        System.out.println(user);
    }


    public void selectUsers(){

        List<User> users = userService.selectUsers();
        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        for (User user : users) {
            System.out.println(user);
        }

    }

    // COMPLETADO
    public void updateUser() {
        fillForm(true);
    }

    // COMPLETADO
    public void deleteUser(int id) {
        userService.deleteUser(id);
        System.out.println("Usuario eliminado.");
    }

    // NUEVO (adicional)
    public void countUsers() {
        int total = userService.countUsers();
        System.out.println("Hay " + total + " usuario(s) registrado(s).");
    }


    // métodos Helper

    // Un solo formulario para crear y actualizar (DRY)
    private void fillForm(boolean isUpdate) {

        int id = DataTypeValidator.validateInt("Ingrese el id del usuario: ");
        if (isUpdate) {
            userService.selectUserById(id); // verifica que exista antes de pedir lo demás
        }
        String name = DataTypeValidator.validateString("Ingrese el nombre del usuario: ");
        String lastName = DataTypeValidator.validateString("Ingrese el apellido del usuario: ");
        String email = DataTypeValidator.validateString("Ingrese el correo del usuario: ");
        String phone = DataTypeValidator.validateString("Ingrese el telefono del usuario: ");
        String password = DataTypeValidator.validateString("Ingrese la contraseña del usuario: ");
        System.out.println("Ingrese el estado del usuario: ");
        String state = SetUserState.getUserState();
        String city = DataTypeValidator.validateString("Ingrese la ciudad del usuario: ");
        System.out.println("Ingrese las preferencias del usuario: ");
        String preferences = setUserPreferences();

        if (isUpdate) {
            userService.updateUser(id, name, lastName, email, phone, password, state, city, preferences);
            System.out.println("Usuario actualizado.");
        } else {
            userService.create(id, name, lastName, email, phone, password, state, city, preferences);
            System.out.println("Usuario registrado.");
        }
    }


    public String setUserPreferences(){


        int option = DataTypeValidator.validateInt("Seleccione 1. VIP 2. General 3. Preferencial");
        String preferences = "";

        switch (option){

            case 1:
                preferences = SelectPreferencesEnum.VIP.getPreference();
                break;
            case 2:
                preferences = SelectPreferencesEnum.GENERAL.getPreference();
                break;
            case 3:
                preferences = SelectPreferencesEnum.PREFERENCIAL.getPreference();
                break;
            default:
                System.out.println("Opción no valida");

        }
        return preferences;
    }

}
