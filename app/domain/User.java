package app.domain;

public class User extends Person{

    private String city;
    private String preferences;

    public User() {
        super();
    }

    public User(Integer id, String name, String lastName, String email, String phone, String password, String state, String city, String preferences) {
        super(id, name, lastName, email, phone, password, state);
        this.city = city;
        this.preferences = preferences;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }



    public void addPreferences(String preference){

    }

    // NUEVO: así se ve un usuario al imprimirlo (la contraseña no se muestra por seguridad)
    @Override
    public String toString() {
        return "Usuario #" + id + " | " + name + " " + lastName
                + " | " + email + " | Tel: " + phone
                + " | Estado: " + state + " | Ciudad: " + city
                + " | Preferencia: " + preferences;
    }

}
