package src;

import src.resources.CoinConverter;
import src.resources.LengthConverter;
import src.resources.TemperatureConverter;

import javax.swing.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        String[] menuOptions = {"Conversor de moneda", "Conversor de temperatura", "Conversor de longitud"};
        CoinConverter coinConverter = new CoinConverter();
        TemperatureConverter temperatureConverter = new TemperatureConverter();
        LengthConverter lengthConverter = new LengthConverter();

        int selectedOption;
        do {
            String selectedValue = (String) JOptionPane.showInputDialog(null,
                    "Elige una opción", "Conversor",
                    JOptionPane.INFORMATION_MESSAGE, null,
                    menuOptions, menuOptions[0]);

            if (selectedValue == null) return;

            switch (selectedValue) {
                case "Conversor de moneda":
                    coinConverter.show();
                    break;
                case "Conversor de temperatura":
                    temperatureConverter.show();
                    break;
                case "Conversor de longitud":
                    lengthConverter.show();
                    break;

            }
            selectedOption = JOptionPane.showConfirmDialog(null, "Desea continuar?", "Desea continuar?", JOptionPane.YES_NO_CANCEL_OPTION);
        } while (Objects.equals(selectedOption, JOptionPane.YES_OPTION));

        JOptionPane.showMessageDialog(null, "Programa finalizado.", "Programa finalizado.", JOptionPane.INFORMATION_MESSAGE);
    }
}