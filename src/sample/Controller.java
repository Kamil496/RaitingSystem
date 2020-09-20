package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label txtLable,
            lblrating,
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
    Here the rating lvl is calculated and the respective value is determined
     */
    private Integer rating() {
        Integer tempValue = calculateValue() % 5;
        Integer rating = tempValue + 1;
        lblrating.setText(rating.toString());
        choise(rating);

        if (rating >= 15) {
            lblrating.setText("15");
        }
        if (rating <= 1) {
            rating = 1;
        }

        return rating;

    }

    public void choise(Integer rating) {

        if (rating >= 5 && rating <= 10) {
            lblValue.setText("Okay");
        } else if (rating >= 1 && rating <= 5) {
            lblValue.setText("sehr gut");
        } else if (rating >= 10 && rating <= 15) {
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
        rating();
    }
}
