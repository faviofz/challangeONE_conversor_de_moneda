package src.resources;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TemperatureConverter {

    private Map<String, Double> _options;
    private String _selectedOption;
    private Double _inputValue;
    private Double _result;

    public TemperatureConverter(Map<String, Double> options) {
        this._options = options;
    }

    public TemperatureConverter() {
        this._options = new HashMap<String, Double>() {{
            put("Fahrenheit a Celsius", 0.);
            put("Celsius a Fahrenheit", 0.);
        }};
    }

    public void show() {
            Object[] options = this._options.keySet().toArray();
            this._selectedOption = (String) JOptionPane
                    .showInputDialog(null, "Elige una opción", "Convertir temperatura", JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (this._selectedOption == null) return;

            String input = JOptionPane.showInputDialog("Ingrese valor");

            if (isValid(input)) {
                this._inputValue = Double.valueOf(input);

                this.convert();

                JOptionPane.showMessageDialog(null, "El valor de la conversión es: " + this._result);
            } else {
                JOptionPane.showMessageDialog(null, "Valor no válido", "Error", JOptionPane.ERROR_MESSAGE);
            }

    }

    private void convert() {
        if (Objects.equals(_selectedOption, "Fahrenheit a Celsius")) {
            toCelsius(_inputValue);
        } else {
            toFahrenheit(_inputValue);
        }
    }

    private void toCelsius(double value) {
        this._result = (value - 32) * 5 / 9;
    }

    private void toFahrenheit(double value) {
        this._result = (value * 9 / 5) + 32;
    }

    private boolean isValid(String value) {
        return value.matches("[1-9][0-9]*,?[0-9]*|0,[0-9]*|0");
    }
}