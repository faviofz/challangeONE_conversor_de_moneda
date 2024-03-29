package src.resources;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class CoinConverter {

    private Map<String, Double> _options;
    private String _selectedOption;
    private Double _inputValue;
    private Double _result;

    public CoinConverter(Map<String, Double> options) {
        this._options = options;
    }

    public CoinConverter(){
        this._options = new HashMap<String,Double>(){{
            put("Peso Argentino a Dólar", 1/209.60);
            put("Peso Argentino a Euro", 1/226.54);
            put("Peso Argentino a Libra esterlina", 1/257.80);
            put("Peso Argentino a Yen japonés", 1/1.58);
            put("Peso Argentino a Won surcoreano", 1/0.16);
            put("Dólar a Peso Argentino", 209.60);
            put("Euro a Peso Argentino", 226.54);
            put("Libra esterlina a Peso Argentino", 257.80);
            put("Yen japonés a Peso Argentino", 1.58);
            put("Won surcoreano a Peso Argentino", 0.16);
        }};
    }

    public void show() {
        Object[] options = this._options.keySet().toArray();
        this._selectedOption = (String) JOptionPane.showInputDialog(null,
                "Elige una opción", "Convertir moneda",
                JOptionPane.INFORMATION_MESSAGE, null,
                options, options[0]);

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
        this._result = this._options.get(this._selectedOption) * this._inputValue;
    }

    private boolean isValid(String value) {
        return value.matches("[1-9][0-9]*,?[0-9]*|0,[0-9]*|0");
    }
}
