package app;

import app.configuration.Config;

public class Application {

    public static void main(String[] args) {
        // Config arma todas las piezas y nos entrega la interfaz lista para usar
        Config.getCliUserInterface().applicationInit();
    }
}
