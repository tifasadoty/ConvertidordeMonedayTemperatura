package com.convertidor.convertidormoneda;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class ConvertidorMoneda {

    private static final DecimalFormat formatear = new DecimalFormat("#.##");

    public static void main(String[] args) {
        boolean continuarPrograma = true;
        while (continuarPrograma) {
            String[] opciones = {"Convertir Monedas", "Conversor de temperatura"};
            String menu = (String) JOptionPane.showInputDialog(null, "Menu",
                    "Conversor de Moneda", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            if (menu == null) {
                JOptionPane.showMessageDialog(null, "Programa Cerrado");
                System.exit(0);
            }

            switch (menu) {
                case "Convertir Monedas" ->
                    convertirMonedas();
                case "Conversor de temperatura" ->
                    convertirTemperatura();
            }
        }
    }

    private static void convertirMonedas() {
        boolean continuarPrograma = true;
        while (continuarPrograma) {
            String[] opciones = {"peso chileno a Euros", "peso chileno a Dólares", "peso chileno a Libras", "peso chileno a Yen",
                "peso chileno a Won", "Dólares a peso chileno", "Euros a peso chileno", "Libras a peso chileno", "Yen a peso chileno", "Won a peso chileno"};
            String cambio = (String) JOptionPane.showInputDialog(null, "Elige una opción:",
                    "Conversor de Moneda", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            String input = JOptionPane.showInputDialog("Ingresa la cantidad que deseas convertir: ");
            
            double cantidad;
            try {
                cantidad = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor no válido, solo son permitidos Números.");
                return;
            }

            double resultado = 0.0;
            switch (cambio) {
                case "peso chileno a Dólares" ->
                    resultado = cantidad / 824.7;
                case "peso chileno a Euros" ->
                    resultado = cantidad / 916.5;
                case "peso chileno a Libras" ->
                    resultado = cantidad / 5.91;
                case "peso chileno a Yen" ->
                    resultado = cantidad / 0.03;
                case "peso chileno a Won" ->
                    resultado = cantidad / 0.65;
                case "Dólares a peso chileno" ->
                    resultado = cantidad * 824.7;
                case "Euros a peso chileno" ->
                    resultado = cantidad * 916.5;
                case "Libras a peso chileno" ->
                    resultado = cantidad * 5.91;
                case "Yen a peso chileno" ->
                    resultado = cantidad * 0.03;
                case "Won a peso chileno" ->
                    resultado = cantidad * 0.65;
            }
            JOptionPane.showMessageDialog(null,
                    cantidad + " " + cambio.split(" a ")[0] + " son " + formatear.format(resultado) + " " + cambio.split(" a ")[1] + ".");

            int confirm = JOptionPane.showConfirmDialog(null, "¿Deseas seguir usando el programa?", "Confirmar",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (confirm == JOptionPane.NO_OPTION || confirm == JOptionPane.CANCEL_OPTION) {
                continuarPrograma = false;
                JOptionPane.showMessageDialog(null, "Programa Finalizado");
            }
        }
    }

    private static void convertirTemperatura() {
        boolean SeguirPrograma = true;
        while (SeguirPrograma) {
            String[] temperaturas = {"Celsius a Fahrenheit", "Fahrenheit a Celsius"};
            String opcion = (String) JOptionPane.showInputDialog(null, "Elige una opción de conversión:",
                    "Conversor de Temperatura", JOptionPane.QUESTION_MESSAGE, null, temperaturas, temperaturas[0]);

            String valorStr = JOptionPane.showInputDialog("Ingresa el valor a convertir: ");

            double valor = 0;
            try {
                valor = Double.parseDouble(valorStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor no válido");
                return;
            }

            double resultado = 0;
            switch (opcion) {
                case "Celsius a Fahrenheit" ->
                    resultado = (valor * 9 / 5) + 32;
                case "Fahrenheit a Celsius" ->
                    resultado = (valor - 32) * 5 / 9;
            }
            JOptionPane.showMessageDialog(null,
                    valor + " grados " + opcion.split(" a ")[0] + " son " + formatear.format(resultado) + " grados " + opcion.split(" a ")[1]);

            int continuar = JOptionPane.showConfirmDialog(null, "¿Deseas seguir usando el programa?", "",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            if (continuar == JOptionPane.NO_OPTION || continuar == JOptionPane.CANCEL_OPTION) {
                SeguirPrograma = false;
                JOptionPane.showMessageDialog(null, "Programa Finalizado");
            }
        }
    }
}
