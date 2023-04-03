package resources;

import javax.swing.*;
import java.util.Map;

public class CoinConverter {

    private Map<String, Double> coins;
    private String _selectedOption;
    private Double _inputValue;

    private Double _result;
    public CoinConverter(Map<String, Double> coins) {
        this.coins = coins;
    }

    public void show() {
        Object[] options = coins.keySet().toArray();
        this._selectedOption = (String) JOptionPane.showInputDialog(null,
                "Elige una opción", "Convertir Pesos Argentinos",
                JOptionPane.INFORMATION_MESSAGE, null,
                options, options[0]);

        String input = JOptionPane.showInputDialog("Ingrese valor");

        if (isValid(input)){
            this._inputValue = Double.valueOf(input);
            this.convert();
            JOptionPane.showMessageDialog(null, "El valor de la conversión es: " + this._result);
        } else{
            JOptionPane.showMessageDialog(null, "Valor no válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void convert() {
        this._result = this.coins.get(this._selectedOption) * this._inputValue;
    }

    private boolean isValid(String value){
        return value.matches("[1-9][0-9]*,?[0-9]*|0,[0-9]*|0");
    }
}
