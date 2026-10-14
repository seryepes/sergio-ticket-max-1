package app.service.validators;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DataTypeValidator {

    static Scanner sc = new Scanner(System.in);

    public static int validateInt(String prompt){

        while(true) {
            try {
                System.out.println(prompt);
                int value = sc.nextInt();
                sc.nextLine();
                return value;
            } catch (InputMismatchException e) {
                sc.nextLine(); // CAMBIO: limpia lo que se escribió mal; sin esto se queda en un ciclo infinito
                System.out.println("Solo se aceptan numeros enteros");
            }
        }
    }


    public static Double validateDouble(String prompt){
        while(true) {
            try {
                System.out.println(prompt);
                Double value = sc.nextDouble();
                sc.nextLine();
                return value;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Solo se aceptan numeros decimales");
            }
        }
    }


    public static Float validateFloat(String prompt){
        while(true) {
            try {
                System.out.println(prompt);
                Float value = sc.nextFloat();
                sc.nextLine();
                return value;
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Solo se aceptan numeros decimal flotante");
            }
        }
    }

    public static String validateString(String prompt){
        while(true) {
            System.out.println(prompt);
            String value = sc.nextLine().trim();
            if(!value.isEmpty()){
                return value;
            }
        }
    }

    // NUEVO: pide una fecha con formato AAAA-MM-DD (ej: 2026-12-31)
    public static LocalDate validateDate(String prompt){
        while(true) {
            try {
                System.out.println(prompt);
                return LocalDate.parse(sc.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida. Use el formato AAAA-MM-DD, por ejemplo 2026-12-31");
            }
        }
    }

    // NUEVO: pide una hora con formato HH:MM en 24 horas (ej: 20:30)
    public static LocalTime validateTime(String prompt){
        while(true) {
            try {
                System.out.println(prompt);
                return LocalTime.parse(sc.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Hora inválida. Use el formato HH:MM, por ejemplo 20:30");
            }
        }
    }
}
