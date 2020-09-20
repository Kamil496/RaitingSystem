package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label txtLable,
            lblRaiting,
            lblValue;
    @FXML
    private TextField txtIncome,
            txtEditions;

    /*
    Hier werden aus den eingegebenen Parametern ein Bilanzwert berechnet
     */
    private Integer calculateValue() {
        String income = txtIncome.getText();
        String editions = txtEditions.getText();
        Integer excessORdeficit = Integer.parseInt(income) - Integer.parseInt(editions);

        return excessORdeficit;
    }


    /*
    Hier wird das Raiting lvl berechnet und die jeweilige Bweretung festlegelgt
     */
    private Integer raiting() {
        Integer tempValue = calculateValue() % 5;
        Integer raiting = tempValue + 1;
        lblRaiting.setText(raiting.toString());

        switch (raiting) {
            case 15: {
                lblValue.setText("Sehr schlecht");
            }
            case 14: {
                lblValue.setText("Sehr schlecht");
            }
            case 13: {
                lblValue.setText("Sehr schlecht");
            }
            case 12: {
                lblValue.setText("Sehr schlecht");
            }
            case 11: {
                lblValue.setText("Sehr schlecht");
            }
            case 10: {
                lblValue.setText("Sehr schlecht");
            }
            case 9: {
                lblValue.setText("Okay");
            }
            case 8: {
                lblValue.setText("Okay");
            }
            case 7: {
                lblValue.setText("Okay");
            }
            case 6: {
                lblValue.setText("Okay");
            }
            case 5: {
                lblValue.setText("Sehr gut");
            }
            case 4: {
                lblValue.setText("Sehr gut");
            }
            case 3: {
                lblValue.setText("Sehr gut");
            }
            case 2: {
                lblValue.setText("Sehr gut");
            }
            case 1: {
                lblValue.setText("Sehr gut");
            }
        }

        if (raiting >= 15) {
            raiting = 15;
            lblValue.setText("Sehr Schlecht");
        }
        if (raiting <= 1) {
            raiting = 1;
            lblRaiting.setText("1");
            lblValue.setText("Sehr gut");
        }

        return raiting;

    }

    /*
    Prüfen ob Textfelder leer sind
     */
    private void checkIfEmpty() {
        if (txtEditions.getText().isEmpty() || txtIncome.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Bitte einen Wert eingeben");
            alert.showAndWait();
        }
    }

    /*
    Button zum auslösen der Berechnung
     */
    public void calculate() {

        checkIfEmpty();
        raiting();
    }
}
