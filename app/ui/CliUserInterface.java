package app.ui;

import app.service.exceptions.TicketMaxException;
import app.service.validators.DataTypeValidator;
import app.view.EventView;
import app.view.UserView;

public class CliUserInterface {



    private final UserView userView;
    // NUEVO: la vista de eventos
    private final EventView eventView;

    public CliUserInterface(UserView userView, EventView eventView){
        this.userView = userView;
        this.eventView = eventView;
    }

    public void applicationInit(){

        System.out.println("Bienvenido TicketMax V1");

        int init = DataTypeValidator.validateInt("Presione 1 para iniciar la aplicación");


        while(init != 0){

            // CAMBIO: text block (""" """) para que cada opción salga en su propia línea
            int option = DataTypeValidator.validateInt("""
                    1. Registro
                    2. Login
                    3. Eventos
                    0. Salir""");

            try {
                switch (option){
                    case 1:
                        userView.createUser();
                        break;
                    case 2:
                        System.out.println("Login");
                        userMenu();
                        break;
                    case 3:
                        eventView.showMenu();
                        break;
                    case 0:
                        System.out.println("Saliendo de la aplicación");
                        init = 0;
                        break;
                    default:
                        System.out.println("Seleccione una opción valida");
                        break;
                }
            } catch (TicketMaxException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }



    }


    // CAMBIO: ahora es un ciclo con todas las opciones del usuario; 0 vuelve al menú principal
    public void userMenu(){

        int option;
        do {
            option = DataTypeValidator.validateInt("""
                    
                    ===== USUARIOS =====
                    1. Registrar usuario
                    2. Consultar usuario por id
                    3. Consultar todos los usuarios
                    4. Actualizar usuario
                    5. Eliminar usuario
                    6. Contar usuarios
                    0. Volver""");

            try {
                switch (option){
                    case 1:
                        System.out.println("Registrar Usuario");
                        userView.createUser();
                        break;
                    case 2:
                        System.out.println("Consultar usuario por id");
                        int id = DataTypeValidator.validateInt("Ingrese el id del usuario a consultar");
                        userView.selectUserById(id);
                        break;
                    case 3:
                        System.out.println("Consultar todos los usuarios");
                        userView.selectUsers();
                        break;
                    case 4:
                        System.out.println("Actualizar usuario");
                        userView.updateUser();
                        break;
                    case 5:
                        System.out.println("Eliminar usuario");
                        int idToDelete = DataTypeValidator.validateInt("Ingrese el id del usuario a eliminar");
                        userView.deleteUser(idToDelete);
                        break;
                    case 6:
                        userView.countUsers();
                        break;
                    case 0:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Ingrese una opción valida");
                }
            } catch (TicketMaxException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (option != 0);

    }

}
