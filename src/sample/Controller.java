package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label txtLable,
            lblRaiting,
            lblWertung;
    @FXML
    private TextField txtfieldEinnahmen,
            txtFieldAusgaben;

    /*
    Hier werden aus den eingegebenen Parametern ein Bilanzwert berechnet
     */
    private Integer berechnungBilanzwert() {
        String einnahmen = txtfieldEinnahmen.getText();
        String ausgaben = txtFieldAusgaben.getText();
        Integer überschussORFehlbetrag = Integer.parseInt(einnahmen) - Integer.parseInt(ausgaben);

        return überschussORFehlbetrag;
    }


    /*
    Hier wird das Raiting lvl berechnet und die jeweilige Bweretung festlegelgt
     */
    private Integer raiting() {
        Integer zwichenwert = berechnungBilanzwert() % 5;
        Integer raiting = zwichenwert + 1;
        lblRaiting.setText(raiting.toString());

        switch (raiting) {
            case 15: {
                lblWertung.setText("Sehr schlecht");
            }
            case 14: {
                lblWertung.setText("Sehr schlecht");
            }
            case 13: {
                lblWertung.setText("Sehr schlecht");
            }
            case 12: {
                lblWertung.setText("Sehr schlecht");
            }
            case 11: {
                lblWertung.setText("Sehr schlecht");
            }
            case 10: {
                lblWertung.setText("Sehr schlecht");
            }
            case 9: {
                lblWertung.setText("Okay");
            }
            case 8: {
                lblWertung.setText("Okay");
            }
            case 7: {
                lblWertung.setText("Okay");
            }
            case 6: {
                lblWertung.setText("Okay");
            }
            case 5: {
                lblWertung.setText("Sehr gut");
            }
            case 4: {
                lblWertung.setText("Sehr gut");
            }
            case 3: {
                lblWertung.setText("Sehr gut");
            }
            case 2: {
                lblWertung.setText("Sehr gut");
            }
            case 1: {
                lblWertung.setText("Sehr gut");
            }
        }

        if (raiting >= 15) {
            raiting = 15;
            lblWertung.setText("Sehr Schlecht");
        }
        if (raiting <= 1) {
            raiting = 1;
            lblRaiting.setText("1");
            lblWertung.setText("Sehr gut");
        }

        return raiting;

    }

    /*
    Prüfen ob Textfelder leer sind
     */
    private void checkIfEmpty(){
        if (txtFieldAusgaben.getText().isEmpty() || txtfieldEinnahmen.getText().isEmpty()) {
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
