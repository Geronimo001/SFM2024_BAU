package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class PacientController {

    @FXML
    private ComboBox<String> speciesComboBox;
    @FXML
    private ComboBox<String> diseaseComboBox;
    @FXML
    private ListView<String> medicineListView;
    @FXML
    private TextField weightTextField;
    @FXML
    private Label resultLabel;


    private Map<String, ObservableList<String>> speciesToDiseases = new HashMap<>();
    private Map<String, ObservableList<String>> diseaseToMedicines = new HashMap<>();
    private Map<String, Double> medicineToDosage = new HashMap<>();
    @FXML
    public void initialize() {
        // Fajok és betegségek
        speciesToDiseases.put("Kutya", FXCollections.observableArrayList("Parvovírus", "Bőratka fertőzés"));
        speciesToDiseases.put("Macska", FXCollections.observableArrayList("Macskanátha", "Alsó húgyúti betegség"));
        speciesToDiseases.put("Ló", FXCollections.observableArrayList("Kólika", "Patairha-gyulladás"));

        // Betegségekhez tartozó gyógyszerek
        diseaseToMedicines.put("Parvovírus", FXCollections.observableArrayList("Infúzió", "Antibiotikumok"));
        diseaseToMedicines.put("Bőratka fertőzés", FXCollections.observableArrayList("Amitraz oldat"));
        diseaseToMedicines.put("Macskanátha", FXCollections.observableArrayList("Immunerősítő"));
        diseaseToMedicines.put("Alsó húgyúti betegség", FXCollections.observableArrayList("Gyulladáscsökkentő"));
        diseaseToMedicines.put("Kólika", FXCollections.observableArrayList("Fájdalomcsillapító"));
        diseaseToMedicines.put("Patairha-gyulladás", FXCollections.observableArrayList("Érkitágító", "Hideg borogatás a patákra"));
        //Gyógyszeradag
        medicineToDosage.put("Infúzió", 0.05);
        medicineToDosage.put("Antibiotikumok", 0.10);
        medicineToDosage.put("Amitraz oldat", 0.07);
        medicineToDosage.put("Immunerősítő", 0.03);
        medicineToDosage.put("Gyulladáscsökkentő", 0.08);
        medicineToDosage.put("Fájdalomcsillapító", 0.04);
        medicineToDosage.put("Érkitágító", 0.06);

        speciesComboBox.setItems(FXCollections.observableArrayList(speciesToDiseases.keySet()));

        speciesComboBox.setOnAction(event -> updateDiseases());

        diseaseComboBox.setOnAction(event -> updateMedicines());
    }

    private void updateDiseases() {
        String selectedSpecies = speciesComboBox.getValue();
        if (selectedSpecies != null) {
            diseaseComboBox.setItems(speciesToDiseases.get(selectedSpecies));
        }
    }

    private void updateMedicines() {
        String selectedDisease = diseaseComboBox.getValue();
        if (selectedDisease != null) {
            medicineListView.setItems(diseaseToMedicines.get(selectedDisease));
        }
    }

    @FXML
    private void calculateDose() {
        ObservableList<String> selectedMedicines = medicineListView.getSelectionModel().getSelectedItems();
        String weightText = weightTextField.getText();

        if (!selectedMedicines.isEmpty() && weightText != null && !weightText.isEmpty()) {
            try {
                double weight = Double.parseDouble(weightText);
                StringBuilder dosageResults = new StringBuilder("Adagok: \n");

                for (String medicine : selectedMedicines) {
                    if (medicineToDosage.containsKey(medicine)) {
                        double dose = weight * medicineToDosage.get(medicine);
                        dosageResults.append(medicine).append(": ").append(dose).append(" mg/nap\n");
                    }
                }

                resultLabel.setText(dosageResults.toString());
            } catch (NumberFormatException e) {
                resultLabel.setText("Helytelen súly formátum.");
            }
        } else {
            resultLabel.setText("Kérlek, válassz gyógyszert és add meg a súlyt.");
        }
    }
}
