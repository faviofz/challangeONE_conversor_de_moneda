import resources.CoinConverter;

import javax.swing.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        JFrame myFrame = new JFrame();
        myFrame.setSize(400, 400);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        String[] menuOptions = {"Conversor de moneda", "Conversor de temperatura", "Conversor de peso"};

        Object selectedValue = JOptionPane.showInputDialog(null,
                "Choose one", "Input",
                JOptionPane.INFORMATION_MESSAGE, null,
                menuOptions, menuOptions[0]);


        CoinConverter miConversor = new CoinConverter(new HashMap<String,Double>(){{
            put("Dólar", 209.60);
            put("Euro", 226.54);
            put("Libra esterlina", 257.80);
            put("Yen japonés", 1.58);
            put("Won surcoreano", 0.16);
        }});

        miConversor.show();

        Object selectedOption = JOptionPane.showConfirmDialog(null, "Desea continuar?", "Desea continuar?", JOptionPane.YES_NO_CANCEL_OPTION);

        JOptionPane.showMessageDialog(null, "Programa finalizado.", "", JOptionPane.INFORMATION_MESSAGE);

    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double celcius) {
        return (celcius * 9 / 5) + 32;
    }
}