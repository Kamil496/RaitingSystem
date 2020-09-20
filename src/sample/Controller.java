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
    Here a balance sheet value is calculated from the entered parameters
     */
    private Integer calculateValue() {
        String income = txtIncome.getText();
        String editions = txtEditions.getText();
        Integer excessORdeficit = Integer.parseInt(income) - Integer.parseInt(editions);

        return excessORdeficit;
    }


    /*
    Here the Raiting lvl is calculated and the respective value is determined
     */
    private Integer raiting() {
        Integer tempValue = calculateValue() % 5;
        Integer raiting = tempValue + 1;
        lblRaiting.setText(raiting.toString());
        choise(raiting);

        if (raiting >= 15) {
            lblRaiting.setText("15");
        }
        if (raiting <= 1) {
            raiting = 1;
        }

        return raiting;

    }

    public void choise(Integer raiting) {

        if (raiting >= 5 && raiting <= 10) {
            lblValue.setText("Okay");
        } else if (raiting >= 1 && raiting <= 5) {
            lblValue.setText("sehr gut");
        } else if (raiting >= 10 && raiting <= 15) {
            lblValue.setText("schlecht");
        }
    }

    /*
   Check if text fields are empty
     */
    private void checkIfEmpty() {
        if (txtEditions.getText().isEmpty() || txtIncome.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Bitte einen Wert eingeben");
            alert.showAndWait();
        }
    }

    /*
    Button to trigger the calculation
     */
    public void calculate() {

        checkIfEmpty();
        raiting();
    }
}
